import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintTest {

    @Test
    public void buscarPorNomeRetornaOSaintCorreto () throws Exception {
        ListaSaint lista = new ListaSaint();
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        Saint afrodite = new Saint("Afrodite", new Armadura((new Constelacao("Peixes")), Categoria.OURO));
        Saint marin = new SilverSaint("Marin", new Armadura((new Constelacao("Águia")), Categoria.PRATA));

        lista.adicionarSaint(saga);
        lista.adicionarSaint(shiryu);
        lista.adicionarSaint(afrodite);
        lista.adicionarSaint(marin);

        assertEquals(marin, lista.buscarPorNome("Marin"));

    }

    @Test
    public void buscarPorCategoriaRetornaTodosDaCategoriaOuro () throws Exception {
        ListaSaint lista = new ListaSaint();
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        Saint afrodite = new Saint("Afrodite", new Armadura((new Constelacao("Peixes")), Categoria.OURO));
        Saint marin = new SilverSaint("Marin", new Armadura((new Constelacao("Águia")), Categoria.PRATA));

        lista.adicionarSaint(saga);
        lista.adicionarSaint(shiryu);
        lista.adicionarSaint(afrodite);
        lista.adicionarSaint(marin);

        ArrayList<Saint> categorias = new ArrayList<Saint>();
        categorias = lista.buscarPorCategoria(Categoria.OURO);

        boolean verifica = false;
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getArmadura().getCategoria() != Categoria.OURO) {
                verifica = true;
            } 
        }

        assertEquals(verifica, false);       

    }

    @Test
    public void buscarPorStatusRetornaTodosDoStatusEscolhido () throws Exception{
        ListaSaint lista = new ListaSaint();
        Saint saga = new Saint("Saga", new Armadura(new Constelacao("Gêmeos"), Categoria.OURO));
        Saint shiryu = new Saint("Shiryu", new Armadura((new Constelacao("Dragão")), Categoria.BRONZE));
        Saint afrodite = new Saint("Afrodite", new Armadura((new Constelacao("Peixes")), Categoria.OURO));
        Saint marin = new SilverSaint("Marin", new Armadura((new Constelacao("Águia")), Categoria.PRATA));

        lista.adicionarSaint(saga);
        lista.adicionarSaint(shiryu);
        lista.adicionarSaint(afrodite);
        lista.adicionarSaint(marin);

        ArrayList<Saint> status = new ArrayList<Saint>();
        status = lista.buscarPorStatus(Status.VIVO);

        boolean verifica = false;
        for (int i = 0; i < status.size(); i++) {
            if (status.get(i).getStatus() != Status.VIVO) {
                verifica = true;
            } 
        }

        assertEquals(verifica, false);
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
