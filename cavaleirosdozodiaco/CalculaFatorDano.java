public abstract class CalculaFatorDano {
    
    public static int getFatorDano (Saint golpeador) {
        return golpeador.getArmaduraVestida() 
        ? (golpeador.getProximoGolpe().getFatorDano()*(1+golpeador.getCategoria().getValor())) 
        : golpeador.getProximoGolpe().getFatorDano();
    }
   
}
