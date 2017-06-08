using LocadoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LocadoraCrescer.Api.Controllers
{
    [BasicAuthorization]
    public class PacotesController : ControllerBasica
    {
        PacotesRepositorio repositorio = new PacotesRepositorio();

        public HttpResponseMessage Get ()
        {
            return ResponderOK(repositorio.Obter());
        }
    }
}
