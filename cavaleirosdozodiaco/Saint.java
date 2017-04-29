import java.security.InvalidParameterException;
import java.util.ArrayList;
public abstract class Saint {
    private String nome;
    protected Armadura armadura;
    private boolean armaduraVestida, contraAtacar = false;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.;
    protected int qtdSentidosDespertados, acumuladorProximoGolpe = 0,acumuladorProximoMovimento = 0, id = 0;
    private ArrayList<Movimento> movimentos = new ArrayList<>();
    private static int qtdSaints = 0, acumuladorSaint = 0;
    
    protected Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        Saint.qtdSaints++;
        this.id = ++acumuladorSaint;
    }
    
    public boolean getContraAtacar () {
        return this.contraAtacar;
    }
    
    public void setContraAtacar (boolean contraAtacar) {
        this.contraAtacar = contraAtacar;
    }
    

    public static int getAcumuladorSaint () {
        return Saint.acumuladorSaint;
    }

    protected void finalize () throws Throwable {
        Saint.qtdSaints--;      
    }

    public int getId () {
        return this.id;
    }

    public static int getQtdSaints () {
        return Saint.qtdSaints;
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
        if (this.getGolpes().isEmpty()) {
            return null;
        }   
        ArrayList<Golpe> golpes = this.getGolpes(); 
        int posicao = this.acumuladorProximoGolpe % golpes.size(); 
        this.acumuladorProximoGolpe++; 
        return golpes.get(posicao); 
    } 

    public boolean equals(Object object) {
        Saint outroSaint = (Saint)object;
        return this.nome.equals(outroSaint.getNome()) && this.getCategoria().equals(outroSaint.getCategoria()) 
        && this.getArmadura().getConstelacao().getNome().equals(outroSaint.getArmadura().getConstelacao().getNome())
        && this.getArmaduraVestida() == outroSaint.getArmaduraVestida() 
        &&  this.getGenero().equals(outroSaint.getGenero())
        && this.getStatus().equals(outroSaint.getStatus())
        && this.getVida() == outroSaint.getVida()
        && this.qtdSentidosDespertados == outroSaint.getQtdSentidosDespertados();

    }

    public String getCSV () {
        return String.format(
            "%s,%s,%s,%s,%s,%s,%s",
            this.nome,
            this.vida,
            this.getConstelacao().getNome(),
            this.armadura.getCategoria(),
            this.status,
            this.genero,
            this.armaduraVestida);

        /*
        return this.getNome() + ","
        + this.getVida() + "," 
        + this.getArmadura().getConstelacao().getNome() + "," 
        + this.getCategoria() + ","
        + this.getStatus() + "," 
        + this.getGenero() + "," 
        + this.getArmaduraVestida(); 
         */
    }

    public Saint getSaintByCSV  (String csv) throws Exception {
        String [] atributos = csv.split(",");
        Saint saint = null;
        if (atributos[3].equals("BRONZE")) {
            saint = new BronzeSaint(atributos[0], atributos[2]);
        } else if (atributos[3].equals("PRATA")) {
            saint = new SilverSaint(atributos[0], atributos[2]);
        } else {
            saint = new GoldSaint(atributos[0], atributos[2]);
        }
        
        saint.setVida(Double.parseDouble(atributos[1]));
        saint.setStatus(Status.valueOf(atributos[4]));
        saint.setGenero(Genero.valueOf(atributos[5]));
        saint.setArmaduraVestida(Boolean.getBoolean(atributos[6]));
        
        return saint;
    }
    
    private void setVida (double vida) {
        this.vida = vida;
    }
    
    private void setArmaduraVestida (boolean armaduraVestida) {
        this.armaduraVestida = armaduraVestida;
    }
    
    public Categoria getCategoria () {
        return this.armadura.getCategoria();
    }

    public void adicionarMovimento (Movimento movimento) {
        this.movimentos.add(movimento);
    }

    public Movimento getProximoMovimento () {
        int posicao = this.acumuladorProximoMovimento % this.movimentos.size(); 
        this.acumuladorProximoMovimento++; 
        return movimentos.get(posicao); 
    }

}
