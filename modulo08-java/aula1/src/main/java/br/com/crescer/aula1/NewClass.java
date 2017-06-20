package br.com.crescer.aula1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class NewClass {

    public static void main(String args[]) {
        try (final Scanner t = new Scanner(System.in)) {
       
            StringBuffer buffer = new StringBuffer();
            
            String[] nomesEstados = new String[Estados.values().length];
            int cont = 0;

            for (Estados estado : Estados.values()) {
                nomesEstados[cont] = estado.getNome();
                cont++;
            }

            Arrays.sort(nomesEstados);

//          ORDENA USANDO TREE MAP
//            SortedMap<String, Estados> map = new TreeMap<String, Estados>();
//            for (Estados estado : Estados.values()) {
//                map.put(estado.getNome(), estado);
//            }
//            
//            for (Estados estado : map.values() ) {
//                 buffer.append(estado.getNome()).append(",");
//            }

//            ORDENA USANDO ARRAY ESTÁTICO
            for (String estado : nomesEstados) {
                buffer.append(estado).append(",");
            }

            buffer.deleteCharAt(buffer.length() - 1);
            System.out.println(buffer);

        } catch (Exception e) {

        }
    }
}
