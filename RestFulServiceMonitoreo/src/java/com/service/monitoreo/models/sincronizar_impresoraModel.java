/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.monitoreo.models;

/**
 *
 * @author Jesús Mendoza
 */
public class sincronizar_impresoraModel {
    private int id_impresora;
    private String nombre;
    private int id_kiosco;

    public sincronizar_impresoraModel() {
    }

    public sincronizar_impresoraModel(int id_impresora, String nombre, int id_kiosco) {
        this.id_impresora = id_impresora;
        this.nombre = nombre;
        this.id_kiosco = id_kiosco;
    }

    public int getId_impresora() {
        return id_impresora;
    }

    public void setId_impresora(int id_impresora) {
        this.id_impresora = id_impresora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }
    
    
}
