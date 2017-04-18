
public class GoldSaint extends Saint {
    public GoldSaint (String nome, Armadura armadura) throws Exception {
        super (nome, armadura);
        this.qtdSentidosDespertados = 7;
        if (this.armadura.getCategoria() == Categoria.OURO) {
            //this.qtdSentidosDespertados = 7;
            
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
    }
}
