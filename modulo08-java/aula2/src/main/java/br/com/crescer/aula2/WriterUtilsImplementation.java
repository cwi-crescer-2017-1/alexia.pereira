package br.com.crescer.aula2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * @author alexiapereira
 */
public class WriterUtilsImplementation implements WriterUtils {

    @Override
    public void write(String file, String conteudo) {
        if (!file.contains(".txt")) {
            try {
                throw new Exception("Arquivo inválido");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try (final FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            bufferedWriter.append(conteudo);
            bufferedWriter.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
