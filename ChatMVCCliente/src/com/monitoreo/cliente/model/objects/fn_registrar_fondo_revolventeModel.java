/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.cliente.model.objects;

import java.sql.Timestamp;

/**
 *
 * @author Jesús Mendoza
 */
public class fn_registrar_fondo_revolventeModel {
    private int id_fondo_revolvente;
    private Timestamp fecha_hora;
    private int id_kiosco;
    private int denominaciones[][];

    public fn_registrar_fondo_revolventeModel() {
    }

    public fn_registrar_fondo_revolventeModel(int id_fondo_revolvente, Timestamp fecha_hora, int id_kiosco, int[][] denominaciones) {
        this.id_fondo_revolvente = id_fondo_revolvente;
        this.fecha_hora = fecha_hora;
        this.id_kiosco = id_kiosco;
        this.denominaciones = denominaciones;
    }

    public int getId_fondo_revolvente() {
        return id_fondo_revolvente;
    }

    public void setId_fondo_revolvente(int id_fondo_revolvente) {
        this.id_fondo_revolvente = id_fondo_revolvente;
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    public int[][] getDenominaciones() {
        return denominaciones;
    }

    public void setDenominaciones(int[][] denominaciones) {
        this.denominaciones = denominaciones;
    }
    
}
