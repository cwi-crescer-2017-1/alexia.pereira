package br.com.crescer.aula2;

import br.com.crescer.lista1.StringUtils;
import br.com.crescer.lista1.StringOperator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author alexiapereira
 */
public class FileUtilsImplementation implements FileUtils {

    private final StringUtils stringOperator = new StringOperator();

    @Override
    public boolean mk(String string) {
        try {
            return new File(string).createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean rm(String string) {
        File file = new File(string);
        if (file.isDirectory()) {
            try {
                throw new Exception("Arquivo inválido");
            } catch (Exception ex) {
                Logger.getLogger(FileUtilsImplementation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return file.delete();
    }

    @Override
    public String ls(String string) {
        File file = new File(string);
        if (file.isDirectory()) {
            String[] nomeDosArquivosInternos = new File(string).list();
            return String.join(", ", nomeDosArquivosInternos);
        } else {
            return file.getAbsolutePath();
        }
    }

    @Override
    public boolean mv(String in, String out) {
        File fileOrigin = new File(in);
        this.mk(out);
        if (fileOrigin.isDirectory()) {
            try {
                throw new Exception("Arquivo inválido");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try (
                    final Reader reader = new FileReader(in);
                    final BufferedReader bufferReader = new BufferedReader(reader);
                    final FileWriter fileWriter = new FileWriter(out);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
                
                String linha = bufferReader.readLine();
                while (!stringOperator.isEmpty(linha)) {
                    bufferedWriter.append(linha);
                    bufferedWriter.newLine();
                    linha = bufferReader.readLine();
                }

                fileOrigin.deleteOnExit();
                return true;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

}
