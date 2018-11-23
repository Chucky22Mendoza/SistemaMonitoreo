/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.objects.controller;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class Denom_Dispensada {
    private int cantidad_total;
    private String nombre;
    private int cantidad_minima;

    public Denom_Dispensada() {
    }

    public Denom_Dispensada(int cantidad_total, String nombre, int cantidad_minima) {
        this.cantidad_total = cantidad_total;
        this.nombre = nombre;
        this.cantidad_minima = cantidad_minima;
    }

    public int getCantidad_total() {
        return cantidad_total;
    }

    public void setCantidad_total(int cantidad_total) {
        this.cantidad_total = cantidad_total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(int cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }
    
    
}
