import java.util.*;
public class ListaSaint {
    ArrayList<Saint> lista = new ArrayList<>();

    public int getSize () {
        return this.lista.size();
    }
 
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
        Saint saint = null;
        for (int i = 0; i < this.lista.size(); i++) {
            if (lista.get(i).getNome().equals(nome)) {
                saint = new Saint();
                saint = lista.get(i);
                return saint;
            }
        }
 
        return saint;

    }

    public ArrayList<Saint> buscarPorCategoria (Categoria categoria) {
        ArrayList<Saint> listaCat = new ArrayList<>();
        for (int i = 0; i < this.lista.size(); i++) {
            if (lista.get(i).getArmadura().getCategoria() == categoria) {
                listaCat.add(lista.get(i));
            }
        }
 
        return listaCat;

    }

    public ArrayList<Saint> buscarPorStatus (Status status) {
        ArrayList<Saint> listaStatus = new ArrayList<>();
        for (int i = 0; i < this.lista.size(); i++) {
            if (lista.get(i).getStatus() == status) {

                listaStatus.add(lista.get(i));

            }

        }

        return listaStatus;    
    }    
 
    public Saint getSaintMaiorVida () {

        Saint saint = new Saint();

        double maior = lista.get(0).getVida();

        saint = this.lista.get(0);

        for (int i = 0; i < this.lista.size(); i++) {

            if (this.lista.get(i).getVida() > maior) {

                maior = this.lista.get(i).getVida();               

                saint = lista.get(i);

            }
        }
        return saint;
    }
 
    public Saint getSaintMenorVida () {

        Saint saint = new Saint();

        double menor = lista.get(0).getVida();

        saint = this.lista.get(0);

        for (int i = 0; i < this.lista.size(); i++) {

            if (this.lista.get(i).getVida() < menor) {
                menor = this.lista.get(i).getVida();

                saint = this.lista.get(i);

            } 

        }

        return saint;

    }

    public void ordenar () {

        Collections.sort(this.lista, new CustomComparator());

    }

 
}
