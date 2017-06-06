using LocadoraCrescer.Dominio.Entidades;
using LocadoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Security.Principal;
using System.Text;
using System.Threading;
using System.Web;
using System.Web.Http;
using System.Web.Http.Controllers;

namespace LocadoraCrescer.Api
{
    public class BasicAuthorization : AuthorizeAttribute
    {
        readonly FuncionarioRepositorio _funcionarioRepositorio;

        public BasicAuthorization()
        {
            _funcionarioRepositorio = new FuncionarioRepositorio();
        }

        public override void OnAuthorization(HttpActionContext actionContext)
        {
            // validar se foi informado no cabeçalho da mensagem o parâmetro de autenticação.
            if (actionContext.Request.Headers.Authorization == null)
            {
                // responde para o cliente como não autorizado
                var dnsHost = actionContext.Request.RequestUri.DnsSafeHost;
                actionContext.Response = actionContext.Request.CreateResponse(HttpStatusCode.Unauthorized);
                actionContext.Response.Headers.Add("WWW-Authenticate", string.Format("Basic realm=\"{0}\"", dnsHost));
                return;
            }
            else
            {
                //obtém o parâmetro (token de autenticação)
                string tokenAutenticacao =
                    actionContext.Request.Headers.Authorization.Parameter;

                // decodifica o parâmetro, pois ele deve vir codificado em base 64
                string decodedTokenAutenticacao =
                    Encoding.Default.GetString(Convert.FromBase64String(tokenAutenticacao));

                // obtém o login e senha (funcionario:senha)
                string[] userNameAndPassword = decodedTokenAutenticacao.Split(':');

                // validar as credenciais obtidas com as cadastradas no sistema
                Funcionario funcionario = null;
                if (ValidarFuncionario(userNameAndPassword[0], userNameAndPassword[1], out funcionario))
                {
                    string[] papeis = new string[1];
                    papeis[0] = funcionario.Permissao;
                    var identidade = new GenericIdentity(funcionario.Email);
                    var genericUser = new GenericPrincipal(identidade, papeis);

                    // confere o perfil da action com os do usuário
                    if (string.IsNullOrEmpty(Roles))
                    {
                        // atribui o usuário informado no contexto da requisição atual
                        Thread.CurrentPrincipal = genericUser;
                        if (HttpContext.Current != null)
                            HttpContext.Current.User = genericUser;

                        return;
                    }
                    else
                    {
                        var currentRoles = Roles.Split(',');
                        foreach (var currentRole in currentRoles)
                        {
                            if (genericUser.IsInRole(currentRole))
                            {
                                // atribui o usuário informado no contexto da requisição atual
                                Thread.CurrentPrincipal = genericUser;
                                if (HttpContext.Current != null)
                                    HttpContext.Current.User = genericUser;

                                return;
                            }
                        }
                    }
                }
            }

            actionContext.Response =
                actionContext.Request.CreateResponse(HttpStatusCode.Unauthorized, new { mensagens = new string[] { "Usuário ou senha inválidos." } });
        }

        private bool ValidarFuncionario(string login, string senha, out Funcionario funcionarioRetorno)
        {
            funcionarioRetorno = null;

            var funcionario = _funcionarioRepositorio.Obter(login);

            if (funcionario != null && funcionario.ValidarSenha(senha))
                funcionarioRetorno = funcionario;
            else
                funcionario = null;

            return funcionario != null;
        }
    }
}