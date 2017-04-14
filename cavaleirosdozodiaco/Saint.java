public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private StatusDeVida status = StatusDeVida.VIVO;
    private double vida;
    
    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
        this.vida = 100.0;
    }
    
    public void vestirArmadura () {
        this.armaduraVestida = true;
    }
    
    public boolean getArmaduraVestida () {
        return this.armaduraVestida;
    }
    
    public Genero getGenero () {
        return this.genero;
    }
    
    public void setGenero (Genero genero) {
        this.genero = genero;
    }
    
    public StatusDeVida getStatus () {
        return this.status;
    }
    
    public double getVida () {
        return this.vida;
    }
    
    public void perderVida (double vida) {
        this.vida = this.vida - vida;
    }
    
    public Armadura getArmadura () {
        return this.armadura;
    }
    
    
    
}