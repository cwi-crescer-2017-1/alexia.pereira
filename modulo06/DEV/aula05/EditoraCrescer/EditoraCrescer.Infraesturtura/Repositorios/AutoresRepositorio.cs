using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class AutoresRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public void Cadastrar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public void Remover(int id)
        {
            contexto.Autores.Remove(Obter(id));
            contexto.SaveChanges();
        }

        public Autor Obter(int id)
        {
            return contexto.Autores.FirstOrDefault(l => l.Id == id);
        }

        public Autor Atualizar(Autor autor)
        {
            contexto.Entry(autor).State = EntityState.Modified;
            contexto.SaveChanges();
            return autor;
        }

        public List<Livro> BuscarLivros(int idAutor)
        {
            return contexto.Livros.Where(l => l.IdAutor == idAutor).ToList();
        }

        public bool AutorExiste(int id)
        {
            return contexto.Autores.Count(a => a.Id == id) > 0;
        }
        
        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
