using LocadoraCrescer.Api.Models;
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
        public HttpResponseMessage Registrar([FromBody]ClienteModel model)
        //public HttpResponseMessage Registrar(Cliente cliente)
        {
            var endereco = new Endereco(model.Endereco.Cidade, model.Endereco.Rua, model.Endereco.Numero, model.Endereco.UF, model.Endereco.CEP);
            var enderecoRepositorio = new EnderecosRepositorio();
            enderecoRepositorio.Cadastrar(endereco);
            
            if (repositorio.ObterPorCPF(model.Cpf) == null)
            {
                var cliente = new Cliente(model.Nome, model.Cpf, model.DataNascimento, model.Genero);
                cliente.Endereco = endereco;

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
            return ResponderOK(repositorio.ObterTodos());
        }

        [HttpGet, Route("{cpf}")]
        public HttpResponseMessage Obter(string cpf)
        {
            return ResponderOK(repositorio.ObterPorCPF(cpf));
        }


        [HttpGet, Route("atualizar")]
        public HttpResponseMessage Atualizar([FromBody]Cliente model)
        {
            return ResponderOK(repositorio.Atualizar(model));
        }


    }
}

