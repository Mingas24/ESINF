/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nuno Capela
 */
public class MundoTest {

    public MundoTest() {
    }
    /**
     * Test of colorirGrafo method, of class Mundo.
     */
    @Test
    public void testColorirGrafo() throws IOException {
        System.out.println("colorirGrafo");
        Mundo instance = new Mundo();
        instance.construirGrafo();
        Pais[] vertices = instance.mainGraph.allkeyVerts();
        Arrays.sort(vertices, new Utilitarios.compararGrau());
        Map<Pais, String> expResult = new LinkedHashMap<>();
        expResult.put(instance.getPais("brasil"), "Azul");
        expResult.put(instance.getPais("alemanha"), "Azul");
        expResult.put(instance.getPais("russia"), "Azul");
        expResult.put(instance.getPais("servia"), "Azul");
        expResult.put(instance.getPais("austria"), "Preto");
        expResult.put(instance.getPais("polonia"), "Preto");
        expResult.put(instance.getPais("franca"), "Preto");
        expResult.put(instance.getPais("hungria"), "Branco");
        expResult.put(instance.getPais("ucrania"), "Rosa");
        expResult.put(instance.getPais("bielorussia"), "Branco");
        expResult.put(instance.getPais("suica"), "Branco");
        expResult.put(instance.getPais("peru"), "Preto");
        expResult.put(instance.getPais("romenia"), "Preto");
        expResult.put(instance.getPais("montenegro"), "Preto");
        expResult.put(instance.getPais("bolivia"), "Branco");
        expResult.put(instance.getPais("argentina"), "Preto");
        expResult.put(instance.getPais("croacia"), "Rosa");
        expResult.put(instance.getPais("macedonia"), "Preto");
        expResult.put(instance.getPais("bulgaria"), "Branco");
        expResult.put(instance.getPais("eslovaquia"), "Azul");
        expResult.put(instance.getPais("eslovenia"), "Azul");
        expResult.put(instance.getPais("turquia"), "Azul");
        expResult.put(instance.getPais("lituania"), "Rosa");
        expResult.put(instance.getPais("belgica"), "Branco");
        expResult.put(instance.getPais("italia"), "Rosa");
        expResult.put(instance.getPais("colombia"), "Branco");
        expResult.put(instance.getPais("letonia"), "Preto");
        expResult.put(instance.getPais("republicacheca"), "Branco");
        expResult.put(instance.getPais("grecia"), "Rosa");
        expResult.put(instance.getPais("kosovo"), "Branco");
        expResult.put(instance.getPais("albania"), "Azul");
        expResult.put(instance.getPais("paraguai"), "Rosa");
        expResult.put(instance.getPais("luxemburgo"), "Rosa");
        expResult.put(instance.getPais("georgia"), "Preto");
        expResult.put(instance.getPais("suriname"), "Preto");
        expResult.put(instance.getPais("venezuela"), "Preto");
        expResult.put(instance.getPais("bosnia"), "Branco");
        expResult.put(instance.getPais("finlandia"), "Preto");
        expResult.put(instance.getPais("noruega"), "Branco");
        expResult.put(instance.getPais("chile"), "Azul");
        expResult.put(instance.getPais("guiana"), "Branco");
        expResult.put(instance.getPais("guianafrancesa"), "Branco");
        expResult.put(instance.getPais("espanha"), "Azul");
        expResult.put(instance.getPais("holanda"), "Preto");
        expResult.put(instance.getPais("armenia"), "Branco");
        expResult.put(instance.getPais("moldavia"), "Azul");
        expResult.put(instance.getPais("liechtenstein"), "Azul");
        expResult.put(instance.getPais("uruguai"), "Branco");
        expResult.put(instance.getPais("suecia"), "Azul");
        expResult.put(instance.getPais("estonia"), "Branco");
        expResult.put(instance.getPais("equador"), "Azul");
        expResult.put(instance.getPais("reinounido"), "Azul");
        expResult.put(instance.getPais("dinamarca"), "Preto");
        expResult.put(instance.getPais("portugal"), "Preto");
        expResult.put(instance.getPais("irlanda"), "Preto");
        expResult.put(instance.getPais("monaco"), "Azul");
        expResult.put(instance.getPais("chipre"), "Azul");
        expResult.put(instance.getPais("malta"), "Azul");
        expResult.put(instance.getPais("islandia"), "Azul");
        
        Map<Pais, String> result = instance.colorirGrafo();
        System.out.println(result);
        
        System.out.println("------------------------------");
        
        System.out.println(expResult);
        assertEquals(expResult, result);

    }

