public class AtaqueDuplo implements Movimento {
    private Saint golpeador;
    private Saint golpeado;

    public AtaqueDuplo (Saint golpeador, Saint golpeado, Golpear golpear) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar () {
        Golpear golpear = new Golpear(this.golpeador, this.golpeado);
        if (this.podeExecutarAtaqueDuplo()) {
            //Implementar comparacao de vida do saint golpeado
            golpear.executar();
        } else {
            golpear.executar();
            this.golpeador.perderVida(this.golpeador.getVida()*0.05);
        }
    }

    private boolean podeExecutarAtaqueDuplo () {
        Sorteador sorteador = new DadoD6();
        return sorteador.sortear() % 3 == 0 ? true : false;
    }

}