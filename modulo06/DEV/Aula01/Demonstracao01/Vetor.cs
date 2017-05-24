using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demonstracao01
{
    class Vetor
    {
        public Vetor()
        {
            // var entradas = new int[] { };
            List<int> entradas = new List<int>();
            Console.WriteLine("Digite Números: (exit para sair)");
            Console.WriteLine("--------------------------------");
            while (true)
            {
                var entrada = Console.ReadLine();

                if (entrada == "exit")
                {
                    break;
                }
                else
                {
                    var entradaDois = 0;
                    if (int.TryParse(entrada, out entradaDois))
                    {
                        entradas.Add(int.Parse(entrada));
                        /*
                       var nrEntradas = entradas.Length;
                       var entradasAux = new int[nrEntradas + 1];
                       for (int i = 0; i < nrEntradas; i++)
                       {
                            entradasAux[i] = entradas[i];
                       }
                       entradasAux[nrEntradas] = int.Parse(entrada);
                       entradas = entradasAux;
                   */
                    }
                    else
                    {
                        Console.WriteLine("Entrada Inválida");
                    }

                }
            }

            Console.WriteLine("Valores Digitados: ");
            Console.WriteLine("-------------------");
            foreach (int entrada in entradas)
            {
                Console.WriteLine(entrada);
            }
            Console.ReadKey();
        }


    }
}
