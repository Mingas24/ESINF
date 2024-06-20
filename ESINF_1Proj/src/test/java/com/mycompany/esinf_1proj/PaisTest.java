/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.esinf_1proj;

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
public class PaisTest {

    public PaisTest() {
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
     * Test of getNome method, of class Pais.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Pais instance = new Pais("portugal", "europa", 10, "Lisboa", 38.7071631, -9.135517);
        String expResult = "portugal";
        String result = instance.getNome();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Pais.
     */
    @Test
    public void testEqualsDiferente() {
        System.out.println("equals");
        Object o = new Pais("letonia", "europa", 1.98, "riga", 56.9465346, 24.1048525);
        Pais instance = new Pais("portugal", "europa", 10, "Lisboa", 38.7071631, -9.135517);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Pais.
     */
    @Test
    public void testEqualsIgual() {
        System.out.println("equals");
        Object o = new Pais("portugal", "europa", 10, "Lisboa", 38.7071631, -9.135517);
        Pais instance = new Pais("portugal", "europa", 10, "Lisboa", 38.7071631, -9.135517);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);

    }

    /**
     * Test of compareTo method, of class Pais.
     */
    @Test
    public void testCompareToPositive() {
        System.out.println("compareTo");
        Pais o = new Pais("portugal", "europa", 10, "Lisboa", 38.7071631, -9.135517);
        Pais instance = new Pais("letonia", "europa", 1.98, "riga", 56.9465346, 24.1048525);
        int result = instance.compareTo(o);
        assertTrue(result > 0);

    }
    
    
    /**
     * Test of compareTo method, of class Pais.
     */
    @Test
    public void testCompareToNegative() {
        System.out.println("compareTo");
        Pais o = new Pais("letonia", "europa", 1.98, "riga", 56.9465346, 24.1048525);
        Pais instance =  new Pais("portugal", "europa", 10, "Lisboa", 38.7071631, -9.135517);
        int result = instance.compareTo(o);
        assertTrue(result < 0);

    }

}
