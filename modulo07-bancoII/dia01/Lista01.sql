Create view vwProdutosCompradosHa4Meses as
SELECT idProduto FROM pedidoItem INNER JOIN pedido ON pedidoItem.IdPedido = pedido.IdPedido
WHERE MONTHS_BETWEEN 
   (TO_DATE(sysdate),
    TO_DATE(pedido.DataPedido) ) < = 4;
    
-- Liste os produtos (id e nome) que n�o tiveram nenhuma compra nos �ltimos quatro meses.
SELECT p.IdProduto, p.Nome FROM produto p WHERE p.IdProduto NOT IN 
(SELECT * FROM VwProdutosCompradosHa4Meses);
    
-- Altere o status dos produtos (campo situacao) que n�o tiveram nenhum pedido nos �ltimos quatro meses. 
-- Definir o valor I para o campo situacao.
UPDATE Produto SET SITUACAO = 'I' WHERE produto.IdProduto NOT IN 
(SELECT * FROM VwProdutosCompradosHa4Meses);

-- Fa�a uma consulta que receba um par�metro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem
-- com este IDProduto foram vendidos no �ltimo ano (desde janeiro/2017).

   SELECT SUM(pi.quantidade) AS quantidade FROM PedidoItem pi
    INNER JOIN Pedido pe ON pi.IdPedido = pe.IdPedido 
    WHERE pe.DataPedido BETWEEN date '2017-01-01' AND
    TO_DATE(sysdate)
    AND pi.IdProduto = :id;


SELECT * FROM user_tables;
EXEC dbms_stats.gather_schema_stats( USER );

COMMIT;