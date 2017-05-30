using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class PedidosController : ApiController
    {
        PedidoRepositorio _pedidoRepositorio = new PedidoRepositorio();

        public IHttpActionResult Post(Pedido pedido)
        {
        
            _pedidoRepositorio.Criar(pedido);

            return Ok(pedido);
        }

        public IHttpActionResult Put(Pedido pedido)
        {
         
            _pedidoRepositorio.Alterar(pedido);

            return Ok(pedido);
        }

        public IHttpActionResult Get()
        {
            return Ok(_pedidoRepositorio.Listar());
        }

        public IHttpActionResult Get(int id)
        {
            return Ok(_pedidoRepositorio.Obter(id));
        }

        public IHttpActionResult Delete(int id)
        {
            _pedidoRepositorio.Excluir(id);

            return Ok();
        }
    }
}
