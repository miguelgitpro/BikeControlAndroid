package com.jrivera.bikecontrolandroid.components;

/**
 * Created by ANDRES on 28-08-2016.
 */
public class CardViews {
    private int imagen;
    private String minutos;
    private String fechayhora;

    public CardViews(int imagen, String minutos, String fechayhora) {
        this.imagen = imagen;
        this.minutos = minutos;
        this.fechayhora = fechayhora;
    }

    public String getMinutos() {
        return minutos;
    }

    public String getFechayhora() {
        return fechayhora;
    }

    public int getImagen() {
        return imagen;
    }
}

