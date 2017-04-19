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
        for (int i = 0; i < this.lista.size(); i++) {
            if (lista.get(i).getNome().equals(nome)) {
                Saint saint = new Saint();
                saint = lista.get(i);
                return saint;
            }
        }

        return null;

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

    private void trocar(List<Saint> sort, int i, int j) {
        Saint tmp = new Saint();
        tmp = sort.get(i);
        sort.set(i, sort.get(j));
        sort.set(j, tmp);
    }

    public void ordenar() {
        int min;
        for (int i = 0; i < this.lista.size(); ++i) {
            min = i;
            for (int j = i + 1; j < this.lista.size(); ++j) {
                if (this.lista.get(j).getVida() < this.lista.get(min).getVida()) {
                    min = j;
                }
            }
            this.trocar(this.lista, i, min);
        }
    }

}
