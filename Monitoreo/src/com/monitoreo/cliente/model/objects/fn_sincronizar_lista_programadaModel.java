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
public class fn_sincronizar_lista_programadaModel {
    private int id_lista_programada;
    private Timestamp hora_inicio;
    private boolean domingo;
    private boolean lunes;
    private boolean martes;
    private boolean miercoles;
    private boolean jueves;
    private boolean viernes;
    private boolean sabado;
    private int id_kiosco;
    private int id_lista;

    public fn_sincronizar_lista_programadaModel() {
    }

    public fn_sincronizar_lista_programadaModel(int id_lista_programada, Timestamp hora_inicio, boolean domingo, boolean lunes, boolean martes, boolean miercoles, boolean jueves, boolean viernes, boolean sabado, int id_kiosco, int id_lista) {
        this.id_lista_programada = id_lista_programada;
        this.hora_inicio = hora_inicio;
        this.domingo = domingo;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.id_kiosco = id_kiosco;
        this.id_lista = id_lista;
    }

    public int getId_lista_programada() {
        return id_lista_programada;
    }

    public void setId_lista_programada(int id_lista_programada) {
        this.id_lista_programada = id_lista_programada;
    }

    public Timestamp getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Timestamp hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public boolean isDomingo() {
        return domingo;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    public boolean isLunes() {
        return lunes;
    }

    public void setLunes(boolean lunes) {
        this.lunes = lunes;
    }

    public boolean isMartes() {
        return martes;
    }

    public void setMartes(boolean martes) {
        this.martes = martes;
    }

    public boolean isMiercoles() {
        return miercoles;
    }

    public void setMiercoles(boolean miercoles) {
        this.miercoles = miercoles;
    }

    public boolean isJueves() {
        return jueves;
    }

    public void setJueves(boolean jueves) {
        this.jueves = jueves;
    }

    public boolean isViernes() {
        return viernes;
    }

    public void setViernes(boolean viernes) {
        this.viernes = viernes;
    }

    public boolean isSabado() {
        return sabado;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    
}
