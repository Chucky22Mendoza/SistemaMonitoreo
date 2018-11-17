/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objects.controller;

/**
 *
 * @author Jesús Mendoza
 */
public class Historial {
    private int id;
    private String fechaHora;
    private String tipoAlerta;
    private String mensaje;
    private String kiosco;
    private Boolean status;

    public Historial() {
    }

    public Historial(int id, String fechaHora, String tipoAlerta, String mensaje, String kiosco, Boolean status) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.tipoAlerta = tipoAlerta;
        this.mensaje = mensaje;
        this.kiosco = kiosco;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getKiosco() {
        return kiosco;
    }

    public void setKiosco(String kiosco) {
        this.kiosco = kiosco;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    
    
}
