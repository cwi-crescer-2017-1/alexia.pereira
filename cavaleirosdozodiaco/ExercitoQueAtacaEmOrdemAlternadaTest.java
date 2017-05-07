import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ExercitoQueAtacaEmOrdemAlternadaTest {

    @Test
    public void adicionar3SaintsNoExercito () throws Exception {
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemAlternada();
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
        ExercitoDeSaints exercito = new ExercitoQueAtacaEmOrdemAlternada();
        exercito.alistar(new GoldSaint("Aiolia", "Leão"));
        exercito.alistar(new SilverSaint("Marin", "Águia"));
        exercito.alistar(new BronzeSaint("Hyoga", "Cisne"));
        exercito.alistar(new GoldSaint("Shura", "Capricórnio"));
        exercito.alistar(new SilverSaint("Misty", "Lagarto"));
        exercito.alistar(new BronzeSaint("Seiya", "Pégaso"));

        exercito.ordenar();
        ArrayList<Saint> resultado = exercito.todos();

        assertEquals(new BronzeSaint("Hyoga", "Cisne"), resultado.get(0));
        assertEquals(new SilverSaint("Marin", "Águia"), resultado.get(1));  
        assertEquals(new GoldSaint("Aiolia", "Leão"), resultado.get(2));
        assertEquals(new BronzeSaint("Seiya", "Pégaso"), resultado.get(3)); 
        assertEquals(new SilverSaint("Misty", "Lagarto"), resultado.get(4));
        assertEquals(new GoldSaint("Shura", "Capricórnio"), resultado.get(5));

    }

    @Test
    public void ordenarComExercitoTotalmenteOrdenado () throws Exception {
        ExercitoDeSaints exercito = new ExercitoQueAtacaEmOrdemAlternada();
        exercito.alistar(new BronzeSaint("Hyoga", "Cisne"));    
        exercito.alistar(new SilverSaint("Marin", "Águia"));
        exercito.alistar(new GoldSaint("Aiolia", "Leão"));
        exercito.alistar(new BronzeSaint("Seiya", "Pégaso"));
        exercito.alistar(new SilverSaint("Misty", "Lagarto"));
        exercito.alistar(new GoldSaint("Shura", "Capricórnio"));

        exercito.ordenar();
        ArrayList<Saint> resultado = exercito.todos();
        assertEquals(new BronzeSaint("Hyoga", "Cisne"), resultado.get(0));
        assertEquals(new SilverSaint("Marin", "Águia"), resultado.get(1));  
        assertEquals(new GoldSaint("Aiolia", "Leão"), resultado.get(2));
        assertEquals(new BronzeSaint("Seiya", "Pégaso"), resultado.get(3)); 
        assertEquals(new SilverSaint("Misty", "Lagarto"), resultado.get(4));
        assertEquals(new GoldSaint("Shura", "Capricórnio"), resultado.get(5));

    }

    @Test
    public void ordenarComFalhaNaOrdenacao () throws Exception {
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        impostores.alistar(new SilverSaint("Misty", "Lagarto"));
        impostores.alistar(new GoldSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new GoldSaint("Saga", "Gêmeos"));
        impostores.alistar(new SilverSaint("Algol", "Perseu"));
        impostores.alistar(new GoldSaint("Afrodite", "Peixes"));
        impostores.ordenar();
        
        ArrayList<Saint> resultado = impostores.todos();        
        assertEquals(new BronzeSaint("Ikki", "Fênix"), resultado.get(0));
        assertEquals(new SilverSaint("Misty", "Lagarto"), resultado.get(1));  
        assertEquals(new GoldSaint("Máscara da Morte", "Câncer"), resultado.get(2));
        assertEquals(new SilverSaint("Algol", "Perseu"), resultado.get(3)); 
        assertEquals(new GoldSaint("Saga", "Gêmeos"), resultado.get(4));
        assertEquals(new GoldSaint("Afrodite", "Peixes"), resultado.get(5));
        
        
    }

}
