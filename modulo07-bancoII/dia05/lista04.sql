-- Exercicio 01
  -- Aposta
Create table LogAposta (
  IDLogAposta   integer not null,
  IDAposta      integer not null,
  Operacao       char(1) not null,
  Usuario        varchar2(50),
  Data           date default sysdate,
    constraint PK_LogAposta 
       primary key (IDLogAposta)
);
Create sequence sqLogAposta;
create or replace trigger TR_AUD_APOSTA
    after insert or update or delete on Aposta
    for each row
Declare
  v_idAposta   Integer;
  v_operacao    Char(1);
  
Begin
  if INSERTING then
     v_operacao    := 'I';
     v_idAposta   := :new.idAposta;
  elsif UPDATING then
     v_operacao := 'U';       
     v_idAposta   := :old.idAposta;
  else
     v_operacao := 'D';
     v_idAposta   := :old.idAposta;
  end if;

  Insert into LogAposta (idlogaposta, idaposta, operacao, usuario, data)
      values (sqlogaposta.nextval, v_idAposta, v_operacao, user, sysdate);

End TR_AUD_APOSTA;
  -- NumeroAposta
Create table LogNumeroAposta (
  IDLogNumeroAposta   integer not null,
  IDNumeroAposta      integer not null,
  Operacao       char(1) not null,
  Usuario        varchar2(50),
  Data           date default sysdate,
  Numero_Novo      number,
  Numero_Antigo    number,
    constraint PK_LogNumeroAposta 
       primary key (IDLogNumeroAposta)
);
CREATE SEQUENCE sqLogNumeroAposta;
create or replace trigger TR_AUD_NUMERO_APOSTA
    after insert or update or delete on NUMERO_APOSTA
    for each row
Declare
  v_idNumeroAposta   Integer;
  v_operacao    Char(1);
  v_numero_Antigo numero_aposta.Numero%type;
  v_numero_novo   numero_aposta.Numero%type;
  
Begin
  if INSERTING then
     v_operacao    := 'I';
     v_idNumeroAposta   := :new.idNumero_Aposta;
     v_numero_novo   := :new.numero; 
     v_numero_Antigo := NULL;
  elsif UPDATING then
     v_operacao := 'U';       
     v_idNumeroAposta   := :old.idNumero_Aposta;  -- MANTEVE-SE O "OLD" PORQUE O ID NÃO DEVE SER ALTERADO
     v_numero_novo   := :new.numero;       -- NOVO NOME
     v_numero_Antigo := :old.numero;     -- ANTIGO NOME
  else
     v_operacao := 'D';
     v_idNumeroAposta   := :old.idNumero_Aposta;  -- 
     v_numero_novo   := NULL;            -- EM OPERAÇÕES DE DELETE NÃO EXISTEM VALORES "NOVOS"
     v_numero_Antigo := :old.numero;     -- NOME ANTES DA EXCLUSÃO
  end if;

  Insert into LogNumeroAposta (IDLogNumeroAposta, IDNumeroAposta, operacao, usuario, data, numero_antigo, Numero_novo)
      values (sqLogNumeroAposta.nextval, v_idNumeroAposta, v_operacao, user, sysdate, v_numero_antigo, v_Numero_novo);

End TR_AUD_NUMERO_APOSTA;

-- Exercicio 02

SELECT C.UF, 
COUNT(AP.IDAPOSTA_PREMIADA) AS QUANTIDADE_GANHADORES, 
SUM (AP.VALOR) AS VALOR_GANHADORES, 
COUNT(A.IDAPOSTA) AS NUMERO_APOSTAS, 
SUM(A.VALOR) AS VALOR_ARRECADADO
FROM APOSTA A INNER JOIN CIDADE C ON
A.IDCIDADE = C.IDCIDADE 
INNER JOIN APOSTA_PREMIADA AP
ON AP.IDAPOSTA = A.IDAPOSTA
WHERE A.IDCONCURSO = 1824
GROUP BY C.UF
ORDER BY NUMERO_APOSTAS, VALOR_ARRECADADO DESC;

-- Exercicio 03
SELECT * FROM APOSTA WHERE IDAPOSTA IN
  (SELECT IDAPOSTA FROM LOGAPOSTA WHERE OPERACAO = 'U' 
    OR OPERACAO = 'I' AND DATA > 
    (SELECT DATA_SORTEIO FROM CONCURSO WHERE IDCONCURSO = 1824)
  );

