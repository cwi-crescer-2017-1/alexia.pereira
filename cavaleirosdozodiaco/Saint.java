public class Saint {
    private String nome;
    protected Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.;
    protected int qtdSentidosDespertados;

    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        /*int valorCategoria = this.armadura.getCategoria().getValor();
        this.qtdSentidosDespertados += valorCategoria;*/
    }

    public void vestirArmadura() {
        this.armaduraVestida = true;
    }

    // camelCase
    public boolean getArmaduraVestida() {
        return this.armaduraVestida;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Status getStatus() {
        return this.status;
    } 
    
    public void setStatus (Status status) {
        this.status = status;
    }
        
    public double getVida() {
        return this.vida;
    }

    public void perderVida(double dano) throws InvalidParameterException {
        if (dano > 0) {  
            if (this.getStatus() != Status.MORTO) {
                this.vida -= dano;
                this.status = (this.vida < 1) ? Status.MORTO : this.status;
            }
            
        } else {
            throw new InvalidParameterException("Parâmetro inválido");
        }
    }

    public Armadura getArmadura() {
        return this.armadura;
    }

    public int getQtdSentidosDespertados() {
        return this.qtdSentidosDespertados;
    }

}

