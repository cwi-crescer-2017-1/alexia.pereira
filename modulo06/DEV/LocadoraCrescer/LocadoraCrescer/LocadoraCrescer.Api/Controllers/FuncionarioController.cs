using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace LocadoraCrescer.Api.Controllers
{
    [RoutePrefix("api/funcionarios")]
    public class FuncionarioController : ControllerBasica
    {
        readonly FuncionariosRepositorio repositorio;

        public FuncionarioController()
        {
            repositorio = new FuncionariosRepositorio();
        }

        [HttpPost, Route("registrar")]
        //public HttpResponseMessage Registrar([FromBody]RegistrarFuncionarioModel funcionarioParametro)
        public HttpResponseMessage Registrar(Funcionario funcionarioParametro)
        {
            if (repositorio.Obter(funcionarioParametro.Email) == null)
            {
                var funcionario = new Funcionario(funcionarioParametro.Nome, funcionarioParametro.Email, funcionarioParametro.Senha);

                if (funcionario.Validar())
                {
                    repositorio.Criar(funcionario);
                    return ResponderOK(funcionario);
                }
                else
                {
                    return ResponderErro(funcionario.Mensagens);
                }
            }
            else
            {
                return ResponderErro("Funcionário já cadastrado.");
            }


        }
        
        // Exige que o usuário se autentique
        [BasicAuthorization]
        [HttpGet, Route("todos")]
        public HttpResponseMessage Obter()
        {
            // só pode obter as informações do usuário corrente (logado, autenticado)
            var funcionario = repositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (funcionario == null)
                return ResponderErro("Funcionário não encontrado.");

            return ResponderOK(new { funcionario.Nome, funcionario.Permissao, funcionario.Email });
        }

        [HttpGet, Route("obtemlogin")]
        public IHttpActionResult ObterPorEmail(string email)
        {
            var funcionario = repositorio.Obter(email);
            if (funcionario == null)
                return BadRequest("Funcionátio não encontrado.");

            return Ok(new { dados = funcionario });
        }
    }
}
