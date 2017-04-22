import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {

    @Test
    public void categoriaSaint1MaiorQueSaint2 () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pegaso");
        Saint marin = new SilverSaint ("Marin", "Águia");
        Batalha batalha = new Batalha (seiya, marin);
        batalha.iniciar();
        assertEquals(90.0, seiya.getVida(), 0.001);
        assertEquals(100.0, marin.getVida(), 0.001);
    }

    @Test
    public void iniciarVerificaEmpateDeCategoria ()  throws Exception {
        Saint alderbaran = new GoldSaint ("Alderbaran", "Touro");
        Saint mascaraMorte = new GoldSaint ("Máscara da Morte", "Câncer");
        Batalha batalha = new Batalha (alderbaran, mascaraMorte);
        batalha.iniciar();
        assertEquals(90.0, mascaraMorte.getVida(), 0.001);
        assertEquals(100.0, alderbaran.getVida(), 0.001);
    }
    
    @Test
    public void categoriaSaint2MaiorQueSaint1 () throws Exception {
        Saint ikki = new BronzeSaint ("Ikki", "Fênix");
        Saint mascaraMorte = new GoldSaint ("Máscara da Morte", "Câncer");
        Batalha batalha = new Batalha (ikki, mascaraMorte);
        batalha.iniciar();
        assertEquals(100.0, mascaraMorte.getVida(), 0.001);
        assertEquals(90.0, ikki.getVida(), 0.001);
    }
    

}
