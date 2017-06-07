using LocadoraCrescer.Dominio.Entidades;
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
    [RoutePrefix("api/clientes")]
    public class ClientesController : ControllerBasica
    {

        readonly ClientesRepositorio repositorio;

        public ClientesController()
        {
            repositorio = new ClientesRepositorio();
        }

        [HttpPost, Route("registrar")]
        //public HttpResponseMessage Registrar([FromBody]RegistrarClienteModel model)
        public HttpResponseMessage Registrar(Cliente cliente)
        {
            if (repositorio.ObterPorCPF(cliente.Cpf) == null)
            {
                var novoCliente = new Cliente(cliente.Nome, cliente.Cpf, cliente.DataNascimento, cliente.Genero);

                if (cliente.Validar())
                {
                    repositorio.Cadastrar(cliente);
                    return ResponderOK(cliente);
                }
                else
                {
                    return ResponderErro(cliente.Mensagens);
                }
            }
            else
            {
                return ResponderErro("Cliente já cadastrado.");
            }


        }
        
        [HttpGet, Route("todos")]
        public HttpResponseMessage Obter()
        {
            return ResponderOK(new { dados = repositorio.ObterTodos() });
        }

        [HttpGet]
        public HttpResponseMessage Obter(string cpf)
        {
            return ResponderOK(new { dados = repositorio.ObterPorCPF(cpf) });
        }


        [HttpGet, Route("atualizar")]
        public HttpResponseMessage Atualizar([FromBody]Cliente model)
        {
            return ResponderOK(new { dados = repositorio.Atualizar(model) });
        }


    }
}

