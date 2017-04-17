import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {

    @Test
    public void categoriaSaint1MaiorQueSaint2 () {
        Saint seiya = new Saint ("Seiya", new Armadura("Pegaso", Categoria.BRONZE));
        Saint marin = new Saint ("Marin", new Armadura("Águia", Categoria.PRATA));
        Batalha batalha = new Batalha (seiya, marin);
        batalha.iniciar();
        assertEquals(90.0, seiya.getVida(), 0.001);
        assertEquals(100.0, marin.getVida(), 0.001);
    }

    @Test
    public void iniciarVerificaEmpateDeCategoria () {
        Saint alderbaran = new Saint ("Alderbaran", new Armadura("Touro", Categoria.OURO));
        Saint mascaraMorte = new Saint ("Máscara da Morte", new Armadura("Câncer", Categoria.OURO));
        Batalha batalha = new Batalha (alderbaran, mascaraMorte);
        batalha.iniciar();
        assertEquals(90.0, mascaraMorte.getVida(), 0.001);
        assertEquals(100.0, alderbaran.getVida(), 0.001);
    }
    
    @Test
    public void categoriaSaint2MaiorQueSaint1 () {
        Saint ikki = new Saint ("Ikki", new Armadura("Fênix", Categoria.BRONZE));
        Saint mascaraMorte = new Saint ("Máscara da Morte", new Armadura("Câncer", Categoria.OURO));
        Batalha batalha = new Batalha (ikki, mascaraMorte);
        batalha.iniciar();
        assertEquals(100.0, mascaraMorte.getVida(), 0.001);
        assertEquals(90.0, ikki.getVida(), 0.001);
    }
    

}
