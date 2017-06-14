 begin
  pck_cidades_duplicadas.corrigir_cidades_duplicadas;
end;

create or replace package pck_cidades_duplicadas as
  procedure corrigir_cidades_duplicadas;
  function busca_menor_id (pNome varchar2, pUf varchar2) return number;
end;

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
        FOR cliente IN C_ListaCli(cid.Nome, cid.uf) LOOP
           UPDATE Cliente SET IdCidade = pck_cidades_duplicadas.busca_menor_id(cid.Nome, cid.Uf)
           WHERE IdCliente = cliente.IdCliente;
        END LOOP;
        excluir_cidades(cid.Nome, cid.Uf, pck_cidades_duplicadas.busca_menor_id(cid.Nome, cid.Uf));
    END LOOP;
END;
END pck_cidades_duplicadas;