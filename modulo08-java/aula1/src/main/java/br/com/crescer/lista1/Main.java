package br.com.crescer.lista1;
/*
 *
 * @author alexiapereira
 */
public class Main {
	public static void main(String args[]) {
		StringOperator stringOperator = new StringOperator();
		System.out.println(stringOperator.isEmpty(null));
		System.out.println(stringOperator.inverter("ovo ata banana"));
		System.out.println(stringOperator.contaVogais("a ana tava lá"));
		System.out.println(stringOperator.isPalindromo("A sogra má e amargosa"));
	}
}

