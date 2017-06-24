package br.com.crescer.aula3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author carloshenrique
 */
public class AbstractDaoTest {


    public void executeUpdate(final String sql) {
        try (final Statement statement = ConnectionUtils.getConnection().createStatement()) {
            statement.executeUpdate(sql);
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public <T> T executeQuery(final String sql, ResultMapper<T> mapperResult) {
        T t = null;
        try (final Statement statement = ConnectionUtils.getConnection().createStatement();
                final ResultSet resultSet = statement.executeQuery(sql)) {
            t = mapperResult.mapper(resultSet);
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return t;
    }
}
