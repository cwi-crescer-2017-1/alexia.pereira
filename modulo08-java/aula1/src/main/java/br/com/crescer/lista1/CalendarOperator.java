package br.com.crescer.lista1;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalendarOperator implements CalendarUtils {

    public DiaSemana diaSemana(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int diaDaSemana = c.get(Calendar.DAY_OF_WEEK);
        return descobrirDiaDaSemanaPorNumero(diaDaSemana);
    }

    public String tempoDecorrido(Date date) {
        LocalDate dataLD = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period periodo = Period.between(dataLD, new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        return String
                .format("%d ano(s), %d messe(s) e %d dia(s)",
                        periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }

    private DiaSemana descobrirDiaDaSemanaPorNumero(int numero) {
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
