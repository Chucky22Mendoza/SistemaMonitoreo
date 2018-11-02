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
public class ListaProgramada {
    private String horaInicio;
    private Boolean domingo;
    private Boolean lunes;
    private Boolean martes;
    private Boolean miercoles;
    private Boolean jueves;
    private Boolean viernes;
    private Boolean sabado;
    private int idKiosco;
    private int idLista;

    public ListaProgramada() {
    }

    public ListaProgramada(String horaInicio, Boolean domingo, Boolean lunes, Boolean martes, Boolean miercoles, Boolean jueves, Boolean viernes, Boolean sabado, int idKiosco, int idLista) {
        this.horaInicio = horaInicio;
        this.domingo = domingo;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.idKiosco = idKiosco;
        this.idLista = idLista;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Boolean getDomingo() {
        return domingo;
    }

    public void setDomingo(Boolean domingo) {
        this.domingo = domingo;
    }

    public Boolean getLunes() {
        return lunes;
    }

    public void setLunes(Boolean lunes) {
        this.lunes = lunes;
    }

    public Boolean getMartes() {
        return martes;
    }

    public void setMartes(Boolean martes) {
        this.martes = martes;
    }

    public Boolean getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(Boolean miercoles) {
        this.miercoles = miercoles;
    }

    public Boolean getJueves() {
        return jueves;
    }

    public void setJueves(Boolean jueves) {
        this.jueves = jueves;
    }

    public Boolean getViernes() {
        return viernes;
    }

    public void setViernes(Boolean viernes) {
        this.viernes = viernes;
    }

    public Boolean getSabado() {
        return sabado;
    }

    public void setSabado(Boolean sabado) {
        this.sabado = sabado;
    }

    public int getIdKiosco() {
        return idKiosco;
    }

    public void setIdKiosco(int idKiosco) {
        this.idKiosco = idKiosco;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }
    
    
}
