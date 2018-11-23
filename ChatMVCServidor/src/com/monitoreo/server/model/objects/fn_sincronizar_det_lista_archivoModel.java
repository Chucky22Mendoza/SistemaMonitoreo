/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.server.model.objects;

/**
 *
 * @author Jesús Mendoza
 */
public class fn_sincronizar_det_lista_archivoModel {
    private int id_lista_reproduccion_archivo;
    private int orden;
    private int id_lista;
    private int id_archivo;

    public fn_sincronizar_det_lista_archivoModel() {
    }

    public fn_sincronizar_det_lista_archivoModel(int id_lista_reproduccion_archivo, int orden, int id_lista, int id_archivo) {
        this.id_lista_reproduccion_archivo = id_lista_reproduccion_archivo;
        this.orden = orden;
        this.id_lista = id_lista;
        this.id_archivo = id_archivo;
    }

    public int getId_lista_reproduccion_archivo() {
        return id_lista_reproduccion_archivo;
    }

    public void setId_lista_reproduccion_archivo(int id_lista_reproduccion_archivo) {
        this.id_lista_reproduccion_archivo = id_lista_reproduccion_archivo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public int getId_archivo() {
        return id_archivo;
    }

    public void setId_archivo(int id_archivo) {
        this.id_archivo = id_archivo;
    }

    
}
