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
public class Kiosco_Gen {
    private int id_kiosco;
    private String nombre;
    private String agencia;
    private String ubicacion;
    private String ip;
    private int id_status;

    public Kiosco_Gen() {
    }

    public Kiosco_Gen(int id_kiosco, String nombre, String agencia, String ubicacion, String ip, int id_status) {
        this.id_kiosco = id_kiosco;
        this.nombre = nombre;
        this.agencia = agencia;
        this.ubicacion = ubicacion;
        this.ip = ip;
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

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }
    
    
}
