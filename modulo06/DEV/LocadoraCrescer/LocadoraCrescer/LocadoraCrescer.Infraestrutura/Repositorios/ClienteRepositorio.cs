using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class ClientesRepositorio : IDisposable
    {
        Contexto contexto;

        public ClientesRepositorio()
        {
            contexto = new Contexto();
        }

        public List<Cliente> ObterTodos()
        {
            return contexto.Clientes.ToList();
        }

        public Cliente ObterPorCPF(string cpf)
        {
            return contexto.Clientes
                .FirstOrDefault(c => c.Cpf == cpf);
        }

        public void Cadastrar(Cliente cliente)
        {
            contexto.Clientes.Add(cliente);
            contexto.SaveChanges();
        }

        public Cliente ObterPorId(int id)
        {
            return contexto.Clientes.FirstOrDefault(c => c.Id == id);
        }

        public void Remover(int id)
        {
            contexto.Clientes.Remove(ObterPorId(id));
            contexto.SaveChanges();
        }

        public Cliente Atualizar(Cliente cliente)
        {
            contexto.Entry(cliente).State = EntityState.Modified;
            contexto.SaveChanges();
            return cliente;
        }

        public bool ClienteExiste(int id)
        {
            return contexto.Clientes.Count(c => c.Id == id) > 0;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
