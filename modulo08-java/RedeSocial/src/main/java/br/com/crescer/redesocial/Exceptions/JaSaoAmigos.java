package br.com.crescer.redesocial.Exceptions;

/**
 *
 * @author alexia.pereira
 */
public class JaSaoAmigos extends Exception {

    private final String mensagem = "Esse usuário já é seu amigo";

    public JaSaoAmigos() {
        super("Esse usuário já é seu amigo");
    }

    public String getMensagem() {
        return mensagem;
    }

}
