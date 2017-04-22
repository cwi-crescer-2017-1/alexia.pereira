import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {

    @Test
    public void categoriaSaint1MaiorQueSaint2 () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", new Armadura((new Constelacao("Pegaso")), Categoria.BRONZE));
        Saint marin = new SilverSaint ("Marin", new Armadura((new Constelacao("Águia")), Categoria.PRATA));
        Batalha batalha = new Batalha (seiya, marin);
        batalha.iniciar();
        assertEquals(90.0, seiya.getVida(), 0.001);
        assertEquals(100.0, marin.getVida(), 0.001);
    }

    @Test
    public void iniciarVerificaEmpateDeCategoria ()  throws Exception {
        Saint alderbaran = new GoldSaint ("Alderbaran", new Armadura((new Constelacao("Touro")), Categoria.OURO));
        Saint mascaraMorte = new GoldSaint ("Máscara da Morte", new Armadura((new Constelacao("Câncer")), Categoria.OURO));
        Batalha batalha = new Batalha (alderbaran, mascaraMorte);
        batalha.iniciar();
        assertEquals(90.0, mascaraMorte.getVida(), 0.001);
        assertEquals(100.0, alderbaran.getVida(), 0.001);
    }
    
    @Test
    public void categoriaSaint2MaiorQueSaint1 () throws Exception {
        Saint ikki = new BronzeSaint ("Ikki", new Armadura((new Constelacao("Fênix")), Categoria.BRONZE));
        Saint mascaraMorte = new GoldSaint ("Máscara da Morte", new Armadura((new Constelacao("Câncer")), Categoria.OURO));
        Batalha batalha = new Batalha (ikki, mascaraMorte);
        batalha.iniciar();
        assertEquals(100.0, mascaraMorte.getVida(), 0.001);
        assertEquals(90.0, ikki.getVida(), 0.001);
    }
    

}
