import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest {
    @Test
    public void adicionarUmGolpe () {
        Constelacao constelacao = new Constelacao("Pégaso");
        Golpe golpe = new Golpe ("Meteoro de Pegaso", 100);
        constelacao.adicionarGolpe(new Golpe ("Meteoro de Pegaso", 100));
        assertEquals(golpe, constelacao.getGolpes().get(0));
        assertEquals(1, constelacao.getGolpes().size());

    }

    @Test
    public void adicionarDoisGolpes () {
        Constelacao constelacao = new Constelacao("Pégaso");
        Golpe golpe1 = new Golpe ("Meteoro de Pegaso", 100);
        constelacao.adicionarGolpe(golpe1);
        assertEquals(golpe1, constelacao.getGolpes().get(0));
        Golpe golpe2 = new Golpe ("Metéoro 2", 80);
        constelacao.adicionarGolpe(new Golpe ("Metéoro 2", 80));
        assertEquals(golpe2, constelacao.getGolpes().get(1));
        assertEquals(2, constelacao.getGolpes().size());
    }

    @Test
    public void adicionarTresGolpes () {
        Constelacao constelacao = new Constelacao("Pégaso");
        Golpe golpe1 = new Golpe ("Meteoro de Pegaso", 100);
        constelacao.adicionarGolpe(golpe1);
        assertEquals(golpe1, constelacao.getGolpes().get(0));
        Golpe golpe2 = new Golpe ("Metéoro 2", 80);
        constelacao.adicionarGolpe(new Golpe ("Metéoro 2", 80));
        assertEquals(golpe2, constelacao.getGolpes().get(1));
        Golpe golpe3 = new Golpe ("Metéoro 3", 30);
        constelacao.adicionarGolpe(new Golpe ("Metéoro 3", 30));
        assertEquals(golpe3, constelacao.getGolpes().get(2));
        assertEquals(3, constelacao.getGolpes().size());
    }

}
