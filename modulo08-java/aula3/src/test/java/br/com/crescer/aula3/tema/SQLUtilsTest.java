package br.com.crescer.aula3.tema;

import java.io.File;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

import br.com.crescer.aula3.AbstractDaoTest;
import br.com.crescer.aula3.ResultMapper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * @author carloshenrique
 */
public class SQLUtilsTest extends AbstractDaoTest {

    private final SQLUtils sQLUtils;

    public SQLUtilsTest() {
        this.sQLUtils = new SQLUtilsImpl();
    }

    @After
    public void tearDown() {
        executeUpdate("DROP SEQUENCE SEQ_TIMES_SERIE_A ");
        executeUpdate("DROP TABLE TIMES_SERIE_A ");
        executeUpdate("DROP TABLE TEST_EXEC_QUERY ");
    }

    /**
     * Test of runFile method, of class SQLUtils.
     */
    @Test
    public void testRunFile() {
        sQLUtils.runFile("Times_Serie_A.sql");
        final List<String> times = executeQuery("SELECT NOME FROM TIMES_SERIE_A", new ResultMapper<List<String>>() {
            @Override
            public List<String> mapper(ResultSet resultSet) throws SQLException {
                final List<String> list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(resultSet.getString("NOME"));
                }
                return list;
            }
        });
        assertEquals(20, times.size());
        assertFalse(times.contains("INTERNACIONAL"));

        try {
            sQLUtils.runFile("Times_Serie_A.csv");
            fail("Caso o arquivo não é um .sql");
        } catch (RuntimeException e) {
            //..
        }

    }

    /**
     * Test of executeQuery method, of class SQLUtils.
     */
    @Test
    public void testExecuteQuery() {
        executeUpdate("CREATE TABLE TEST_EXEC_QUERY ( "
                + "    COL_1 VARCHAR(2) NOT NULL, "
                + "    COL_2 VARCHAR(2) NOT NULL "
                + ")");

        executeUpdate("INSERT INTO TEST_EXEC_QUERY (COL_1, COL_2) VALUES ('OK', 'OK') ");

        String result = sQLUtils.executeQuery("SELECT * FROM TEST_EXEC_QUERY");
        System.out.println(result);
        assertTrue(result.contains("COL_1"));
        assertTrue(result.contains("COL_2"));
        assertTrue(result.contains("OK"));
    }

    /**
     * Test of importCSV method, of class SQLUtils.
     */
    @Test
    public void testImportCSV() {
        executeUpdate("CREATE TABLE TIMES_SERIE_A ( "
                + "    ID NUMBER(8) NOT NULL, "
                + "    NOME VARCHAR2(60) NOT NULL, "
                + "    CONSTRAINT TIMES_SERIE_A_PK PRIMARY KEY (ID) "
                + "    ENABLE "
                + ")");


        final Path path = Paths.get("Times_Serie_A.csv");
        sQLUtils.importCSV(path.toFile());

        final List<String> times = executeQuery("SELECT NOME FROM TIMES_SERIE_A", new ResultMapper<List<String>>() {
            @Override
            public List<String> mapper(ResultSet resultSet) throws SQLException {
                final List<String> list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(resultSet.getString("NOME"));
                }
                return list;
            }
        });
        assertEquals(20, times.size());
        assertFalse(times.contains("INTERNACIONAL"));

        try {
            sQLUtils.importCSV(new File("Times_Serie_A.sql"));
            fail("Caso o arquivo não é um .csv");
        } catch (RuntimeException e) {
            // ..
        }
    }

    /**
     * Test of exportCSV method, of class SQLUtils.
     */
    @Test
    public void testExportCSV() {
        executeUpdate("CREATE TABLE TEST_EXEC_QUERY ( "
                + "    COL_1 VARCHAR(2) NOT NULL, "
                + "    COL_2 VARCHAR(2) NOT NULL "
                + ")");

        executeUpdate("INSERT INTO TEST_EXEC_QUERY (COL_1, COL_2) VALUES ('OK', 'OK') ");

        final File file = sQLUtils.exportCSV("SELECT * FROM TEST_EXEC_QUERY");

        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            final String string = String.join("\n", bufferedReader.lines().collect(toList()));
            assertTrue(string.contains("COL_1"));
            assertTrue(string.contains("COL_2"));
            assertTrue(string.contains("OK"));
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}
