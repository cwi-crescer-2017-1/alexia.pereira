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

-- Exercicio 03
UPDATE Cliente SET Situacao = 'I' WHERE IdCliente NOT IN
    (SELECT IdCliente FROM Pedido WHERE MONTHS_BETWEEN 
        (TO_DATE(sysdate), TO_DATE(pedido.DataPedido) ) < = 6);

-- Exercicio 04
DECLARE

    CURSOR c_SomaProdutosPorData (p_idProduto in number, p_AnoMes in varchar2) IS
            SELECT idProduto, SUM(pi.quantidade) AS quantidade FROM Pedido p 
            INNER JOIN PEDIDOITEM pi ON p.IdPedido = pi.IdPedido 
            WHERE TO_CHAR(p.DataPedido, 'YYYY/MM') = p_AnoMes 
            AND pi.IdProduto = p_idProduto GROUP BY idProduto;
            
    CURSOR c_MateriaisPorProduto (p_idProduto in number) IS
        SELECT mat.descricao, pm.quantidade FROM Material mat INNER JOIN ProdutoMaterial pm ON
        pm.IdMaterial = mat.IdMaterial INNER JOIN Produto p ON p.IdProduto = pm.IdProduto WHERE
        pm.idProduto = p_idProduto AND pm.quantidade IS NOT NULL;
        
        aux NUMBER := 0;
    
BEGIN
    FOR soma IN c_SomaProdutosPorData (4246, '2017/04') LOOP
        FOR reg IN c_MateriaisPorProduto (soma.IdProduto) LOOP
           dbms_output.put_line(reg.descricao || ' - ' || TO_CHAR(reg.quantidade * soma.quantidade));
        END LOOP;
    END LOOP;
END;
