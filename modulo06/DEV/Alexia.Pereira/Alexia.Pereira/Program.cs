using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Alexia.Pereira
{
    class Program
    {
        static void Main(string[] args)
        {
            FolhaPagamento fp = new FolhaPagamento();
            fp.GerarDemonstrativo(200, 5000, 50, 10);
        }
    }
}
