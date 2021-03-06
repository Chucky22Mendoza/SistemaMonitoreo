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
public class fn_registrar_corte_cajaModel {
    private int id_corte_caja;
    private Timestamp fecha_hora;
    private int id_kiosco;

    public fn_registrar_corte_cajaModel() {
    }

    public fn_registrar_corte_cajaModel(int id_corte_caja, Timestamp fecha_hora, int id_kiosco) {
        this.id_corte_caja = id_corte_caja;
        this.fecha_hora = fecha_hora;
        this.id_kiosco = id_kiosco;
    }

    public int getId_corte_caja() {
        return id_corte_caja;
    }

    public void setId_corte_caja(int id_corte_caja) {
        this.id_corte_caja = id_corte_caja;
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
    
}
