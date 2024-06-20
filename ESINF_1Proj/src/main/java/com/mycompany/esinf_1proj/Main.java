package com.mycompany.esinf_1proj;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Utilizador
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Mundo m = new Mundo();

        Map<Pais, Set<Pais>> map = m.getMap();
        boolean b1 = Mundo.lerPais(map);
        boolean b2 = Mundo.lerFronteira(map);

        for (Pais p : map.keySet()) {
            System.out.println(p.toString());
            System.out.println(map.get(p));

        }
        /**
         * Exercício 2)
         */
        System.out.println(m.getNPopulation(map, 50.00, "europa"));
        /**
         * Exercício 3)
         */
        System.out.println(m.sortFronteiras("europa"));
        /**
         * Exercício 4) 
         */
        Pais p1= new Pais ("portugal", "europa", 10.31,"lisboa", 38.7071631, -9.135517);
        Pais p2 = new Pais ("alemanha", "europa", 82.8, "berlim", 52.5234051, 13.4113999);
        System.out.println(m.minFront(p1,p2));
    }

}
