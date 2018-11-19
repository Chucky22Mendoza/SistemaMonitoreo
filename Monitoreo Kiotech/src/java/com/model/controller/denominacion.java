/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.model.controller;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class denominacion {
    private int id_denonominacion;
    private float valor;
    private String tipo;
    private int cantidad_min;

    public denominacion() {
    }

    public denominacion(int id_denonominacion, float valor, String tipo, int cantidad_min) {
        this.id_denonominacion = id_denonominacion;
        this.valor = valor;
        this.tipo = tipo;
        this.cantidad_min = cantidad_min;
    }

    public int getId_denonominacion() {
        return id_denonominacion;
    }

    public void setId_denonominacion(int id_denonominacion) {
        this.id_denonominacion = id_denonominacion;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad_min() {
        return cantidad_min;
    }

    public void setCantidad_min(int cantidad_min) {
        this.cantidad_min = cantidad_min;
    }
    
    
}
