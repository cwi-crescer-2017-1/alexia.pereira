using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class LocacoesOpcionaisRepositorio : IDisposable
    {
        Contexto contexto;

        public LocacoesOpcionaisRepositorio()
        {
            contexto = new Contexto();
        }

        public List<LocacaoOpcional> Obter()
        {
            return contexto.LocacoesOpcionais
                .Include("Locacao")
                .Include("Opcional")
                .ToList();
        }

        public void Cadastrar(LocacaoOpcional locacaoOpcional)
        {
            contexto.LocacoesOpcionais.Add(locacaoOpcional);
            contexto.SaveChanges();
        }

        public LocacaoOpcional Obter(int id)
        {
            return contexto.LocacoesOpcionais
                .Include("Locacao")
                .Include("Opcional")
                .FirstOrDefault(l => l.Id == id);
        }

        public List<LocacaoOpcional> ObterPorLocacao(int idLocacao)
        {
            return contexto.LocacoesOpcionais
                .Where(lo => lo.Locacao.Id == idLocacao)
                .ToList();
        }

        public void Remover(int id)
        {
            contexto.LocacoesOpcionais.Remove(Obter(id));
            contexto.SaveChanges();
        }

        public LocacaoOpcional Atualizar(LocacaoOpcional locacaoOpcional)
        {
            contexto.Entry(locacaoOpcional).State = EntityState.Modified;
            contexto.SaveChanges();
            return locacaoOpcional;
        }

        public bool LocacaoOpcionalExiste(int id)
        {
            return contexto.LocacoesOpcionais.Count(l => l.Id == id) > 0;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
