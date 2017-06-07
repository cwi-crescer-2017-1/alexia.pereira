using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
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
            return contexto.Locacoes.ToList();
        }

        public void Cadastrar(Locacao locacao)
        {
            contexto.Locacoes.Add(locacao);
            contexto.SaveChanges();
        }

        public Locacao Obter(int id)
        {
            return contexto.Locacoes.FirstOrDefault(l => l.Id == id);
        }

        public List<Cliente> ObterClientesComLocacoesAtrasadas()
        {
            return contexto.Locacoes
                .Include("Cliente")
                .Where(l => l.DataEntregaReal == null && l.DataEntregaPrevista < DateTime.Now)
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

    }
}
