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
public class Disp_Vending {
    private int id_disp_vend;
    private String nombre;
    private boolean status;

    public Disp_Vending() {
    }

    public Disp_Vending(int id_disp_vend, String nombre, boolean status) {
        this.id_disp_vend = id_disp_vend;
        this.nombre = nombre;
        this.status = status;
    }

    public int getId_disp_vend() {
        return id_disp_vend;
    }

    public void setId_disp_vend(int id_disp_vend) {
        this.id_disp_vend = id_disp_vend;
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
    
    
}
