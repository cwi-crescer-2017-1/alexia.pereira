using System;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Endereco : EntidadeBasica
    {
        public int Id { get; set; }
        public string Cidade { get; set; }
        public string Rua { get; set; }
        public string Numero { get; set; }
        public string UF { get; set; }
        public string CEP { get; set; }

        public Endereco(string cidade, string rua, string numero, string uf, string cep)
        {
            Id = 0;
            Cidade = cidade;
            Rua = rua;
            Numero = numero;
            UF = uf;
            CEP = cep;
        }

        public override bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Cidade))
                Mensagens.Add("Cidade é inválida.");

            if (string.IsNullOrWhiteSpace(Rua))
                Mensagens.Add("Rua é inválida.");

            if (string.IsNullOrWhiteSpace(Numero))
                Mensagens.Add("Número inválido.");

            if (UF.Length > 2 || string.IsNullOrWhiteSpace(UF))
                Mensagens.Add("Unidade Federatica inválida.");

            if (string.IsNullOrWhiteSpace(CEP))
                Mensagens.Add("CEP inválido.");

            return Mensagens.Count == 0;
        }
    }
}
