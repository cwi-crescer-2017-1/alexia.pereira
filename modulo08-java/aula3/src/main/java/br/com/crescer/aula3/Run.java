package br.com.crescer.aula3;

import br.com.crescer.aula3.DAO.PaisDAO;
import br.com.crescer.aula3.DAO.PaisDAOImpl;
import br.com.crescer.aula3.POJO.Pais;
import java.sql.SQLException;

/*
 * @author alexia.pereira
 */
public class Run {

    public static void main(String[] args) throws SQLException {
        //PAIS
        PaisDAO paisDAO = new PaisDAOImpl();
        Pais eua = new Pais();
        //INSERT
        eua.setId(new Long(2));
        eua.setNome("Estados Unidos 2");
        eua.setSigla("EUA");
        //paisDAO.insert(eua);
        //LOAD
        System.out.println(paisDAO.loadBy(eua.getId()).getNome());
        //UPDATE
        paisDAO.update(eua);
        //DELETE
        paisDAO.delete(eua);
    }
}
