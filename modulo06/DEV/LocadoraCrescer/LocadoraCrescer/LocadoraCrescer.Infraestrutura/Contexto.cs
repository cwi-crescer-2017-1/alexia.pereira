using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Mappings;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=ExemploEFSP")
        { }

        public DbSet<Endereco> Enderecos { get; set; }
        public DbSet<Pacote> Pacotes { get; set; }
        public DbSet<Veiculo> Veiculos { get; set; }
        public DbSet<Opcional> Opcionais { get; set; }
        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Funcionario> Funcionarios { get; set; }
        public DbSet<Locacao> Locacoes { get; set; }
        public DbSet<LocacaoOpcional> LocacoesOpcionais { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new EnderecoMap());
            modelBuilder.Configurations.Add(new PacoteMap());
            modelBuilder.Configurations.Add(new VeiculoMap());
            modelBuilder.Configurations.Add(new OpcionaisMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new FuncionarioMap());
            modelBuilder.Configurations.Add(new LocacaoMap());
            modelBuilder.Configurations.Add(new LocacaoOpcionalMap());

        }

    }
}
