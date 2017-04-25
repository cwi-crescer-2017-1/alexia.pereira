import java.security.InvalidParameterException;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {

    @After
    public void tearDown () {
        System.gc();
    }

    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Saint milo = new GoldSaint("Milo", "Escorpião");
        // 2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        assertEquals(false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new BronzeSaint("Jabu", "Unicornio");
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }

    @Test
    public void statusInicialDeveSerVivo() throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        assertEquals(Status.VIVO, shiryu.getStatus());
    }

    @Test
    public void vidaInicialDeveSer100() throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor10() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        // Act
        shiryu.perderVida(10);
        // Assert
        assertEquals(90, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor100() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        // Act
        shiryu.perderVida(100);
        // Assert
        assertEquals(0, shiryu.getVida(), 0.01);
    }

    @Test
    public void perderDanoComValor1000() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        // Act
        shiryu.perderVida(1000);
        // Assert
        assertEquals(0, shiryu.getVida(), 0.01);
    }

    @Test
    public void setStatusAlteraStatus () throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.setStatus(Status.MORTO);
        assertEquals(Status.MORTO, shiryu.getStatus());
    }

    @Test
    public void criarSaintNasceCom5SentidosDespertados() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        Saint marin = new SilverSaint("Marin", "Águia");
        assertEquals(6, marin.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        Saint afrodite = new GoldSaint("Afrodite", "Peixes");
        assertEquals(7, afrodite.getQtdSentidosDespertados());
    }

    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Bernardo", "Café");
    }    

    @Test
    public void saintPerdeVidaEMorre () throws Exception {
        Saint afrodite = new GoldSaint("Afrodite", "Peixes");
        afrodite.perderVida(100);
        assertEquals(Status.MORTO, afrodite.getStatus());
    }

    @Test
    public void saintPerdeVidaENaoMorre () throws Exception {
        Saint afrodite = new GoldSaint("Afrodite", "Peixes");
        afrodite.perderVida(99);
        assertEquals(Status.VIVO, afrodite.getStatus());
    }

    @Test(expected=InvalidParameterException.class)
    public void perderDanoComValorNegativoDeveLancarErro() throws Exception {
        // Arrange
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        // Act
        shiryu.perderVida(-1000);
        // Assert
        assertEquals(1100, shiryu.getVida(), 0.01);
    }

    @Test
    public void saintNaoPerdeVidaQuandoMorto () throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.perderVida(100);
        shiryu.perderVida(100);
        assertEquals(0, shiryu.getVida(), 0.01);
    }

    @Test
    public void aprenderUmGolpe () throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Golpe golpe = new Golpe ("Cólera do Dragão", 20);
        shiryu.aprenderGolpe(golpe);
        assertEquals(golpe, shiryu.getArmadura().getConstelacao().getGolpes().get(0));
        assertEquals(1, shiryu.getArmadura().getConstelacao().getGolpes().size());
    }

    @Test
    public void aprenderDoisGolpes () throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Golpe golpe = new Golpe ("Cólera do Dragão", 20);
        shiryu.aprenderGolpe(golpe);
        assertEquals(golpe, shiryu.getArmadura().getConstelacao().getGolpes().get(0));

        Golpe cafe = new Golpe ("Café", 2);
        shiryu.aprenderGolpe(cafe);

        assertEquals(cafe, shiryu.getArmadura().getConstelacao().getGolpes().get(1));
        assertEquals(2, shiryu.getArmadura().getConstelacao().getGolpes().size());
    }

    @Test
    public void aprenderTresGolpes () throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Golpe golpe1 = new Golpe ("Meteoro de Pegaso", 100);
        shiryu.aprenderGolpe(golpe1);
        assertEquals(golpe1, shiryu.getArmadura().getConstelacao().getGolpes().get(0));
        Golpe golpe2 = new Golpe ("Metéoro 2", 80);
        shiryu.aprenderGolpe(new Golpe ("Metéoro 2", 80));
        assertEquals(golpe2, shiryu.getArmadura().getConstelacao().getGolpes().get(1));
        Golpe golpe3 = new Golpe ("Metéoro 3", 30);
        shiryu.aprenderGolpe(new Golpe ("Metéoro 3", 30));
        assertEquals(golpe3, shiryu.getArmadura().getConstelacao().getGolpes().get(2));
        assertEquals(3, shiryu.getArmadura().getConstelacao().getGolpes().size());
    }

    @Test
    public void getProximoGolpeComUm() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComDois() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComTres() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
    }

    @Test
    public void getProximoGolpeComQuatroChamadas() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galáctica", 11);
        Golpe sataImperial = new Golpe("Satã Imperial", 42);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(explosaoGalatica);
        saga.aprenderGolpe(sataImperial);
        assertEquals(outraDimensao, saga.getProximoGolpe());
        assertEquals(explosaoGalatica, saga.getProximoGolpe());
        assertEquals(sataImperial, saga.getProximoGolpe());
        assertEquals(outraDimensao, saga.getProximoGolpe());
    }

    @Test
    public void getCSVComArmaduraVestida () throws Exception {
        ListaSaint lista = new ListaSaint();
        Saint dohko = new GoldSaint("Dohko", "Libra");
        dohko.perderVida(90);
        dohko.vestirArmadura();
        lista.adicionarSaint(dohko);
        String esperado = "Dohko,10.0,Libra,OURO,VIVO,NAO_INFORMADO,true";
        assertEquals(esperado, dohko.getCSV());

    }

    public void getCSVSemArmaduraVestida () throws Exception {
        ListaSaint lista = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionarSaint(june);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, june.getCSV());

    }

    @Test (expected = ArithmeticException.class)
    public void getProximoMovimentoComListaVazia () throws Exception {
        Saint seiya = new BronzeSaint ("Seiya", "Pégaso");
        Movimento movimento = seiya.getProximoMovimento();
    }

    @Test
    public void getProximoMovimentoComUm() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Movimento vestir = new VestirArmadura(saga);
        saga.adicionarMovimento(vestir);
        assertEquals(vestir, saga.getProximoMovimento());
    }

    @Test
    public void getProximoMovimentoComDois() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Movimento vestir = new VestirArmadura(saga);
        Golpear golpear = new Golpear (saga, new BronzeSaint("Seya", "Pégaso"));
        saga.adicionarMovimento(vestir);
        saga.adicionarMovimento(golpear);
        assertEquals(vestir, saga.getProximoMovimento());
        assertEquals(golpear, saga.getProximoMovimento());
        assertEquals(vestir, saga.getProximoMovimento());
    }

    @Test
    public void criarUmSaintPopulacaoDeveSerUm () throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        int quantidadeAtual = Saint.getQtdSaints();
        assertEquals(1, quantidadeAtual);
    }

    @Test
    public void criarDoisSaintPopulacaoDeveSerMaisDois () throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint marin = new SilverSaint("Marin", "Águia");
        int quantidadeAtual = Saint.getQtdSaints();
        assertEquals(2, quantidadeAtual);
    }  

    @Test
    public void criarTresSaintsPopulacaoDeveSerMaisTres () throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint marin = new SilverSaint("Marin", "Águia");
        Saint camus = new GoldSaint ("Camus", "Aquário");
        int quantidadeAtual = Saint.getQtdSaints();
        assertEquals(3, quantidadeAtual);
    }

    @Test
    public void criarDuzentosSaintsQtdSaintsDeveTerDuzentosAMais() throws Exception {
        final int quantidade = 200;
        for (int i = 0; i < quantidade; i++) {
            new BronzeSaint("Bronze " + i, "Constelação " + i);
        }
        assertEquals(quantidade, Saint.getQtdSaints());
    }

    @Test
    public void idUnicoIncrementaUnitariamente () throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint marin = new SilverSaint("Marin", "Águia");
        Saint camus = new GoldSaint ("Camus", "Aquário");
        assertEquals (seiya.getId(), marin.getId()-1);
        assertEquals (seiya.getId(), camus.getId()-2);
    }

}
