/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf_parte_3;

import PL.*;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nuno Capela
 */
public class Script {

    Mundo w;
    AVL<Pais> avlAlf;
    AVL<PaisAux> avlFrontPop;
    KDTREE<Pais> kdtree;

    /**
     * Constructor por defeito Cria um objecto da classe mundo que por sua vez,
     * no seu constructor, faz a leitura dos ficheiros paises.txt e
     * fronteiras.txt, cria e preenche um map com os países e as respectivas
     * fronteiras
     *
     * @throws IOException
     */
    Script() throws IOException {
        w = new Mundo();
        avlAlf = new AVL<>();
        avlFrontPop = new AVL<>();
        kdtree = new KDTREE<>();

    }

    /**
     * ### EXERCICIO 1a) ### Método que preenche a tree com os respectivos
     * países e lista das suas fronteiras, a partir do mapa
     *
     * @return
     * @throws IOException
     */
    public AVL<Pais> preencherTree() throws IOException {

        for (Pais p : w.m.keySet()) {
            w.getFronteiraByPais(p.getNome());
            w.getnumFrontByPais(p.getNome());
            avlAlf.insert(p);
        }

        System.out.println(avlAlf);
        return avlAlf;
    }

    /**
     * ### EXERCICIO 1b) ### Método que percorre a tree e procura o continente
     * passado por parâmetro Se encontrar países que estejam nesse continente,
     * insere-os numa lista
     *
     * Depois ordena a lista e devolve-a
     *
     * @param continent do qual queremos a lista de países
     * @return lista de páises que pertencem a um continente
     */
    public List<PaisAux> listByContinent(String continent) {

        //Lista que contém os países de um determinado continente 
        List<PaisAux> countryList = new LinkedList<>();
        for (Pais p : avlAlf.inOrder()) {

            if (p.getContinente().equalsIgnoreCase(continent)) {

                avlFrontPop.insert(new PaisAux(p));
            }

        }
        for (PaisAux p : avlFrontPop.inOrder()) {
            countryList.add(p);
        }

        //System.out.println(avlFrontPop);
        Collections.sort(countryList, Collections.reverseOrder());
        return countryList;

    }

    /**
     * ***************************************
     *
     *
     * 2d-tree **************************************
     */
    /**
     * Método para criar a 2d-tree
     *
     * @return kdtree
     */
    public KDTREE<Pais> preencher2dtree() {
        for (Pais p : avlAlf.inOrder()) {
            //w.getFronteiraByPais(p.getNome());
            //w.getnumFrontByPais(p.getNome());
            kdtree.insert(p, p.getLatitude(), p.getLongitude());
        }

        System.out.println(kdtree);
        return kdtree;

    }

    public Pais procurarByCoord(double latitude, double longitude) {

        //Verifica se as coordenadas inseridas são iguais
        if (latitude == longitude) {
            return null;
        }

        return kdtree.findNode(latitude, longitude);
    }

    //Exercicio 2c
    /**
     * Método que devolve um país cuja capital está mais próxima das coordenadas
     * passadas
     *
     * @param latitude
     * @param longitude
     * @return
     */
    public Pais capitalMaisProxima(double latitude, double longitude) {

        double[] coordenadasDadas = {latitude, longitude};
        Pais maisProximoAparente = kdtree.getMaisProximoByLatitudeLongitudePrep(coordenadasDadas);
        double[] coordenadasMaisProximoAparente = {maisProximoAparente.getLatitude(), maisProximoAparente.getLongitude()};

        double lat1, lat2, long1, long2, dist;
        dist = kdtree.calcularDistanciaEntreCoordenadas(coordenadasDadas, coordenadasDadas);

        lat1 = maisProximoAparente.getLatitude() - dist;
        lat2 = maisProximoAparente.getLatitude() + dist;
        long1 = maisProximoAparente.getLongitude() - dist;
        long2 = maisProximoAparente.getLongitude() + dist;

        //Pesquisa os países contidos na área rectangular
        List<Pais> paisesMaisProximos = pesquisaGeo(lat1, lat2, long1, long2);
        double distanciaMin = Double.MAX_VALUE;
        Pais paisMaisProx = maisProximoAparente;

        //Calcular a distância a cada um
        for (Pais p : paisesMaisProximos) {
            coordenadasMaisProximoAparente[0] = p.getLatitude();
            coordenadasMaisProximoAparente[1] = p.getLongitude();
            dist = kdtree.calcularDistanciaEntreCoordenadas(coordenadasDadas, coordenadasMaisProximoAparente);

            if (dist < distanciaMin) {
                distanciaMin = dist;
                paisMaisProx = p;
            }
        }
        return paisMaisProx;

    }

    //Exercicio 2d
    public LinkedList<Pais> pesquisaGeo(double lat1, double long1, double lat2, double long2) {
        return kdtree.pesquisaGeo(lat1, long1, lat2, long2);

    }
}
