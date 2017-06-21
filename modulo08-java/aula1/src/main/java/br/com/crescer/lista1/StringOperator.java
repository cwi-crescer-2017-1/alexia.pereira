package br.com.crescer.lista1;
/*
 *
 * @author alexiapereira
 */
 import java.text.Normalizer;
import java.util.Stack;

public class StringOperator implements StringUtils {
    
    public boolean isEmpty(String string) {
        return string == null 
        		|| string.length() < 1
        		|| string.equals("");
    }
    
    public String inverter(String string) {
    	
    	 StringBuffer stringInvertida = new StringBuffer(); 
    	 Stack<Character> pilha = new Stack<Character>();

         for (char letra : string.toCharArray()) {
             pilha.push(letra);
         }
         
         while (!pilha.isEmpty()) {
             stringInvertida.append(pilha.pop());
         }
         
        return stringInvertida.toString();
    }
    
    public int contaVogais(String string) {
    	string = Normalizer
    	           .normalize(string, Normalizer.Form.NFD)
    	           .replaceAll("[^\\p{ASCII}]", "");
    			
		System.out.println(string.replace("([^aeiou]+)", ""));
    	return string.length() - string.replace("/[^aeiou]+/g", "").length();
    }
    
    public boolean isPalindromo(String string) {
    	string = Normalizer
 	           .normalize(string.replaceAll(" ", ""), Normalizer.Form.NFD)
 	           .replaceAll("[^\\p{ASCII}]", "");
        return string.equalsIgnoreCase(this.inverter(string));
    }
    
}
