using System;
using Alexia.Pereira;

namespace Alexia.Pereira
{
    public interface IFolhaPagamento
    {
        Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas);
    }
}
