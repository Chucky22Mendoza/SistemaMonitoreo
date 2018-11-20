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
public class fn_sincronizar_permiso_alerta_kioscoModel {
    private int id_permiso_alerta_kiosco;
    private int id_kiosco;
    private int id_usuario;

    public fn_sincronizar_permiso_alerta_kioscoModel() {
    }

    public fn_sincronizar_permiso_alerta_kioscoModel(int id_permiso_alerta_kiosco, int id_kiosco, int id_usuario) {
        this.id_permiso_alerta_kiosco = id_permiso_alerta_kiosco;
        this.id_kiosco = id_kiosco;
        this.id_usuario = id_usuario;
    }

    public int getId_permiso_alerta_kiosco() {
        return id_permiso_alerta_kiosco;
    }

    public void setId_permiso_alerta_kiosco(int id_permiso_alerta_kiosco) {
        this.id_permiso_alerta_kiosco = id_permiso_alerta_kiosco;
    }

    public int getId_kiosco() {
        return id_kiosco;
    }

    public void setId_kiosco(int id_kiosco) {
        this.id_kiosco = id_kiosco;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
