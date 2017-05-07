import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GuerraEntreExercitosTest {

    @Test
    public void clientTest () throws Exception {
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        Saint aiolia = new GoldSaint("Aiolia", "Leão");
        aiolia.aprenderGolpe(new Golpe ("Teste", 20));
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        hyoga.aprenderGolpe(new Golpe ("Teste", 20));
        Saint marin = new SilverSaint("Marin", "Águia");
        marin.aprenderGolpe(new Golpe ("Teste", 20));
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        seiya.aprenderGolpe(new Golpe ("Teste", 20));
        Saint shura = new GoldSaint("Shura", "Capricórnio");
        shura.aprenderGolpe(new Golpe ("Teste", 20));
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe ("Teste", 20));
        

        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();

        Saint misty = new SilverSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe ("Teste", 20));
        Saint mdm = new GoldSaint("Máscara da Morte", "Câncer");
        mdm.aprenderGolpe(new Golpe ("Teste", 20));
        Saint ikki = new BronzeSaint("Ikki", "Fênix");
        ikki.aprenderGolpe(new Golpe ("Teste", 20));
        Saint saga = new GoldSaint("Saga", "Gêmeos");
        saga.aprenderGolpe(new Golpe ("Teste", 20));
        Saint algol= new SilverSaint("Algol", "Perseu");
        algol.aprenderGolpe(new Golpe ("Teste", 20));
        Saint afrodite = new GoldSaint("Afrodite", "Peixes");
        afrodite.aprenderGolpe(new Golpe ("Teste", 20));

        hyoga.adicionarMovimento(new Golpear (hyoga, ikki));
        ikki.adicionarMovimento(new Golpear (ikki, hyoga));
        
        seiya.adicionarMovimento(new Golpear (seiya, misty));
        misty.adicionarMovimento(new Golpear (misty, seiya));
        
        shiryu.adicionarMovimento(new Golpear (shiryu, mdm));
        mdm.adicionarMovimento(new Golpear (mdm, shiryu));
        
        marin.adicionarMovimento(new Golpear (marin, algol));
        algol.adicionarMovimento(new Golpear (algol, marin));
        
        aiolia.adicionarMovimento(new Golpear (aiolia, saga));
        saga.adicionarMovimento(new Golpear (saga, aiolia));
        
        shura.adicionarMovimento(new Golpear (shura, afrodite));
        afrodite.adicionarMovimento(new Golpear (afrodite, shura));
        
        
        defensoresDeAthena.alistar(aiolia);
        defensoresDeAthena.alistar(hyoga);
        defensoresDeAthena.alistar(marin);
        defensoresDeAthena.alistar(seiya);
        defensoresDeAthena.alistar(shura);
        defensoresDeAthena.alistar(shiryu);

        impostores.alistar(misty);
        impostores.alistar(mdm);
        impostores.alistar(ikki);
        impostores.alistar(saga);
        impostores.alistar(algol);
        impostores.alistar(afrodite);

        GuerraEntreExercitos guerra = new GuerraEntreExercitos(defensoresDeAthena, impostores);
        guerra.iniciar();

        assertTrue(defensoresDeAthena.todos().isEmpty());
        assertTrue(impostores.todos().isEmpty());

    }

}
