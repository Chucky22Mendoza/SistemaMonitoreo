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
public class ListasArchivos {
    private int idLista;
    private int idArchivo;
    private int orden;

    public ListasArchivos() {
    }

    public ListasArchivos(int idLista, int idArchivo, int orden) {
        this.idLista = idLista;
        this.idArchivo = idArchivo;
        this.orden = orden;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public int getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
    
    
}
