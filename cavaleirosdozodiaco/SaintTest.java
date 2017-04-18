import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Armadura escorpiao = new Armadura((new Constelacao("Escorpião")), Categoria.OURO);
        Saint milo = new Saint("Milo", escorpiao);
        // 2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura((new Constelacao("Cisne")), Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Armadura virgem = new Armadura((new Constelacao("Virgem")), Categoria.OURO);
        Saint shaka = new Saint("Shaka", virgem);
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new Saint("Jabu", new Armadura((new Constelacao("Unicornio")), Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }

    @Test
    public void statusInicialDeveSerVivo() throws Exception {
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        assertEquals(Status.VIVO, shiryu.getStatus());
    }

    @Test
    public void vidaInicialDeveSer100() throws Exception {
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor10() throws Exception {
        // Arrange
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        // Act
        shiryu.perderVida(10);
        // Assert
        assertEquals(90, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor100() throws Exception {
        // Arrange
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        // Act
        shiryu.perderVida(100);
        // Assert
        assertEquals(0, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor1000() throws Exception {
        // Arrange
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        // Act
        shiryu.perderVida(1000);
        // Assert
        assertEquals(-900, shiryu.getVida(), 0.01);
    }

    @Test
    public void setStatusAlteraStatus () throws Exception {
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        shiryu.setStatus(Status.MORTO);
        assertEquals(Status.MORTO, shiryu.getStatus());
    }

    @Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", new Armadura((new Constelacao("Pégaso")), Categoria.BRONZE));
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        Saint marin = new SilverSaint("Marin", new Armadura((new Constelacao("Águia")), Categoria.PRATA));
        assertEquals(6, marin.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        Saint afrodite = new GoldSaint("Afrodite", new Armadura((new Constelacao("Peixes")), Categoria.OURO));
        assertEquals(7, afrodite.getQtdSentidosDespertados());
    }

    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", new Armadura((new Constelacao("Café")), Categoria.OURO));
    }    

    @Test
    public void saintPerdeVidaEMorre () throws Exception {
        Saint afrodite = new Saint("Afrodite", new Armadura((new Constelacao("Peixes")), Categoria.OURO));
        afrodite.perderVida(100);
        assertEquals(Status.MORTO, afrodite.getStatus());
    }

    @Test
    public void saintPerdeVidaENaoMorre () throws Exception {
        Saint afrodite = new Saint("Afrodite", new Armadura((new Constelacao("Peixes")), Categoria.OURO));
        afrodite.perderVida(99);
        assertEquals(Status.VIVO, afrodite.getStatus());
    }

    @Test(expected=InvalidParameterException.class)
    public void perderDanoComValorNegativoDeveLancarErro() throws Exception {
        // Arrange
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        // Act
        shiryu.perderVida(-1000);
        // Assert
        assertEquals(1100, shiryu.getVida(), 0.01);
    }

    @Test
    public void saintNaoPerdeVidaQuandoMorto () throws Exception {
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        shiryu.perderVida(100);
        shiryu.perderVida(100);
        assertEquals(0, shiryu.getVida(), 0.01);
    }

    @Test
    public void aprenderGolpeInsereGolpeNaConstelacao () throws Exception {
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        Golpe golpe = new Golpe ("Cólera do Dragão", 20);
        shiryu.aprenderGolpe(golpe);
        assertEquals(golpe, shiryu.getArmadura().getConstelacao().getGolpes()[0]);
        
    }

    @Test
    public void proximoGolpeRetornaOGolpeCerto () throws Exception {
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        Golpe golpe1 = new Golpe ("Cólera do Dragão", 20);
        shiryu.aprenderGolpe(golpe1);
        Golpe golpe2 = new Golpe ("Cólera2 do2 Dragão2", 30);
        shiryu.aprenderGolpe(golpe2);        
        Golpe golpe3 = new Golpe ("Cólera3 do3 Dragão3", 40);
        shiryu.aprenderGolpe(golpe3);        
        assertEquals(golpe1, shiryu.getProximoGolpe());
        assertEquals(golpe2, shiryu.getProximoGolpe());
        assertEquals(golpe3, shiryu.getProximoGolpe());
        assertEquals(golpe1, shiryu.getProximoGolpe());
    }

    
}

