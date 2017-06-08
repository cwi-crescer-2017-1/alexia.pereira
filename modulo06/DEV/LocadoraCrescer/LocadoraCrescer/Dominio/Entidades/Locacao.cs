using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Locacao
    {
        public int Id { get; set; }
        public Veiculo Veiculo { get; set; }
        public Cliente Cliente { get; set; }
        public Pacote Pacote { get; set; }
        public DateTime DataLocacao { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaReal { get; set; }
        public decimal ValorLocacao { get; set; }
        public decimal ValorDesconto { get; set; }
        public List<LocacaoOpcional> LocacaoOpcionais { get; set; }

        public Locacao()
        {

        }

        public Locacao(Veiculo veiculo, Cliente cliente, Pacote pacote,
            DateTime dataEntregaPrevista, decimal valorLocacao, List<LocacaoOpcional> locacaoOpcionais)
        {
            Veiculo = veiculo;
            Cliente = cliente;
            Pacote = pacote;
            DataEntregaPrevista = dataEntregaPrevista;
            ValorLocacao = valorLocacao;
            LocacaoOpcionais = locacaoOpcionais;
            DataLocacao = DateTime.Now;
        }
    }
}
