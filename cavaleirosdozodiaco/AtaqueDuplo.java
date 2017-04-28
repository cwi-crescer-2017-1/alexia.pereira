public class AtaqueDuplo implements Movimento {
    private Saint golpeador;
    private Saint golpeado;
    private Sorteador sorteador;
    
    public AtaqueDuplo (Saint golpeador, Saint golpeado, Sorteador sorteador) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.sorteador = sorteador;
    }

    public void executar () {
        Golpear golpear = new Golpear(this.golpeador, this.golpeado);
        if (this.podeExecutarAtaqueDuplo()) {
            golpear.executar();
            this.golpeado.perderVida(CalculaFatorDano.getFatorDano(this.golpeador));
        } else {
            golpear.executar();
            this.golpeador.perderVida(this.golpeador.getVida()*0.05);
        }
    }

    private boolean podeExecutarAtaqueDuplo () {
        return sorteador.sortear() % 3 == 0 ? true : false;
    }

}