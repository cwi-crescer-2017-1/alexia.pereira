public enum Status {
    VIVO(3), MORTO(2), DESACORDADO(1);
    private int valor;
    private Status (int valor) {
        this.valor = valor;
    }
    
    public int getValor () {
        return this.valor;
    }
}
