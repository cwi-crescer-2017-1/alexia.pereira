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
            throw new RuntimeException("Arquivo inválido");
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
        File fileDestiny = new File(out);
        return fileOrigin.renameTo(fileDestiny);
    }

}
