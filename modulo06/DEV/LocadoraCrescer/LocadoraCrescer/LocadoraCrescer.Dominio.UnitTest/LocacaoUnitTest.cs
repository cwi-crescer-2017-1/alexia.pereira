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
                { Descricao = "Cabo Bateria"}));
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
    }
}
