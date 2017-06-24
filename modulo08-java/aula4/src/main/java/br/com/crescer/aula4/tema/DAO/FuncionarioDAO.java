package br.com.crescer.aula4.tema.DAO;

import br.com.crescer.aula4.tema.POJO.Funcionario;
import java.util.List;

/**
 *
 * @author alexia.pereira
 */
public class FuncionarioDAO extends AbstractDAO<Funcionario, Long> {

    public FuncionarioDAO() {
        super(Funcionario.class);
    }
    
    public Funcionario save (Funcionario funcionario) {
        super(funcionario);
        return null;
    }

    
    
   
    

}
