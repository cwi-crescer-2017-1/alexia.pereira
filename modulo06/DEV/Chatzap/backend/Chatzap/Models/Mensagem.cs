using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Chatzap.Models
{
    public class Mensagem
    {
        public int Id { get; set; }
        public string texto;
        public DateTime DataMensagem;
        public Usuario usuario;
    }
}