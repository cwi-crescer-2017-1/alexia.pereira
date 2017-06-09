using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Repositorios
{
    public class VeiculoRepositorio : IDisposable
    {
        Contexto contexto;

        public VeiculoRepositorio()
        {
            contexto = new Contexto();
        }

        public void Criar(Veiculo veiculo)
        {
            contexto.Veiculos.Add(veiculo);
            contexto.SaveChanges();
        }

        public List<Veiculo> Obter()
        {
            return contexto.Veiculos
                .Where(v => v.Quantidade > 0)
                .ToList();
        }

        public Veiculo Obter(int id)
        {
            return contexto.Veiculos.FirstOrDefault(v => v.Id == id);
        }

        public Veiculo AtualizarEstoque(Veiculo veiculo)
        {
            contexto.Entry(veiculo).State = EntityState.Modified;
            veiculo.Quantidade--;
            contexto.SaveChanges();
            return veiculo;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
