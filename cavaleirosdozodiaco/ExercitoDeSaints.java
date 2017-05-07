import java.util.ArrayList;
public abstract class ExercitoDeSaints extends ListaSaint {
    private int categoriaAtual = 0;
    public void alistar (Saint saint) {
        super.adicionarSaint(saint);
    }

    public void ordenar (TipoOrdenacao tipoOrdenacao) {
        boolean posicoesSendoTrocadas;
        if (tipoOrdenacao.equals(TipoOrdenacao.HIERARQUICA)) {
            do {
                posicoesSendoTrocadas = false;
                for (int i = 0; i < this.lista.size() - 1; i++) {
                    Saint atual = this.lista.get(i);
                    Saint proximo = this.lista.get(i + 1);
                    boolean precisaTrocar = atual.getCategoria().getValor() > proximo.getCategoria().getValor();
                    if (precisaTrocar) {
                        this.lista.set(i, proximo);
                        this.lista.set(i + 1, atual);
                        posicoesSendoTrocadas = true;
                    }
                }
            } while (posicoesSendoTrocadas); 
            
        } else if (tipoOrdenacao.equals(TipoOrdenacao.ALTERNADA)) {
            do {
                posicoesSendoTrocadas = false;
                for (int i = 0; i < this.lista.size() - 1; i++) {
                    switch ((i+1)%3) {
                        case 0: 
                            this.categoriaAtual = 3;
                            break;
                        case 1:
                            this.categoriaAtual = 1;
                            break;
                        case 2: 
                            this.categoriaAtual = 2;
                            break;
                    }
                    Saint atual = this.lista.get(i);
                    Saint proximo = this.lista.get(i + 1);
                    boolean precisaTrocar = atual.getCategoria().getValor() > categoriaAtual && atual.getCategoria().getValor() > proximo.getCategoria().getValor() ;
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
