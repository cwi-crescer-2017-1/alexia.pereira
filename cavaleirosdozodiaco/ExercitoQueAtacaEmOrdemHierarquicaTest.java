import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ExercitoQueAtacaEmOrdemHierarquicaTest {

    @Test
    public void adicionar3SaintsNoExercito () throws Exception {
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        defensoresDeAthena.alistar(new GoldSaint("Aiolia", "Leão"));
        defensoresDeAthena.alistar(new BronzeSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new BronzeSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new GoldSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new BronzeSaint("Shiryu", "Dragão"));

        int tamanhoExercito = defensoresDeAthena.todos().size();
        assertEquals(6, tamanhoExercito);

    }

    @Test
    public void ordenarComExercitoTotalmenteDesordenado () throws Exception {
        ExercitoDeSaints exercito = new ExercitoQueAtacaEmOrdemHierarquica();
        exercito.alistar(new GoldSaint("Aiolia", "Leão"));
        exercito.alistar(new SilverSaint("Marin", "Águia"));
        exercito.alistar(new BronzeSaint("Hyoga", "Cisne"));
        exercito.alistar(new GoldSaint("Shura", "Capricórnio"));
        exercito.alistar(new SilverSaint("Misty", "Lagarto"));
        exercito.alistar(new BronzeSaint("Seiya", "Pégaso"));
        exercito.ordenar();
        ArrayList<Saint> resultado = exercito.todos();
        assertEquals(new BronzeSaint("Hyoga", "Cisne"), resultado.get(0));
        assertEquals(new BronzeSaint("Seiya", "Pégaso"), resultado.get(1));	
        assertEquals(new SilverSaint("Marin", "Águia"), resultado.get(2));	
        assertEquals(new SilverSaint("Misty", "Lagarto"), resultado.get(3));
        assertEquals(new GoldSaint("Aiolia", "Leão"), resultado.get(4));
        assertEquals(new GoldSaint("Shura", "Capricórnio"), resultado.get(5));

    }

    @Test
    public void ordenarComExercitoTotalmenteOrdenado () throws Exception {
        ExercitoDeSaints exercito = new ExercitoQueAtacaEmOrdemHierarquica();
        exercito.alistar(new BronzeSaint("Hyoga", "Cisne"));
        exercito.alistar(new BronzeSaint("Seiya", "Pégaso"));
        exercito.alistar(new SilverSaint("Marin", "Águia"));
        exercito.alistar(new SilverSaint("Misty", "Lagarto"));
        exercito.alistar(new GoldSaint("Aiolia", "Leão"));
        exercito.alistar(new GoldSaint("Shura", "Capricórnio"));

        exercito.ordenar();
        ArrayList<Saint> resultado = exercito.todos();
        assertEquals(new BronzeSaint("Hyoga", "Cisne"), resultado.get(0));
        assertEquals(new BronzeSaint("Seiya", "Pégaso"), resultado.get(1));	
        assertEquals(new SilverSaint("Marin", "Águia"), resultado.get(2));	
        assertEquals(new SilverSaint("Misty", "Lagarto"), resultado.get(3));
        assertEquals(new GoldSaint("Aiolia", "Leão"), resultado.get(4));
        assertEquals(new GoldSaint("Shura", "Capricórnio"), resultado.get(5));

    }

}
