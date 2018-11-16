/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.service.monitoreo.models;

/**
 *
 * @author Jesús Mendoza
 */
public class fn_sincronizar_dispositivo_vending_kioscoModel {
    private int id_dispositivo_vending_kiosco;
    private boolean status;
    private int id_kiosco;
    private int id_dispositivo_vending;

    public fn_sincronizar_dispositivo_vending_kioscoModel() {
    }

    public fn_sincronizar_dispositivo_vending_kioscoModel(int id_dispositivo_vending_kiosco, boolean status, int id_kiosco, int id_dispositivo_vending) {
        this.id_dispositivo_vending_kiosco = id_dispositivo_vending_kiosco;
        this.status = status;
        this.id_kiosco = id_kiosco;
        this.id_dispositivo_vending = id_dispositivo_vending;
    }

    public int getId_dispositivo_vending_kiosco() {
        return id_dispositivo_vending_kiosco;
    }

    public void setId_dispositivo_vending_kiosco(int id_dispositivo_vending_kiosco) {
        this.id_dispositivo_vending_kiosco = id_dispositivo_vending_kiosco;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    public int getId_dispositivo_vending() {
        return id_dispositivo_vending;
    }

    public void setId_dispositivo_vending(int id_dispositivo_vending) {
        this.id_dispositivo_vending = id_dispositivo_vending;
    }
    
}
