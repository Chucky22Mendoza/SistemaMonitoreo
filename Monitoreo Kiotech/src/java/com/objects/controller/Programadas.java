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
public class Programadas {
    private int id_kiosco;
    private String nombreKiosco;
    private String agencia;
    private int id_lista_reproduccion;
    private String nombreLista;
    private String hora_inicio;
    private boolean d;
    private boolean l;
    private boolean ma;
    private boolean mi;
    private boolean j;
    private boolean v;
    private boolean s;

    public Programadas() {
    }

    public Programadas(int id_kiosco, String nombreKiosco, String agencia, int id_lista_reproduccion, String nombreLista, String hora_inicio, boolean d, boolean l, boolean ma, boolean mi, boolean j, boolean v, boolean s) {
        this.id_kiosco = id_kiosco;
        this.nombreKiosco = nombreKiosco;
        this.agencia = agencia;
        this.id_lista_reproduccion = id_lista_reproduccion;
        this.nombreLista = nombreLista;
        this.hora_inicio = hora_inicio;
        this.d = d;
        this.l = l;
        this.ma = ma;
        this.mi = mi;
        this.j = j;
        this.v = v;
        this.s = s;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    public String getNombreKiosco() {
        return nombreKiosco;
    }

    public void setNombreKiosco(String nombreKiosco) {
        this.nombreKiosco = nombreKiosco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public int getId_lista_reproduccion() {
        return id_lista_reproduccion;
    }

    public void setId_lista_reproduccion(int id_lista_reproduccion) {
        this.id_lista_reproduccion = id_lista_reproduccion;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public boolean isD() {
        return d;
    }

    public void setD(boolean d) {
        this.d = d;
    }

    public boolean isL() {
        return l;
    }

    public void setL(boolean l) {
        this.l = l;
    }

    public boolean isMa() {
        return ma;
    }

    public void setMa(boolean ma) {
        this.ma = ma;
    }

    public boolean isMi() {
        return mi;
    }

    public void setMi(boolean mi) {
        this.mi = mi;
    }

    public boolean isJ() {
        return j;
    }

    public void setJ(boolean j) {
        this.j = j;
    }

    public boolean isV() {
        return v;
    }

    public void setV(boolean v) {
        this.v = v;
    }

    public boolean isS() {
        return s;
    }

    public void setS(boolean s) {
        this.s = s;
    }
    
    
    
}
