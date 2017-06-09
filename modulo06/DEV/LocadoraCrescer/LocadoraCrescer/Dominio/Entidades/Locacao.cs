using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Locacao : EntidadeBasica
    {
        public int Id { get; private set; }
        public Veiculo Veiculo { get; private set; }
        public Cliente Cliente { get; private set; }
        public Pacote Pacote { get; private set; }
        public DateTime DataLocacao { get; private set; }
        public DateTime DataEntregaPrevista { get; private set; }
        public DateTime? DataEntregaReal { get; private set; }
        public decimal ValorLocacao { get; private set; }
        public decimal ValorDesconto { get; private set; }
        public List<LocacaoOpcional> LocacaoOpcionais { get; private set; }

        public Locacao()
        {

        }

        public Locacao(Veiculo veiculo, Cliente cliente, Pacote pacote,
            DateTime dataEntregaPrevista)
        {
            Veiculo = veiculo;
            Cliente = cliente;
            Pacote = pacote;
            DataEntregaPrevista = dataEntregaPrevista;
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
                    Mensagens.Add("Hilux não pode ter Rack.");
                if (locacaoOpcional.Opcional.Descricao == "Cabo Bateria" && Veiculo.Nome != "Kombi")
                    Mensagens.Add("Apenas Kombi pode ter Cabo Bateria.");
            }

            return Mensagens.Count == 0;
        }

        public override bool Validar()
        {
            return ValidarVeiculoEOpcional() && Cliente.Validar();
        }

        public void calcularValorInicialLocacao()
        {
            var diasLocados = Convert.ToInt32(DataEntregaPrevista.Subtract(DataLocacao).TotalDays);
            var totalPacote = Pacote == null ? 0 : diasLocados * Pacote.Valor;
            var totalVeiculo = diasLocados * Veiculo.ValorDiario;
            decimal totalOpcionais = 0;
            foreach (var locacaoOpcional in LocacaoOpcionais)
            {
                totalOpcionais += locacaoOpcional.Opcional.Preco;
            }
            ValorLocacao = totalVeiculo + totalPacote + totalOpcionais;
        }

        public void calcularDevolucao()
        {
            var diasDeAtraso = Convert.ToInt32(DataEntregaReal.Value.Subtract(DataEntregaPrevista).TotalDays);
            ValorDesconto = diasDeAtraso * Veiculo.ValorAdicional;
        }

        public void AtribuirDataDevolucaoReal ()
        {
            DataEntregaReal = DateTime.Now;
        }

        public void atualizarEstoqueItens()
        {
            Veiculo.AtualizarEstoque();
            foreach (var locacaoOpcional in LocacaoOpcionais)
            {
                locacaoOpcional.Opcional.AtualizarEstoque();
            }
        }

    }
}
