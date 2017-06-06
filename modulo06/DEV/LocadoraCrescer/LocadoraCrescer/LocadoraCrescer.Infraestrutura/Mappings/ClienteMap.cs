using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
            HasRequired(x => x.Endereco).WithMany().Map(x => x.MapKey("IdEndereco"));
            Property(x => x.Genero).IsRequired();
            Property(x => x.Nome).HasMaxLength(200);
            Property(x => x.Cpf).HasMaxLength(11);
        }
    }
}