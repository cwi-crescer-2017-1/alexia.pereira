package br.com.crescer.aula1;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ExercicioDatas {

    public static void main(String args[]) {
        try (final Scanner t = new Scanner(System.in)) {

            System.out.println("Dia de hoje" + new java.util.Date());

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse("14/02/2000");
            Calendar c = Calendar.getInstance();

            c.setTime(date);

            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            dayOfWeek = dayOfWeek == 1 ? 8 : dayOfWeek;
            System.out.println(DayOfWeek.of(dayOfWeek-1));

        } catch (Exception e) {

        }
    }
}
