/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.esinf_1proj;

import static com.mycompany.esinf_1proj.Mundo.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nuno Capela
 */
public class MundoTest {

    private Mundo instance2;
    private List<String> lst;

    public MundoTest() throws IOException {
        instance2 = new Mundo();
        lerPais(instance2.getMap());
        lerFronteira(instance2.getMap());
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMap method, of class Mundo.
     * @throws java.io.IOException
     */
    @Test
    public void testGetMap() throws IOException {
        System.out.println("getMap");
        Mundo instance = new Mundo();
        Map<Pais, Set<Pais>> expResult = instance2.getMap();
        Map<Pais, Set<Pais>> result = instance.getMap();
        assertEquals(expResult, result);
    }

    /**
     * Test of procurarPais method, of class Mundo.
     */
    @Test
    public void testProcurarPais() {
        System.out.println("procurarPais");
        Map<Pais, Set<Pais>> m = new TreeMap<>();
        String nomePais = "";
        Pais expResult = null;
        Pais result = Mundo.procurarPais(m, nomePais);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNPopulation method, of class Mundo.
     * @throws java.io.IOException
     */
    @Test
    public void testGetNPopulation() throws IOException {

        Set<Pais> s = new TreeSet<>();
        s.add(new Pais("russia", "europa", 146.5, "moscovo", 55.755786, 37.617633));
        s.add(new Pais("alemanha", "europa", 82.8, "berlim", 52.5234051, 13.4113999));

        Set<Pais> result = instance2.getNPopulation(instance2.getMap(), 80.0, "europa");

        assertEquals(s, result);

    }

    /**
     * Test of sortFronteiras method, of class Mundo.
     * @throws java.io.IOException
     */
    @Test
    public void testSortFronteiras() throws IOException {
        System.out.println("sortFronteiras");
        String continente = "americasul";
        Mundo instance = new Mundo();

        Map<Integer, Set<Pais>> expResult = new TreeMap<>();

        //10 países
        Set<Pais> setTest10 = new TreeSet<>();
        setTest10.add(new Pais("brasil", "americasul", 206.12, "brasilia", -15.7797200, -47.9297200));
        expResult.put(10, setTest10);

        //5 países
        Set<Pais> setTest5 = new TreeSet<>();
        setTest5.add(new Pais("argentina", "americasul", 41.67, "buenosaires", -34.6131500, -58.3772300));
        setTest5.add(new Pais("bolivia", "americasul", 9.70f, "lapaz", -16.5000000, -68.1500000));
        setTest5.add(new Pais("peru", "americasul", 28.22f, "lima", -12.0431800, -77.0282400));
        expResult.put(5, setTest5);

        //4 países
        Set<Pais> setTest4 = new TreeSet<>();
        setTest4.add(new Pais("colombia", "americasul", 46.86f, "bogota", 4.6097100, -74.0817500));
        expResult.put(4, setTest4);

        //3 países
        Set<Pais> setTest3 = new TreeSet<>();
        setTest3.add(new Pais("chile", "americasul", 16.80, "santiago", -33.4569400, -70.6482700));
        setTest3.add(new Pais("guiana", "americasul", 0.07, "georgetwon", 6.8044800, -58.1552700));
        setTest3.add(new Pais("paraguai", "americasul", 6.24, "assuncao", -25.3006600, -57.6359100));
        setTest3.add(new Pais("suriname", "americasul", 0.04, "paramaribo", 5.8663800, -55.1668200));
        setTest3.add(new Pais("venezuela", "americasul", 31.02, "caracas", 10.4880100, -66.8791900));
        expResult.put(3, setTest3);

        //2 países
        Set<Pais> setTest2 = new TreeSet<>();
        setTest2.add(new Pais("equador", "americasul", 14.88, "quito", -0.2298500, -78.5249500));
        setTest2.add(new Pais("guianafrancesa", "americasul", 2.88, "caiena", 4.9333300, -52.3333300));
        setTest2.add(new Pais("uruguai", "americasul", 3.35, "montevideu", -34.9032800, -56.1881600));
        expResult.put(2, setTest2);

        Map<Integer, Set<Pais>> result = instance.sortFronteiras(continente);
        assertEquals(expResult, result);

    }

    /**
     * Test of procurarNumFront method, of class Mundo.
     * @throws java.io.IOException
     */
    @Test
    public void testProcurarNumFront() throws IOException {
        System.out.println("procurarNumFront");
        Set<Integer> si = new TreeSet<>();
        int n = 0;
        Mundo instance = new Mundo();
        int expResult = instance2.procurarNumFront(si, n);
        int result = instance.procurarNumFront(si, n);
        assertEquals(expResult, result);

    }   
    
    /**
     * Test of minFront method, of class Fronteiras.
     * @throws java.io.IOException
     */
    @Test
    public void testMinFront() throws IOException {
      
        List<String> lp = Files.lines(Paths.get("paises.txt")).collect(Collectors.toList());
        List<String> lf = Files.lines(Paths.get("fronteiras.txt")).collect(Collectors.toList());
        instance2.lerPais(instance2.getMap());
        instance2.lerFronteira(instance2.getMap());
        
        System.out.println("Portugal <-> Alemanha");
        Integer expResult = 3;
        Integer result = instance2.minFront(instance2.getPais("portugal"), instance2.getPais("alemanha"));
        assertEquals(expResult, result);

        System.out.println("Portugal <-> Portugal");
        expResult = 0;
        result = instance2.minFront(instance2.getPais("portugal"), instance2.getPais("portugal"));
        assertEquals(expResult, result);

        System.out.println("Portugal <-> Uruguai");
        expResult = -1;
        result = instance2.minFront(instance2.getPais("portugal"), instance2.getPais("uruguai"));
        assertEquals(expResult, result);
    }

}
