using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Infraestrutura.Mappings
{
    public class LocacaoOpcionalMap : EntityTypeConfiguration<LocacaoOpcional>
    {
        public LocacaoOpcionalMap()
        {
            ToTable("LocacaoOpcional");
            HasRequired(x => x.Locacao).WithMany().Map(x => x.MapKey("IdLocacao"));
            HasRequired(x => x.Opcional).WithMany().Map(x => x.MapKey("IdOpcional"));
        }
    }
}
