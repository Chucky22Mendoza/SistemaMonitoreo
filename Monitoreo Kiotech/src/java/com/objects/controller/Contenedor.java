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
public class Contenedor {
    private int id_contenedor;
    private String nombre;
    private int cantidad_maxima;

    public Contenedor() {
    }

    public Contenedor(int id_contenedor, String nombre, int cantidad_maxima) {
        this.id_contenedor = id_contenedor;
        this.nombre = nombre;
        this.cantidad_maxima = cantidad_maxima;
    }

    public int getId_contenedor() {
        return id_contenedor;
    }

    public void setId_contenedor(int id_contenedor) {
        this.id_contenedor = id_contenedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad_maxima() {
        return cantidad_maxima;
    }

    public void setCantidad_maxima(int cantidad_maxima) {
        this.cantidad_maxima = cantidad_maxima;
    }
    
    
}
