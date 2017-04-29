public class Golpear implements Movimento {
    private Saint golpeador;
    private Saint golpeado;
    private Golpe golpeUtilizado;
    
    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.golpeUtilizado = this.golpeador.getProximoGolpe();
    }
    
    public void executar () {
        golpeado.perderVida(CalculaFatorDano.getFatorDano(this.golpeador, this.golpeUtilizado));
    }
}
