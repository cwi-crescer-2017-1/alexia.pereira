public enum Categoria {
    OURO(2), PRATA(1), BRONZE(0);
    private int valor;
    private Categoria (int valor) {
        this.valor = valor;
    }
    
    public int getValor () {
        return this.valor;
    }
    
    
    
    
}
