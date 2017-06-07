using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocadoraCrescer.Api.Models
{
    public class LocacaoModel
    {
        public int Id { get; set; }
        public int IdVeiculo { get; set; }
        public int IdCliente { get; set; }
        public int IdPacote { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public decimal ValorLocacao { get; set; }
        public List<int> IdLocacaoOpcional { get; set; }
    }
}