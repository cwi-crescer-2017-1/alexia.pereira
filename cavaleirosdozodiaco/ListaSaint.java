import java.util.*;

public class ListaSaint {
    ArrayList<Saint> lista = new ArrayList<>();
    
    public void adicionarSaint (Saint saint) {
        this.lista.add(saint);
    }
    
    public Saint get (int indice) {
        return this.lista.get(indice);
    }
    
    public ArrayList<Saint> todos () {
        return this.lista;
    }
    
    public void removerSaint (Saint saint) {
        lista.remove(saint);
    }
    
    public Saint buscarPorNome (String nome) {
        Saint saint;
        for (int i = 0; i < this.lista.size(); i++) {
            if (lista.get(i).getNome().equals(nome)) {
                
            }
        }
    }
    
    //buscar por nome
    //buscar por categoria
    //buscar por status
    //get saint com maior vida
    //get saint menor vida
    //ordenar (void)
    
    
}