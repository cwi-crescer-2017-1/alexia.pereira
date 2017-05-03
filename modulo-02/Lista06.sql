-- Lista 06

-- 1
/* Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome. */
SELECT TOP (1) fn.primeiroNome AS PrimeiroNome, COUNT(fn.primeiroNome) AS TotalOcorrencia FROM
(SELECT (Substring(cliente.Nome, 1, CHARINDEX(' ', cliente.Nome)-1)) AS primeiroNome FROM cliente) AS fn 
GROUP BY fn.PrimeiroNome ORDER BY TotalOcorrencia DESC;

-- 2
/* Liste o total de pedidos (quantidade e valor) realizados no mês de abril/2017. */
SELECT COUNT(p.IdPedido) AS Quantidade, SUM(p.ValorPedido) AS ValorPedido
FROM pedido p WHERE YEAR(DataPedido) = 2017 AND MONTH (DataPedido) = 4;
