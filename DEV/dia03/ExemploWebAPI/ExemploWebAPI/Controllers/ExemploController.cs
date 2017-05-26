using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web.Mvc;
using ExemploWebAPI.Models;

namespace ExemploWebAPI.Controllers
{
    public class ExemploController : ApiController
    {
        private static List<Heroi> herois = new List<Heroi>();

        private object objetoLock = new object();

        private static int IdS = 0;

        public List<Heroi> Get(string nome = null, int? id = null)
        {
            return herois.Where(h =>
                (id == null || id == h.Id) &&
                (nome == null || nome == h.Nome))
                .ToList();

        }

        public IHttpActionResult Post(Heroi heroi)
        {
            if (heroi == null)
            {
                return BadRequest();
            }

            else
            {
                lock (objetoLock)
                {
                    heroi.Id = ++IdS;
                    herois.Add(heroi);
                    return Ok(heroi);
                }
            }
        }
    }

}