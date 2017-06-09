using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.SqlServer;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class LocacoesRepositorio : IDisposable
    {
        Contexto contexto;

        public LocacoesRepositorio()
        {
            contexto = new Contexto();
        }

        public List<Locacao> Obter()
        {
            return contexto.Locacoes
                 .Include("Cliente")
                .Include("Veiculo")
                .Include("Pacote")
                .ToList();
        }

        public Locacao Criar(int idCliente, int idVeiculo, int idPacote,
            DateTime dataEntregaPrevista, List<int> idLocacaoOpcional)
        {
            Pacote pacote = null;
            var cliente = contexto.Clientes.FirstOrDefault(c => c.Id == idCliente);
            var veiculo = contexto.Veiculos.FirstOrDefault(v => v.Id == idVeiculo);

            if (idPacote > 0)
                pacote = contexto.Pacotes.FirstOrDefault(p => p.Id == idPacote);


            var locacao = new Locacao(veiculo, cliente, pacote, dataEntregaPrevista);

            foreach (var id in idLocacaoOpcional)
            {
                var opcional = contexto.Opcionais.FirstOrDefault(o => o.Id == id);
                locacao.LocacaoOpcionais.Add(new LocacaoOpcional(locacao, opcional));
            }

            if (!locacao.Validar())
                throw new Exception("Combinação inválida");

            locacao.calcularValorInicialLocacao();
            locacao.atualizarEstoqueItens();
            
            return locacao;
        }

        
        public void Cadastrar(Locacao locacao)
        {
            contexto.Locacoes.Add(locacao);
            contexto.SaveChanges();
            
        }

        public Locacao Obter(int id)
        {
            return contexto.Locacoes
                .Include("Cliente")
                .Include("Veiculo")
                .Include("Pacote")
                .FirstOrDefault(l => l.Id == id);
        }

        public List<Cliente> ObterClientesComLocacoesAtrasadas()
        {
            return contexto.Locacoes
                .Include("Cliente")
                .Where(l => l.DataEntregaReal == null && DateTime.Compare(l.DataEntregaPrevista, DateTime.Now) < 0)
                .OrderBy(l => SqlFunctions.DateDiff("dd", l.DataEntregaPrevista, DateTime.Now))
                .Select(l => l.Cliente)
                .ToList();
        }

        public void Remover(int id)
        {
            contexto.Locacoes.Remove(Obter(id));
            contexto.SaveChanges();
        }

        public Locacao Atualizar(Locacao locacao)
        {
            contexto.Entry(locacao).State = EntityState.Modified;
            contexto.SaveChanges();
            return locacao;
        }

        public bool LocacaoExiste(int id)
        {
            return contexto.Locacoes.Count(l => l.Id == id) > 0;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

        public List<Locacao> BuscarLocacoesPorMes(DateTime data)
        {
            return contexto.Locacoes.Where(l => l.DataEntregaReal != null
            && DbFunctions.AddDays(l.DataEntregaReal, 30) >= data).ToList();
        }
    }
}
