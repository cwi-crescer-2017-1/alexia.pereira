create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin
        
        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);
        
        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin
    
       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;
  
    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
    begin

       defineRateioPremio(pPremio);
       
       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );
       
       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */
  procedure geraProximoConcurso as
  
   CURSOR c_Concurso_Anterior IS
    SELECT IdConcurso, Acumulou, Premio_Sena, Numero_Linhas FROM 
        (SELECT IdConcurso, Acumulou, Premio_Sena, row_number() OVER (ORDER BY IdConcurso DESC) AS Numero_Linhas FROM CONCURSO)
    WHERE Numero_Linhas = 1;    
    
    vValorPremio NUMBER;
    vIdConcursoAnterior NUMBER;
    vValorTotalArrecadado NUMBER;
  
   begin
      
      vValorPremio:=0;
      
      FOR registro IN c_Concurso_Anterior LOOP
        vIdConcursoAnterior:= registro.IdConcurso;
        IF registro.Acumulou = 1 THEN
          vValorPremio:= registro.Premio_Sena;
        END IF;
      END LOOP;
      
      -- Busca total arrecadado no último concurso
      SELECT SUM(Valor) 
      INTO vValorTotalArrecadado -- atribui variável
      FROM Aposta
      WHERE IdConcurso = vIdConcursoAnterior;
      
      vValorPremio:= vValorPremio + (vValorTotalArrecadado * (45.3/100));  
      
      salvaConcurso((vIdConcursoAnterior + 1), TO_DATE(SYSDATE, 'DD/MM/YY'), vValorPremio);
 
   end geraProximoConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
  procedure atualizaAcertadores (pConcurso in integer) as
  
  CURSOR c_Dezenas (pIdConcurso IN NUMBER) IS
  SELECT DEZENAS FROM 
  (
      SELECT PRIMEIRA_DEZENA AS DEZENAS, IDCONCURSO  FROM CONCURSO  UNION ALL
      SELECT SEGUNDA_DEZENA, IDCONCURSO  FROM CONCURSO  UNION ALL
      SELECT TERCEIRA_DEZENA, IDCONCURSO  FROM CONCURSO  UNION ALL  
      SELECT QUARTA_DEZENA, IDCONCURSO  FROM CONCURSO  UNION ALL  
      SELECT QUINTA_DEZENA, IDCONCURSO  FROM CONCURSO  UNION ALL
      SELECT SEXTA_DEZENA, IDCONCURSO  FROM CONCURSO
  )
  WHERE IDCONCURSO = pIdConcurso;
  
  CURSOR c_Numero_Apostas (pIdAposta IN NUMBER) IS
    SELECT N.NUMERO, N.IDAPOSTA FROM NUMERO_APOSTA N 
    WHERE N.IDAPOSTA = pIdAposta;
    
  CURSOR c_Apostas (pIdConcurso IN NUMBER) IS 
    SELECT IDAPOSTA FROM APOSTA WHERE IDCONCURSO = pIdConcurso;
  
  vContadorAcertos NUMBER;
  vContadorQuadra NUMBER := 0;
  vContadorQuina NUMBER := 0;
  vContadorMega NUMBER := 0;
  
  vPremioMegaSena NUMBER;
  vPremioQuina NUMBER;
  vPremioQuadra NUMBER;
  
   BEGIN

    SELECT PREMIO_SENA 
    INTO vPremioMegaSena
    FROM Concurso
    WHERE IdConcurso = pConcurso;
    
    SELECT PREMIO_QUINA 
    INTO vPremioQuina
    FROM Concurso
    WHERE IdConcurso = pConcurso;
    
    SELECT PREMIO_QUADRA 
    INTO vPremioQuadra
    FROM Concurso
    WHERE IdConcurso = pConcurso;
      
      FOR iAposta IN c_Apostas(pConcurso) LOOP
      vContadorAcertos:= 0;
        FOR iNumeroAposta IN c_Numero_Apostas(iAposta.IdAposta) LOOP
            FOR linha IN c_Dezenas (pConcurso) LOOP
                IF iNumeroAposta.Numero = linha.dezenas THEN
                    vContadorAcertos:= vContadorAcertos + 1;
                END IF;
            END LOOP;
            CASE vContadorAcertos
                WHEN 4 THEN 
                    vContadorQuadra:= vContadorQuadra + 1;
                    
                    INSERT INTO APOSTA_PREMIADA 
                    (IdAposta_Premiada, IdAposta, Acertos, Valor)
                    VALUES
                    (sqAposta_Premiada.nextVal, iAposta.IdAposta, 4, vPremioQuadra);
                    
                WHEN 5 THEN
                    vContadorQuina:= vContadorQuina + 1;
                    
                    INSERT INTO APOSTA_PREMIADA 
                    (IdAposta_Premiada, IdAposta, Acertos, Valor)
                    VALUES
                    (sqAposta_Premiada.nextVal, iAposta.IdAposta, 5, vPremioQuina);
                    
                WHEN 6 THEN
                    vContadorMega:= vContadorMega + 1;
                    
                    INSERT INTO APOSTA_PREMIADA 
                    (IdAposta_Premiada, IdAposta, Acertos, Valor)
                    VALUES
                    (sqAposta_Premiada.nextVal, iAposta.IdAposta, 6, vPremioMegaSena);
                
                ELSE null;
            END CASE;
        END LOOP;
      END LOOP;
      
      IF vContadorMega > 1 THEN
        UPDATE APOSTA_PREMIADA SET VALOR = (vPremioMegaSena / vContadorMega) WHERE ACERTOS = 6;
      END IF;
      
      IF vContadorQuina > 1 THEN
        UPDATE APOSTA_PREMIADA SET VALOR = (vPremioQuina / vContadorQuina) WHERE ACERTOS = 5;
      END IF;
      
      IF vContadorQuadra > 1 THEN
        UPDATE APOSTA_PREMIADA SET VALOR = (vPremioQuadra / vContadorQuadra) WHERE ACERTOS = 4;
      END IF;
      
      IF vContadorMega = 0 THEN 
        UPDATE CONCURSO SET ACUMULOU = 1 WHERE IDCONCURSO = pConcurso;
      ELSIF vContadorMega > 0 THEN
        UPDATE CONCURSO SET ACUMULOU = 0 WHERE IDCONCURSO = pConcurso;
      END IF;

   END atualizaAcertadores;
   
begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;