using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class LocacaoOpcional
    {
        public int Id { get; set; }
        public Locacao Locacao { get; set; }
        public Opcional Opcional { get; set; }
        public int Quantidade { get; set; }
    }
}
