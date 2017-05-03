-- Lista 06

-- 1
/* Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome. */
SELECT TOP (1) fn.primeiroNome AS PrimeiroNome, COUNT(fn.primeiroNome) AS TotalOcorrencia FROM
(SELECT (Substring(cliente.Nome, 1, CHARINDEX(' ', cliente.Nome)-1)) AS primeiroNome FROM cliente) AS fn 
GROUP BY fn.PrimeiroNome ORDER BY TotalOcorrencia DESC;

-- 2
/* Liste o total de pedidos (quantidade e valor) realizados no m�s de abril/2017. */
SELECT COUNT(p.IdPedido) AS Quantidade, SUM(p.ValorPedido) AS ValorPedido
FROM pedido p WHERE YEAR(DataPedido) = 2017 AND MONTH (DataPedido) = 4;

-- 3
/* Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes (tabela Cliente), 
	liste tamb�m qual o Estado possu� o menor n�mero de clientes. */


SELECT temp.UF, temp.Quantidade FROM 
	(SELECT ci.UF, COUNT(cl.idCliente) AS Quantidade FROM cliente cl INNER JOIN cidade ci ON 
		ci.IdCidade = cl.IdCidade GROUP BY ci.UF
	) AS temp
WHERE temp.Quantidade IN
	(SELECT MAX(temp2.Quantidade) FROM 
		(SELECT COUNT(cl.idCliente) AS Quantidade FROM cliente cl INNER JOIN
			cidade ci ON ci.IdCidade = cl.IdCidade GROUP BY ci.UF
		) AS temp2
	)
OR temp.Quantidade IN
(SELECT MIN(temp3.Quantidade) FROM 
		(SELECT COUNT(cl.idCliente) AS Quantidade FROM cliente cl INNER JOIN
			cidade ci ON ci.IdCidade = cl.IdCidade GROUP BY ci.UF
		) AS temp3
	)
 ORDER BY Quantidade ASC;