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
    public class VeiculosController : ControllerBasica
    {

        VeiculoRepositorio repositorio = new VeiculoRepositorio();

        [HttpGet]
        public HttpResponseMessage Obter()
        {
            return ResponderOK(repositorio.Obter());
        }
    }
}
