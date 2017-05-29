using System.Data.SqlClient;
using Demo1.Dominio.Entidades;
using System.Collections.Generic;

namespace Demo1.Infraestrutura.Repositorios
{
    public class ProdutoRepositorio
    {
        string stringConexao = "Server=13.65.101.67;User Id=alexia.pereira;Password=123456;Database=aluno16db";

        public void Criar (Produto produto)
        {
            
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {


                    comando.CommandText = "INSERT INTO Produto (Nome, Preco, Estoque) VALUES (@nome, @preco, @estoque)";
                    comando.Parameters.AddWithValue("@nome", produto.Nome);
                    comando.Parameters.AddWithValue("@preco", produto.Preco);
                    comando.Parameters.AddWithValue("@estoque", produto.Estoque);

                    //Executa o comando e retorna somente a quantidade de linhas alterdas
                    comando.ExecuteNonQuery();
                    //Executa o comando e lê o resultado de um SELECT 
                    //comando.ExecuteReader();
                    //Executa o comando e lê o primeiro comando de retorno
                    //comando.ExecuteScalar();
                }
                //Obtem o ID criado
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    //Executa o comando e lê o primeiro comando de retorno
                    var result = (decimal)comando.ExecuteScalar();
                    produto.Id = (int)result;
                }
            }
        }

        public List<Produto> Listar ()
        {
            var produtos = new List<Produto>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT Id, Nome, Preco, Estoque FROM Produto";
                    var dataReader = comando.ExecuteReader();
                    while(dataReader.Read())
                    {
                        Produto produto = new Produto();
                        produto.Id = (int)dataReader["Id"];
                        produto.Nome = (string)dataReader["Nome"];
                        produto.Preco = (decimal)dataReader["Preco"];
                        produto.Estoque = (int)dataReader["Estoque"];

                        produtos.Add(produto);
                    }
                }
            }

            return produtos;
        }

    }
}
