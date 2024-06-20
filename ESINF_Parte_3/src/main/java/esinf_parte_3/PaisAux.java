/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf_parte_3;

import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Utilizador
 */
public class PaisAux implements Comparable<PaisAux> {

    private Pais p;
    private String nome;
    private String continente;
    private double populacao;
    private String capital;
    private double longitude;
    private double latitude;
    private int numFront;
    private Set<Pais> fronteiras;

    public PaisAux(Pais p) {
        this.p = p;
        nome = p.getNome();
        continente = p.getContinente();
        populacao = p.getPopulacao();
        capital = p.getCapital();
        longitude = p.getLongitude();
        latitude = p.getLatitude();
        numFront = p.getNumFront();
        fronteiras = p.getFronteiras();
    }

    @Override
    public String toString() {
        return "Pais: " + this.p.getNome();
    }

    @Override
    public int compareTo(PaisAux p) {

//        if (this.p.getNumFront() == p.p.getNumFront()) {
//            return Double.compare(this.p.getPopulacao(), p.p.getPopulacao());
//        }
//
//        return p.p.getNumFront() - this.p.getNumFront();
//    }
        return (this.p.getNumFront() == p.p.getNumFront()) ? -(int) ((this.p.getPopulacao() - p.p.getPopulacao()) * 1000000) : this.p.getNumFront() - p.p.getNumFront();

    }

    /**
     * Método que compara um objecto desta classe com um objecto passado por
     * parâmetro
     *
     * @param o objecto recebido e que vai ser comparado com o desta classe
     * @return true ou false, dependendo de ser igual ao objecto recebido ou
     * não, respectivamente
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaisAux pais = (PaisAux) o;
        return p.getNome().equals(pais.nome)
                && p.getContinente().equals(pais.continente)
                && p.getCapital().equals(pais.capital)
                && (p.getPopulacao() == pais.populacao)
                && (p.getLongitude() == pais.longitude)
                && (p.getLatitude() == pais.latitude);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.p);
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.continente);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.populacao) ^ (Double.doubleToLongBits(this.populacao) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.capital);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        return hash;
    }
}
