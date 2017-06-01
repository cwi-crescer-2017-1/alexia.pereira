using EditoraCrescer.Infraesturtura;
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
    [RoutePrefix("api/Livros")]
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet, Route]
        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();
            return Ok(livros);
        }

        [Route("{isbn:int}"), HttpGet]
        public IHttpActionResult Get(int isbn)
        {
            var livro = repositorio.Obter(isbn);
            return Ok(livro);
        }

        [Route("{genero}"), HttpGet]
        public IHttpActionResult Get(string genero)
        {
            var livro = repositorio.Obter(genero);
            return Ok(livro);
        }

        [HttpPost, Route]
        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Cadastrar(livro);
            return Ok(livro);
        }

        [Route("{isbn:int}"), HttpDelete]
        public IHttpActionResult Delete(int isbn)
        {
            repositorio.Remover(isbn);
            return Ok();
        }

        [Route("{isbn:int}"), HttpPut]
        public IHttpActionResult Put(int isbn, Livro livro)
        {
            if (isbn != livro.Isbn)
                return BadRequest("O livro que você informou não corresponde com o selecionado"); 
                   
            if (!repositorio.LivroExiste(livro.Isbn))
                return BadRequest("O livro que você informou não corresponde a nenhum livro cadastrado");

            return Ok(repositorio.Atualizar(livro));
        }

        [HttpGet, Route("lancamentos")]
        public IHttpActionResult Lancamentos ()
        {
            return Ok(repositorio.ObterLancamentos());
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
