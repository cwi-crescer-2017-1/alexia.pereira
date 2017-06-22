package br.com.crescer.aula2;

import br.com.crescer.lista1.StringUtils;
import br.com.crescer.lista1.StringOperator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author alexiapereira
 */
public class ReaderUtilsImplementation implements ReaderUtils {

    StringUtils stringOperator = new StringOperator();

    @Override
    public String read(String string) {
        
        if (!string.endsWith(".txt")) {
            try {
                throw new Exception("Arquivo inválido");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return bufferString.toString();
    }

}
