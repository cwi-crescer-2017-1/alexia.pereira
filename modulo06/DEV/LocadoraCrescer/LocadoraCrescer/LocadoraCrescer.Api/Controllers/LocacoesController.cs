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
        //Contexto contexto = new Contexto();
        LocacoesRepositorio repositorio = new LocacoesRepositorio();

        [HttpPost, Route("cadastrar")]
        public HttpResponseMessage Post([FromBody]LocacaoModel model)
        {
            var locacao = repositorio.Cadastrar(model.IdCliente, model.IdVeiculo,
                model.IdPacote, model.DataEntregaPrevista, model.IdLocacaoOpcional);

            return ResponderOK(locacao);
        }

        [HttpGet, Route("obter")]
        public HttpResponseMessage Obter()
        {
            return ResponderOK(repositorio.Obter());
        }

        [HttpPut, Route("devolver/{id:int}")]
        public HttpResponseMessage Devolver(int id)
        {
            var locacao = repositorio.Obter(id);
            locacao.AtribuirDataDevolucaoReal();
            return ResponderOK(repositorio.Atualizar(locacao));
        }

        [HttpGet, Route("atrasados")]
        public HttpResponseMessage ClientesAtrasados()
        {
            return ResponderOK(repositorio.ObterClientesComLocacoesAtrasadas());
        }

        [BasicAuthorization(Roles = "Gerente")]
        [HttpGet, Route("relatorio")]
        public HttpResponseMessage GerarRelatorioMensal(DateTime data)
        {
            return ResponderOK(repositorio.BuscarLocacoesPorMes(data));
        }

    }
}