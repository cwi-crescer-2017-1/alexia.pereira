package br.com.crescer.aula2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author carloshenrique
 */
public class WriterUtilsTest {

    private static final String TARGET_PATH = "target";

    private final WriterUtils writerUtils;

    private String filename;

    private ReaderUtils reader;
    
    public WriterUtilsTest() {
        this.writerUtils = new WriterUtilsImplementation();
        this.reader = new ReaderUtilsImplementation();
    }

    @Before
    public void setBefore() throws IOException {
        this.filename = TARGET_PATH + "/" + new Date().getTime() + "/testWrite.txt";
        Files.createDirectories(Paths.get(filename).getParent());
    }

    /**
     * Test of write method, of class WriterUtils.
     */
    @Test
    public void testWrite() throws IOException {
        final String test = "teste de inclusão " + new Date().getTime();
        writerUtils.write(filename, test);
        assertTrue(reader.read(filename).contains(test));
    }

}
