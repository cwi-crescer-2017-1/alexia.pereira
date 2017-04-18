public class Constelacao  {
    private String nome;
    private Golpe [] golpes = new Golpe [3];
   
    public Constelacao (String nome) {
        this.nome = nome;
    }
    
    public String getNome () {
        return this.nome;
    }
    
    public Golpe[] getGolpes () {
        return this.golpes;
    }
    
    public void adicionarGolpe (Golpe golpe) {
        int contador = 3;
        for (int i = 0; i < this.golpes.length; i++) {
            if (golpes[i] == null) {
                contador--;
            }           
        }
        golpes[contador] = golpe; 
    }
    
}