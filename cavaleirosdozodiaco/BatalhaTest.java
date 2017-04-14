import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {
    
    @Test
    public void iniciarVerificaCategoriasCorretamente () {
        Saint seiya = new Saint ("Seiya", new Armadura("Pegaso", Categoria.BRONZE));
        Saint marin = new Saint ("Marin", new Armadura("Águia", Categoria.PRATA));
        Batalha batalha = new Batalha (seiya, marin);
        batalha.iniciar();
        assertEquals(90.0, seiya.getVida(), 0.001);
    }
    
    
    @Test
     public void iniciarVerificaEmpateDeCategoria () {
        Saint seiya = new Saint ("Seiya", new Armadura("Pegaso", Categoria.BRONZE));
        Saint marin = new Saint ("Marin", new Armadura("Águia", Categoria.BRONZE));
        Batalha batalha = new Batalha (seiya, marin);
        batalha.iniciar();
        assertEquals(90.0, marin.getVida(), 0.001);
    }

}
