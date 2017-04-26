import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SorteDoDiaTest {

    @Test
    public void estouComSorte () {
        SorteDoDia sorte = new SorteDoDia(new DadoFalso(4));
        assertEquals(true, sorte.estouComSorte());
    }
    
    @Test
    public void estouSemSorte () {
        SorteDoDia sorte = new SorteDoDia(new DadoFalso(1));
        assertEquals(false, sorte.estouComSorte());
    }

}
