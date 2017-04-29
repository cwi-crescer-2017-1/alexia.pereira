import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContraAtaqueTest {

    @Test
    public void saintPodeContraAtacarEEncerraAposIsso () throws Exception {
        Saint shiryu = new BronzeSaint("Shyriu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));

        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        seiya.aprenderGolpe(new Golpe("Meteoro de Pégaso", 10));
        seiya.perderVida(51);

        Movimento seiyaContraAtaca = new ContraAtaque(shiryu, seiya, new DadoFalso(2));
        Movimento golpearShiryuAtacaSeiya = new Golpear(shiryu, seiya);

        seiyaContraAtaca.executar();
        golpearShiryuAtacaSeiya.executar();

        assertEquals(75, shiryu.getVida(), 0.1);
        assertEquals(49, seiya.getVida(), 0.1);
    }

    @Test
    public void saintPodeContraAtacarERecebeGolpeAposIsso () throws Exception {
        Saint shiryu = new BronzeSaint("Shyriu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));

        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        seiya.aprenderGolpe(new Golpe("Meteoro de Pégaso", 10));
        seiya.perderVida(51);

        Movimento seiyaContraAtaca = new ContraAtaque(shiryu, seiya, new DadoFalso(2));
        Movimento golpearShiryuAtacaSeiya = new Golpear(shiryu, seiya);

        seiyaContraAtaca.executar();
        golpearShiryuAtacaSeiya.executar();
        golpearShiryuAtacaSeiya.executar();

        assertEquals(75, shiryu.getVida(), 0.1);
        assertEquals(39, seiya.getVida(), 0.1);
    }

    @Test
    public void saintPodeContraAtacarMasDadoNaoPermite () throws Exception {
        Saint shiryu = new BronzeSaint("Shyriu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));

        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        seiya.aprenderGolpe(new Golpe("Meteoro de Pégaso", 10));
        seiya.perderVida(51);

        Movimento seiyaContraAtaca = new ContraAtaque(shiryu, seiya, new DadoFalso(3));
        Movimento golpearShiryuAtacaSeiya = new Golpear(shiryu, seiya);

        seiyaContraAtaca.executar();
        golpearShiryuAtacaSeiya.executar();

        assertEquals(100, shiryu.getVida(), 0.1);
        assertEquals(39, seiya.getVida(), 0.1);
    }

    @Test
    public void saintNaoPodeContraAtacar () throws Exception {
        Saint shiryu = new BronzeSaint("Shyriu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));

        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        seiya.aprenderGolpe(new Golpe("Meteoro de Pégaso", 10));

        Movimento seiyaContraAtaca = new ContraAtaque(shiryu, seiya, new DadoFalso(3));
        Movimento golpearShiryuAtacaSeiya = new Golpear(shiryu, seiya);

        seiyaContraAtaca.executar();
        golpearShiryuAtacaSeiya.executar();

        assertEquals(100, shiryu.getVida(), 0.1);
        assertEquals(90, seiya.getVida(), 0.1);
    }

    @Test
    public void saintPodeContraAtacarEMataOponenteNoContraAtaque () throws Exception {
        Saint shiryu = new BronzeSaint("Shyriu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        shiryu.perderVida(98.68);

        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        seiya.aprenderGolpe(new Golpe("Meteoro de Pégaso", 10));
        seiya.perderVida(51);

        Movimento seiyaContraAtaca = new ContraAtaque(shiryu, seiya, new DadoFalso(4));
        Movimento golpearShiryuAtacaSeiya = new Golpear(shiryu, seiya);

        seiyaContraAtaca.executar();
        golpearShiryuAtacaSeiya.executar();

        assertEquals(Status.MORTO, shiryu.getStatus());
        assertEquals(49, seiya.getVida(), 0.1);
    }

}
