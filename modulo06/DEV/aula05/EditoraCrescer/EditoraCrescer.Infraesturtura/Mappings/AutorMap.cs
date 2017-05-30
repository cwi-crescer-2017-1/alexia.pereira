using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Mappings
{
    public class AutorMap : EntityTypeConfiguration<Autor>
    {

        public AutorMap()
        {
            ToTable("Autores");
            Property(p => p.Nome).HasMaxLength(300);
        }

    }
}
