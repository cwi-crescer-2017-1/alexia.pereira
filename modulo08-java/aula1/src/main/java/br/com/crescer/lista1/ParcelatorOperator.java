package br.com.crescer.lista1;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class ParcelatorOperator implements Parcelator {

	@Override
	public Map<String, BigDecimal> calcular(BigDecimal valorParcelar,
			int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
		
		Map<String, BigDecimal> conta = new TreeMap<String, BigDecimal>(Collections.reverseOrder());
		
		Calendar c = Calendar.getInstance();
        c.setTime(dataPrimeiroVencimento);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        BigDecimal multiplicadoValorPelaTaxa = valorParcelar
        		.add(valorParcelar
				.multiply(BigDecimal.valueOf(taxaJuros)));
        
        BigDecimal valorMensal = multiplicadoValorPelaTaxa 
        				.divide(BigDecimal.valueOf(numeroParcelas));
        				
		for (int i = 0; i < numeroParcelas; i++) {
			conta.put(sdf.format(c.getTime()), valorMensal);
			c.add(Calendar.MONTH, 1);
		}
		
		return conta;
	}

}
