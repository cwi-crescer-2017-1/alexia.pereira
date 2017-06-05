﻿using EditoraCrescer.Infraesturtura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Mappings
{
    public class AssinanteMap : EntityTypeConfiguration<Assinante>
    {
        public AssinanteMap()
        {
            ToTable("Assinante");
        }
    }
}
