using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demonstracao01
{
    public class Pessoa
    {
        public const double PI = 3.14;
        public readonly double PIReadOnly;

        public Pessoa()
        {
            PIReadOnly = 3.14;
        }


        public string Nome { get; set; }
        public int? Id { get; set; }
        public DateTime Nascimento { get; set; }

    }
}
