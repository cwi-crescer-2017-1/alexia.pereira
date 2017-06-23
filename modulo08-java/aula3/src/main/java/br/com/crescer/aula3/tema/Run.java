package br.com.crescer.aula3.tema;

/**
 *
 * @author alexia.pereira
 */
public class Run {

    public static void main(String[] args) {
        SQLUtils util = new SQLUtilsImpl();
        System.out.println(util.executeQuery("SELECT * FROM ESTADO WHERE ID > 20"));
//        File file = new File("C:\\Users\\A\\Documents\\instrutores\\modulo-07\\tarefa\\cidade.csv");
//        util.importCSV(file);
        System.out.println(util.importCSV("SELECT * FROM ESTADO WHERE ID > 20").getName());

    }
}
