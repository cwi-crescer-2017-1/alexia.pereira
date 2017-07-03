package br.com.crescer.redesocial.Exceptions;

/**
 *
 * @author alexia.pereira
 */
public class AdicionarASiMesmo extends Exception {

    private final String mensagem = "Você não pode se adicionar como amigo";

    public AdicionarASiMesmo() {
        super("Você não pode se adicionar como amigo");
    }

    public String getMensagem() {
        return mensagem;
    }

}
