using Alexia.Pereira;
using System;

namespace Alexia.Pereira
{
    public class FolhaPagamento : IFolhaPagamento
    {

        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            var ValorHora = salarioBase / horasCategoria;
            var TotalHorasExtras = new HorasCalculadas(horasExtras, ValorHora);
            var TotalHorasDescontadas = new HorasCalculadas(horasDescontadas, ValorHora);
            var TotalDeProventos = salarioBase + TotalHorasExtras.calcularTotal() - TotalHorasDescontadas.calcularTotal();
            var INSS = new Desconto(calcularAliquotaINSS(TotalDeProventos), TotalDeProventos);
            var IRRF = new Desconto(calcularAliquotaIRRF(TotalDeProventos - INSS.calcularDesconto()), TotalDeProventos - INSS.calcularDesconto());
            var TotalDescontos = INSS.calcularDesconto() + IRRF.calcularDesconto();
            var SalarioLiquido = TotalDeProventos - TotalDescontos;
            var FGTS = new Desconto((11d / 100d), TotalDeProventos);

            Demonstrativo demonstrativo = new Demonstrativo
            (
            salarioBase,
            horasCategoria,
            TotalHorasExtras,
            TotalHorasDescontadas,
            TotalDeProventos,
            INSS,
            IRRF,
            TotalDescontos,
            SalarioLiquido,
            FGTS
            );

            demonstrativo.LogarDemonstrativo();
            //demonstrativo.TotalHorasExtras.calcularTotal();
            //demonstrativo.TotalHorasExtras.calcularTotal();
            //demonstrativo.INSS.calcularDesconto();
            //demonstrativo.IRRF.calcularDesconto();

            return demonstrativo;
         
        }

        public double calcularAliquotaINSS(double proventos)
        {
            if (proventos <= 1000)
            {
                return 8d / 100d;
            }
            else if (proventos <= 1500)
            {
                return 9d / 100d;
            }
            else
            {
                return 1d / 10d;
            }
        }

        public double calcularAliquotaIRRF(double proventosDeduzidos)
        {
            if (proventosDeduzidos <= 1710.78)
            {
                return 0d;
            }
            else if (proventosDeduzidos <= 2563.91)
            {
                return 7.5d / 100d;
            }
            else if (proventosDeduzidos <= 3418.59)
            {
                return 15d / 100d;
            }
            else if (proventosDeduzidos <= 4271.59)
            {
                return 22.5d / 100d;
            }
            else
            {
                return 27.5d / 100d;
            }
        }
    }
}
