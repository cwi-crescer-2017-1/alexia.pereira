using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {

        private Contexto contexto = new Contexto();

        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }

        public void Cadastrar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public void Remover(int id)
        {
            contexto.Livros.Remove(Obter(id));
            contexto.SaveChanges();
        }

        public Livro Obter (int id)
        {
            return contexto.Livros.FirstOrDefault(l => l.Isbn == id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }


    }
}
