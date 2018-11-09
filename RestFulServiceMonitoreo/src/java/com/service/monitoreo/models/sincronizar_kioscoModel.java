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
public class sincronizar_kioscoModel {
    private int id_kiosco;
    private String nombre;
    private boolean status_mantenimiento;
    private String ip;
    private int id_status;
    private int id_agencia;
    private int id_configuracion_envio;

    public sincronizar_kioscoModel() {
    }

    public sincronizar_kioscoModel(int id_kiosco, String nombre, boolean status_mantenimiento, String ip, int id_status, int id_agencia, int id_configuracion_envio) {
        this.id_kiosco = id_kiosco;
        this.nombre = nombre;
        this.status_mantenimiento = status_mantenimiento;
        this.ip = ip;
        this.id_status = id_status;
        this.id_agencia = id_agencia;
        this.id_configuracion_envio = id_configuracion_envio;
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

    public boolean isStatus_mantenimiento() {
        return status_mantenimiento;
    }

    public void setStatus_mantenimiento(boolean status_mantenimiento) {
        this.status_mantenimiento = status_mantenimiento;
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

    public int getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(int id_agencia) {
        this.id_agencia = id_agencia;
    }

    public int getId_configuracion_envio() {
        return id_configuracion_envio;
    }

    public void setId_configuracion_envio(int id_configuracion_envio) {
        this.id_configuracion_envio = id_configuracion_envio;
    }
    
    
}
