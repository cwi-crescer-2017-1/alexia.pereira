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
        public HttpResponseMessage Post([FromBody]LocacaoModel model)
        {
            //Buscar dados do banco
            var veiculo = new VeiculoRepositorio().Obter(model.IdVeiculo);
            var cliente = new ClientesRepositorio().ObterPorId(model.IdCliente);
            var pacote = new PacotesRepositorio().Obter(model.IdPacote);
            var listaLocacaoOpcional = new List<LocacaoOpcional>();
            foreach (var locacaoOpcional in model.IdLocacaoOpcional)
            {
                listaLocacaoOpcional.Add(new LocacoesOpcionaisRepositorio().Obter(locacaoOpcional));
            }

            var locacao = new Locacao(veiculo, cliente, pacote, model.DataEntregaPrevista,
                model.ValorLocacao, listaLocacaoOpcional);

            repositorio.Cadastrar(locacao);

            return ResponderOK(locacao);
        }

        [HttpGet]
        public HttpResponseMessage Obter()
        {
            return ResponderOK(repositorio.Obter());
        }


    }
}
