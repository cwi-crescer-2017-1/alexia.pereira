using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class UsuariosRepositorio : IDisposable
    {

        Contexto contexto = new Contexto();

        public List<Usuario> Obter()
        {
            return contexto.Usuarios.ToList();
        }

        public void Cadastrar(Usuario usuario)
        {
            contexto.Usuarios.Add(usuario);
            contexto.SaveChanges();
        }

        public Usuario Obter(int id)
        {
            return contexto.Usuarios.FirstOrDefault(u => u.Id == id);
        }

        public void Remover(int id)
        {
            contexto.Usuarios.Remove(Obter(id));
            contexto.SaveChanges();
        }

        public Usuario Atualizar(Usuario usuario)
        {
            contexto.Entry(usuario).State = EntityState.Modified;
            contexto.SaveChanges();
            return usuario;
        }

        public bool RevisorExiste(int id)
        {
            return contexto.Usuarios.Count(u => u.Id == id) > 0;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
