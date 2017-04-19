import static org.junit.Assert.*; 
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test; 
import java.util.ArrayList; 

public class ListaSaintTest { 

    @Test 
    public void buscarSaintExistentePorNome () throws Exception { 
        ListaSaint lista = new ListaSaint(); 
        Saint marin = new SilverSaint("Marin", new Armadura((new Constelacao("Águia")), Categoria.PRATA)); 

        lista.adicionarSaint(marin); 

        assertEquals(marin, lista.buscarPorNome("Marin")); 

    } 

    @Test 
    public void buscarSaintInexistentePorNome () throws Exception { 
        ListaSaint lista = new ListaSaint(); 
        Saint marin = new SilverSaint("Marin", new Armadura((new Constelacao("Águia")), Categoria.PRATA)); 

        lista.adicionarSaint(marin); 

        assertNull(lista.buscarPorNome("Shiryu")); 

    } 

    @Test 
    public void buscarSaintExistenteComRepeticaoDeNomes () throws Exception { 
        ListaSaint lista = new ListaSaint(); 
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO)); 
        Saint saga2 = new Saint("Saga", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE)); 

        lista.adicionarSaint(saga); 
        lista.adicionarSaint(saga2); 

        assertEquals(saga, lista.buscarPorNome("Saga")); 

    } 

    @Test 
    public void buscarSaintPorNomeComListaVazia () throws Exception { 
        ListaSaint lista = new ListaSaint(); 

        assertNull(lista.buscarPorNome("Marin")); 

    }

    @Test
    public void buscarPorCategoriaListaVazia() {
        ListaSaint ListaSaint = new ListaSaint();
        ArrayList<Saint> resultadoBusca = ListaSaint.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaInexistente() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        ListaSaint.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = ListaSaint.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        ListaSaint.adicionarSaint(misty);
        ListaSaint.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = ListaSaint.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        ListaSaint.adicionarSaint(shun);
        ListaSaint.adicionarSaint(misty);
        ListaSaint.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = ListaSaint.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }

    @Test
    public void buscarPorStatusListaVazia() {
        ListaSaint ListaSaint = new ListaSaint();
        ArrayList<Saint> resultadoBusca = ListaSaint.buscarPorStatus(Status.VIVO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusInexistente() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        ListaSaint.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = ListaSaint.buscarPorStatus(Status.MORTO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test 
    public void getSaintMaiorVidaRetornaSaintComMaiorVida () throws Exception { 
        ListaSaint lista = new ListaSaint(); 
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO)); 
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE)); 
        shiryu.perderVida(10); 
        Saint afrodite = new Saint("Afrodite", new Armadura((new Constelacao("Peixes")), Categoria.OURO)); 
        afrodite.perderVida(30); 
        Saint marin = new SilverSaint("Marin", new Armadura((new Constelacao("Águia")), Categoria.PRATA)); 
        marin.perderVida(5); 

        lista.adicionarSaint(saga); 
        lista.adicionarSaint(shiryu); 
        lista.adicionarSaint(afrodite); 
        lista.adicionarSaint(marin); 

        assertEquals(saga, lista.getSaintMaiorVida()); 

    } 

    @Test 
    public void getSaintMenorVidaRetornaSaintComMenorVida () throws Exception { 
        ListaSaint lista = new ListaSaint(); 
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO)); 
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE)); 
        shiryu.perderVida(10); 
        Saint afrodite = new Saint("Afrodite", new Armadura((new Constelacao("Peixes")), Categoria.OURO)); 
        afrodite.perderVida(30); 
        Saint marin = new SilverSaint("Marin", new Armadura((new Constelacao("Águia")), Categoria.PRATA)); 
        marin.perderVida(5); 

        lista.adicionarSaint(saga); 
        lista.adicionarSaint(shiryu); 
        lista.adicionarSaint(afrodite); 
        lista.adicionarSaint(marin); 

        assertEquals(afrodite, lista.getSaintMenorVida()); 
    } 

    @Test 
    public void ordenarSegueAOrdemCorretamente () throws Exception { 
        ListaSaint lista = new ListaSaint(); 
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO)); 
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE)); 
        shiryu.perderVida(10); 
        Saint afrodite = new Saint("Afrodite", new Armadura((new Constelacao("Peixes")), Categoria.OURO)); 
        afrodite.perderVida(30); 
        Saint marin = new SilverSaint("Marin", new Armadura((new Constelacao("Águia")), Categoria.PRATA)); 
        marin.perderVida(5); 

        lista.adicionarSaint(saga); 
        lista.adicionarSaint(shiryu); 
        lista.adicionarSaint(afrodite); 
        lista.adicionarSaint(marin); 

        lista.ordenar(); 
        boolean verifica = false; 
        for (int i = 1; i < lista.getSize(); i++) { 
            if (lista.get(i).getVida() > lista.get(i-1).getVida()) { 
                verifica = true; 
            }  
        } 

        assertEquals(true, verifica); 

    } 
} 
