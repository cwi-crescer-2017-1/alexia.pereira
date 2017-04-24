public class Batalha {
    private Saint saint1;
    private Saint saint2;

    public Batalha (Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar () throws Exception {
        int cont;
        if (this.saint1.getCategoria().getValor() >= this.saint2.getCategoria().getValor()) {
            cont = 0;
        } else {
            cont = 1;
        }
        
        while (!saint1.getStatus().equals(Status.MORTO) && !saint2.getStatus().equals(Status.MORTO)) {
            Saint turno = (cont % 2 == 0) ? this.saint1 : this.saint2;
            turno.getProximoMovimento().executar();
            cont++;
        }
       
    }

}
