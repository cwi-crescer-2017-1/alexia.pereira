using LocadoraCrescer.Api.Models;
using LocadoraCrescer.Dominio.Entidades;
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

        [HttpPost]
        //public HttpResponseMessage Registrar([FromBody]RegistrarClienteModel model)
        public HttpResponseMessage CadastrarLocacao([FromBody]LocacaoModel model)
        {
            var locacao = new Locacao(model.Veiculo, model.Cliente, model.Pacote, model.DataEntregaPrevista, model.ValorLocacao, model.LocacaoOpcionais);
            repositorio.Cadastrar(locacao);
            return ResponderOK(new { dados = locacao });
        }

        [HttpGet]
        public HttpResponseMessage Obter()
        {
            return ResponderOK(new { dados = repositorio.Obter() });
        }


    }
}
