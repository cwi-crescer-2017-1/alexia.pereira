package br.com.crescer.aula3;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author carloshenrique
 */
public interface ResultMapper<T> {

    T mapper(ResultSet resultSet) throws SQLException;
}
