package br.com.crescer.aula3.tema;

import br.com.crescer.aula2.WriterUtils;
import br.com.crescer.aula2.WriterUtilsImplementation;
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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author A
 */
public class SQLUtilsImpl implements SQLUtils {

    WriterUtils writter = new WriterUtilsImplementation();

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
        return renderizarResultSet(query, "    |");
    }

    @Override
    public void importCSV(File file) {
        removerAutoCommit();
        try (
                final Reader reader = new FileReader(file);
                final BufferedReader bufferReader = new BufferedReader(reader);) {

            String linha;
            Object objetos[] = null;
            String query = montarQuery(file, bufferReader);

            while ((linha = bufferReader.readLine()) != null && !linha.isEmpty()) {
                objetos = linha.split(",");
                PreparedStatement preparedStatement = ConnectionUtils.getConnection().prepareStatement(query);
                for (int i = 1; i <= objetos.length; i++) {
                    preparedStatement.setObject(i, objetos[i - 1]);
                }
                preparedStatement.executeQuery();
                preparedStatement.close();
            }
            ConnectionUtils.getConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public File exportCSV(String query) {
        writter.write("C:\\Users\\A\\Desktop\\teste.csv", renderizarResultSet(query, ","));
        return new File("C:\\Users\\A\\Desktop\\teste.csv");
    }

    private String montarQuery(File file, BufferedReader bufferReader) throws IOException {
        String nomeDoArquivo = file.getName().substring(0, file.getName().length() - 4);
        StringBuffer stringBuffer = new StringBuffer("INSERT INTO ");
        StringBuffer values = new StringBuffer("(");
        stringBuffer.append(nomeDoArquivo).append(" (");
        String[] cabecalho = bufferReader.readLine().split(",");
        Arrays.asList(cabecalho).forEach(k -> {
            stringBuffer.append(k).append(" ,");
        });
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" ) VALUES ");

        for (int i = 0; i < cabecalho.length; i++) {
            values.append("?,");
        }
        values.deleteCharAt(values.length() - 1);
        values.append(")");
        return stringBuffer.append(values).toString();
    }

    private void removerAutoCommit() {
        try {
            ConnectionUtils.getConnection().setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String renderizarResultSet(String query, String separador) {
        StringBuffer buffer = new StringBuffer();
        try (PreparedStatement ps = ConnectionUtils.getConnection().prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int numeroColunas = rsmd.getColumnCount();
            for (int i = 1; i <= numeroColunas; i++) {
                buffer.append(rsmd.getColumnName(i)).append(separador);
            }
            buffer.deleteCharAt(buffer.length() - 1).append("\n");
            while (rs.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
                    Object obj = rs.getObject(i);
                    buffer.append(obj.toString()).append(separador);
                }
                buffer.deleteCharAt(buffer.length() - 1).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

}
