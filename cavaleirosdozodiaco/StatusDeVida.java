public enum StatusDeVida {
    VIVO(3), MORTO(2), DESACORDADO(1);
    private int valor;
    private StatusDeVida (int valor) {
        this.valor = valor;
    }
    
    public int getValor () {
        return this.valor;
    }
}
