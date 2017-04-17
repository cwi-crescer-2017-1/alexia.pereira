public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida;
    private int qtdSentidosDespertados;
    
    
    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
        this.vida = 100.0;
        
        if (this.armadura.getCategoria() == Categoria.PRATA) {
            this.qtdSentidosDespertados = 6;
        } else if (this.armadura.getCategoria() == Categoria.OURO) {
            this.qtdSentidosDespertados = 7;
        } else {
            this.qtdSentidosDespertados = 5;
        }
        
        
        
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
    
    public Status getStatus () {
        return this.status;
    }
    
    public double getVida () {
        return this.vida;
    }
    
    public void perderVida (double dano) {
        this.vida = this.vida - dano;
    }
    
    public Armadura getArmadura () {
        return this.armadura;
    }
    
    public int getQtdSentidosDespertados () {
        return this.qtdSentidosDespertados;
    }
    
}