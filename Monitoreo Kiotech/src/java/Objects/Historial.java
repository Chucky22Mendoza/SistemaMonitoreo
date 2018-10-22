/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Jesús Mendoza
 */
public class Historial {
    private int id;
    private String fechaHora;
    private String tipoAlerta;
    private String mensaje;
    private int kiosco;

    public Historial() {
    }

    public Historial(int id, String fechaHora, String tipoAlerta, String mensaje, int kiosco) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.tipoAlerta = tipoAlerta;
        this.mensaje = mensaje;
        this.kiosco = kiosco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getKiosco() {
        return kiosco;
    }

    public void setKiosco(int kiosco) {
        this.kiosco = kiosco;
    }
    
}
