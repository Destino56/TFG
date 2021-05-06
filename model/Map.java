package model;

import java.util.ArrayList;

public class Map {

    private int numPiso;
    private String nombrePiso;
    private int numMapa;
    private ArrayList<Sala> arrSalas;

    public int getNumPiso() {
        return numPiso;
    }

    public void setNumPiso(int numPiso) {
        this.numPiso = numPiso;
    }

    public String getNombrePiso() {
        return nombrePiso;
    }

    public void setNombrePiso(String nombrePiso) {
        this.nombrePiso = nombrePiso;
    }

    public int getNumMapa() {
        return numMapa;
    }

    public void setNumMapa(int numMapa) {
        this.numMapa = numMapa;
    }

    public ArrayList<Sala> getArrSalas() {
        return arrSalas;
    }

    public void setArrSalas(ArrayList<Sala> arrSalas) {
        this.arrSalas = arrSalas;
    }
}
