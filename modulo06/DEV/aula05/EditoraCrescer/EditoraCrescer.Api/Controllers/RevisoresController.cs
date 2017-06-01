using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class RevisoresController : ApiController
    {
        private RevisoresRepositorio repositorio = new RevisoresRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(repositorio.Obter());
        }

        public IHttpActionResult Post (Revisor revisor)
        {
            repositorio.Cadastrar(revisor);
            return Ok(revisor);
        }

        public IHttpActionResult Get (int id)
        {
            return Ok(repositorio.Obter(id));
        }

        public IHttpActionResult Delete (int id)
        {
            repositorio.Remover(id);
            return Ok();
        }

        public IHttpActionResult Put(int id, Revisor revisor)
        {
            if (id != revisor.Id)
                return BadRequest("O revisor que você informou não corresponde com o selecionado");

            if (!repositorio.RevisorExiste(revisor.Id))
                return BadRequest("O revisor que você informou não corresponde a nenhum revisor cadastrado no sistema");

            return Ok(repositorio.Atualizar(revisor));
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
