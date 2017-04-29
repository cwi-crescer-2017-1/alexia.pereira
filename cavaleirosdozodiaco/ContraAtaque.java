public class ContraAtaque implements Movimento {
    private Saint golpeador; 
    private Saint golpeado;    
    private Sorteador sorteador;

    public ContraAtaque (Saint golpeador, Saint golpeado, Sorteador sorteador) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.sorteador = sorteador;
    }

    /* Caso o golpeado tenha menos da metade da vida e esteja sem armadura, ele tem 66.6% de chance de, no próximo ataque que tentarem desferir contra ele, 
     * não sofrer dano e ainda aplicar um ataque simples (sem regras de categoria, etc) no adversário que tira 25% da vida. Altere classes caso necessário.*/

    public void executar () {
        if (this.golpeado.getVida() < 50 && this.golpeado.getArmaduraVestida() == false) {
            if (this.podeContraAtacar()) {
                this.golpeado.setContraAtacar(true);
            }
        }
    }

    private boolean podeContraAtacar () {
        return sorteador.sortear() % 3 == 0 ? false : true;
    }
}