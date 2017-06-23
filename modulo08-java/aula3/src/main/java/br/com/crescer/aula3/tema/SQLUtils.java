package br.com.crescer.aula3.tema;

import java.io.File;

/**
 * @author carloshenrique
 */
public interface SQLUtils {

    void runFile(String filename);

    String executeQuery(String query);

    void importCSV(File file);

    File importCSV(String query);

}
