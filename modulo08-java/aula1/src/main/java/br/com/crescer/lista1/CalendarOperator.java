package br.com.crescer.lista1;

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
        Calendar cAtual = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        long diff = cAtual.getTime().getTime() - c.getTime().getTime();
       
        long dataEmDias = TimeUnit.MILLISECONDS.toDays(diff);
        long meses = dataEmDias%365 / 30;
        long dias = Math.abs((dataEmDias%365)%31);
        long anos = Math.abs(dataEmDias/365);
        
       return String
                .format("%d ano(s), %d messe(s) e %d dia(s)",
                        anos, meses, dias);
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
