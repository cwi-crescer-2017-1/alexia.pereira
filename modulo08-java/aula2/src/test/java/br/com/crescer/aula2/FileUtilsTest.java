package br.com.crescer.aula2;

import java.io.File;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 * @author carloshenrique
 */
public class FileUtilsTest {

    private static final String TARGET_PATH = "target";

    private final FileUtils fileUtils;

    public FileUtilsTest() {
        this.fileUtils = new FileUtilsImplementation();
    }

    @BeforeClass
    public static void setBeforeClass() {
        new File(TARGET_PATH).mkdir();
    }

    /**
     * Test of mk method, of class FileUtils.
     */
    @Test
    public void testMk() {
        final String testPath = TARGET_PATH + "/" + new Date().getTime() + "/testMk";
        fileUtils.mk(TARGET_PATH + "/" + new Date().getTime());
        assertTrue(fileUtils.mk(testPath));
        assertTrue(fileUtils.mk(testPath + "/testMk.txt"));

        final File file = new File(testPath);
        assertTrue(file.exists() && file.isDirectory());

        assertTrue(file.listFiles(f -> "testMk.txt".equals(f.getName())).length > 0);
    }

    /**
     * Test of rm method, of class FileUtils.
     */
    @Test
    public void testRm() {
        final String testPath = TARGET_PATH + "/" + new Date().getTime() + "/testRm";
        fileUtils.mk(testPath.substring(0, testPath.length()-7));
        fileUtils.mk(testPath);
        fileUtils.mk(testPath + "/testRm.txt");
        assertTrue(fileUtils.rm(testPath + "/testRm.txt"));
        try {
            fileUtils.rm(testPath);
            fail("Ao tentar remover o diretório deve lançar uma exception.");
        } catch (RuntimeException e) {
            //.. 
        }
    }

    /**
     * Test of ls method, of class FileUtils.
     */
    @Test
    public void testLs() {
        final String testPath = TARGET_PATH + "/" + new Date().getTime() + "/testLs";
        fileUtils.mk(testPath.substring(0, testPath.length()-7));
        fileUtils.mk(testPath);
        final File file = new File(testPath + "/testLs.txt");
        fileUtils.mk(file.getAbsolutePath());
        assertEquals(file.getAbsolutePath(), fileUtils.ls(testPath + "/testLs.txt"));
        assertTrue(fileUtils.ls(testPath).contains("testLs.txt"));
    }

    /**
     * Test of mv method, of class FileUtils.
     */
    @Test
    public void testMv() {
        final String testPath = TARGET_PATH + "/" + new Date().getTime() + "/testMv";
        fileUtils.mk(testPath.substring(0, testPath.length()-7));
        fileUtils.mk(testPath);
        final String origem = testPath + "/origem.txt";
        final String destino = testPath + "/destino.txt";
        fileUtils.mk(origem);
        assertTrue(fileUtils.mv(origem, destino));
        try {
            fileUtils.mv(testPath, TARGET_PATH + "/" + new Date().getTime());
            fail("Ao tentar remover o diretório deve lançar uma exception.");
        } catch (RuntimeException e) {
            //.. 
        }
    }

}
