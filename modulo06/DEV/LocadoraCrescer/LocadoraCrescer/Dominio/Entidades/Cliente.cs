using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Cliente : EntidadeBasica
    {
        public int Id{ get; set; }
        public string Nome{ get; set; }
        public string Cpf { get; set; }
        public DateTime DataNascimento { get; set; }
        public Endereco Endereco { get; set; }
        public Genero Genero { get; set; }

        public Cliente ()
        {

        }

        public Cliente(string nome, string cpf, DateTime dataNascimento, Genero genero)
        {
            Id = 0;
            Nome = nome;
            Cpf = cpf;
            DataNascimento = dataNascimento;
            Genero = genero;
        }

        public bool ValidarCliente()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Nome))
                Mensagens.Add("Nome é inválido.");

            if (string.IsNullOrWhiteSpace(Cpf))
                Mensagens.Add("CPF é inválido.");

            return Mensagens.Count == 0;
        }

        public override bool Validar()
        {
            return ValidarCliente();     
        }

    }
}
