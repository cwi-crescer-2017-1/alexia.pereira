import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() {
 
         // AAA
         // 1. Arrange - Montagem dos dados de teste
         Armadura armadura = new Armadura("Aquário", Categoria.OURO);
         Saint saint = new Saint("Camus", armadura);
         // 2. Act - Invocar ação a ser testada
         saint.vestirArmadura();
         // 3. Assert - Verificação dos resultados do teste
         boolean resultado = saint.getArmaduraVestida();
         assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida () {
        Saint saint = new Saint ("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, saint.getArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado () {
        Saint saint = new Saint("Shaka", new Armadura ("Virgem", Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO, saint.getGenero());
    }
    
    @Test
    public void deveSerPossivelAlterarOGenero () {
        Saint saint = new Saint("Jabu", new Armadura ("Unicornio", Categoria.OURO));
        saint.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, saint.getGenero());        
    }
   
    @Test
    public void aoCriarSaintEleEVivo () {
        Saint saint = new Saint("Shaka", new Armadura ("Virgem", Categoria.OURO));
        assertEquals(Status.VIVO, saint.getStatus());
        
    }
    
    @Test
    public void aoCriarSaintEleTem100DeVida () {
        Saint saint = new Saint("Shaka", new Armadura ("Virgem", Categoria.OURO));
        assertEquals(100.0, saint.getVida(), 100.0);
        
    }
    
    @Test
    public void perderDanoComValor10() {
        Saint saint = new Saint("Shaka", new Armadura ("Virgem", Categoria.OURO));
        saint.perderVida(10.0);
        assertEquals(90.0, saint.getVida(), 0.001);    
    }
    
    
    @Test
    public void perderDanoComValor100() {
        Saint saint = new Saint("Shaka", new Armadura ("Virgem", Categoria.OURO));
        saint.perderVida(100.0);
        assertEquals(0.0, saint.getVida(), 0.001);    
    }
    
    
    @Test
    public void perderDanoComValor1000() {
        Saint saint = new Saint("Shaka", new Armadura ("Virgem", Categoria.OURO));
        saint.perderVida(1000.0);
        assertEquals(-900.0, saint.getVida(), 0.001);    
    }
    
    
    @Test
    public void perderDanoComValorMenos1000() {
        Saint saint = new Saint("Shaka", new Armadura ("Virgem", Categoria.OURO));
        saint.perderVida(-1000.0);
        assertEquals(1100.0, saint.getVida(), 0.001);    
    }
    
    
    
    
    
    
    
    
}
