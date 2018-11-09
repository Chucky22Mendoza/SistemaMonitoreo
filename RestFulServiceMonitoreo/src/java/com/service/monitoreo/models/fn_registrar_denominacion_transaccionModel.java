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
public class fn_registrar_denominacion_transaccionModel {
    private int id_transaccion;
    private Timestamp fecha_hora;
    private int denominaciones_recibidas[][];
    private int id_kiosco;
    private int denominaciones_dispensadas[][];

    public fn_registrar_denominacion_transaccionModel() {
    }

    public fn_registrar_denominacion_transaccionModel(int id_transaccion, Timestamp fecha_hora, int[][] denominaciones_recibidas, int id_kiosco, int[][] denominaciones_dispensadas) {
        this.id_transaccion = id_transaccion;
        this.fecha_hora = fecha_hora;
        this.denominaciones_recibidas = denominaciones_recibidas;
        this.id_kiosco = id_kiosco;
        this.denominaciones_dispensadas = denominaciones_dispensadas;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int[][] getDenominaciones_recibidas() {
        return denominaciones_recibidas;
    }

    public void setDenominaciones_recibidas(int[][] denominaciones_recibidas) {
        this.denominaciones_recibidas = denominaciones_recibidas;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    public int[][] getDenominaciones_dispensadas() {
        return denominaciones_dispensadas;
    }

    public void setDenominaciones_dispensadas(int[][] denominaciones_dispensadas) {
        this.denominaciones_dispensadas = denominaciones_dispensadas;
    }

    
}
