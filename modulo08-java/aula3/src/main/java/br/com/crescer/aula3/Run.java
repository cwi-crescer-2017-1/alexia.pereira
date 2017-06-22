package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * @author alexia.pereira
 */
public class Run {

    public static void main(String[] args) throws SQLException {
        TesteDAO dao = new TesteDAO();
        dao.drop();
        dao.create();
        dao.insert();
    }
}
