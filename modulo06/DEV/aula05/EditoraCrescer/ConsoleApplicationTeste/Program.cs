using EditoraCrescer.Infraesturtura;
using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplicationTeste
{
    class Program
    {
        static void Main(string[] args)
        {
            var autor1 = new Autor() { Nome = "Tolkien" };
            var autor2 = new Autor() { Nome = "Machado de Assis" };

            using (var contexto = new Contexto())
            {
                //Inclusão
                //contexto.Autores.Add(autor1);
                //contexto.Autores.Add(autor2);
                //contexto.SaveChanges();

                var livro = new Livro()
                {
                    IdAutor = 3,
                    Titulo = "O Hobbit",
                    Descricao = "Um livro bem legal",
                    Genero = "Aventura",
                    DataPublicacao = DateTime.Now,
                    DataRevisão = DateTime.Now,
                    Capa = "",
                    IdRevisor = 2
                };

                contexto.Livros.Add(livro);
                contexto.SaveChanges();
            }
        }
    }
}
