-- Exercicio 01
DECLARE
    CURSOR c_listacidaderepetida IS
        SELECT nome, uf, COUNT(*)
        FROM cidade
        GROUP BY nome, uf
        HAVING COUNT(*) > 1
        ORDER BY nome;
        
    CURSOR C_ListaCli (nomeCidade in varchar2, ufCidade in varchar2) IS
     Select cli.Nome From Cliente cli INNER JOIN Cidade cid ON
     cid.IdCidade = cli.IdCidade WHERE cid.Nome = nomeCidade;

BEGIN
    FOR cid IN c_listacidaderepetida LOOP
        dbms_output.put_line( 'CIDADE - UF' );
        dbms_output.put_line( cid.nome  ||  '-'  ||  cid.uf );
        dbms_output.put_line( 'CLIENTES DE ' || cid.nome );
        FOR cliente IN C_ListaCli(cid.Nome, cid.uf) LOOP
         dbms_output.put_line(cliente.Nome);
        END LOOP;
        dbms_output.put_line( ' ' );
    END LOOP;
END;

-- Exercicio 02
/* 
Atualizando Valor do Pedido
Faça uma rotina que permita atualizar o valor do pedido a partir dos seus itens. 
Esta rotina deve receber por parametro o IDPedido e então verificar o valor total de seus itens (quantidade x valor unitário).
*/
DECLARE
    CURSOR c_itemsPedido (p_idpedido in number) IS
        SELECT quantidade, idProduto, precoUnitario FROM PedidoItem pi WHERE pi.IdPedido = p_idpedido;
    soma NUMBER := 0;
    precoProduto NUMBER;
BEGIN
    FOR reg IN c_itemsPedido(1) LOOP
          soma := soma + reg.precoUnitario*reg.quantidade;    
    END LOOP;
    
    UPDATE Pedido SET ValorPedido = soma WHERE idPedido = 1;
      
END;

 -- Solucao alternativa 
    
     UPDATE Pedido SET ValorPedido = 
     (SELECT SUM(quantidade*precoUnitario) FROM 
       PedidoItem WHERE idPedido =: idPedido
     )
     WHERE idPedido =: idPedido;
