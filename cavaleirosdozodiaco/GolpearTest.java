import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest {

    @Test
    public void executarGolpeadorDeOuroComArmaduraVestida () throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        saga.vestirArmadura();
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Golpear golpear = new Golpear (saga, seiya);
        golpear.executar();

        //Golpe posui originalmente 10 de dano, multiplicado por 3+1 = 40
        assertEquals(saga.getVida(), 100, 0.1);
        assertEquals(seiya.getVida(), 60, 0.1);
    }

    @Test
    public void executarGolpeadorDePrataComArmaduraVestida () throws Exception {
        Saint marin = new SilverSaint("Marin", "Águia");
        Golpe lampejoDaAguia = new Golpe("Lampejo da Águia", 20);
        marin.aprenderGolpe(lampejoDaAguia);
        marin.vestirArmadura();
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Golpear golpear = new Golpear (marin, seiya);
        golpear.executar();

        //Golpe posui originalmente 20 de dano, multiplicado por 2+1 = 60
        assertEquals(marin.getVida(), 100, 0.1);
        assertEquals(seiya.getVida(), 40, 0.1);
    }

    @Test
    public void executarGolpeadorDeBronzeComArmaduraVestida () throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Golpe coleraDoDragao = new Golpe("Cólera do Dragão", 5);
        shiryu.aprenderGolpe(coleraDoDragao);
        shiryu.vestirArmadura();
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Golpear golpear = new Golpear (shiryu, seiya);
        golpear.executar();

        //Golpe posui originalmente 5 de dano, multiplicado por 1+1 = 10
        assertEquals(shiryu.getVida(), 100, 0.1);
        assertEquals(seiya.getVida(), 90, 0.1);        
    }
    
    @Test
    public void executarGolpeadorDeOuroSemArmaduraVestida () throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10));
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Golpear golpear = new Golpear (saga, seiya);
        golpear.executar();

        //Golpe posui originalmente 10 de dano
        assertEquals(saga.getVida(), 100, 0.1);
        assertEquals(seiya.getVida(), 90, 0.1);
    }

    @Test
    public void executarGolpeadorDePrataSemArmaduraVestida () throws Exception {
        Saint marin = new SilverSaint("Marin", "Águia");
        Golpe lampejoDaAguia = new Golpe("Lampejo da Águia", 20);
        marin.aprenderGolpe(lampejoDaAguia);
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Golpear golpear = new Golpear (marin, seiya);
        golpear.executar();

        //Golpe posui originalmente 20 de dano
        assertEquals(marin.getVida(), 100, 0.1);
        assertEquals(seiya.getVida(), 80, 0.1);
    }

    @Test
    public void executarGolpeadorDeBronzeSemArmaduraVestida () throws Exception {
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        Golpe coleraDoDragao = new Golpe("Cólera do Dragão", 5);
        shiryu.aprenderGolpe(coleraDoDragao);
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Golpear golpear = new Golpear (shiryu, seiya);
        golpear.executar();

        //Golpe posui originalmente 5 de dano
        assertEquals(shiryu.getVida(), 100, 0.1);
        assertEquals(seiya.getVida(), 95, 0.1);        
    }
}
