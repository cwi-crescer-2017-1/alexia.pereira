import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest {
    @Test
    public void vestirArmadura () throws Exception {
        // 1. Arrange 
        Saint shaina = new SilverSaint("Shaina", "Serpente");
        Movimento movimento = new VestirArmadura(shaina);
        // 2. Act 
        movimento.executar();       
        // 3. Assert 
        assertEquals(true, shaina.getArmaduraVestida());
    }

    @Test
    public void naoVestirArmadura () throws Exception {
        // 1. Arrange 
        Saint shaina = new SilverSaint("Shaina", "Serpente");
        Movimento movimento = new VestirArmadura(shaina);
        // 2. Act 
        //movimento.executar();       
        // 3. Assert 
        assertEquals(false, shaina.getArmaduraVestida());
    }

    @Test (expected = NullPointerException.class)
    public void vestirArmaduraComSaintNull () throws Exception {
        // 1. Arrange 
        Saint shaina = null;
        Movimento movimento = new VestirArmadura(shaina);
        // 2. Act 
        movimento.executar();       
        // 3. Assert 
      
    }

}
