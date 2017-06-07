using LocadoraCrescer.Infraestrutura;
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
    public class LocacoesController : ControllerBasica
    {
        LocacoesRepositorio repositorio = new LocacoesRepositorio();
    }
}
