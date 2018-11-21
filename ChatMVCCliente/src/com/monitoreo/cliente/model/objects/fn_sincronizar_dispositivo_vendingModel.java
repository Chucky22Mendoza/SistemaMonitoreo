/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.cliente.model.objects;

/**
 *
 * @author Jesús Mendoza
 */
public class fn_sincronizar_dispositivo_vendingModel {
    private int id_dispositivo_vending;
    private String nombre;

    public fn_sincronizar_dispositivo_vendingModel() {
    }

    public fn_sincronizar_dispositivo_vendingModel(int id_dispositivo_vending, String nombre) {
        this.id_dispositivo_vending = id_dispositivo_vending;
        this.nombre = nombre;
    }

    public int getId_dispositivo_vending() {
        return id_dispositivo_vending;
    }

    public void setId_dispositivo_vending(int id_dispositivo_vending) {
        this.id_dispositivo_vending = id_dispositivo_vending;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
