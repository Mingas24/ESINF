package esinf_parte_3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nuno Capela
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Script s = new Script();

        List<PaisAux> countryList;
        Pais p;

        //Exercicio 1a)
        s.preencherTree();
        System.out.println("\n\n");
//        System.out.println(s.avlAlf);
        //Exercicio 1b)
//        countryList = s.listByContinent("americasul");
////        countryList = s.listByContinent("europa");
//
//        for (PaisAux px : countryList) {
//            System.out.println(px);
//        }
//        System.out.println("\n\n");


        //Exercicio 2a)
        s.preencher2dtree();
        System.out.println("\n\n");
        //Exercício 2b)
        System.out.println(s.procurarByCoord(38.7071631, -9.135517));
        System.out.println("\n\n");
        //System.out.println(s.procurarByCoord(55.6762944, 12.5681157));
        //System.out.println("\n\n");
        //Exercício 2c)
        System.out.println(s.capitalMaisProxima(21.89, 47.89));
//      //Exercico 2d)
        System.out.println(s.pesquisaGeo(20.97, 31.43, 54.245, 40.5));
    }
}
