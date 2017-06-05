using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public int IdProduto { get; set; }
        public int? IdPacote{ get; set; }
        public DateTime DataPedido { get; set; }
        public DateTime DataEntregaPrevista { get; set; }
        public DateTime? DataEntregaReal { get; set; }
    }
}
