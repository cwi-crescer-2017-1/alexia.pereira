create table Empregado (
 IDEmpregado    int not null
,NomeEmpregado  varchar(30) not null
,Cargo          varchar(15) not null
,IDGerente      int null
,DataAdmissao   datetime not null
,Salario        decimal(7,2) not null
,Comissao       decimal(7,2)
,IDDepartamento int
);

/* 1) Faça uma consulta que retorne os empregados em ordem de admissão, projetar apenas ID e Nome. */
SELECT idEmpregado, nomeEmpregado FROM empregado ORDER BY dataAdmissao ASC;

/* 2) Faça uma consulta que liste todos os empregados que não recebam comissão, deve ser ordenado pelo salário. */
SELECT * FROM empregado WHERE comissao IS NULL ORDER BY salario ASC;

/* 3) Faça uma consulta que retorno o nome dos empregados, o salário anual (considere 13 salários), 
projete também a comissão (considere 12x). As colunas que deverão ser exibidas são:
ID do Empregado
Nome
Salario Anual
Comissão Anual
Renda Anual
*/
SELECT idEmpregado AS [ID do Empregado], nomeEmpregado AS Nome, salario*13 AS SalarioAnual, comissao*12 AS ComissaoAnual, 
COALESCE(salario*13+comissao*12, salario*13) AS RendaAnual
FROM empregado;

SELECT idEmpregado AS [ID do Empregado], nomeEmpregado AS Nome, salario*13 AS SalarioAnual, comissao*12 AS ComissaoAnual, 
salario*13 + ISNULL(comissao, 0) AS RendaAnual
FROM empregado;

/* 4) Faça uma consulta que liste todos os empregados que tenham o salário anual seja inferior a R$ 18500 
ou que tenham o cargo de Atendente. Projetar as seguintes colunas:
ID do Empregado
Nome
Cargo
Salário Mensal */
SELECT idEmpregado AS [ID do Empregado] , nomeempregado AS Nome, Cargo, salario AS SalarioMensal FROM empregado 
WHERE salario*13 < 18500 OR cargo = 'Atendente'; 