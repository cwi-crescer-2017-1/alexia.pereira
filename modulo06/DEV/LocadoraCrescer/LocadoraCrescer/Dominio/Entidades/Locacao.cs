using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Locacao : EntidadeBasica
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
            DateTime dataEntregaPrevista, decimal valorLocacao)
        {
            Veiculo = veiculo;
            Cliente = cliente;
            Pacote = pacote;
            DataEntregaPrevista = dataEntregaPrevista;
            ValorLocacao = valorLocacao;
            DataLocacao = DateTime.Now;
            LocacaoOpcionais = new List<LocacaoOpcional>();
        }

        public bool ValidarVeiculoEOpcional()
        {
            foreach (var locacaoOpcional in LocacaoOpcionais)
            {
                if (locacaoOpcional.Opcional.Descricao == "Reboque" && Veiculo.Nome == "Mobi")
                    Mensagens.Add("Mobi não pode ter Reboque.");
                if (locacaoOpcional.Opcional.Descricao == "Rack" && Veiculo.Nome == "Hilux")
                    Mensagens.Add("Hilux não pode ter hack.");
                if (locacaoOpcional.Opcional.Descricao == "Cabo Bateria" && Veiculo.Nome != "Kombi")
                    Mensagens.Add("Apenas Kombi pode ter Cabo Bateria.");
            }

            return Mensagens.Count == 0;
        }

        public override bool Validar()
        {
            return ValidarVeiculoEOpcional();
        }
    }
}
