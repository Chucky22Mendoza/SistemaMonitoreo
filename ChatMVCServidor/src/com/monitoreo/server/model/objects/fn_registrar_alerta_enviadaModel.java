/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.server.model.objects;

import java.sql.Timestamp;

/**
 *
 * @author Jesús Mendoza
 */
public class fn_registrar_alerta_enviadaModel {
    private int id_alerta_enviada;
    private Timestamp fecha_hora;
    private String emisor;
    private boolean correo_enviado;
    private boolean sms_enviado;
    private int id_usuario;
    private int id_historial_alerta;
    private int id_kiosco;

    public fn_registrar_alerta_enviadaModel() {
    }

    public fn_registrar_alerta_enviadaModel(int id_alerta_enviada, Timestamp fecha_hora, String emisor, boolean correo_enviado, boolean sms_enviado, int id_usuario, int id_historial_alerta, int id_kiosco) {
        this.id_alerta_enviada = id_alerta_enviada;
        this.fecha_hora = fecha_hora;
        this.emisor = emisor;
        this.correo_enviado = correo_enviado;
        this.sms_enviado = sms_enviado;
        this.id_usuario = id_usuario;
        this.id_historial_alerta = id_historial_alerta;
        this.id_kiosco = id_kiosco;
    }

    public int getId_alerta_enviada() {
        return id_alerta_enviada;
    }

    public void setId_alerta_enviada(int id_alerta_enviada) {
        this.id_alerta_enviada = id_alerta_enviada;
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
    
    
}
