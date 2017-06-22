package br.com.crescer.lista1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParcelatorOperator implements Parcelator {

    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar,
            int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {

        Map<String, BigDecimal> conta = new LinkedHashMap<String, BigDecimal>();

        taxaJuros = taxaJuros / 100;
        Calendar c = Calendar.getInstance();
        c.setTime(dataPrimeiroVencimento);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        BigDecimal multiplicadoValorPelaTaxa = valorParcelar
                .add(valorParcelar
                        .multiply(BigDecimal.valueOf(taxaJuros)));

        BigDecimal valorMensal = multiplicadoValorPelaTaxa
                .divide(BigDecimal.valueOf(numeroParcelas), 2, RoundingMode.UP);
        
        BigDecimal vlResto = valorMensal.multiply(BigDecimal.valueOf(numeroParcelas)).subtract(multiplicadoValorPelaTaxa);
        
        for (int i = 0; i < numeroParcelas; i++) {
            conta.put(sdf.format(c.getTime()), valorMensal.subtract(vlResto));
            vlResto = BigDecimal.ZERO;
            c.add(Calendar.MONTH, 1);
        }

        return conta;
    }

}
