using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LocadoraCrescer.Dominio.Entidades;
using System.Linq;

namespace LocadoraCrescer.Dominio.UnitTest
{
    [TestClass]
    public class ClienteUnitTest
    {
        [TestMethod]
        public void Deve_Criar_Entidade_Cliente_Valida()
        {
            var genero = new Genero("Masculino");
            var cliente = new Cliente("Teste", "70707070707", DateTime.Now, genero);
            Assert.IsTrue(cliente.Validar());
            Assert.IsFalse(cliente.Mensagens.Any());
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Cliente_Sem_Nome()
        {
            var genero = new Genero("Masculino");
            var cliente = new Cliente("", "70707070707", DateTime.Now, genero);
            Assert.IsFalse(cliente.Validar());
            Assert.IsTrue(cliente.Mensagens.Any());
            Assert.IsTrue(cliente.Mensagens[0] == "Nome é inválido.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Cliente_Sem_Cpf()
        {
            var genero = new Genero("Masculino");
            var cliente = new Cliente("Teste", "", DateTime.Now, genero);
            Assert.IsFalse(cliente.Validar());
            Assert.IsTrue(cliente.Mensagens.Any());
            Assert.IsTrue(cliente.Mensagens[0] == "CPF é inválido.");
        }
    }
}
