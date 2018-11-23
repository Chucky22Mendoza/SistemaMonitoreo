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
public class Kiosco_Agencia {
    private int id_kiosco;
    private String nombre;
    private int id_agencia;
    private int id_status;

    public Kiosco_Agencia() {
    }

    public Kiosco_Agencia(int id_kiosco, String nombre, int id_agencia, int id_status) {
        this.id_kiosco = id_kiosco;
        this.nombre = nombre;
        this.id_agencia = id_agencia;
        this.id_status = id_status;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(int id_agencia) {
        this.id_agencia = id_agencia;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    
}
