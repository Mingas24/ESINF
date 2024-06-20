/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import GrafoMatrizDeAdjacencias.AdjacencyMatrixGraph;
import Graph.Edge;
import Graph.Graph;
import Graph.GraphAlgorithms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Utilizador
 */
public class Mundo {

    Map<Pais, Set<Pais>> m;
    Graph<Pais, String> mainGraph;
    AdjacencyMatrixGraph matrizMundo;

    @Override
    public String toString() {
        return "Mundo{" + "m=" + m + '}';
    }

    Mundo() throws IOException {
        //this.listP = new ArrayList<Paises> ();
        //this.listF = new ArrayList<Fronteiras>();

        m = new HashMap<>();
        Files.lerPais(m);
        Files.lerFronteira(m);
        mainGraph = new Graph(false);
        matrizMundo = new AdjacencyMatrixGraph();
        construirGrafo();
    }

    public Map<Pais, Set<Pais>> getMap() {
        return this.m;
    }
    public Graph<Pais, String> getGrafo(){
        return this.mainGraph;
    }
    public Pais getPais(String p) {
        for (Pais p2 : m.keySet()) {
            if (p2.getNome().equalsIgnoreCase(p)) {
                return p2;
            }
        }
        return null;
    }

    public Pais getPaisByCapital(String capital) {
        for (Pais p : m.keySet()) {
            if (p.getCapital().equalsIgnoreCase(capital)) {
                return p;

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

    //Ex1
    public void construirGrafo() {

        /*Preencher os vértices do grafo com países */
        for (Pais p : m.keySet()) {
            mainGraph.insertVertex(p);
        }
        /*Criar as arestas que ligam os diversos países */
 /*Percorre o set de países*/
        for (Pais p : m.keySet()) {
            for (int i = 0; i < m.get(p).size(); i++) {
                Pais p2 = (Pais) m.get(p).toArray()[i];
                mainGraph.insertEdge(p, p2, p.getNome() + "-" + p2.getNome(), Utilitarios.calcDistance(p.getLatitude(),
                        p2.getLatitude(), p.getLongitude(), p2.getLongitude()));

            }
        }
        setGrau1();
    }

    public void setGrau1() {
        int grau = 0;
        Pais[] grauPaises = mainGraph.allkeyVerts();
        for (Pais p : grauPaises) {
            grau = mainGraph.outDegree(p);
            p.setGrau(grau);
        }
    }

    //Ex2
    public Map<Pais, String> colorirGrafo() {
        Pais[] paises = mainGraph.allkeyVerts();
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Azul");
        cores.add("Preto");
        cores.add("Branco");
        cores.add("Rosa");
        ArrayList<Pais> grauOrdenado = new ArrayList<>();
        Collections.addAll(grauOrdenado, paises);
        Collections.sort(grauOrdenado, new Utilitarios.compararGrau());
        Map<Pais, String> association = new LinkedHashMap<>();

        /*1. Ordenam-se os vértices por ordem decrescente dos seus graus. 
        Caso haja vértices com o mesmo grau, escolhe-se qualquer ordenação entre eles.*/
        boolean checkColor = false;
        int numPaises = mainGraph.numVertices();
        int contadorPais = 0;
        int i = 0;
        /*2. Faz-se corresponder a primeira cor ao primeiro vértice e, 
        seguidamente, faz-se corresponder essa cor ao primeiro vértice da 
        sequência que não é adjacente a nenhum vértice ao qual já foi atribuída essa cor.*/

        //Preencho o mapa association com os paises ordenados 
        for (Pais p : grauOrdenado) {
            association.put(p, null);
        }
        String corAtual;
        //Enquanto houver países
        while (contadorPais != numPaises) {
            corAtual = cores.get(i++);
            //Para cada país na lista de países ordenados
            for (Pais p : grauOrdenado) {
                if (association.get(p) == null) {       //Se ainda não tiver uma cor associada
                    //Para cada um dos seus vizinhos
                    for (Pais vizinho : mainGraph.adjVertices(p)) {
                        checkColor = false;
                        //Se esse vizinho estiver pintado com a cor actual, faz break
                        if (association.get(vizinho) != null && association.get(vizinho).equals(corAtual)) {
                            checkColor = true;
                            break;
                        }
                    }
                    if (!checkColor) {
                        contadorPais++;
                        p.setCor(corAtual);
                        association.replace(p, corAtual);
                    }
                }
            }
        }
        return association;
    }

    /*Ex3*/
    /**
     * Método para calcular o caminho mais curto entre duas capitais passadas
     * por parâmetro
     *
     * @param capitalOrigem capital inicial
     * @param capitalDestino capital final
     * @param countryList
     * @return distância mínima entre capitalOrigem e capitalDestino
     */
    public double calcShortestPath(String capitalOrigem, String capitalDestino, LinkedList<Pais> countryList) {
        Pais p1 = getPaisByCapital(capitalOrigem);
        Pais p2 = getPaisByCapital(capitalDestino);

        /*---------------------------------------------------------------------
        *   Verificar se as duas capitais pertencem ao mesmo continente
        -----------------------------------------------------------------------*/
        if (p1 == null || p2 == null || !(p1.getContinente().equalsIgnoreCase(p2.getContinente()))) {
            //System.out.println("O pais " + p1.getNome() + " e o pais " + p2.getNome() + " não são do mesmo continente");
            return -1;
        }

        /*--------------------------------------------------------------------
        *   Calcular o caminho mais curto entre as duas capitais
        ---------------------------------------------------------------------*/
        double distance = GraphAlgorithms.shortestPath(mainGraph, p1, p2, countryList);
        System.out.println("Capitais incluidas: ");
        for (Pais p : countryList) {
            System.out.println(p.getCapital());
        }

        return distance;

    }

    /**
     * ******************************************
     * Ex 4 
     ********************************************/
    public LinkedList<String> caminhoMaisCurtoPassandoPorOutrasCapitais(String capitalOrigem, String capitalDestino, List<String> percursoDeCapitais) {

        Pais p1 = getPaisByCapital(capitalOrigem);
        Pais p2 = getPaisByCapital(capitalDestino);
        if (p1 == null || p2 == null || !p1.getContinente().equals(p2.getContinente())) {
            return  new LinkedList<>();
        }
        LinkedList<String> capitaisCaminhoMaisCurto = new LinkedList<>();
        LinkedList<Pais> caminhoMaisCurto = new LinkedList<>();
        Pais[] countryList = new Pais[percursoDeCapitais.size()];
        for (int i = 0; i < percursoDeCapitais.size(); i++) {
            if (getPaisByCapital(percursoDeCapitais.get(i)) == null
                    || !p1.getContinente().equals(getPaisByCapital(percursoDeCapitais.get(i)).getContinente())
                    || !p2.getContinente().equals(getPaisByCapital(percursoDeCapitais.get(i)).getContinente())) {
                return new LinkedList<>();
            }
            countryList[i] = getPaisByCapital(percursoDeCapitais.get(i));
        }

        LinkedList<LinkedList<Pais>> permutacoesList = new LinkedList<>();
        heapPermutation(countryList, countryList.length, countryList.length, permutacoesList);

        LinkedList<Pais> caminhoTemp = new LinkedList<>();
        LinkedList<Pais> aux = new LinkedList<>();
        double distanciaMinima = Double.MAX_VALUE;
        double distanciaTemporaria = 0;
        int i = 0;

        for (i = 0; i < permutacoesList.size(); i++) {
            //Adiciona o pais origem e o pais destino a lista
            permutacoesList.get(i).addFirst(p1);
            permutacoesList.get(i).addLast(p2);
            //verifica a (temp) dist da lista
            caminhoTemp.add(permutacoesList.get(i).get(0));
            for (int h = 0; h < permutacoesList.get(i).size() - 1; h++) {
                distanciaTemporaria += GraphAlgorithms.shortestPath(mainGraph, permutacoesList.get(i).get(h), permutacoesList.get(i).get(h + 1), aux);
                aux.removeFirst();
                caminhoTemp.addAll(aux);
                aux.clear();
            }

            ///compara tempdist com d_min
            if (distanciaTemporaria < distanciaMinima) {
                caminhoMaisCurto.clear();
                caminhoMaisCurto.addAll(caminhoTemp);
                distanciaMinima = distanciaTemporaria;
            }
            caminhoTemp.clear();
            aux.clear();
            distanciaTemporaria = 0;
        }
        for (Pais pais : caminhoMaisCurto) {
            capitaisCaminhoMaisCurto.add(pais.getCapital());
        }
        return capitaisCaminhoMaisCurto;
    }

    private void concatenarPermutacoes(Pais countryList[], int n, LinkedList<LinkedList<Pais>> listaPermutacoes) {
        LinkedList<Pais> permutacaoAtual = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            permutacaoAtual.add(countryList[i]);
        }
        listaPermutacoes.add(permutacaoAtual);
    }

    /**
     * Através do algoritmo de heap sort, calcula as permutações possíveis entre
     * a lista de capitais indicadas e obrigatórias no percurso
     *
     * @param countryList lista de países
     * @param size
     * @param n
     * @param permutacoesList
     */
    private void heapPermutation(Pais countryList[], int size, int n, LinkedList<LinkedList<Pais>> permutacoesList) {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1) {
            concatenarPermutacoes(countryList, n, permutacoesList);
        }

        for (int i = 0; i < size; i++) {
            heapPermutation(countryList, size - 1, n, permutacoesList);

            // Se o tamanho for ímpar, troca o primeiro e o último elemento
            if (size % 2 == 1) {
                Pais temp = countryList[0];
                countryList[0] = countryList[size - 1];
                countryList[size - 1] = temp;
            } // Se o tamanho for par, troca o primeiro e o último elemento
            else {
                Pais temp = countryList[i];
                countryList[i] = countryList[size - 1];
                countryList[size - 1] = temp;
            }
        }
    }

    //Ex5
    /*---------------------------------------------------------------------
    * Método que calcula o circuito passando por todas capitais possíveis
    ----------------------------------------------------------------------*/
    /**
     *
     * @param capitalOrigem capital onde começa o circuito
     * @return lista de países que pertencem ao circuito
     */
    public List<Pais> calcularCircuito(String capitalOrigem) {

        Pais actual;
        boolean checkorigem;
        double min;
        Edge<Pais, String> edge;

        /*Identifica o país cuja capital é a passada por parâmetro*/
        Pais p1 = getPaisByCapital(capitalOrigem);

        /*Se não encontrar nenhum país com a capital passada por parâmetro
            Dá return da lista vazia*/
        if (p1 == null) {
            return new LinkedList<>();
        }

        //Cria-se uma lista que irá conter o circuito
        List<Pais> countryList = new LinkedList<>();
        countryList.add(p1);        //Adiciona o país à lista 

        Iterator<Edge<Pais, String>> iterator = mainGraph.outgoingEdges(p1).iterator();

        do {
            min = Double.MAX_VALUE;     //Atribuí o máximo valor possível à variável min
            checkorigem = false;
            actual = null;
            do {
                edge = iterator.next();
                if (edge.getWeight() < min && !countryList.contains(edge.getVDest())) {
                    min = edge.getWeight();
                    actual = edge.getVDest();
                }
                if (edge.getVDest().equals(p1)) {
                    checkorigem = true;
                }
            } while (iterator.hasNext());
            if (actual != null) {
                countryList.add(actual);
                iterator = mainGraph.outgoingEdges(actual).iterator();
            } else if (checkorigem) {
                countryList.add(p1);
            }
        } while (actual != null);

        /*Imprime o size da lista */
        System.out.println(countryList.size());
        return countryList;     //retorna a lista
    }
}
