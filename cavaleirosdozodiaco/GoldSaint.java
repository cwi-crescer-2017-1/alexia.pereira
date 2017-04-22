
public class GoldSaint extends Saint {
    
    public GoldSaint (String nome, String constelacao) throws Exception {
        this(nome, new Armadura (new Constelacao (constelacao), Categoria.OURO));
    }
    
    
    
    public GoldSaint (String nome, Armadura armadura) throws Exception {
        super (nome, armadura);
        this.qtdSentidosDespertados = 7;
        String cons = armadura.getConstelacao().getNome(); 
        if ( !cons.equals("Áries")  
        && !cons.equals("Touro") 
        && !cons.equals("Gêmeos") 
        && !cons.equals("Câncer") 
        && !cons.equals("Virgem") 
        && !cons.equals("Leão") 
        && !cons.equals("Libra") 
        && !cons.equals("Escorpião") 
        && !cons.equals("Sagitário") 
        && !cons.equals("Capricórnio") 
        && !cons.equals("Aquário") 
        && !cons.equals("Peixes")) { 
            // dar erro
            throw new Exception("Constelação inválida");
        }
    }

    public void moverNaVelocidadeDaLuz() {
        System.out.println(this.getNome() + " na velocidade da Luz!");
    }
    
    public String getNome() {
        return super.getNome();
    }

}

