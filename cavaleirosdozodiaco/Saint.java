import java.security.InvalidParameterException;
import java.util.ArrayList;
public abstract class Saint {
    private String nome;
    protected Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.;
    protected int qtdSentidosDespertados;
    private int acumuladorProximoGolpe = 0; 

    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        /*int valorCategoria = this.armadura.getCategoria().getValor();
        this.qtdSentidosDespertados += valorCategoria;*/
    }

    public String getNome() {
        return this.nome;
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
                if (vida < 1) {
                    this.status = Status.MORTO;
                    this.vida = 0;
                }
            }

        } else {
            throw new InvalidParameterException("Dano inválido");
        }
    }

    public Armadura getArmadura() {
        return this.armadura;
    }

    private Constelacao getConstelacao () {
        return this.armadura.getConstelacao();
    }

    public int getQtdSentidosDespertados() {
        return this.qtdSentidosDespertados;
    }

    public ArrayList<Golpe> getGolpes () {
        return this.getConstelacao().getGolpes();
    }

    public void aprenderGolpe (Golpe golpe) {
        this.getConstelacao().adicionarGolpe(golpe);
    }

    public Golpe getProximoGolpe() { 
        ArrayList<Golpe> golpes = this.getGolpes(); 
        int posicao = this.acumuladorProximoGolpe % golpes.size(); 
        this.acumuladorProximoGolpe++; 
        return golpes.get(posicao); 
    } 

    public boolean equals(Object object) {
        Saint outroSaint = (Saint)object;
        return this.nome.equals(outroSaint.getNome()) && this.getArmadura().getCategoria().equals(outroSaint.getArmadura().getCategoria()) 
        && this.getArmadura().getConstelacao().getNome().equals(outroSaint.getArmadura().getConstelacao().getNome())
        && this.getArmaduraVestida() == outroSaint.getArmaduraVestida() 
        &&  this.getGenero().equals(outroSaint.getGenero())
        && this.getStatus().equals(outroSaint.getStatus())
        && this.getVida() == outroSaint.getVida()
        && this.qtdSentidosDespertados == outroSaint.getQtdSentidosDespertados();

    }

    public String getCSV () {
        return this.getNome() + ","
        + this.getVida() + "," 
        + this.getArmadura().getConstelacao().getNome() + "," 
        + this.getArmadura().getCategoria() + ","
        + this.getStatus() + "," 
        + this.getGenero() + "," 
        + this.getArmaduraVestida(); 
    }

}
