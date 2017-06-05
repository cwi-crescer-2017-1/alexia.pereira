using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Cliente
    {
        public int Id{ get; set; }
        public string Nome{ get; set; }
        public string Cpf { get; set; }
        public DateTime DataNascimento { get; set; }
        public Endereco Endereco { get; set; }
        public Genero Genero { get; set; }
    }
}