    /**
     * Test of calcShortestPath method, of class Mundo.
     */
    @Test
    public void testCalcShortestPath() throws IOException {
        System.out.println("calcShortestPath");
        Mundo instance = new Mundo();
        instance.construirGrafo();

        double distancia;
        LinkedList<Pais> caminhoMaisCurto = new LinkedList<>();
        LinkedList<Pais> testeCaminhoMaisCurto = new LinkedList<>();

        assertTrue("Deve retornar -1 se país origem não existir", instance.calcShortestPath("nulo", "lisboa", caminhoMaisCurto) == -1);
        assertTrue("Deve retornar -1 se país destino não existir", instance.calcShortestPath("lisboa", "nulo", caminhoMaisCurto) == -1);
        assertTrue("Deve retornar -1 se os continentes forem diferentes", instance.calcShortestPath("brasilia", "lisboa", caminhoMaisCurto) == -1);

        // TESTE EUROPA CAMINHO CURTO
        distancia = instance.calcShortestPath("lisboa", "paris", caminhoMaisCurto);
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("lisboa"));
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("madrid"));
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("paris"));
        assertEquals(testeCaminhoMaisCurto, caminhoMaisCurto);
        assertEquals(1787.5, distancia, 1.0);
        caminhoMaisCurto.clear();
        testeCaminhoMaisCurto.clear();

        //TESTE EUROPA CAMINHO GRANDE
        distancia = instance.calcShortestPath("lisboa", "bucareste", caminhoMaisCurto);
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("lisboa"));
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("madrid"));
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("paris"));
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("berna"));
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("viena"));
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("budapeste"));
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("bucareste"));
        assertEquals(testeCaminhoMaisCurto, caminhoMaisCurto);
        assertEquals(4548.3, distancia, 1.0);
        caminhoMaisCurto.clear();
        testeCaminhoMaisCurto.clear();
        //TESTE AMERICA DO SUL
        distancia = instance.calcShortestPath("montevideu", "lima", caminhoMaisCurto);
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("montevideu"));
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("buenosaires"));
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("santiago"));
        testeCaminhoMaisCurto.add(instance.getPaisByCapital("lima"));
        assertEquals(testeCaminhoMaisCurto, caminhoMaisCurto);
        assertEquals(2569.4, distancia, 1.0);
        caminhoMaisCurto.clear();
        testeCaminhoMaisCurto.clear();
    }
    /**
     * Test of caminhoMaisCurtoPassandoPorOutrasCapitais method, of class Mundo.
     */
    @Test
    public void testCaminhoMaisCurtoPassandoPorOutrasCapitais() throws IOException {
        Mundo instance = new Mundo();
        instance.construirGrafo();
        LinkedList<String> capitaisObrigatorias = new LinkedList<>();
        LinkedList<String> caminhoMaisCurto ;
        LinkedList<String> testeCaminhoMaisCurto = new LinkedList<>();
        
        assertTrue("Deve retornar uma lista vazia se a capital não existir", instance.caminhoMaisCurtoPassandoPorOutrasCapitais("nulo","lisboa" , capitaisObrigatorias).isEmpty());
        assertTrue("Deve retornar uma lista vazia se a capital não existir", instance.caminhoMaisCurtoPassandoPorOutrasCapitais("lisboa","nulo" , capitaisObrigatorias).isEmpty());
        assertTrue("Deve retornar uma lista vazia se as capitais forem de continentes diferentes", instance.caminhoMaisCurtoPassandoPorOutrasCapitais("lima","lisboa" , capitaisObrigatorias).isEmpty());
        
        capitaisObrigatorias.add("nulo");
        assertTrue("Deve retornar uma lista vazia se uma das capitais obrigatorias nao existir", instance.caminhoMaisCurtoPassandoPorOutrasCapitais("kiev","lisboa" , capitaisObrigatorias).isEmpty());

        capitaisObrigatorias.clear();
        
        //caminho mais curto na Europa
        capitaisObrigatorias.add("roma");
        capitaisObrigatorias.add("atenas");
        
        caminhoMaisCurto = instance.caminhoMaisCurtoPassandoPorOutrasCapitais("lisboa", "bucareste", capitaisObrigatorias);
        testeCaminhoMaisCurto.add("lisboa");
        testeCaminhoMaisCurto.add("madrid");
        testeCaminhoMaisCurto.add("paris");
        testeCaminhoMaisCurto.add("roma");
        testeCaminhoMaisCurto.add("liubliana");
        testeCaminhoMaisCurto.add("zagreb");
        testeCaminhoMaisCurto.add("podgorica");
        testeCaminhoMaisCurto.add("tirana");
        testeCaminhoMaisCurto.add("atenas");
        testeCaminhoMaisCurto.add("sofia");
        testeCaminhoMaisCurto.add("bucareste");  
        assertEquals(testeCaminhoMaisCurto,caminhoMaisCurto);
        
        capitaisObrigatorias.clear();
        testeCaminhoMaisCurto.clear();
        
        //america do sul
        capitaisObrigatorias.add("brasilia");
        
        caminhoMaisCurto = instance.caminhoMaisCurtoPassandoPorOutrasCapitais("montevideu", "lima", capitaisObrigatorias);
        testeCaminhoMaisCurto.add("montevideu");
        testeCaminhoMaisCurto.add("brasilia");
        testeCaminhoMaisCurto.add("lima"); 
        assertEquals(testeCaminhoMaisCurto,caminhoMaisCurto);
    }

    /**
     * Test of calcularCircuito method, of class Mundo.
     */
    @Test
    public void testeCalcularCircuito() throws IOException {
        Mundo instance=new Mundo();
        instance.construirGrafo();
        List <Pais> maiorCircuito;
        List <Pais> testeCalcularCircuito=new LinkedList<>();
        
        assertTrue("Deve retornar uma lista vazia se pais origem não existir",instance.calcularCircuito("nulo").isEmpty());
        
        //Maior circuito na europa
        maiorCircuito = instance.calcularCircuito("lisboa");
        testeCalcularCircuito.add(instance.getPaisByCapital("lisboa"));
        testeCalcularCircuito.add(instance.getPaisByCapital("madrid"));
        testeCalcularCircuito.add(instance.getPaisByCapital("paris"));
        testeCalcularCircuito.add(instance.getPaisByCapital("bruxelas"));
        testeCalcularCircuito.add(instance.getPaisByCapital("amsterdam"));
        testeCalcularCircuito.add(instance.getPaisByCapital("berlim"));
        testeCalcularCircuito.add(instance.getPaisByCapital("praga"));
        testeCalcularCircuito.add(instance.getPaisByCapital("viena"));
        testeCalcularCircuito.add(instance.getPaisByCapital("bratislava"));
        testeCalcularCircuito.add(instance.getPaisByCapital("budapeste"));
        testeCalcularCircuito.add(instance.getPaisByCapital("belgrado"));
        testeCalcularCircuito.add(instance.getPaisByCapital("pristina"));
        testeCalcularCircuito.add(instance.getPaisByCapital("escopia"));
        testeCalcularCircuito.add(instance.getPaisByCapital("tirana"));
        testeCalcularCircuito.add(instance.getPaisByCapital("podgorica"));
        testeCalcularCircuito.add(instance.getPaisByCapital("sarajevo"));
        testeCalcularCircuito.add(instance.getPaisByCapital("zagreb"));
        testeCalcularCircuito.add(instance.getPaisByCapital("liubliana"));
        testeCalcularCircuito.add(instance.getPaisByCapital("roma"));
        testeCalcularCircuito.add(instance.getPaisByCapital("berna"));
        testeCalcularCircuito.add(instance.getPaisByCapital("vaduz"));
        
        assertEquals(testeCalcularCircuito, maiorCircuito);
        
        
    }

}