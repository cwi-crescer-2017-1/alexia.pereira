using Alexia.Pereira;
using System;

namespace Alexia.Pereira
{
    public class FolhaPagamento : IFolhaPagamento
    {

        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            //Quanto o colaborador ganha por hora
            var ValorHora = TruncarValor(salarioBase / horasCategoria);
            //Calcula valor das horas (extras e descontadas)
            var valorHorasExtras = calcularHoras(horasExtras, ValorHora);
            var valorHorasDesconto = calcularHoras(horasDescontadas, ValorHora);
            //Inicia o objeto de horas extras e horas descontadas
            var TotalHorasExtras = new HorasCalculadas(horasExtras, valorHorasExtras);
            var TotalHorasDescontadas = new HorasCalculadas(horasDescontadas, valorHorasDesconto);


            var TotalDeProventos = TruncarValor(salarioBase + TotalHorasExtras.ValorTotalHoras - TotalHorasDescontadas.ValorTotalHoras);

            var aliquotaINSS = CalcularAliquotaINSS(TotalDeProventos);
            var INSS = new Desconto(aliquotaINSS, TruncarValor(aliquotaINSS * TotalDeProventos));

            var aliquotaIRRF = CalcularAliquotaIRRF(TotalDeProventos - INSS.Valor);
            var IRRF = new Desconto(aliquotaIRRF, TruncarValor(aliquotaIRRF * (TotalDeProventos - INSS.Valor)));

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

        private double calcularHoras (double horasExtras, double valorPorHora)
        {
            return TruncarValor(horasExtras * valorPorHora);
        }


    }
}
