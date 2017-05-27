using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Chatzap.Models;

namespace Chatzap.Controllers
{
    public class MensagensController : ApiController
    {
        private static int incrementavel = 1;
        private static object @lock = new object();
        private static List<Mensagem> mensagens = new List<Mensagem>();

        public IEnumerable<Mensagem> Get()
        {
            return mensagens;
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null)
            {
                return BadRequest();
            }
            else
            {
                lock (@lock)
                {
                    mensagens.Add(mensagem);
                    mensagem.Id = incrementavel++;
                    mensagem.DataMensagem = DateTime.Now;
                }

                return Ok(mensagem);
            }
        }


    }
}
