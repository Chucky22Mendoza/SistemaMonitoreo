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
    private int id_denominacion;
    private float valor;
    private String tipo;
    private int cantidad_min;

    public denominacion() {
    }

    public denominacion(int id_denominacion, float valor, String tipo, int cantidad_min) {
        this.id_denominacion = id_denominacion;
        this.valor = valor;
        this.tipo = tipo;
        this.cantidad_min = cantidad_min;
    }

    public int getId_denominacion() {
        return id_denominacion;
    }

    public void setId_denominacion(int id_denominacion) {
        this.id_denominacion = id_denominacion;
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
