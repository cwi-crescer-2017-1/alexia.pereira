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

        for (Saint saint : this.lista) {
            boolean temMesmoNome = saint.getNome().equals(nome);
            if (temMesmoNome) {
                return saint;
            }
        }
        return null;

        /*return this.lista.stream()
        .filter(s -> s.getNome().equals(nome))
        .findFirst().
        orElse(null);
         */
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
        double maior = lista.get(0).getVida();
        Saint saint = this.lista.get(0);
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
        Saint saint;
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
        Saint tmp;
        tmp = sort.get(i);
        sort.set(i, sort.get(j));
        sort.set(j, tmp);
    }

    public void ordenar() {
        this.ordenar(TipoOrdenacao.ASCENDENTE);
    }

    public void ordenar (TipoOrdenacao tipoOrdenacao) {
        boolean ascendente = tipoOrdenacao.equals(TipoOrdenacao.ASCENDENTE);
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.lista.size() - 1; i++) {
                Saint atual = this.lista.get(i);
                Saint proximo = this.lista.get(i + 1);
                boolean precisaTrocar = ascendente ? atual.getVida() > proximo.getVida() : atual.getVida() < proximo.getVida();
                if (precisaTrocar) {
                    this.lista.set(i, proximo);
                    this.lista.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas); 
    }

    public String getCSV () {
        String csv = "";
        StringBuilder builder = new StringBuilder(512);
        for (Saint saint : this.lista) {
            builder.append(saint.getCSV());
            if (this.lista.indexOf(saint) != this.lista.size()-1) {
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

    public ArrayList<Saint> unir (ArrayList<Saint> listaDois) {
        ArrayList<Saint> listaRetorno = new ArrayList<>();
        listaRetorno.addAll(this.lista);
        listaRetorno.addAll(listaDois);
        return listaRetorno;
    }

    private ArrayList<Saint> clonarLista() {
        ArrayList<Saint> listaClone = new ArrayList();
        for (Saint saint : this.lista) {
            listaClone.add(saint);
        }
        return listaClone;
    }

    public ArrayList<Saint> diff (ArrayList<Saint> listaDois) {
        ArrayList<Saint> listaRetorno = new ArrayList<>();
        listaRetorno = this.clonarLista();
        for (Saint saint : listaDois) {
            listaRetorno.remove(saint);
        }
        return listaRetorno;

    }

    public ArrayList<Saint> intersec (ArrayList<Saint> listaDois) {
        ArrayList<Saint> listaRetorno = new ArrayList<>();
        for (Saint saint : this.lista) {
            for (Saint saintDois : listaDois) {
                if (saint.equals(saintDois)) {
                    listaRetorno.add(saint);
                }
            }
        }
        return listaRetorno;    
    }
    /*
    public ArrayList<Saint> intersec (ArrayList<Saint> listaDois) {
    ArrayList<Saint> listaRetorno = new ArrayList<>();
    for (Saint saint : this.lista) {
    if (this.lista.contains(saint) && listaDois.contains(saint)) {
    listaRetorno.add(saint);
    }
    }
    return listaRetorno;
    }
     */
}

