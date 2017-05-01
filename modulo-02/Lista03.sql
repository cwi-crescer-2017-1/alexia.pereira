-- Lista 03


-- 1 
/* Faça uma consulta que liste o total de empregados admitidos no ano de 1980. Deve ser projetado nesta 
consulta: ID, Nome e Idade no momento da admissão. */
SELECT IdEmpregado, NomeEmpregado, 1980-YEAR(DataNascimento) AS Idade FROM empregado 
WHERE YEAR(DataAdmissao) = 1980; 

-- 2 
/*Qual o cargo (tabela empregado) possui mais empregados?
Deve ser projetado apenas um registro. ** DICA: Pesquise recursos específicos para esta funcionalidade. */
SELECT TOP(1) Cargo, COUNT(idEmpregado) AS NumeroDeEmpregados FROM empregado 
GROUP BY cargo ORDER BY NumeroDeEmpregados DESC;

-- 3 
/* Liste os estados (atributo UF) e o total de cidades existente em cada estado na tabela cidade. */
SELECT UF, COUNT(Nome) FROM cidade GROUP BY UF;

-- 4 
/* Crie um novo departamento, denominado 'Inovação' com localização em 'SÃO LEOPOLDO'. Todos os empregados 
que foram admitidos no mês de dezembro (qualquer ano) que não ocupam o cargo de 'Atendente' devem ser ter
o departamento (IDDepartamento) atualizado para este novo registro (inovação). */
INSERT INTO Departamento (idDepartamento, nomeDepartamento, localizacao) 
	VALUES (4, 'Inovação', 'SÃO LEOPOLDO');
UPDATE empregado SET IdDepartamento = 4 WHERE MONTH(DataAdmissao) = 12 AND cargo != 'Atendente';

