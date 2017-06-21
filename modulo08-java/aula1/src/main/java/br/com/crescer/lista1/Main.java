package br.com.crescer.lista1;
/*
 *
 * @author alexiapereira
 */
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		try (final Scanner t = new Scanner(System.in)) {
			
			StringOperator stringOperator = new StringOperator();
			
			System.out.println("STRING UTILS:");
			
			System.out.println("Resultado do isEmpty com ''");
			System.out.println(stringOperator.isEmpty(""));
			System.out.println("-------------------------");
			
			System.out.println("Resultado do inverter com a frase: 'hello world'");
			System.out.println(stringOperator.inverter("hello world"));
			System.out.println("-------------------------");
			
			System.out.println("Resultado do contaVogais com a frase: 'a ana estava l�'");
			System.out.println(stringOperator.contaVogais("a ana estava la"));
			System.out.println("-------------------------");
			
			System.out.println("Resultado do isPalindromo com a frase: 'A sogra ma e amargosa'");
			System.out.println(stringOperator
					.isPalindromo("A sogra ma e amargosa") + "\n");
			System.out.println("-------------------------------------------------\n");
			
			
			CalendarOperator calendarO = new CalendarOperator();
			
			System.out.println("CALENDAR UTILS:");
			
			System.out.println("Dia da Semana: ");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Digite a data: ");
			Date date = sdf.parse(t.next());
			System.out.println(calendarO.diaSemana(date));
			System.out.println("-------------------------");
			
			System.out.println("Tempo Decorrido: ");
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Digite a data");
			date = sdf.parse(t.next());
			System.out.println(calendarO.tempoDecorrido(date) + "\n");
			System.out.println("-------------------------------------------------\n");
			
			System.out.println("PARCELATOR: ");
			System.out.println("Resultado do Parcelator com os dados da gist");
			ParcelatorOperator po = new ParcelatorOperator();
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			date = sdf.parse("30/06/2016");
			Map<String, BigDecimal> conta = po.calcular(new BigDecimal(1000),
					10, 10, date);
			for (Entry<String, BigDecimal> pair : conta.entrySet()) {
				System.out.println(pair.getKey() + " - " + pair.getValue());
			}
			
		} catch (Exception e) {

		}
	}

}
