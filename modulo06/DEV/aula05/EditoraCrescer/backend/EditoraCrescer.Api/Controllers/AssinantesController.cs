using System;
using System.Collections.Generic;
using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/assinantes")]
    public class AssinantesController : ApiController
    {

        private AssinantesRepositorio repositorio = new AssinantesRepositorio();

        public IHttpActionResult Get()
        {
            var assinantes = repositorio.Obter();
            return Ok(assinantes);
        }


        public IHttpActionResult Get(int id)
        {
            var assinante = repositorio.Obter(id);
            return Ok(assinante);
        }

        public IHttpActionResult Post(Assinante assinante)
        {
            if (assinante.Validar())
            {
                repositorio.Cadastrar(assinante);
                return Ok(assinante);
            }

            return BadRequest(assinante.Mensagens.ToString());

        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.Remover(id);
            return Ok();
        }

        public IHttpActionResult Put(int id, Assinante assinante)
        {
            if (assinante.Validar())
            {
                return Ok(repositorio.Atualizar(assinante));
            }
            return BadRequest(assinante.Mensagens.ToString());

        }


        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
