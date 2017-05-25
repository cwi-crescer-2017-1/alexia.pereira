using Alexia.Pereira;
using System;

namespace Alexia.Pereira
{
    public class FolhaPagamento : IFolhaPagamento
    {

        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            var ValorHora = TruncarValor(salarioBase / horasCategoria);
            var TotalHorasExtras = new HorasCalculadas(horasExtras, (horasExtras * ValorHora));
            var TotalHorasDescontadas = new HorasCalculadas(horasDescontadas, horasDescontadas*ValorHora);
            var TotalDeProventos = TruncarValor(salarioBase + TotalHorasExtras.ValorTotalHoras - TotalHorasDescontadas.ValorTotalHoras);
            var INSS = new Desconto(CalcularAliquotaINSS(TotalDeProventos), TruncarValor(CalcularAliquotaINSS(TotalDeProventos)*TotalDeProventos));
            var IRRF = new Desconto(CalcularAliquotaIRRF(TotalDeProventos - INSS.Valor), TruncarValor(CalcularAliquotaIRRF(TotalDeProventos - INSS.Valor) * (TotalDeProventos - INSS.Valor)));
            var TotalDescontos = INSS.Valor + IRRF.Valor;
            var SalarioLiquido = TruncarValor(TotalDeProventos - TotalDescontos);
            var FGTS = new Desconto((11d / 100d), TruncarValor((11d / 100d)*TotalDeProventos));

            Demonstrativo Demonstrativo = new Demonstrativo
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

            //Demonstrativo.LogarDemonstrativo();

            return Demonstrativo;

        }

        public double CalcularAliquotaINSS(double proventos)
        {
            if (proventos <= 1000)
            {
                return Math.Round(8d / 100d, 2);
            }
            else if (proventos <= 1500)
            {
                return Math.Round(9d / 100d, 2);
            }
            else
            {
                return Math.Round(1d / 10d, 2);
            }
        }

        public double CalcularAliquotaIRRF(double proventosDeduzidos)
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

        public double TruncarValor(double valor)
        {
            return Math.Truncate(valor * 100) / 100;
        }
    }
}
