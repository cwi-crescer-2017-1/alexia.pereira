 begin
  pck_cidades_duplicadas.corrigir_cidades_duplicadas;
end;

SELECT * FROM CIDADE WHERE NOME ='Caico' AND UF = 'RN';

SELECT * FROM CLIENTE INNER JOIN CIDADE ON cliente.IdCidade = cidade.IdCidade
  WHERE cidade.Nome = 'Caico' AND cidade.UF = 'RN';
  
  
  create or replace package body pck_cidades_duplicadas as

FUNCTION busca_menor_id (pNome in varchar2, pUf in varchar2) RETURN NUMBER AS
  vMenorId NUMBER; 
BEGIN
  SELECT MIN(idCidade) INTO vMenorId
  FROM cidade WHERE Nome = pNome AND Uf = pUf;
  return vMenorId;
END;
-----------------------------------------------
procedure excluir_cidades(pNome in varchar2, pUf in varchar2, pMenorId in number) is
  BEGIN
    DELETE FROM CIDADE WHERE nome = pNome AND Uf = pUf AND idCidade != pMenorId; 
  END;
-----------------------------------------------
  procedure corrigir_cidades_duplicadas is

    vMenorIdAtual NUMBER;
    
     CURSOR c_listacidaderepetida IS
        SELECT nome, uf, COUNT(*)
        FROM cidade
        GROUP BY nome, uf
        HAVING COUNT(*) > 1
        ORDER BY nome;

    CURSOR C_ListaCli (nomeCidade in varchar2, ufCidade in varchar2) IS
     Select cli.Nome, cli.IdCliente From Cliente cli INNER JOIN Cidade cid ON
     cid.IdCidade = cli.IdCidade WHERE cid.Nome = nomeCidade AND cid.Uf = ufCidade;

BEGIN
    FOR cid IN c_listacidaderepetida LOOP
    vMenorIdAtual :=  pck_cidades_duplicadas.busca_menor_id(cid.Nome, cid.Uf);
        FOR cli IN C_ListaCli(cid.Nome, cid.uf) LOOP
           UPDATE Cliente SET IdCidade = vMenorIdAtual
           WHERE IdCliente = cli.IdCliente;
        END LOOP;
        excluir_cidades(cid.Nome, cid.Uf, vMenorIdAtual);
    END LOOP;
END;
END pck_cidades_duplicadas;