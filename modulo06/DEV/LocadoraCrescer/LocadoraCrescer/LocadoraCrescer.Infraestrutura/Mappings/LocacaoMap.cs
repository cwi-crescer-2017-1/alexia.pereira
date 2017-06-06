using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public class LocacaoMap : EntityTypeConfiguration<Locacao>
    {
        public LocacaoMap()
        {
            ToTable("Locacao");
            HasRequired(x => x.Veiculo).WithMany().Map(x => x.MapKey("IdVeiculo"));

            HasRequired(x => x.Cliente).WithMany().Map(x => x.MapKey("IdCliente"));

            HasOptional(x => x.Pacote).WithMany().Map(x => x.MapKey("IdPacote"));

        }
    }
}
