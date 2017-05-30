using System.Data.SqlClient;
using Demo1.Dominio.Entidades;
using System.Collections.Generic;

namespace Demo1.Infraestrutura.Repositorios
{
    public class ItemPedidoRepositorio
    {
        string stringConexao = "Server=13.65.101.67;User Id=alexia.pereira;Password=123456;Database=aluno16db";
        ProdutoRepositorio _produtoRepositorio = new ProdutoRepositorio();

        public void Criar(ItemPedido itemPedido, Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "INSERT INTO ItemPedido (PedidoId, ProdutoId, Quantidade) VALUES (@pedidoId, @produtoId, @quantidade)";
                    comando.Parameters.AddWithValue("@pedidoId", pedido.Id);
                    comando.Parameters.AddWithValue("@produtoId", itemPedido.ProdutoId);
                    comando.Parameters.AddWithValue("@quantidade", itemPedido.Quantidade);

                    _produtoRepositorio.AtualizarEstoque(itemPedido.ProdutoId, itemPedido.Quantidade);

                    comando.ExecuteNonQuery();
                }
                //Obtem o ID criado
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    //Executa o comando e lê o primeiro comando de retorno
                    var result = (decimal)comando.ExecuteScalar();
                    itemPedido.Id = (int)result;
                }
            }
        }

        public List<ItemPedido> ListarPorPedido(int idPedido)
        {
            var itensPedido = new List<ItemPedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT Id, ProdutoId, Quantidade FROM ItemPedido WHERE PedidoId = @id";
                    comando.Parameters.AddWithValue("@id", idPedido);
                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        ItemPedido itemPedido = new ItemPedido();
                        itemPedido.Id = (int)dataReader["Id"];
                        itemPedido.ProdutoId = (int)dataReader["ProdutoId"];
                        itemPedido.Quantidade = (int)dataReader["Quantidade"];
                        
                        itensPedido.Add(itemPedido);
                    }
                }
            }

            return itensPedido;
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o INSERT
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE ItemPedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);
                    
                    comando.ExecuteNonQuery();
                }
            }
        }

        public ItemPedido Obter(int id)
        {
            ItemPedido itemPedido = null;

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        "SELECT Id, ProdutoId, Quantidade FROM ItemPedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        itemPedido = new ItemPedido();
                        itemPedido.Id = (int)dataReader["Id"];
                        itemPedido.ProdutoId = (int)dataReader["ProdutoId"];
                        itemPedido.Quantidade = (int)dataReader["Quantidade"];
                        return itemPedido;
                    }
                }
            }

            return itemPedido;
        }
    }
}