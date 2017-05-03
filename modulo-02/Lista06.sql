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

-- 3
/* Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes (tabela Cliente), 
	liste também qual o Estado possuí o menor número de clientes. */
	
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

 -- 4
 /* Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:

Nome: Galocha Maragato
Preço de custo: 35.67
Preço de venda: 77.95
Situação: A */

INSERT INTO Produto (Nome, PrecoCusto, PrecoVenda, Situacao) VALUES
('Galocha Maragato', 35.67, 77.95, 'A');

-- 5
/* Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de dados, 
pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
=> Obs.: o produto criado anteriormente deverá ser listado (apenas este) */

SELECT * FROM produto prod LEFT JOIN PedidoItem i ON prod.IdProduto = i.IdProduto 
LEFT JOIN pedido p ON p.IdPedido = i.IdPedido WHERE i.IdProduto IS NULL;
