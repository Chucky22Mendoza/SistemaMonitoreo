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
public class Impresora {
    private String nombre;
    private int folio_inicial;
    private int folio_final;
    private int total;

    public Impresora() {
    }

    public Impresora(String nombre, int folio_inicial, int folio_final, int total) {
        this.nombre = nombre;
        this.folio_inicial = folio_inicial;
        this.folio_final = folio_final;
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFolio_inicial() {
        return folio_inicial;
    }

    public void setFolio_inicial(int folio_inicial) {
        this.folio_inicial = folio_inicial;
    }

    public int getFolio_final() {
        return folio_final;
    }

    public void setFolio_final(int folio_final) {
        this.folio_final = folio_final;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
