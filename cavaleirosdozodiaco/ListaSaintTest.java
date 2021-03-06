import static org.junit.Assert.*; 
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test; 
import java.util.ArrayList; 

public class ListaSaintTest { 

    @Test 
    public void buscarSaintExistentePorNome () throws Exception { 
        ListaSaint lista = new ListaSaint(); 
        Saint marin = new SilverSaint("Marin", "Águia"); 

        lista.adicionarSaint(marin); 

        assertEquals(marin, lista.buscarPorNome("Marin")); 

    } 

    @Test 
    public void buscarSaintInexistentePorNome () throws Exception { 
        ListaSaint lista = new ListaSaint(); 
        Saint marin = new SilverSaint("Marin", "Águia"); 

        lista.adicionarSaint(marin); 

        assertNull(lista.buscarPorNome("Shiryu")); 

    } 

    @Test 
    public void buscarSaintExistenteComRepeticaoDeNomes () throws Exception { 
        ListaSaint lista = new ListaSaint(); 
        Saint saga = new GoldSaint("Saga", "Gêmeos"); 
        Saint saga2 = new BronzeSaint("Saga", "Dragão"); 

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
        Saint june = new BronzeSaint("June", "Camaleão");
        ListaSaint.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = ListaSaint.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorCategoriaExistente() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        ListaSaint.adicionarSaint(misty);
        ListaSaint.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = ListaSaint.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(june, resultadoBusca.get(0));
        assertEquals(1, resultadoBusca.size());
    }

    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
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
        Saint june = new BronzeSaint("June", "Camaleão");
        ListaSaint.adicionarSaint(june);
        ArrayList<Saint> resultadoBusca = ListaSaint.buscarPorStatus(Status.MORTO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void getSaintMaiorVidaComApenasUm() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        ListaSaint.adicionarSaint(june);
        assertEquals(june, ListaSaint.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComApenasTres() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
        ListaSaint.adicionarSaint(shun);
        ListaSaint.adicionarSaint(misty);
        ListaSaint.adicionarSaint(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(misty, ListaSaint.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComListaVazia() {
        ListaSaint ListaSaint = new ListaSaint();
        Saint maiorVida = ListaSaint.getSaintMaiorVida();
        assertNull(maiorVida);
    }

    @Test
    public void getSaintMenorVidaComApenasUm() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        ListaSaint.adicionarSaint(june);
        assertEquals(june, ListaSaint.getSaintMenorVida());
    }

    @Test
    public void getSaintMenorVidaComApenasTres() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
        ListaSaint.adicionarSaint(shun);
        ListaSaint.adicionarSaint(misty);
        ListaSaint.adicionarSaint(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(june, ListaSaint.getSaintMenorVida());
    }

    @Test
    public void getSaintMenorVidaComListaVazia() {
        ListaSaint ListaSaint = new ListaSaint();
        Saint menorVida = ListaSaint.getSaintMenorVida();
        assertNull(menorVida);
    }

    @Test
    public void ordenarComListaTotalmenteDesordenada() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        ListaSaint.adicionarSaint(shun);
        ListaSaint.adicionarSaint(misty);
        ListaSaint.adicionarSaint(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        ListaSaint.ordenar();
        ArrayList<Saint> resultado = ListaSaint.todos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }

    @Test
    public void ordenarComListaTotalmenteOrdenada() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        ListaSaint.adicionarSaint(shun);
        ListaSaint.adicionarSaint(misty);
        ListaSaint.adicionarSaint(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        ListaSaint.ordenar();
        ArrayList<Saint> resultado = ListaSaint.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarComListaVazia() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        ListaSaint.ordenar();
        ArrayList<Saint> resultado = ListaSaint.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarComListaApenasUm() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        ListaSaint.adicionarSaint(shun);
        shun.perderVida(30);
        ListaSaint.ordenar();
        ArrayList<Saint> resultado = ListaSaint.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarComListaDeValoresIguais() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        ListaSaint.adicionarSaint(shun);
        ListaSaint.adicionarSaint(misty);
        ListaSaint.adicionarSaint(june);
        ListaSaint.ordenar();
        ArrayList<Saint> resultado = ListaSaint.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarDescendenciaComListaTotalmenteDesordenada() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        ListaSaint.adicionarSaint(june);
        ListaSaint.adicionarSaint(misty);
        ListaSaint.adicionarSaint(shun);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        ListaSaint.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = ListaSaint.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void ordenarDescendenciaComListaTotalmenteOrdenada() throws Exception {
        ListaSaint listaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaint.adicionarSaint(june);
        listaSaint.adicionarSaint(misty);
        listaSaint.adicionarSaint(shun);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaint.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = listaSaint.todos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }

    @Test
    public void ordenarDescendenciaComListaVazia() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        ListaSaint.ordenar();
        ArrayList<Saint> resultado = ListaSaint.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarDescendenciaComListaApenasUm() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        ListaSaint.adicionarSaint(shun);
        shun.perderVida(30);
        ListaSaint.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = ListaSaint.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(1, resultado.size());
    }

    @Test
    public void ordenarDescendenciaComListaDeValoresIguais() throws Exception {
        ListaSaint ListaSaint = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        ListaSaint.adicionarSaint(shun);
        ListaSaint.adicionarSaint(misty);
        ListaSaint.adicionarSaint(june);
        ListaSaint.ordenar();
        ArrayList<Saint> resultado = ListaSaint.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test 
    public void getCSVComDoisSaints () throws Exception {
        ListaSaint lista = new ListaSaint();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionarSaint(june);

        Saint dohko = new GoldSaint("Dohko", "Libra");
        dohko.perderVida(90);
        dohko.vestirArmadura();
        lista.adicionarSaint(dohko);

        String real = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false"
            + System.lineSeparator()
            + "Dohko,10.0,Libra,OURO,VIVO,NAO_INFORMADO,true";
        String csv = lista.getCSV();
        assertEquals (real, csv);

    }

    //TODO: fazer outros cenários  
    @Test
    public void unirListasCom2ListasExistentes () throws Exception {
        ListaSaint lista = new ListaSaint();

        Saint june = new BronzeSaint("June", "Camaleão");
        Saint dohko = new GoldSaint("Dohko", "Libra");

        lista.adicionarSaint(june);
        lista.adicionarSaint(dohko);

        ArrayList<Saint> listaDois = new ArrayList<>();

        Saint shiryu = new BronzeSaint("Shiryu", "Shyriu");
        Saint marin = new SilverSaint("Marin", "Águia");

        listaDois.add(shiryu);
        listaDois.add(marin);

        ArrayList<Saint> listaRetorno = lista.unir(listaDois);

        assertEquals(lista.get(0), listaRetorno.get(0));
        assertEquals(lista.get(1), listaRetorno.get(1));        
        assertEquals(listaDois.get(0), listaRetorno.get(2));
        assertEquals(listaDois.get(1), listaRetorno.get(3));        
        assertEquals(listaRetorno.size(), listaDois.size()+lista.getSize());

    }
    //TODO: fazer outros cenários  
    @Test
    public void diferenciar2ListasComUmValorDeDiferença () throws Exception {
        ListaSaint lista = new ListaSaint();

        Saint shiryu = new BronzeSaint("Shiryu", "Shyriu");
        Saint dohko = new GoldSaint("Dohko", "Libra");

        lista.adicionarSaint(shiryu);
        lista.adicionarSaint(dohko);

        ArrayList<Saint> listaDois = new ArrayList<>();

        Saint marin = new SilverSaint("Marin", "Águia");

        listaDois.add(shiryu);
        listaDois.add(marin);

        ArrayList<Saint> listaRetorno = new ArrayList<>();
        listaRetorno = lista.diff(listaDois);

        assertEquals(listaRetorno.get(0), lista.get(1));
        assertEquals(listaRetorno.size(), 1);

    }

    //TODO: fazer outros cenários
    @Test
    public void intersecComUmSaint () throws Exception{
        ListaSaint lista = new ListaSaint();

        Saint shiryu = new BronzeSaint("Shiryu", "Shyriu");
        Saint dohko = new GoldSaint("Dohko", "Libra");

        lista.adicionarSaint(shiryu);
        lista.adicionarSaint(dohko);

        ArrayList<Saint> listaDois = new ArrayList<>();

        Saint marin = new SilverSaint("Marin", "Águia");

        listaDois.add(shiryu);
        listaDois.add(marin);

        ArrayList<Saint> listaRetorno = new ArrayList<>();
        listaRetorno = lista.intersec(listaDois);

        assertEquals(listaRetorno.get(0), lista.get(0));
        assertEquals(listaRetorno.size(), 1);
    }

} 

