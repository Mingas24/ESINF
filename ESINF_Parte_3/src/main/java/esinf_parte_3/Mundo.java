/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf_parte_3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Utilizador
 */
public class Mundo {

    Map<Pais, Set<Pais>> m;

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
    }

    public Map<Pais, Set<Pais>> getMap() {
        return this.m;
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

    /**
     * Método para obter um Set com as fronteiras de um país passado por
     * parâmetro
     *
     * @param nome do país do qual queremos obter as fronteiras
     * @return lista de fronteiras desse país
     */
    public Set<Pais> getFronteiraByPais(String nome) {
        for (Pais p : m.keySet()) {
            if (nome.equalsIgnoreCase(p.getNome())) {
                p.setFronteiras(m.get(p));
                return m.get(p);
            }

        }
        return null;
    }

    /**
     * Método que obtém o número de fronteiras de um país passado por parâmetro
     *
     * @param nome do país do qual queremos obter o número de fronteiras
     * @return número de fronteiras desse país
     */
    public int getnumFrontByPais(String nome) {
        for (Pais p : m.keySet()) {
            if (nome.equalsIgnoreCase(p.getNome())) {
                p.setNumFront(m.get(p).size());
                return m.get(p).size();
            }
        }
        return -1;
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

}
