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
    [RoutePrefix("api/locacoes")]
    public class LocacoesController : ControllerBasica
    {
        LocacoesRepositorio repositorio = new LocacoesRepositorio();

        [HttpPost, Route("cadastrar")]
        
        public HttpResponseMessage Post([FromBody]LocacaoModel model)
        {
            Pacote pacote = null;
            var opcionais = new List<LocacaoOpcional>();
            var cliente = new ClientesRepositorio().ObterPorId(model.IdCliente);
            var veiculo = new VeiculoRepositorio().Obter(model.IdVeiculo);

            if (model.IdPacote > 0)
                pacote = new PacotesRepositorio().Obter(model.IdPacote);

            
            var locacao = new Locacao(veiculo, cliente, pacote, model.DataEntregaPrevista);
            
            foreach (var id in model.IdLocacaoOpcional)
            {
                var opcional = new OpcionaisRepositorio().Obter(id);
                locacao.LocacaoOpcionais.Add(new LocacaoOpcional(locacao, opcional));
            }

            if (!locacao.Validar())
                ResponderErro(locacao.Mensagens);

            locacao.calcularValorInicialLocacao();
            repositorio.Cadastrar(locacao);

            return ResponderOK(locacao);

        }

        [HttpGet, Route("obter")]
        public HttpResponseMessage Obter()
        {
            return ResponderOK(repositorio.Obter());
        }

        [HttpPut, Route("devolver")]
        public HttpResponseMessage Devolver(Locacao locacao)
        {
            locacao.AtribuirDataDevolucaoReal();
            return ResponderOK(repositorio.Atualizar(locacao));
        }


    }
}
