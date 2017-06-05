using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Dominio.Entidades;
using System.Linq;

namespace LocadoraCrescer.Dominio.UnitTest
{

    [TestClass]
    public class FuncionarioUnitTest
    {
        [TestMethod]
        public void Deve_Criar_Entidade_Funcionario_Valida()
        {
            var funcionario = new Funcionario("Giovani", "giovani@cwi.com.br", "123456");
            Assert.IsTrue(funcionario.Validar());
            Assert.IsFalse(funcionario.Mensagens.Any());
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Funcionario_Sem_Nome()
        {
            var funcionario = new Funcionario("", "giovani@cwi.com.br", "123456");
            Assert.IsFalse(funcionario.Validar());
            Assert.IsTrue(funcionario.Mensagens.Any());
            Assert.IsTrue(funcionario.Mensagens[0] == "Nome é inválido.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Funcionario_Sem_Email()
        {
            var funcionario = new Funcionario("Giovani", "", "123456");
            Assert.IsFalse(funcionario.Validar());
            Assert.IsTrue(funcionario.Mensagens.Any());
            Assert.IsTrue(funcionario.Mensagens[0] == "Email é inválido.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Funcionario_Sem_Senha()
        {
            var funcionario = new Funcionario("Giovani", "giovani@cwi.com.br", "");
            Assert.IsFalse(funcionario.Validar());
            Assert.IsTrue(funcionario.Mensagens.Any());
            Assert.IsTrue(funcionario.Mensagens[0] == "Senha é inválido.");
        }

        [TestMethod]
        public void Deve_Validar_Senha_Funcionario_Correta()
        {
            var funcionario = new Funcionario("Giovani", "giovani@cwi.com.br", "123456");
            Assert.IsTrue(funcionario.ValidarSenha("123456"));
        }

        [TestMethod]
        public void Deve_Criptografar_Senha_Funcionario()
        {
            var funcionario = new Funcionario("Giovani", "giovani@cwi.com.br", "123456");
            Assert.IsTrue(funcionario.Senha != "123456");
        }

        [TestMethod]
        public void Deve_Criar_Funcionario_Com_Permissoes_Operador()
        {
            var funcionario = new Funcionario("Giovani", "giovani@cwi.com.br", "123456");
            Assert.IsTrue(funcionario.Permissao == "Operador");
        }
        
    }
}
