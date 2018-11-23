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
public class Contenedor_Actual {
    private String nombre;
    private int cantidad_actual;
    private int cantidad_total;

    public Contenedor_Actual() {
    }

    public Contenedor_Actual(String nombre, int cantidad_actual, int cantidad_total) {
        this.nombre = nombre;
        this.cantidad_actual = cantidad_actual;
        this.cantidad_total = cantidad_total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad_actual() {
        return cantidad_actual;
    }

    public void setCantidad_actual(int cantidad_actual) {
        this.cantidad_actual = cantidad_actual;
    }

    public int getCantidad_total() {
        return cantidad_total;
    }

    public void setCantidad_total(int cantidad_total) {
        this.cantidad_total = cantidad_total;
    }
    
    
}
