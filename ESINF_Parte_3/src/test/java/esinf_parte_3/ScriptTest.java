/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf_parte_3;

import PL.AVL;
import PL.KDTREE;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Utilizador
 */
public class ScriptTest {

    public ScriptTest() {
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
     * Test of preencherTree method, of class Script.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testPreencherTree() throws Exception {

        System.out.println("preencherTree");

        Script instance = new Script();
        Mundo w = new Mundo();
        AVL<Pais> result;

        result = instance.preencherTree();

        AVL<Pais> expResult = new AVL<>();

        expResult.insert(new Pais("argentina", "americasul", 41.67, "buenosaires", -34.6131500, -58.3772300));
        expResult.insert(new Pais("bolivia", "americasul", 9.70, "lapaz", -16.5000000, -68.1500000));
        expResult.insert(new Pais("brasil", "americasul", 206.12, "brasilia", -15.7797200, -47.9297200));
        expResult.insert(new Pais("chile", "americasul", 16.80, "santiago", -33.4569400, -70.6482700));
        expResult.insert(new Pais("colombia", "americasul", 46.86, "bogota", 4.6097100, -74.0817500));
        expResult.insert(new Pais("equador", "americasul", 14.88, "quito", -0.2298500, -78.5249500));
        expResult.insert(new Pais("guiana", "americasul", 0.07, "georgetwon", 6.8044800, -58.1552700));
        expResult.insert(new Pais("guianafrancesa", "americasul", 2.88, "caiena", 4.9333300, -52.3333300));
        expResult.insert(new Pais("paraguai", "americasul", 6.24, "assuncao", -25.3006600, -57.6359100));
        expResult.insert(new Pais("peru", "americasul", 28.22, "lima", -12.0431800, -77.0282400));
        expResult.insert(new Pais("suriname", "americasul", 0.04, "paramaribo", 5.8663800, -55.1668200));
        expResult.insert(new Pais("venezuela", "americasul", 31.02, "caracas", 10.4880100, -66.8791900));
        expResult.insert(new Pais("uruguai", "americasul", 3.35, "montevideu", -34.9032800, -56.1881600));
        expResult.insert(new Pais("albania", "europa", 2.88, "tirana", 41.33165, 19.8318));
        expResult.insert(new Pais("alemanha", "europa", 82.8, "berlim", 52.5234051, 13.4113999));
        expResult.insert(new Pais("armenia", "europa", 3.01, "erevan", 40.1811100, 44.5136100));
        expResult.insert(new Pais("austria", "europa", 8.77, "viena", 48.2092062, 16.3727778));
        expResult.insert(new Pais("belgica", "europa", 11.37, "bruxelas", 50.8462807, 4.3547273));
        expResult.insert(new Pais("bielorussia", "europa", 9.48, "minsk", 53.905117, 27.5611845));
        expResult.insert(new Pais("bosnia", "europa", 3.75, "sarajevo", 43.85643, 18.41342));
        expResult.insert(new Pais("bulgaria", "europa", 7.1, "sofia", 42.6976246, 23.3222924));
        expResult.insert(new Pais("chipre", "europa", 0.85, "nicosia", 35.167604, 33.373621));
        expResult.insert(new Pais("croacia", "europa", 4.15, "zagreb", 45.8150053, 15.9785014));
        expResult.insert(new Pais("dinamarca", "europa", 5.75, "copenhaga", 55.6762944, 12.5681157));
        expResult.insert(new Pais("eslovaquia", "europa", 5.44, "bratislava", 48.1483765, 17.1073105));
        expResult.insert(new Pais("eslovenia", "europa", 2.06, "liubliana", 46.0514263, 14.5059655));
        expResult.insert(new Pais("espanha", "europa", 46.53, "madrid", 40.4166909, -3.7003454));
        expResult.insert(new Pais("estonia", "europa", 1.32, "tallinn", 59.4388619, 24.7544715));
        expResult.insert(new Pais("finlandia", "europa", 5.5, "helsinque", 60.1698791, 24.9384078));
        expResult.insert(new Pais("franca", "europa", 66.99, "paris", 48.8566667, 2.3509871));
        expResult.insert(new Pais("georgia", "europa", 3.71, "tbilisi", 41.709981, 44.792998));
        expResult.insert(new Pais("grecia", "europa", 10.76, "atenas", 37.97918, 23.716647));
        expResult.insert(new Pais("holanda", "europa", 17.08, "amsterdam", 52.3738007, 4.8909347));
        expResult.insert(new Pais("hungria", "europa", 9.8, "budapeste", 47.4984056, 19.0407578));
        expResult.insert(new Pais("irlanda", "europa", 4.77, "dublin", 53.344104, -6.2674937));
        expResult.insert(new Pais("islandia", "europa", 0.34, "reiquiavique", 64.135338, -21.89521));
        expResult.insert(new Pais("italia", "europa", 60.59, "roma", 41.8954656, 12.4823243));
        expResult.insert(new Pais("kosovo", "europa", 1.77, "pristina", 42.672421, 21.164539));
        expResult.insert(new Pais("letonia", "europa", 1.98, "riga", 56.9465346, 24.1048525));
        expResult.insert(new Pais("liechtenstein", "europa", 0.05, "vaduz", 47.1410409, 9.5214458));
        expResult.insert(new Pais("lituania", "europa", 2.85, "vilnius", 54.6893865, 25.2800243));
        expResult.insert(new Pais("luxemburgo", "europa", 0.59, "luxemburgo", 49.815273, 6.129583));
        expResult.insert(new Pais("macedonia", "europa", 2.07, "escopia", 41.9964600, 21.4314100));
        expResult.insert(new Pais("malta", "europa", 0.44, "valletta", 35.904171, 14.518907));
        expResult.insert(new Pais("moldavia", "europa", 3.55, "chisinau", 47.026859, 28.841551));
        expResult.insert(new Pais("monaco", "europa", 0.04, "monaco", 43.750298, 7.412841));
        expResult.insert(new Pais("montenegro", "europa", 0.62, "podgorica", 42.442575, 19.268646));
        expResult.insert(new Pais("noruega", "europa", 5.26, "oslo", 59.9138204, 10.7387413));
        expResult.insert(new Pais("polonia", "europa", 38.42, "varsovia", 52.2296756, 21.0122287));
        expResult.insert(new Pais("portugal", "europa", 10.31, "lisboa", 38.7071631, -9.135517));
        expResult.insert(new Pais("reinounido", "europa", 65.81, "londres", 51.5001524, -0.1262362));
        expResult.insert(new Pais("republicacheca", "europa", 10.57, "praga", 50.0878114, 14.4204598));
        expResult.insert(new Pais("romenia", "europa", 19.64, "bucareste", 44.430481, 26.12298));
        expResult.insert(new Pais("russia", "europa", 146.5, "moscovo", 55.755786, 37.617633));
        expResult.insert(new Pais("servia", "europa", 7.04, "belgrado", 44.802416, 20.465601));
        expResult.insert(new Pais("suecia", "europa", 10, "estocolmo", 59.3327881, 18.0644881));
        expResult.insert(new Pais("suica", "europa", 8.42, "berna", 46.9479986, 7.4481481));
        expResult.insert(new Pais("turquia", "europa", 79.81, "ancara", 39.9198700, 32.8542700));
        expResult.insert(new Pais("ucrania", "europa", 42.59, "kiev", 50.440951, 30.5271814));

        int resultSize = result.size();
        int expResultSize = expResult.size();

        assertEquals(expResultSize, resultSize);

    }

    /**
     * Test of listByContinent method, of class Script.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testListByContinent() throws IOException {

        System.out.println("listByContinent");

        Script instance = new Script();
        instance.preencherTree();
        List<PaisAux> result;

        result = instance.listByContinent("americasul");

        List<PaisAux> expResult = new LinkedList<>();
        expResult.add(new PaisAux(new Pais("brasil", "americasul", 206.12, "brasilia", -15.7797200, -47.9297200)));
        expResult.add(new PaisAux(new Pais("bolivia", "americasul", 9.70, "lapaz", -16.5000000, -68.1500000)));
        expResult.add(new PaisAux(new Pais("peru", "americasul", 28.22, "lima", -12.0431800, -77.0282400)));
        expResult.add(new PaisAux(new Pais("argentina", "americasul", 41.67, "buenosaires", -34.6131500, -58.3772300)));
        expResult.add(new PaisAux(new Pais("colombia", "americasul", 46.86, "bogota", 4.6097100, -74.0817500)));
        expResult.add(new PaisAux(new Pais("suriname", "americasul", 0.04, "paramaribo", 5.8663800, -55.1668200)));
        expResult.add(new PaisAux(new Pais("guiana", "americasul", 0.07, "georgetwon", 6.8044800, -58.1552700)));
        expResult.add(new PaisAux(new Pais("paraguai", "americasul", 6.24, "assuncao", -25.3006600, -57.6359100)));
        expResult.add(new PaisAux(new Pais("chile", "americasul", 16.80, "santiago", -33.4569400, -70.6482700)));
        expResult.add(new PaisAux(new Pais("venezuela", "americasul", 31.02, "caracas", 10.4880100, -66.8791900)));
        expResult.add(new PaisAux(new Pais("guianafrancesa", "americasul", 2.88, "caiena", 4.9333300, -52.3333300)));
        expResult.add(new PaisAux(new Pais("uruguai", "americasul", 3.35, "montevideu", -34.9032800, -56.1881600)));
        expResult.add(new PaisAux(new Pais("equador", "americasul", 14.88, "quito", -0.2298500, -78.5249500)));

        assertEquals(expResult, result);

    }

    /**
     * Test of preencher2dtree method, of class Script.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testPreencher2dtree() throws IOException {

        System.out.println("preencher2dtree");

        Script instance = new Script();
        AVL<Pais> avl = instance.preencherTree();
        KDTREE<Pais> result = instance.preencher2dtree();

        KDTREE<Pais> expResult = new KDTREE<>();
        expResult.insert(new Pais("argentina", "americasul", 41.67, "buenosaires", -34.6131500, -58.3772300), -34.6131500, -58.3772300);
        expResult.insert(new Pais("bolivia", "americasul", 9.70, "lapaz", -16.5000000, -68.1500000), -16.5000000, -68.1500000);
        expResult.insert(new Pais("brasil", "americasul", 206.12, "brasilia", -15.7797200, -47.9297200), -15.7797200, -47.9297200);
        expResult.insert(new Pais("chile", "americasul", 16.80, "santiago", -33.4569400, -70.6482700), -33.4569400, -70.6482700);
        expResult.insert(new Pais("colombia", "americasul", 46.86, "bogota", 4.6097100, -74.0817500), 4.6097100, -74.0817500);
        expResult.insert(new Pais("equador", "americasul", 14.88, "quito", -0.2298500, -78.5249500), -0.2298500, -78.5249500);
        expResult.insert(new Pais("guiana", "americasul", 0.07, "georgetwon", 6.8044800, -58.1552700), 6.8044800, -58.1552700);
        expResult.insert(new Pais("guianafrancesa", "americasul", 2.88, "caiena", 4.9333300, -52.3333300), 4.9333300, -52.3333300);
        expResult.insert(new Pais("paraguai", "americasul", 6.24, "assuncao", -25.3006600, -57.6359100), -25.3006600, -57.6359100);
        expResult.insert(new Pais("peru", "americasul", 28.22, "lima", -12.0431800, -77.0282400), -12.0431800, -77.0282400);
        expResult.insert(new Pais("suriname", "americasul", 0.04, "paramaribo", 5.8663800, -55.1668200), 5.8663800, -55.1668200);
        expResult.insert(new Pais("venezuela", "americasul", 31.02, "caracas", 10.4880100, -66.8791900), 10.4880100, -66.8791900);
        expResult.insert(new Pais("uruguai", "americasul", 3.35, "montevideu", -34.9032800, -56.1881600), -34.9032800, -56.1881600);
        expResult.insert(new Pais("albania", "europa", 2.88, "tirana", 41.33165, 19.8318), 41.33165, 19.8318);
        expResult.insert(new Pais("alemanha", "europa", 82.8, "berlim", 52.5234051, 13.4113999), 52.5234051, 13.4113999);
        expResult.insert(new Pais("armenia", "europa", 3.01, "erevan", 40.1811100, 44.5136100), 40.1811100, 44.5136100);
        expResult.insert(new Pais("austria", "europa", 8.77, "viena", 48.2092062, 16.3727778), 48.2092062, 16.3727778);
        expResult.insert(new Pais("belgica", "europa", 11.37, "bruxelas", 50.8462807, 4.3547273), 50.8462807, 4.3547273);
        expResult.insert(new Pais("bielorussia", "europa", 9.48, "minsk", 53.905117, 27.5611845), 53.905117, 27.5611845);
        expResult.insert(new Pais("bosnia", "europa", 3.75, "sarajevo", 43.85643, 18.41342), 43.85643, 18.41342);
        expResult.insert(new Pais("bulgaria", "europa", 7.1, "sofia", 42.6976246, 23.3222924), 42.6976246, 23.3222924);
        expResult.insert(new Pais("chipre", "europa", 0.85, "nicosia", 35.167604, 33.373621), 35.167604, 33.373621);
        expResult.insert(new Pais("croacia", "europa", 4.15, "zagreb", 45.8150053, 15.9785014), 45.8150053, 15.9785014);
        expResult.insert(new Pais("dinamarca", "europa", 5.75, "copenhaga", 55.6762944, 12.5681157), 55.6762944, 12.5681157);
        expResult.insert(new Pais("eslovaquia", "europa", 5.44, "bratislava", 48.1483765, 17.1073105), 48.1483765, 17.1073105);
        expResult.insert(new Pais("eslovenia", "europa", 2.06, "liubliana", 46.0514263, 14.5059655), 46.0514263, 14.5059655);
        expResult.insert(new Pais("espanha", "europa", 46.53, "madrid", 40.4166909, -3.7003454), 40.4166909, -3.7003454);
        expResult.insert(new Pais("estonia", "europa", 1.32, "tallinn", 59.4388619, 24.7544715), 59.4388619, 24.7544715);
        expResult.insert(new Pais("finlandia", "europa", 5.5, "helsinque", 60.1698791, 24.9384078), 60.1698791, 24.9384078);
        expResult.insert(new Pais("franca", "europa", 66.99, "paris", 48.8566667, 2.3509871), 48.8566667, 2.3509871);
        expResult.insert(new Pais("georgia", "europa", 3.71, "tbilisi", 41.709981, 44.792998), 41.709981, 44.792998);
        expResult.insert(new Pais("grecia", "europa", 10.76, "atenas", 37.97918, 23.716647), 37.97918, 23.716647);
        expResult.insert(new Pais("holanda", "europa", 17.08, "amsterdam", 52.3738007, 4.8909347), 52.3738007, 4.8909347);
        expResult.insert(new Pais("hungria", "europa", 9.8, "budapeste", 47.4984056, 19.0407578), 47.4984056, 19.0407578);
        expResult.insert(new Pais("irlanda", "europa", 4.77, "dublin", 53.344104, -6.2674937), 53.344104, -6.2674937);
        expResult.insert(new Pais("islandia", "europa", 0.34, "reiquiavique", 64.135338, -21.89521), 64.135338, -21.89521);
        expResult.insert(new Pais("italia", "europa", 60.59, "roma", 41.8954656, 12.4823243), 41.8954656, 12.4823243);
        expResult.insert(new Pais("kosovo", "europa", 1.77, "pristina", 42.672421, 21.164539), 42.672421, 21.164539);
        expResult.insert(new Pais("letonia", "europa", 1.98, "riga", 56.9465346, 24.1048525), 56.9465346, 24.1048525);
        expResult.insert(new Pais("liechtenstein", "europa", 0.05, "vaduz", 47.1410409, 9.5214458), 47.1410409, 9.5214458);
        expResult.insert(new Pais("lituania", "europa", 2.85, "vilnius", 54.6893865, 25.2800243), 54.6893865, 25.2800243);
        expResult.insert(new Pais("luxemburgo", "europa", 0.59, "luxemburgo", 49.815273, 6.129583), 49.815273, 6.129583);
        expResult.insert(new Pais("macedonia", "europa", 2.07, "escopia", 41.9964600, 21.4314100), 41.9964600, 21.4314100);
        expResult.insert(new Pais("malta", "europa", 0.44, "valletta", 35.904171, 14.518907), 35.904171, 14.518907);
        expResult.insert(new Pais("moldavia", "europa", 3.55, "chisinau", 47.026859, 28.841551), 47.026859, 28.841551);
        expResult.insert(new Pais("monaco", "europa", 0.04, "monaco", 43.750298, 7.412841), 43.750298, 7.412841);
        expResult.insert(new Pais("montenegro", "europa", 0.62, "podgorica", 42.442575, 19.268646), 42.442575, 19.268646);
        expResult.insert(new Pais("noruega", "europa", 5.26, "oslo", 59.9138204, 10.7387413), 59.9138204, 10.7387413);
        expResult.insert(new Pais("polonia", "europa", 38.42, "varsovia", 52.2296756, 21.0122287), 52.2296756, 21.0122287);
        expResult.insert(new Pais("portugal", "europa", 10.31, "lisboa", 38.7071631, -9.135517), 38.7071631, -9.135517);
        expResult.insert(new Pais("reinounido", "europa", 65.81, "londres", 51.5001524, -0.1262362), 51.5001524, -0.1262362);
        expResult.insert(new Pais("republicacheca", "europa", 10.57, "praga", 50.0878114, 14.4204598), 50.0878114, 14.4204598);
        expResult.insert(new Pais("romenia", "europa", 19.64, "bucareste", 44.430481, 26.12298), 44.430481, 26.12298);
        expResult.insert(new Pais("russia", "europa", 146.5, "moscovo", 55.755786, 37.617633), 55.755786, 37.617633);
        expResult.insert(new Pais("servia", "europa", 7.04, "belgrado", 44.802416, 20.465601), 44.802416, 20.465601);
        expResult.insert(new Pais("suecia", "europa", 10, "estocolmo", 59.3327881, 18.0644881), 59.3327881, 18.0644881);
        expResult.insert(new Pais("suica", "europa", 8.42, "berna", 46.9479986, 7.4481481), 46.9479986, 7.4481481);
        expResult.insert(new Pais("turquia", "europa", 79.81, "ancara", 39.9198700, 32.8542700), 39.9198700, 32.8542700);
        expResult.insert(new Pais("ucrania", "europa", 42.59, "kiev", 50.440951, 30.5271814), 50.440951, 30.5271814);

        int resultSize = result.size();
        int expResultSize = expResult.size();

        assertEquals(resultSize, expResultSize);
    }

    /**
     * Test of procurarByCoord method, of class Script.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testProcurarByCoord() throws IOException {

        System.out.println("procurarByCoord");

        double latitude1 = 54.6893865;
        double longitude1 = 25.2800243;
        double latitude2 = 123;
        double longitude2 = 14345325;
        double latitude3 = -16.5000000;
        double longitude3 = -68.1500000;
        Script instance = new Script();

        instance.preencherTree();
        instance.preencher2dtree();

        Pais result1 = instance.procurarByCoord(latitude1, longitude1);
        Pais result2 = instance.procurarByCoord(latitude2, longitude2);
        Pais result3 = instance.procurarByCoord(latitude3, longitude3);

        Pais expResult1 = new Pais("lituania", "europa", 2.85, "vilnius", 54.6893865, 25.2800243);
        Pais expResult2 = null;
        Pais expResult3 = new Pais("bolivia", "americasul", 9.70, "lapaz", -16.5000000, -68.1500000);

        assertEquals(expResult1, result1);
        assertEquals(result2, expResult2);
        assertEquals(result3, expResult3);
    }

    /**
     * Test of pesquisaGeo method, of class Script.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testPesquisaGeo() throws IOException {

        System.out.println("pesquisaGeo");

        double lat1 = 30.77;
        double long1 = 12.463;
        double lat2 = 45.445;
        double long2 = 20.5;
        Script instance = new Script();

        instance.preencherTree();
        instance.preencher2dtree();

        List<Pais> expResult = new LinkedList<>();
        expResult.add(new Pais("servia", "europa", 7.04, "belgrado", 44.802416, 20.465601));
        expResult.add(new Pais("montenegro", "europa", 0.62, "podgorica", 42.442575, 19.268646));
        expResult.add(new Pais("albania", "europa", 2.88, "tirana", 41.33165, 19.8318));
        expResult.add(new Pais("bosnia", "europa", 3.75, "sarajevo", 43.85643, 18.41342));
        expResult.add(new Pais("italia", "europa", 60.59, "roma", 41.8954656, 12.4823243));
        expResult.add(new Pais("malta", "europa", 0.44, "valletta", 35.904171, 14.518907));

        LinkedList<Pais> result1 = instance.pesquisaGeo(lat1, long1, lat2, long2);
        assertEquals(expResult, result1);

        expResult.clear();

        double lat3 = 29.43;
        double long3 = 85.63;
        double lat4 = 29.43;
        double long4 = 85.63;

        LinkedList<Pais> result2 = instance.pesquisaGeo(lat3, long3, lat4, long4);
        assertEquals(expResult, result2);

    }
    /**
     * Test of capitalMaisProxima method, of class Script.
     *
     * @throws java.io.IOException
     */
    @Test
    public void capitalMaisProxima() throws IOException {
        
        System.out.println("capitalMaisProxima");
        
        Script instance = new Script();
        double latitude = 90;
        double longitude = 0;

        instance.preencherTree();
        instance.preencher2dtree();
        
        Pais result1 = instance.capitalMaisProxima(latitude, longitude);
        Pais expResult1 = new Pais("noruega", "europa", 5.26, "oslo", 59.9138204, 10.7387413);
        
        assertEquals(result1,expResult1);
        
        double latitude2 = 0;
        double longitude2 = 90;
        
        Pais result2 = instance.capitalMaisProxima(latitude2, longitude2);
        Pais expResult2 = new Pais("brasil", "americasul", 206.12, "brasilia", -15.7797200, -47.9297200);
        
        assertEquals (result2,expResult2);
        
        Pais result3 = instance.capitalMaisProxima(21.89, 47.89);
        Pais expResult3 = new Pais("chipre", "europa", 0.85, "nicosia", 35.167604, 33.373621);
        
        assertEquals (result3,expResult3);
    }

}
