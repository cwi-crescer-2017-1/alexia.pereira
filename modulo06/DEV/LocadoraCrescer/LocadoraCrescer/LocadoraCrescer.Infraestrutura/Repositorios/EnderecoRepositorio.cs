using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class EnderecosRepositorio : IDisposable
    {
        Contexto contexto;

        public EnderecosRepositorio()
        {
            contexto = new Contexto();
        }

        public List<Endereco> Obter()
        {
            return contexto.Enderecos.ToList();
        }

        public void Cadastrar(Endereco endereco)
        {
            contexto.Enderecos.Add(endereco);
            contexto.SaveChanges();
        }

        public Endereco Obter(int id)
        {
            return contexto.Enderecos.FirstOrDefault(e => e.Id == id);
        }
        
        public void Remover(int id)
        {
            contexto.Enderecos.Remove(Obter(id));
            contexto.SaveChanges();
        }

        public Endereco Atualizar(Endereco endereco)
        {
            contexto.Entry(endereco).State = EntityState.Modified;
            contexto.SaveChanges();
            return endereco;
        }

        public bool EnderecoExiste(int id)
        {
            return contexto.Enderecos.Count(l => l.Id == id) > 0;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
