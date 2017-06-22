package br.com.crescer.aula2;

import java.util.Date;

/*
 * @author alexiapereira
 */
public class Main {

    public static void main(String args[]) {
        FileUtils fileUtils = new FileUtilsImplementation();
        ReaderUtils readerUtils = new ReaderUtilsImplementation();
        WriterUtils writerUtils = new WriterUtilsImplementation();
        //        boolean criaArquivo = fileUtils.mk("teste");
        //        boolean deletaArquivo = fileUtils.rm("teste");
        //        String path = fileUtils.ls("src");
        //        System.out.println(fileUtils.mv("teste.txt", "src/teste.txt"));
        final String TARGET_PATH = "target";

        final String testPath = TARGET_PATH + "/" + new Date().getTime() + "/testLs";

        System.out.println(fileUtils.ls(testPath));
//        writerUtils.write("src/teste.txt", "Testando o writer de novo");
//        System.out.println(readerUtils.read("src/teste.txt"));

    }

}
