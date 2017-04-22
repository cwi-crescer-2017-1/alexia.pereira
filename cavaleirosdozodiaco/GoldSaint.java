public class GoldSaint extends Saint {
    public GoldSaint (String nome, String cons) throws Exception {
        super (nome, new Armadura(new Constelacao(cons), Categoria.OURO));
        if (!cons.equals("Áries")  
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
        this.qtdSentidosDespertados = 7;
        
    }

    public void moverNaVelocidadeDaLuz() {
        System.out.println(this.getNome() + " na velocidade da Luz!");
    }
    
    public String getNome() {
        return super.getNome();
    }

}

