import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class AtaqueDuploTest {

    @Test
    public void executarGolpeadorDeOuroComArmaduraVestidaPodendoDarDAtaqueDuplo () throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(outraDimensao);
        saga.aprenderGolpe(new Golpe ("Sei lá", 20));
        saga.vestirArmadura();
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Movimento ataqueDuplo = new AtaqueDuplo (saga, seiya, new DadoFalso(3));
        ataqueDuplo.executar();

        //Golpe posui originalmente 10 de dano, multiplicado por 3+1 = 40 * 2 = 80
        assertEquals(100, saga.getVida(), 0.1);
        assertEquals(20, seiya.getVida(), 0.1);
    }

    @Test
    public void executarGolpeadorDeOuroSemArmaduraVestidaPodendoDarDAtaqueDuplo () throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(outraDimensao);
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Movimento ataqueDuplo = new AtaqueDuplo (saga, seiya, new DadoFalso(6));
        ataqueDuplo.executar();
        //Golpe posui originalmente 10 de dano, multiplicado por 2 = 20
        assertEquals(100, saga.getVida(), 0.1);
        assertEquals(80, seiya.getVida(), 0.1);
    }

    @Test
    public void executarGolpeadorDeOuroComArmaduraVestidaNaoPodendoDarDAtaqueDuplo () throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(outraDimensao);
        saga.vestirArmadura();
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Movimento ataqueDuplo = new AtaqueDuplo (saga, seiya, new DadoFalso(4));
        ataqueDuplo.executar();

        //Golpe posui originalmente 10 de dano, multiplicado por 3+1 = 40
        assertEquals(95, saga.getVida(), 0.1);
        assertEquals(60, seiya.getVida(), 0.1);
    }

    // SilverSaint 

    @Test
    public void executarGolpeadorDePrataComArmaduraVestidaPodendoDarDAtaqueDuplo () throws Exception {
        Saint marin = new SilverSaint("Marin", "Prata");
        marin.aprenderGolpe(new Golpe("Lampejo de Águia", 10));
        marin.vestirArmadura();
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Movimento ataqueDuplo = new AtaqueDuplo (marin, seiya, new DadoFalso(3));
        ataqueDuplo.executar();

        //Golpe posui originalmente 10 de dano, multiplicado por 2+1 = 30 * 2 = 60
        assertEquals(100, marin.getVida(), 0.1);
        assertEquals(40, seiya.getVida(), 0.1);
    }

    @Test
    public void executarGolpeadorDePrataSemArmaduraVestidaPodendoDarDAtaqueDuplo () throws Exception {
        Saint marin = new SilverSaint("Marin", "Prata");
        marin.aprenderGolpe(new Golpe("Lampejo de Águia", 10));
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Movimento ataqueDuplo = new AtaqueDuplo (marin, seiya, new DadoFalso(6));
        ataqueDuplo.executar();

        //Golpe posui originalmente 10 de dano, multiplicado por 2 = 20
        assertEquals(100, marin.getVida(), 0.1);
        assertEquals(80, seiya.getVida(), 0.1);
    }

    @Test
    public void executarGolpeadorDePrataComArmaduraVestidaNaoPodendoDarDAtaqueDuplo () throws Exception {
        Saint marin = new SilverSaint("Marin", "Prata");
        marin.aprenderGolpe(new Golpe("Lampejo de Águia", 10));
        marin.vestirArmadura();
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Movimento ataqueDuplo = new AtaqueDuplo (marin, seiya, new DadoFalso(4));
        ataqueDuplo.executar();

        //Golpe posui originalmente 10 de dano, multiplicado por 2+1 = 30
        assertEquals(95, marin.getVida(), 0.1);
        assertEquals(70, seiya.getVida(), 0.1);
    }

    // BronzeSaint 

    @Test
    public void executarGolpeadorDeBronzeComArmaduraVestidaPodendoDarDAtaqueDuplo () throws Exception {
        Saint shiryu = new BronzeSaint("Shyriu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        shiryu.vestirArmadura();
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Movimento ataqueDuplo = new AtaqueDuplo (shiryu, seiya, new DadoFalso(3));
        ataqueDuplo.executar();

        //Golpe posui originalmente 10 de dano, multiplicado por 1+1 = 20 * 2 = 40
        assertEquals(100, shiryu.getVida(), 0.1);
        assertEquals(60, seiya.getVida(), 0.1);
    }

    @Test
    public void executarGolpeadorDeBronzeSemArmaduraVestidaPodendoDarDAtaqueDuplo () throws Exception {
        Saint shiryu = new BronzeSaint("Shyriu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Movimento ataqueDuplo = new AtaqueDuplo (shiryu, seiya, new DadoFalso(6));
        ataqueDuplo.executar();

        //Golpe posui originalmente 10 de dano, multiplicado por 2 = 20
        assertEquals(100, shiryu.getVida(), 0.1);
        assertEquals(80, seiya.getVida(), 0.1);
    }

    @Test
    public void executarGolpeadorDeBronzeComArmaduraVestidaNaoPodendoDarDAtaqueDuplo () throws Exception {
        Saint shiryu = new BronzeSaint("Shyriu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        shiryu.vestirArmadura();
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Movimento ataqueDuplo = new AtaqueDuplo (shiryu, seiya, new DadoFalso(4));
        ataqueDuplo.executar();

        //Golpe posui originalmente 10 de dano, multiplicado por 1+1 = 20
        assertEquals(95, shiryu.getVida(), 0.1);
        assertEquals(80, seiya.getVida(), 0.1);
    }
}
