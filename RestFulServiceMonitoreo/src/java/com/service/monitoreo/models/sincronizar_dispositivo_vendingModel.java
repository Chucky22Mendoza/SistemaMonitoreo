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
public class sincronizar_dispositivo_vendingModel {
    private String nombre;
    private boolean status;
    private int id_dispositivo_vending;
    private int id_kiosco;

    public sincronizar_dispositivo_vendingModel() {
    }

    public sincronizar_dispositivo_vendingModel(String nombre, boolean status, int id_dispositivo_vending, int id_kiosco) {
        this.nombre = nombre;
        this.status = status;
        this.id_dispositivo_vending = id_dispositivo_vending;
        this.id_kiosco = id_kiosco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId_dispositivo_vending() {
        return id_dispositivo_vending;
    }

    public void setId_dispositivo_vending(int id_dispositivo_vending) {
        this.id_dispositivo_vending = id_dispositivo_vending;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }
    
    
}
