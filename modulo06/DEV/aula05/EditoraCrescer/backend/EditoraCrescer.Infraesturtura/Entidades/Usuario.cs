using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Entidades
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public List<Permissao> Permissoes { get; set; }

        protected Usuario() { }

        public Usuario(string nome, string email, string senha)
        {
            Nome = nome;
            Email = email;
            Id = 0;
            Senha = senha;
            Permissoes = new List<Permissao>();
            AtribuirPermissoes("Colaborador");
        }
        
        public void AtribuirPermissoes(params string[] nomes)
        {
            foreach (var nome in nomes)
                Permissoes.Add(new Permissao(nome));
        }
        
    }
}
