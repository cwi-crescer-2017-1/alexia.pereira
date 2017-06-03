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
    public class UsuariosController : ApiController
    {
        private UsuariosRepositorio repositorio = new UsuariosRepositorio();

        public IHttpActionResult Get()
        {
            return Ok(repositorio.Obter());
        }

        public IHttpActionResult Post (Usuario usuario)
        {
            repositorio.Cadastrar(usuario);
            return Ok(usuario);
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

        public IHttpActionResult Put(int id, Usuario usuario)
        {
            if (id != usuario.Id)
                return BadRequest("O usuario que você informou não corresponde com o selecionado");

            if (!repositorio.RevisorExiste(usuario.Id))
                return BadRequest("O usuario que você informou não corresponde a nenhum revisor cadastrado no sistema");

            return Ok(repositorio.Atualizar(usuario));
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
