
package com.monitoreo.server.model.objects;

/**
 *
 * @author nipan
 */
public class Kiosco {

  
    private int id_kisoco;
    private String nombre;
    private boolean status;

    public Kiosco(int id_kisoco, String nombre, boolean status) {
        this.id_kisoco = id_kisoco;
        this.nombre = nombre;
        this.status = status;
    }

    public Kiosco() {
     
    }

    public int getId_kisoco() {
        return id_kisoco;
    }

    public void setId_kisoco(int id_kisoco) {
        this.id_kisoco = id_kisoco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


   
}
