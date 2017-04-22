public class Golpear implements Movimento {
    private Saint golpeador;
    private Saint golpeado;
    
    
    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        
    }

    public void executar () {
        int fatorDano = golpeador.getArmaduraVestida() ? 
        (golpeador.getProximoGolpe().getFatorDano()*(1+golpeador.getCategoria().getValor())) 
        : golpeador.getProximoGolpe().getFatorDano();
        
        golpeado.perderVida(fatorDano);
        
    }
    
    
}
