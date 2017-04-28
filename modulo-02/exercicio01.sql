-- 1
SELECT * INTO CidadeAux FROM cidade;

SELECT * FROM CidadeAux;

-- 2
TRUNCATE TABLE CidadeAux;

INSERT INTO CidadeAux(idCidade, nome, UF) SELECT * FROM Cidade WHERE Cidade.UF = 'RS';

-- 3
CREATE TABLE produto (
	id_produto INT NOT NULL,
	nome_curto VARCHAR(15) NOT NULL,
	nome_descritivo VARCHAR(100) NOT NULL,
	data_criacao DATE NOT NULL,
	local_no_estoque VARCHAR(30),
	quantidade INT NOT NULL,
	preco FLOAT NOT NULL,
	CONSTRAINT PK_Produto PRIMARY KEY (id_produto)
);

--4
INSERT INTO produto (id_produto, nome_curto, nome_descritivo, data_criacao, local_no_estoque, quantidade, preco)
VALUES (1, 'Computador', 'Computador Dell', '28/04/17', 'A12', 3, 2800);

INSERT INTO produto (id_produto, nome_curto, nome_descritivo, data_criacao, local_no_estoque, quantidade, preco)
VALUES (2, 'Celular', 'Zenfone 2', '28/04/17', 'B20', 5, 1000);


