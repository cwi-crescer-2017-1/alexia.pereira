package br.com.crescer.aula1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Data {

    public static void main(String args[]) {
        try (final Scanner t = new Scanner(System.in)) {
            
            System.out.println("Digite a data");
            String data = t.next();
            System.out.println("Digite o numero de dias");
            int dias = t.nextInt();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(data);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, dias);
            System.out.println(sdf.format(c.getTime()));

        } catch (Exception e) {

        }
    }
}
