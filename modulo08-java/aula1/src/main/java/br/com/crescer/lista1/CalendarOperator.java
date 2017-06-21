package br.com.crescer.lista1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

public class CalendarOperator implements CalendarUtils{

	public DiaSemana diaSemana(Date date) {
		Calendar c = Calendar.getInstance();
        c.setTime(date);
        int diaDaSemana = c.get(Calendar.DAY_OF_WEEK);
		return descobrirDiaDaSemanaPorNumero(diaDaSemana);
	}

	public String tempoDecorrido(Date date) {
		Calendar cAtual = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
        c.setTime(date);
        int diferencaAnos = cAtual.get(Calendar.YEAR) - c.get(Calendar.YEAR); 
        int diferencaMeses =  Math.abs(cAtual.get(Calendar.MONTH) - c.get(Calendar.MONTH));
        int diferencaDias = Math.abs(cAtual.get(Calendar.DATE) - c.get(Calendar.DATE));
        return String
        		.format("%d ano(s), %d messe(s) e %d dia(s)", 
        		diferencaAnos, diferencaMeses, diferencaDias);
	}

	private DiaSemana descobrirDiaDaSemanaPorNumero (int numero) {
		switch (numero) {
		case 1:
			return DiaSemana.DOMINGO;
		case 2:
			return DiaSemana.SEGUNDA_FEIRA;
		case 3: 
			return DiaSemana.TERCA_FEIRA;
		case 4:
			return DiaSemana.QUARTA_FEIRA;
		case 5: 
			return DiaSemana.QUINTA_FEIRA;
		case 6:
			return DiaSemana.SEXTA_FEIRA;
		default:
			return DiaSemana.SABADO;
		}
	}
	
}
