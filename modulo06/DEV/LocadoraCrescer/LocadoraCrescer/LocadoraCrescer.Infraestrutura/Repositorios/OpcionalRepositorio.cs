using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class OpcionaisRepositorio : IDisposable
    {
        Contexto contexto;

        public OpcionaisRepositorio()
        {
            contexto = new Contexto();
        }

        public List<Opcional> Obter()
        {
            return contexto.Opcionais.ToList();
        }

        public Opcional Obter(int id)
        {
            return contexto.Opcionais.FirstOrDefault(l => l.Id == id);
        }

        public Opcional Atualizar(Opcional opcional)
        {
            contexto.Entry(opcional).State = EntityState.Modified;
            contexto.SaveChanges();
            return opcional;
        }

        public Opcional AtualizarEstoque(Opcional opcional)
        {
            contexto.Entry(opcional).State = EntityState.Modified;
            opcional.Quantidade--;
            contexto.SaveChanges();
            return opcional;
        }

        public bool OpcionalExiste(int id)
        {
            return contexto.Opcionais.Count(o => o.Id == id) > 0;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
