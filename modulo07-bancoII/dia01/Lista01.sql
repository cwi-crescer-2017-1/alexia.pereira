Create view vwProdutosCompradosHa4Meses as
SELECT idProduto FROM pedidoItem INNER JOIN pedido ON pedidoItem.IdPedido = pedido.IdPedido
WHERE MONTHS_BETWEEN 
   (TO_DATE(sysdate),
    TO_DATE(pedido.DataPedido) ) < = 4;
    
-- Liste os produtos (id e nome) que não tiveram nenhuma compra nos últimos quatro meses.
SELECT p.IdProduto, p.Nome FROM produto p WHERE p.IdProduto NOT IN 
(SELECT * FROM VwProdutosCompradosHa4Meses);
    
-- Altere o status dos produtos (campo situacao) que não tiveram nenhum pedido nos últimos quatro meses. 
-- Definir o valor I para o campo situacao.
UPDATE Produto SET SITUACAO = 'I' WHERE produto.IdProduto NOT IN 
(SELECT * FROM VwProdutosCompradosHa4Meses);

-- Faça uma consulta que receba um parâmetro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem
-- com este IDProduto foram vendidos no último ano (desde janeiro/2017).

SELECT SUM (quantidade) AS QuantidadeProdutos FROM 
(
  (SELECT SUM(pi.quantidade), pi.IdPedido AS quantidade FROM PedidoItem pi INNER JOIN Produto p ON pi.IdProduto = p.IdProduto
    WHERE p.IdProduto = :id GROUP BY pi.IdProduto
  ) INNER JOIN Pedido pe ON pi.IdPedido = pe.IdPedido WHERE TO_DATE(pe.DataPedido) BETWEEN TO_DATE('01-01-2017', 'DD-MM-AAAA') AND
  TO_DATE(sysdate)
)    


COMMIT;