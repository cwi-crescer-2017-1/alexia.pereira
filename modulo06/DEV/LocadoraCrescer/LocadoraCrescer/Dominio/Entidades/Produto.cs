using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Produto
    {
        public int Id { get; set; }
        public string Marca { get; set; }
        public int Quantidade { get; set; }
        public bool Status { get; set; }
        public double ValorDiario { get; set; }
        public double ValorAdicional { get; set; }
    }
}
