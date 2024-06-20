/**
 *
 */
package com.mycompany.esinf_1proj;

//import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Mundo {
    // List<Paises> listP;
    //List<Fronteiras> listF;

    Map<Pais, Set<Pais>> m;

    @Override
    public String toString() {
        return "Mundo{" + "m=" + m + '}';
    }

    Mundo() throws IOException {
        //this.listP = new ArrayList<Paises> ();
        //this.listF = new ArrayList<Fronteiras>();
        m = new HashMap<>();
        lerPais(m);
        lerFronteira(m);

    }

    public Map<Pais, Set<Pais>> getMap() {
        return this.m;
    }
    
    public Pais getPais(String p){
        for(Pais p2:m.keySet()){
            if(p2.getNome().equals(p)){
                return p2;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mundo that = (Mundo) o;
        return Objects.equals(m, that.m);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m);
    }

    /**
     * Método que faz a leitura do ficheiro que contem os países e adiciona-os a
     * um mapa
     *
     * @param m mapa de países
     * @return mapa de países
     * @throws FileNotFoundException excepção de ficheiro não encontrado
     */
    public static boolean lerPais(Map<Pais, Set<Pais>> m) throws FileNotFoundException, IOException {
        Pais p = null;
        Set<Pais> sp;

        Scanner ler = new Scanner(new File("paises.txt"));

        /*Ler o ficheiro até este chegar ao fim */
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            //Verifica se linha está em branco
            if ((linha.trim()).length() > 0) {
                String[] temp = linha.split(",");
                p = new Pais(temp[0].trim(), temp[1].trim(), Double.parseDouble(temp[2].trim()), temp[3].trim(), Double.parseDouble(temp[4].trim()), Double.parseDouble(temp[5].trim()));
                sp = new TreeSet<>();
                m.put(p, sp);
            }
        }
         if(m.isEmpty()){
            return false;
        }
        return true;
    }

    public static boolean lerFronteira(Map<Pais, Set<Pais>> m) throws FileNotFoundException {
        Scanner ler = new Scanner(new File("fronteiras.txt"));
        Pais p;
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            //Verifica se linha está em branco
            if ((linha.trim()).length() > 0) {
                String[] temp = linha.split(",");
                p = procurarPais(m, temp[0].trim());
                Set<Pais> fronteira = m.get(p);
                p = procurarPais(m, temp[1].trim());
                fronteira.add(p);
                p = procurarPais(m, temp[1].trim());
                fronteira = m.get(p);
                p = procurarPais(m, temp[0].trim());
                fronteira.add(p);
            }
        }
        if(m.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * Procura um país passado por parâmetro no mapa recebido e se existir
     * procura a respectiva fronteira e adiciona a fronteira ao set de países
     *
     * @param m mapa com os países
     * @param nomePais nome do país que queremos procurar
     * @return país encontrado
     */
    public static Pais procurarPais(Map<Pais, Set<Pais>> m, String nomePais) {
        Iterator<Pais> itr = m.keySet().iterator();
        while (itr.hasNext()) {
            Pais p = itr.next();
            if (p.getNome().equals(nomePais)) {
                return p;
            }
        }
        return null;
    }

    public Set<Pais> getNPopulation(Map<Pais, Set<Pais>> m, Double pop, String continente) {

        Set<Pais> setPais = new TreeSet<>(new Comparator<Pais>() {
            @Override
            public int compare(Pais o1, Pais o2) {
                return Double.compare(o1.getPopulacao(), o2.getPopulacao());
            }
        });

        Set<Pais> paises = new TreeSet<>();

        //Para cada país no mapa
        for (Pais p : m.keySet()) {
            if (p.getContinente().equals(continente)) {
                //Se a sua população for maior ou igual à população passada por parâmetro
                if (p.getPopulacao() >= pop) {
                    //adiciona esse país à lista paises
                    setPais.add(p);
                }
            }
        }
        //return da lista de países com população >= pop 
        return setPais;
    }

    /**
     * Método para ordenar os países pelo número de fronteiras Devolve uma lista
     * ordenada por ordem decrescente
     *
     * @param continente
     * @return lista de países, ordenada pelas suas fronteiras por ordem
     * decrescente
     */
    public Map<Integer, Set<Pais>> sortFronteiras(String continente) {
        /*
        Mapa guarda o número de fronteiras e as respectivas fronteiras */
        Map<Integer, Set<Pais>> map = new TreeMap<>(Collections.reverseOrder());
        for (Pais p : m.keySet()) {
            if (p.getContinente().equals(continente)) {
                int nFront = m.get(p).size();       //Número de fronteiras de p
                if (map.containsKey(nFront)) {
                    int key = procurarNumFront(map.keySet(), nFront);
                    map.get(key).add(p);
                } else {
                    Set<Pais> setPais = new TreeSet<>();
                    setPais.add(p);
                    map.put(nFront, setPais);
                }
            }
        }
        return map;
    }

    public int procurarNumFront(Set<Integer> si, int n) {
        for (Integer i : si) {
            if (i == n) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Método para calcular o número mínimo de fronteiras que são necessárias
     * atravessar para chegar de um país de origem a um país de destino
     *
     * @param origem país de origem
     * @param dest país de destino
     * @return número de fronteiras atravessadas (valor mínimo)
     */
    public int minFront(Pais origem, Pais dest) {
        /*Lista que contém os países necessários atravessar para chegar do país
        origem ao país destino - util??? - */
        List<Pais> fila = new ArrayList<>();
        Map<Pais, Integer> map4 = new TreeMap<>();
        if (!origem.getContinente().equals(dest.getContinente())) {
            return -1;
        }
        //Verificação para o caso de o país destino e o país de origem serem o mesmo
        if (origem.getNome().equals(dest.getNome())) {
            return 0;
        }
        //Verificação para o caso de o país destino e o país de origem não terem fronteiras
        if(m.get(origem).isEmpty()||m.get(dest).isEmpty()){
            return -1;
        }
        //Se o país de origem fôr diferente do país destino 
        fila.add(origem);
        map4.put(origem, 0);
        while (!fila.isEmpty() && !fila.contains(dest)) {
            fila.remove(0);
            for (Pais p : m.get(origem)) {
                if (!map4.containsKey(p)) {
                    fila.add(p);
                    map4.put(p, map4.get(origem) + 1);
                }
            }
            origem = fila.get(0);
        }
        return map4.get(dest);
    }

}
