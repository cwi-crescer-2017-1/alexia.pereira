using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LocadoraCrescer.Dominio.Entidades;
using System.Linq;

namespace LocadoraCrescer.Dominio.UnitTest
{
    [TestClass]
    public class EnderecoUnitTest
    {
        [TestMethod]
        public void Deve_Criar_Entidade_Endereco_Valida()
        {
            var endereco = new Endereco("Sao Leopoldo", "Rua Teste", "123", "RS", "90909090");
            Assert.IsTrue(endereco.Validar());
            Assert.IsFalse(endereco.Mensagens.Any());
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Endereco_Sem_Cidade()
        {
            var endereco = new Endereco("", "Rua Teste", "123", "RS", "90909090");
            Assert.IsFalse(endereco.Validar());
            Assert.IsTrue(endereco.Mensagens.Any());
            Assert.IsTrue(endereco.Mensagens[0] == "Cidade é inválida.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Endereco_Sem_Rua()
        {
            var endereco = new Endereco("Sao Leopoldo", "", "123", "RS", "90909090");
            Assert.IsFalse(endereco.Validar());
            Assert.IsTrue(endereco.Mensagens.Any());
            Assert.IsTrue(endereco.Mensagens[0] == "Rua é inválida.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Endereco_Sem_Numero()
        {
            var endereco = new Endereco("Sao Leopoldo", "Rua Teste", "", "RS", "90909090");
            Assert.IsFalse(endereco.Validar());
            Assert.IsTrue(endereco.Mensagens.Any());
            Assert.IsTrue(endereco.Mensagens[0] == "Número inválido.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Endereco_Sem_UF()
        {
            var endereco = new Endereco("Sao Leopoldo", "Rua Teste", "123", "", "90909090");
            Assert.IsFalse(endereco.Validar());
            Assert.IsTrue(endereco.Mensagens.Any());
            Assert.IsTrue(endereco.Mensagens[0] == "Unidade Federatica inválida.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Endereco_Com_UF_Maior_Que_Dois()
        {
            var endereco = new Endereco("Sao Leopoldo", "Rua Teste", "123", "RSRSRS", "90909090");
            Assert.IsFalse(endereco.Validar());
            Assert.IsTrue(endereco.Mensagens.Any());
            Assert.IsTrue(endereco.Mensagens[0] == "Unidade Federatica inválida.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Endereco_Sem_CEP()
        {
            var endereco = new Endereco("Sao Leopoldo", "Rua Teste", "123", "RS", "");
            Assert.IsFalse(endereco.Validar());
            Assert.IsTrue(endereco.Mensagens.Any());
            Assert.IsTrue(endereco.Mensagens[0] == "CEP inválido.");
        }

    }
}
