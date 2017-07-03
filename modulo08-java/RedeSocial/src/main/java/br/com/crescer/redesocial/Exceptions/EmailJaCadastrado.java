package br.com.crescer.redesocial.Exceptions;

/**
 *
 * @author alexia.pereira
 */
public class EmailJaCadastrado extends Exception {
    
    private final String mensagem = "Esse email já está sendo utilizado";
    
    public EmailJaCadastrado() {
        super("Esse email já está sendo utilizado");
    }

    public String getMensagem() {
        return mensagem;
    }
    
    
    
    
    
}
