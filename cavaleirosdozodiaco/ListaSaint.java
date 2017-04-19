import java.util.ArrayList;
import java.util.stream.Collectors;

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
        /*
        for (int i = 0; i < this.lista.size(); i++) {
        if (lista.get(i).getNome().equals(nome)) {
        return lista.get(i);
        }
        }
        return null;
         */

        return this.lista.stream()
        .filter(s -> s.getNome().equals(nome))
        .findFirst().
        orElse(null);

    }

    public ArrayList<Saint> buscarPorCategoria (Categoria categoria) {
        /*
        ArrayList<Saint> listaCat = new ArrayList<>();
        for (int i=0; i< this.lista.size(); i++) {
        if (this.lista.get(i).getArmadura().getCategoria().equals(categoria)) {
        listaCat.add(this.lista.get(i));
        }
        }
        return listaCat;
         */
        return (ArrayList<Saint>)this.lista.stream()
        .filter(s -> s.getArmadura().getCategoria().equals(categoria))
        .collect(Collectors.toList());
    }

    public ArrayList<Saint> buscarPorStatus (Status status) {
        /* 
        ArrayList<Saint> listaStatus = new ArrayList<>();
        for (int i = 0; i < this.lista.size(); i++) {
        if (lista.get(i).getStatus() == status) {
        listaStatus.add(lista.get(i));
        }
        }
        return listaStatus;    
         */

        return (ArrayList<Saint>)this.lista.stream()
        .filter(s -> s.getArmadura().getCategoria().equals(status))
        .collect(Collectors.toList());

    }    

    public Saint getSaintMaiorVida () {
        if (this.lista.isEmpty()) {
            return null;
        }
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
        if (this.lista.isEmpty()) {
            return null;
        }
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

    private void trocar(ArrayList<Saint> sort, int i, int j) {
        Saint tmp = new Saint();
        tmp = sort.get(i);
        sort.set(i, sort.get(j));
        sort.set(j, tmp);
    }

    public void ordenar() {
        /*
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
         */
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.lista.size() - 1; i++) {
                Saint atual = this.lista.get(i);
                Saint proximo = this.lista.get(i + 1);
                boolean precisaTrocar = atual.getVida() > proximo.getVida();
                if (precisaTrocar) {
                    this.lista.set(i, proximo);
                    this.lista.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);   
    
    }
    
    public void ordenar (TipoOrdenacao tipoOrdenacao) {
        if (tipoOrdenacao.equals(TipoOrdenacao.ASCENDENTE)) {
            this.ordenar();
        } else if (tipoOrdenacao.equals(TipoOrdenacao.DESCENDENTE)) {
            boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.lista.size() - 1; i++) {
                Saint atual = this.lista.get(i);
                Saint proximo = this.lista.get(i + 1);
                boolean precisaTrocar = atual.getVida() < proximo.getVida();
                if (precisaTrocar) {
                    this.lista.set(i, proximo);
                    this.lista.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas); 
        }
    }
    
    

}
