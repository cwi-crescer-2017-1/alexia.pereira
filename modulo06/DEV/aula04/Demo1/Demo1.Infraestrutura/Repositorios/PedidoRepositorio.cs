using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao = "Server=13.65.101.67;User Id=alexia.pereira;Password=123456;Database=aluno16db";
        ItemPedidoRepositorio _itemPedidoRepositorio = new ItemPedidoRepositorio();

        public void Alterar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o INSERT
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"UPDATE Pedido SET NomeCliente = @nome WHERE Id = @id";

                    comando.Parameters.AddWithValue("@nome", pedido.NomeCliente);
                    comando.Parameters.AddWithValue("@id", pedido.Id);

                    // Executa o comando e 
                    // retorna somente a quantidade de linhas afetads
                    comando.ExecuteNonQuery();
                }
            }
        }

        public void Criar(Pedido pedido)
        {
            // realizar o insert do Pedido
            // obter o ultimo id do pedido (SELECT @@IDENTITY)
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "INSERT INTO Pedido (NomeCliente) VALUES (@nomeCliente)";
                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);

                    comando.ExecuteNonQuery();
                }
                //Obtem o ID criado
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    //Executa o comando e lê o primeiro comando de retorno
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }
            }

            // para cada item do pedido, realizar o insert do ItemPedido
            // obter o ultimo id do ItemPedido (SELECT @@IDENTITY)
            foreach (var itemPedido in pedido.Itens)
            {
                var mensagens = new List<string>();
                if (!itemPedido.Validar(out mensagens))
                    break;
                _itemPedidoRepositorio.Criar(itemPedido, pedido);
            }
        }

        public void Excluir(int id)
        {
            var pedido = this.Obter(id);
            foreach (var item in pedido.Itens)
            {
                _itemPedidoRepositorio.Excluir(item.Id);
            }

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "DELETE Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    comando.ExecuteNonQuery();
                }
            }
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT Id, NomeCliente FROM Pedido";
                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        Pedido pedido = new Pedido();
                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];

                        pedido.Itens = _itemPedidoRepositorio.ListarPorPedido(pedido.Id);
                        
                        pedidos.Add(pedido);
                    }
                }
            }
            return pedidos;
        }

        public Pedido Obter(int id)
        {
            Pedido pedido = null;

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        "SELECT Id, NomeCliente FROM Pedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        pedido = new Pedido();
                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];

                        pedido.Itens = _itemPedidoRepositorio.ListarPorPedido(pedido.Id);

                        return pedido;
                    }
                }
            }

            return pedido;
        }
    }
}

