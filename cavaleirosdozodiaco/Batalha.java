public class Batalha {
    private Saint saint1;
    private Saint saint2;

    public Batalha (Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar () throws Exception {
        final double dano = 10;
        if (this.saint1.getArmadura().getCategoria().getValor() >= this.saint2.getArmadura().getCategoria().getValor()) {
            this.saint2.perderVida(dano);
        } else {
            this.saint1.perderVida(dano);
        }
    }

}
