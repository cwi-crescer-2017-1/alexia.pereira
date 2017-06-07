using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class PacotesRepositorio : IDisposable
    {
        Contexto contexto;

        public PacotesRepositorio()
        {
            contexto = new Contexto();
        }

        public List<Pacote> Obter()
        {
            return contexto.Pacotes.ToList();
        }

        
        public Pacote Obter(int id)
        {
            return contexto.Pacotes.FirstOrDefault(p => p.Id == id);
        }
        
        public bool PacoteExiste(int id)
        {
            return contexto.Pacotes.Count(l => l.Id == id) > 0;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
