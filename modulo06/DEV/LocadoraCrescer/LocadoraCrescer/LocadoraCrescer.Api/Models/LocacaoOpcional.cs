using LocadoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LocadoraCrescer.Api.Models
{
    public class LocacaoOpcional
    {
        public int Id { get; set; }
        public Veiculo Veiculo { get; set; }
        public Cliente Cliente { get; set; }
        public Pacote Pacote { get; set; }
        public DateTime DataLocacao { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaReal { get; set; }
        public decimal ValorLocacao { get; set; }
        public decimal ValorDesconto { get; set; }
        public List<LocacaoOpcional> LocacaoOpcionais { get; set; }
    }
}