using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Alexia.Pereira
{
    public class Demonstrativo
    {
        public Demonstrativo(
        double salarioBase,
        double hrsConvencao,
        HorasCalculadas horasExtras,
        HorasCalculadas horasDescontadas,
        double totalProventos,
        Desconto inss,
        Desconto irrf,
        double totalDescontos,
        double totalLiquido,
        Desconto fgts)
        {
            SalarioBase = salarioBase;
            HrsConvencao = hrsConvencao;
            HorasExtras = horasExtras;
            HorasDescontadas = horasDescontadas;
            TotalProventos = totalProventos;
            Inss = inss;
            Irrf = irrf;
            TotalDescontos = totalDescontos;
            TotalLiquido = totalLiquido;
            Fgts = fgts;
        }

        public void LogarDemonstrativo()
        {
            Console.WriteLine("+---------------------------------------------------+");
            Console.WriteLine("-DEMONSTRATIVO DE FOLHA DE PAGAMENTO (CONTRA-CHEQUE)-");
            Console.WriteLine("+---------------------------------------------------+");
            Console.WriteLine("-Salário Mensalista (" + this.HrsConvencao + ")                  " + this.SalarioBase);
            Console.WriteLine("-Horas Extras (" + this.HorasExtras.QtdHoras + ")                  " + this.HorasExtras.calcularTotal());
            Console.WriteLine("-Horas Descontadas (" + this.HorasDescontadas.QtdHoras + ")                  " + this.HorasDescontadas.calcularTotal());
            Console.WriteLine("-Total de Proventos                  " + this.TotalProventos);
            Console.WriteLine("-INSS(" + this.Inss.Aliquota + ")                  " + this.Inss.calcularDesconto());
            Console.WriteLine("-IRRF(" + this.Irrf.Aliquota + ")                  " + this.Irrf.calcularDesconto());
            Console.WriteLine("-Total de Descontos                  " + this.TotalDescontos);
            Console.WriteLine("-Total de Líquido                  " + this.TotalLiquido);
            Console.WriteLine("-FGTS(" + this.Fgts.Aliquota + ")                  " + this.Fgts.calcularDesconto());
            Console.WriteLine("+---------------------------------------------------+");
            Console.WriteLine("-----------------------FIM---------------------------");
            Console.WriteLine("+---------------------------------------------------+");
            Console.ReadKey();
        }



        public double SalarioBase { get; private set; }
        public double HrsConvencao { get; private set; }
        public HorasCalculadas HorasExtras { get; private set; }
        public HorasCalculadas HorasDescontadas { get; private set; }
        public double TotalProventos { get; private set; }
        public Desconto Inss { get; private set; }
        public Desconto Irrf { get; private set; }
        public double TotalDescontos { get; private set; }
        public double TotalLiquido { get; private set; }
        public Desconto Fgts { get; private set; }
    }

}
