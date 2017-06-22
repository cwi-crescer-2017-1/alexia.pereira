package br.com.crescer.aula2;
/*
 * @author alexiapereira
 */
public class Main {
    public static void main (String args []) {
        FileUtils fileUtils = new FileUtilsImplementation();
        ReaderUtils readerUtils = new ReaderUtilsImplementation();
        WriterUtils writerUtils = new WriterUtilsImplementation();
        
//        boolean criaArquivo = fileUtils.mk("teste");
//        boolean deletaArquivo = fileUtils.rm("teste");
//        String path = fileUtils.ls("src");
//        System.out.println(fileUtils.mv("teste.txt", "src/teste.txt"));
        
        writerUtils.write("src/teste.txt", "Testando o writer de novo");
        System.out.println(readerUtils.read("src/teste.txt"));
        
    }
    
}
