using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {

        private Contexto contexto = new Contexto();

        public object Obter()
        {
            return contexto.Livros
                .Select(l => new
                {
                    Isbn = l.Isbn,
                    Titulo = l.Titulo,
                    Capa = l.Capa,
                    NomeAutor = l.Autor.Nome,
                    Genero = l.Genero
                })
                .ToList();
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

        public Livro Obter(int id)
        {
            return contexto.Livros.FirstOrDefault(l => l.Isbn == id);
        }

        public List<Livro> Obter(string genero)
        {
            return contexto.Livros.Where(l => l.Genero.Contains(genero)).ToList();
        }

        public Livro Atualizar(Livro livro)
        {
            contexto.Entry(livro).State = EntityState.Modified;
            contexto.SaveChanges();
            return livro;
        }
        
        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
