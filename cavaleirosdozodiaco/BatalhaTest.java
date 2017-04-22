import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {

    @Test
    public void categoriaSaint1MaiorQueSaint2 () throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe explosao = new Golpe ("Explosão Galáctica", 10);
        saga.aprenderGolpe(explosao);
        Movimento vestirSaga = new VestirArmadura(saga);
        saga.adicionarMovimento(vestirSaga);

        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Golpe meteoro = new Golpe ("Meteoro de Pégaso", 20);
        seiya.aprenderGolpe(meteoro);
        Movimento vestirSeiya = new VestirArmadura(seiya);
        seiya.adicionarMovimento(vestirSeiya);

        Golpear golpearSagaGolpeador = new Golpear (saga, seiya);
        saga.adicionarMovimento(golpearSagaGolpeador);

        Golpear golpearSeiyaGolpeador = new Golpear (seiya, saga);
        seiya.adicionarMovimento(golpearSeiyaGolpeador);

        Batalha batalha = new Batalha (saga, seiya);
        batalha.iniciar();

        assertEquals(seiya.getStatus(), Status.MORTO);
        assertEquals(saga.getStatus(), Status.VIVO);
    }

    @Test
    public void iniciarVerificaEmpateDeCategoria ()  throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Golpe colera = new Golpe ("Cólera do Dragão", 20);
        shiryu.aprenderGolpe(colera);
        Movimento vestirShiryu = new VestirArmadura(shiryu);
        shiryu.adicionarMovimento(vestirShiryu);

        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Golpe meteoro = new Golpe ("Meteoro de Pégaso", 20);
        seiya.aprenderGolpe(meteoro);
        Movimento vestirSeiya = new VestirArmadura(seiya);
        seiya.adicionarMovimento(vestirSeiya);

        Golpear golpearSagaGolpeador = new Golpear (shiryu, seiya);
        shiryu.adicionarMovimento(golpearSagaGolpeador);

        Golpear golpearSeiyaGolpeador = new Golpear (seiya, shiryu);
        seiya.adicionarMovimento(golpearSeiyaGolpeador);

        Batalha batalha = new Batalha (shiryu, seiya);
        batalha.iniciar();

        assertEquals(seiya.getStatus(), Status.MORTO);
        assertEquals(shiryu.getStatus(), Status.VIVO);
    }

    @Test
    public void categoriaSaint2MaiorQueSaint1 () throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe explosao = new Golpe ("Explosão Galáctica", 10);
        saga.aprenderGolpe(explosao);
        Movimento vestirSaga = new VestirArmadura(saga);
        saga.adicionarMovimento(vestirSaga);

        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Golpe meteoro = new Golpe ("Meteoro de Pégaso", 20);
        seiya.aprenderGolpe(meteoro);
        Movimento vestirSeiya = new VestirArmadura(seiya);
        seiya.adicionarMovimento(vestirSeiya);

        Golpear golpearSagaGolpeador = new Golpear (saga, seiya);
        saga.adicionarMovimento(golpearSagaGolpeador);

        Golpear golpearSeiyaGolpeador = new Golpear (seiya, saga);
        seiya.adicionarMovimento(golpearSeiyaGolpeador);

        Batalha batalha = new Batalha (seiya, saga);
        batalha.iniciar();

        assertEquals(seiya.getStatus(), Status.MORTO);
        assertEquals(saga.getStatus(), Status.VIVO);

    }

}
