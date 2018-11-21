/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.cliente.model.objects;

/**
 *
 * @author Jesús Mendoza
 */
public class fn_actualizar_impresoraModel {
    private int id_impresora;
    private int folio_inicial;
    private int folio_final;
    private int total_folios;
    private int id_kiosco;

    public fn_actualizar_impresoraModel() {
    }

    public fn_actualizar_impresoraModel(int id_impresora, int folio_inicial, int folio_final, int total_folios, int id_kiosco) {
        this.id_impresora = id_impresora;
        this.folio_inicial = folio_inicial;
        this.folio_final = folio_final;
        this.total_folios = total_folios;
        this.id_kiosco = id_kiosco;
    }

    public int getId_impresora() {
        return id_impresora;
    }

    public void setId_impresora(int id_impresora) {
        this.id_impresora = id_impresora;
    }

    public int getFolio_inicial() {
        return folio_inicial;
    }

    public void setFolio_inicial(int folio_inicial) {
        this.folio_inicial = folio_inicial;
    }

    public int getFolio_final() {
        return folio_final;
    }

    public void setFolio_final(int folio_final) {
        this.folio_final = folio_final;
    }

    public int getTotal_folios() {
        return total_folios;
    }

    public void setTotal_folios(int total_folios) {
        this.total_folios = total_folios;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }
    
    
}
