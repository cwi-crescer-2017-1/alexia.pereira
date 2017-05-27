using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Chatzap.Models;

namespace Chatzap.Controllers
{
    public class UsuariosController : ApiController
    {
        private static int incrementavel = 1;
        private static List<Usuario> usuarios = new List<Usuario>();
        private static object @lock = new object();

        public IEnumerable<Usuario> Get()
        {
            return usuarios;
        }

        public IHttpActionResult Post(Usuario usuario)
        {
            if (usuario == null)
            {
                return BadRequest();
            }
            else
            {
                lock (@lock)
                {
                    usuarios.Add(usuario);
                    usuario.Id = incrementavel++;
                    
                }

                return Ok(usuario);
            }
        }

    }
}
