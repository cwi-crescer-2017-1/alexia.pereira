import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest {
    @Test
    public void adicionarGolpeAdicionaGolpe () {
        Constelacao constelacao = new Constelacao("Pégaso");
        Golpe golpe = new Golpe ("Meteoro de Pegaso", 100);
        constelacao.adicionarGolpe(golpe);
        assertEquals(golpe, constelacao.getGolpes()[0]);
    }
    
    
}
