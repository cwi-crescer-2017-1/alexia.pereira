-- 1
/* Liste o nome do empregado, o nome do gerente e o departamento de cada um. */
SELECT e.NomeEmpregado, g.NomeEmpregado AS NomeGerente, d.NomeDepartamento FROM empregado e 
INNER JOIN empregado g ON e.IdGerente = g.idEmpregado 
INNER JOIN departamento d ON e.IdDepartamento = d.IdDepartamento;

-- 2
/* Liste o deparamento (id e nome) com o empregado de maior salário. */
SELECT d.IdDepartamento, d.NomeDepartamento, MAX(e.Salario) AS MaiorSalario FROM departamento d INNER JOIN
empregado e ON e.IdDepartamento = d.IdDepartamento GROUP BY d.IdDepartamento, d.NomeDepartamento;

-- 3
/* Aplique uma alteração salarial em todos os empregados que o departamento fique na localidade de SAO PAULO, 
este reajuste deve ser de 17,3%. Por segurança faça uma cópia da tabela Empregado antes de iniciar esta tarefa. */

SELECT * INTO EmpregadoCopy FROM Empregado; 

UPDATE empregado SET salario += salario * 0.173 
WHERE 'SAO PAULO' IN (SELECT d.Localizacao FROM departamento d 
		INNER JOIN empregado e ON d.IdDepartamento = e.IdDepartamento) 

-- 4
/* Liste todas as cidades duplicadas (nome e UF iguais). */
SELECT Nome, UF, COUNT(*) AS Repeticao FROM cidade GROUP BY Nome, UF HAVING COUNT(*) > 1;

-- 5
/* Faça uma alteraçao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco.
	 Mas atenção! apenas a cidade com maior ID deve ser alterada. */
BEGIN TRANSACTION;
SELECT * INTO CidadeCopy FROM Cidade; 

UPDATE cidade SET nome = nome + '*' WHERE idCidade IN 
	(SELECT temp.idCidade FROM 
		(SELECT MAX(idCidade) AS idCidade, Nome, UF, COUNT(*) AS Repeticao FROM cidade GROUP BY Nome, UF HAVING COUNT(*) > 1
		) AS temp
	);