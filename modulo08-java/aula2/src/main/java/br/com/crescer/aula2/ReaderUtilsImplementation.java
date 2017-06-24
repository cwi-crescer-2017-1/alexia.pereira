package br.com.crescer.aula2;

import br.com.crescer.lista1.StringUtils;
import br.com.crescer.lista1.StringOperator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 * @author alexiapereira
 */
public class ReaderUtilsImplementation implements ReaderUtils {

    StringUtils stringOperator = new StringOperator();

    @Override
    public String read(String string) {

        if (!string.endsWith(".txt")) {
            throw new RuntimeException("Arquivo inválido");
        }
        StringBuffer bufferString = new StringBuffer();
        try (
                final Reader reader = new FileReader(string);
                final BufferedReader bufferReader = new BufferedReader(reader);) {

            String linha = bufferReader.readLine();
            while (!stringOperator.isEmpty(linha)) {
                bufferString.append(linha).append("\n");
                linha = bufferReader.readLine();
            }
            bufferString.deleteCharAt(bufferString.length()-1);
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return bufferString.toString();
    }

}
