/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf_parte_3;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import java.io.IOException;

/**
 *
 * @author Utilizador
 */
public class Pais implements Comparable<Pais> {

    private String nome;
    private String continente;
    private double populacao;
    private String capital;
    private double longitude;
    private double latitude;
    private Set<Pais> fronteiras;
    private int numFront;

    /**
     * Constructor completo
     *
     * @param nome nome do país
     * @param continente continente a que o país pertence
     * @param populacao população do país
     * @param Capital capital do país
     * @param longitude longitude do país
     * @param latitude latitude do país
     */
    public Pais(String nome, String continente, double populacao, String Capital, double latitude, double longitude) throws IOException {
        this.nome = nome;
        this.continente = continente;
        this.populacao = populacao;
        this.capital = Capital;
        this.longitude = longitude;
        this.latitude = latitude;
        this.fronteiras = new TreeSet<>();
        this.numFront = 0;

    }

    public Set<Pais> getFronteiras() {
        return fronteiras;
    }

    public void setFronteiras(Set<Pais> fronteiras) {
        this.fronteiras = fronteiras;
    }

    public void addFronteiras(Pais fronteira) {
        this.fronteiras.add(fronteira);
    }

    public int getNumFront() {
        return numFront;
    }

    public void setNumFront(int numFront) {
        this.numFront = numFront;
    }

    /**
     * Método que devolve o nome do país
     *
     * @return nome do país
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que devolve o continente a que o país pertence
     *
     * @return continente
     */
    public String getContinente() {
        return continente;
    }

    /**
     * Método que devolve a população do país
     *
     * @return população do país
     */
    public double getPopulacao() {
        return populacao;
    }

    /**
     * Método que devolve a capital do país
     *
     * @return capital do país
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Método que devolve a longitude do país
     *
     * @return longitude do país
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Método que devolve a latitude do país
     *
     * @return latitude do país
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Método que altera o nome do país
     *
     * @param nome novo nome do país
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que altera o continente do país
     *
     * @param continente a que o país pertence
     */
    public void setContinente(String continente) {
        this.continente = continente;
    }

    /**
     * Método que altera a população existente no país
     *
     * @param populacao do país
     */
    public void setPopulacao(double populacao) {
        this.populacao = populacao;
    }

    /**
     * Método que altera a capital do país
     *
     * @param capital do país
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * Método que altera a longitude do páis
     *
     * @param longitude do país
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Método que altera a latitude do país
     *
     * @param latitude do país
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
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
        Pais pais = (Pais) o;
        return nome.equals(pais.nome)
                && continente.equals(pais.continente)
                && capital.equals(pais.capital)
                && (populacao == pais.populacao)
                && (longitude == pais.longitude)
                && (latitude == pais.latitude);
    }

    /**
     * Método que devolve o hashCode do objecto como um inteiro
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, continente, capital, populacao, longitude, latitude);
    }

    @Override
    public String toString() {
        //return "Pais: " + nome + "| Nº Fronteiras: " + numFront + "| Populacao: " + populacao;
        return "Pais: " + this.nome + "| Latitude: " + this.latitude + "| Longitude " + this.longitude;

    }

    @Override
    public int compareTo(Pais o) {
        return o.getNome().compareTo(this.nome);
    }

}
