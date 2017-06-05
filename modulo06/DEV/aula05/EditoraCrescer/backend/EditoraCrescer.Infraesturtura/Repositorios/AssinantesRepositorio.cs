using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class AssinantesRepositorio
    {

        private Contexto contexto = new Contexto();

        public List<Assinante> Obter()
        {
            return contexto.Assinantes.ToList();
        }

        public void Cadastrar(Assinante assinante)
        {
            contexto.Assinantes.Add(assinante);
            contexto.SaveChanges();
        }

        public void Remover(int id)
        {
            contexto.Assinantes.Remove(Obter(id));
            contexto.SaveChanges();
        }

        public Assinante Obter(int id)
        {
            return contexto.Assinantes.FirstOrDefault(a => a.Id == id);
        }

        public Assinante Atualizar(Assinante assinante)
        {
            contexto.Entry(assinante).State = EntityState.Modified;
            contexto.SaveChanges();
            return assinante;
        }

        public bool AssinanteExiste(int id)
        {
            return contexto.Assinantes.Count(a => a.Id == id) > 0;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
