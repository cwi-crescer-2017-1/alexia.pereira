using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Entidades
{
    public class Assinante : EntidadeBasica
    {
        public int Id { get; set; }
        public string Email { get; set; }

        public override bool Validar()
        {
            Mensagens.Clear();
            
            if (string.IsNullOrWhiteSpace(Email))
                Mensagens.Add("Email é inválido.");

            if (!Email.Contains('@'))
                Mensagens.Add("Email é inválido.");

            if (!Email.Contains('.'))
                Mensagens.Add("Email é inválido.");

            return Mensagens.Count == 0;

        }
    }
}
