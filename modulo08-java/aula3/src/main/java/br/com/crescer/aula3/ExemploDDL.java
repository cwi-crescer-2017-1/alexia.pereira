package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author alexia.pereira
 */
public class ExemploDDL {

    public static void main(String[] args) {
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "JAVA";
        final String pass = "JAVA";
        final String query = "CREATE TABLE TESTE (\n"
                + "  ID NUMBER(8) NOT NULL ,\n"
                + "  NOME VARCHAR2(75) DEFAULT NULL\n"
                + ")";
        try (
                final Connection connection = DriverManager.getConnection(url, user, pass);
                final Statement statement = connection.createStatement();) {

            statement.executeUpdate(query);

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }

    }
}
