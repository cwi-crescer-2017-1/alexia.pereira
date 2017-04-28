public class Golpear implements Movimento {
    private Saint golpeador;
    private Saint golpeado;
    
    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar () {
        golpeado.perderVida(CalculaFatorDano.getFatorDano(this.golpeador));
    }
    
    
}
