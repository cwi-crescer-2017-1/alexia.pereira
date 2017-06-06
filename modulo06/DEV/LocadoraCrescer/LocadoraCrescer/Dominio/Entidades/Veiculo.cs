﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Veiculo
    {
        public int Id { get; set; }
        public string Marca { get; set; }
        public int Quantidade { get; set; }
        public bool Status { get; set; }
        public decimal ValorDiario { get; set; }
        public decimal ValorAdicional { get; set; }
    }
}