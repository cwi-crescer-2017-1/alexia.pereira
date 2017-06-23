package br.com.crescer.aula3.tema;

import br.com.crescer.aula3.ConnectionUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.stream.Collectors;

/**
 *
 * @author A
 */
public class SQLUtilsImpl implements SQLUtils {

    @Override
    public void runFile(String fileName) {
        //Deve possuir um metodo que execute as instruções contidas dentro de um arquivo, o mesmo tem que ser um ".sql".
        if (!fileName.endsWith(".sql")) {
            throw new RuntimeException("Arquivo inválido");
        }
        File arquivo = new File(fileName);
        try (
                final Reader reader = new FileReader(arquivo);
                final BufferedReader bufferReader = new BufferedReader(reader);) {

            String[] queries = bufferReader.lines().collect(Collectors.joining()).split(";");
            for (String query : queries) {
                try (final PreparedStatement preparedStatement
                        = ConnectionUtils.getConnection().prepareStatement(query)) {
                    preparedStatement.executeUpdate();
                } catch (final SQLException e) {
                    System.err.format("SQLException: %s", e);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public String executeQuery(String query) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(query)) {
            StringBuffer buffer = new StringBuffer();
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            buffer.append(rsmd.getTableName(2)).append("\n");
            int numeroColunas = rsmd.getColumnCount();
            for (int i = 1; i <= numeroColunas; i++) {
                buffer.append(rsmd.getColumnName(i)).append("    |");
            }
            buffer.deleteCharAt(buffer.length() - 1).append("\n");
            while (rs.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
                    Object obj = rs.getObject(i);
                    buffer.append(obj.toString()).append("   |   ");
                }
                buffer.deleteCharAt(buffer.length() - 1).append("\n");
            }
            return buffer.toString();

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
            return null;
        }
    }

    @Override
    public void importCSV(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File importCSV(String query
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
