using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LocadoraCrescer.Dominio.Entidades;
using System.Linq;

namespace LocadoraCrescer.Dominio.UnitTest
{
    [TestClass]
    public class LocacaoUnitTest
    {
        [TestMethod]
        public void Deve_Criar_Locacao_Kombi_Cabo_Bateria()
        {
            var cliente = new Cliente("Teste", "70707070707", DateTime.Now, Genero.MASCULINO);
            var veiculo = new Veiculo() { Nome = "Kombi" };
            var locacao = new Locacao(veiculo, cliente, null, DateTime.Now, 1200);
            locacao.LocacaoOpcionais.Add
                (new LocacaoOpcional(locacao, new Opcional()
                { Descricao = "Cabo Bateria" }));
            Assert.IsTrue(locacao.Validar());
            Assert.IsFalse(locacao.Mensagens.Any());
        }

        [TestMethod]
        public void Nao_Deve_Criar_Locacao_Mobi_Cabo_Bateria()
        {
            var cliente = new Cliente("Teste", "70707070707", DateTime.Now, Genero.MASCULINO);
            var veiculo = new Veiculo() { Nome = "Mobi" };
            var locacao = new Locacao(veiculo, cliente, null, DateTime.Now, 1200);
            locacao.LocacaoOpcionais.Add
                (new LocacaoOpcional(locacao, new Opcional()
                { Descricao = "Cabo Bateria" }));
            Assert.IsTrue(!locacao.Validar());
            Assert.IsTrue(locacao.Mensagens.Any());
            Assert.IsTrue(locacao.Mensagens[0] == "Apenas Kombi pode ter Cabo Bateria.");
        }

        [TestMethod]
        public void Nao_Deve_Criar_Locacao_Mobi_Reboque()
        {
            var cliente = new Cliente("Teste", "70707070707", DateTime.Now, Genero.MASCULINO);
            var veiculo = new Veiculo() { Nome = "Mobi" };
            var locacao = new Locacao(veiculo, cliente, null, DateTime.Now, 1200);
            locacao.LocacaoOpcionais.Add
                (new LocacaoOpcional(locacao, new Opcional()
                { Descricao = "Reboque" }));
            locacao.LocacaoOpcionais.Add
                (new LocacaoOpcional(locacao, new Opcional()
                { Descricao = "Rack" }));
            Assert.IsTrue(!locacao.Validar());
            Assert.IsTrue(locacao.Mensagens.Any());
            Assert.IsTrue(locacao.Mensagens[0] == "Mobi não pode ter Reboque.");
        }

        [TestMethod]
        public void Deve_Criar_Locacao_Mobi_Rack()
        {
            var cliente = new Cliente("Teste", "70707070707", DateTime.Now, Genero.MASCULINO);
            var veiculo = new Veiculo() { Nome = "Mobi" };
            var locacao = new Locacao(veiculo, cliente, null, DateTime.Now, 1200);
            locacao.LocacaoOpcionais.Add
                (new LocacaoOpcional(locacao, new Opcional()
                { Descricao = "Rack" }));
            Assert.IsTrue(locacao.Validar());
            Assert.IsFalse(locacao.Mensagens.Any());
        }

        [TestMethod]
        public void Deve_Criar_Locacao_Hilux_Reboque()
        {
            var cliente = new Cliente("Teste", "70707070707", DateTime.Now, Genero.MASCULINO);
            var veiculo = new Veiculo() { Nome = "Hilux" };
            var locacao = new Locacao(veiculo, cliente, null, DateTime.Now, 1200);
            locacao.LocacaoOpcionais.Add
                (new LocacaoOpcional(locacao, new Opcional()
                { Descricao = "Reboque" }));
            Assert.IsTrue(locacao.Validar());
            Assert.IsFalse(locacao.Mensagens.Any());
        }

        [TestMethod]
        public void Nao_Deve_Criar_Locacao_Hilux_Rack()
        {
            var cliente = new Cliente("Teste", "70707070707", DateTime.Now, Genero.MASCULINO);
            var veiculo = new Veiculo() { Nome = "Hilux" };
            var locacao = new Locacao(veiculo, cliente, null, DateTime.Now, 1200);
            locacao.LocacaoOpcionais.Add
                (new LocacaoOpcional(locacao, new Opcional()
                { Descricao = "Rack" }));
            Assert.IsFalse(locacao.Validar());
            Assert.IsTrue(locacao.Mensagens.Any());
            Assert.IsTrue(locacao.Mensagens[0] == "Hilux não pode ter Rack.");
        }

        [TestMethod]
        public void Nao_Deve_Criar_Locacao_Hilux_Rack_E_Cabo_Bateria()
        {
            var cliente = new Cliente("Teste", "70707070707", DateTime.Now, Genero.MASCULINO);
            var veiculo = new Veiculo() { Nome = "Hilux" };
            var locacao = new Locacao(veiculo, cliente, null, DateTime.Now, 1200);
            locacao.LocacaoOpcionais.Add
                (new LocacaoOpcional(locacao, new Opcional()
                { Descricao = "Rack" }));
            locacao.LocacaoOpcionais.Add
                (new LocacaoOpcional(locacao, new Opcional()
                { Descricao = "Cabo Bateria" }));
            Assert.IsFalse(locacao.Validar());
            Assert.IsTrue(locacao.Mensagens.Any());
            Assert.IsTrue(locacao.Mensagens[0] == "Hilux não pode ter Rack.");
            Assert.IsTrue(locacao.Mensagens[1] == "Apenas Kombi pode ter Cabo Bateria.");

        }
    }
}
