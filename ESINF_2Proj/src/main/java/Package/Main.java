/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Mundo m = new Mundo();

        Map<Pais, Set<Pais>> map = m.getMap();
        Map<Pais, String> association;
        boolean b1 = Files.lerPais(map);
        boolean b2 = Files.lerFronteira(map);
        LinkedList<String> capitaisPercorrer = new LinkedList<>();
        capitaisPercorrer.add("roma");
        capitaisPercorrer.add("atenas");
        LinkedList<Pais> resultado = new LinkedList<>();

        //Ex1)
        System.out.println(m.mainGraph);

        //Ex2)
        System.out.println(m.colorirGrafo());
        association = m.colorirGrafo();

        for (Map.Entry<Pais, String> entry : association.entrySet()) {
            Pais k = entry.getKey();
            String v = entry.getValue();
            System.out.println("Key: " + k + ", Value: " + v);
        }

        //Ex3)
        System.out.println("Distancia entre capitais: " + m.calcShortestPath("Lima", "Kiev",resultado));
        System.out.println("Distancia entre capitais: " + m.calcShortestPath("Minsk", "Berlim",resultado));
        
        //Ex4)
        System.out.println(m.caminhoMaisCurtoPassandoPorOutrasCapitais("lisboa", "bucareste", capitaisPercorrer));
        
        //Ex5)
        System.out.println(m.calcularCircuito("lisboa"));
        
    }
}
