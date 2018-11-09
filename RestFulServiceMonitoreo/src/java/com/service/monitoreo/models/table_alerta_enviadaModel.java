/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.monitoreo.models;

import java.sql.Timestamp;

/**
 *
 * @author Jesús Mendoza
 */
public class table_alerta_enviadaModel {
    private int id_historial_alerta;
    private int id_kiosco;
    private Timestamp fecha_hora;
    private int id_usuario;
    private boolean correo_enviado;
    private boolean sms_enviado;
    private String emisor;

    public table_alerta_enviadaModel() {
    }

    public table_alerta_enviadaModel(int id_historial_alerta, int id_kiosco, Timestamp fecha_hora, int id_usuario, boolean correo_enviado, boolean sms_enviado, String emisor) {
        this.id_historial_alerta = id_historial_alerta;
        this.id_kiosco = id_kiosco;
        this.fecha_hora = fecha_hora;
        this.id_usuario = id_usuario;
        this.correo_enviado = correo_enviado;
        this.sms_enviado = sms_enviado;
        this.emisor = emisor;
    }

    public int getId_historial_alerta() {
        return id_historial_alerta;
    }

    public void setId_historial_alerta(int id_historial_alerta) {
        this.id_historial_alerta = id_historial_alerta;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isCorreo_enviado() {
        return correo_enviado;
    }

    public void setCorreo_enviado(boolean correo_enviado) {
        this.correo_enviado = correo_enviado;
    }

    public boolean isSms_enviado() {
        return sms_enviado;
    }

    public void setSms_enviado(boolean sms_enviado) {
        this.sms_enviado = sms_enviado;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }
    
    
    
    
}
