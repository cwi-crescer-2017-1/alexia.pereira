using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class FuncionariosRepositorio : IDisposable
    {
        Contexto contexto = new Contexto();
        
        public FuncionariosRepositorio()
        {
            
        }

        public void Criar(Funcionario funcionario)
        {
            contexto.Funcionarios.Add(funcionario);
            contexto.SaveChanges();
        }

        public Funcionario Obter(string login)
        {
            return contexto.Funcionarios
                .FirstOrDefault(u => u.Email == login);
        }

        public Funcionario Obter(int id)
        {
            return contexto.Funcionarios.FirstOrDefault(u => u.Id == id);
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
