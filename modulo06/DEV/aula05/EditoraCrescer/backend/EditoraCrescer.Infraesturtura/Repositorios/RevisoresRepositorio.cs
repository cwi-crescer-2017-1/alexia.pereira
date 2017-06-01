using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class RevisoresRepositorio : IDisposable
    {

        Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public void Cadastrar (Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public Revisor Obter (int id)
        {
            return contexto.Revisores.FirstOrDefault(r => r.Id == id);
        }

        public void Remover (int id)
        {
            contexto.Revisores.Remove(Obter(id));
            contexto.SaveChanges();
        }

        public Revisor Atualizar(Revisor revisor)
        {
            contexto.Entry(revisor).State = EntityState.Modified;
            contexto.SaveChanges();
            return revisor;
        }

        public bool RevisorExiste(int id)
        {
            return contexto.Revisores.Count(r => r.Id == id) > 0;
        }

        public void Dispose ()
        {
            contexto.Dispose();
        }

    }
}
