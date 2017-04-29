public abstract class CalculaFatorDano {
    
    public static int getFatorDano (Saint golpeador, Golpe golpe) {
        return golpeador.getArmaduraVestida() 
        ? golpe.getFatorDano()*(1+golpeador.getCategoria().getValor())
        : golpe.getFatorDano();
    }
   
}
