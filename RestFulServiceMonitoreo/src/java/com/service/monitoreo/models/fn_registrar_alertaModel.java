/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.service.monitoreo.models;

import java.sql.Timestamp;

/**
 *
 * @author Jesús Mendoza
 */
public class fn_registrar_alertaModel {
    private int id_historial_alerta;
    private String mensaje;
    private Timestamp fecha_hora;
    private boolean status;
    private int id_evento;
    private int id_kiosco;

    public fn_registrar_alertaModel() {
    }

    public fn_registrar_alertaModel(int id_historial_alerta, String mensaje, Timestamp fecha_hora, boolean status, int id_evento, int id_kiosco) {
        this.id_historial_alerta = id_historial_alerta;
        this.mensaje = mensaje;
        this.fecha_hora = fecha_hora;
        this.status = status;
        this.id_evento = id_evento;
        this.id_kiosco = id_kiosco;
    }

    public int getId_historial_alerta() {
        return id_historial_alerta;
    }

    public void setId_historial_alerta(int id_historial_alerta) {
        this.id_historial_alerta = id_historial_alerta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    
}
