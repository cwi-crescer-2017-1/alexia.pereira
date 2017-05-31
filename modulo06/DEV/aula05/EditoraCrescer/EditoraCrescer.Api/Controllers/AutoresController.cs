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
    public class AutoresController : ApiController
    {
        private AutoresRepositorio repositorio = new AutoresRepositorio();

        public IHttpActionResult Get()
        {
            var autores = repositorio.Obter();
            return Ok(autores);
        }


        public IHttpActionResult Get(int id)
        {
            var autor = repositorio.Obter(id);
            return Ok(autor);
        }

        public IHttpActionResult Post(Autor autor)
        {
            repositorio.Cadastrar(autor);
            return Ok(autor);
        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.Remover(id);
            return Ok();
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
