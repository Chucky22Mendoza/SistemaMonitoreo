package Model;

import java.sql.Timestamp;

/**
 *
 * @author mario
 */
public class archivoVideo {

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    private int duracion;
    private String ubicacion;
    private String listaReproduccion;
    private String tipo;
    private String nombre;
    private Timestamp hora;
    private Timestamp horaInicio;
        private Timestamp minutosInicio;

    public Timestamp getMinutosInicio() {
        return minutosInicio;
    }

    public void setMinutosInicio(Timestamp minutosInicio) {
        this.minutosInicio = minutosInicio;
    }

    public Timestamp getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getListaReproduccion() {
        return listaReproduccion;
    }

    public void setListaReproduccion(String listaReproduccion) {
        this.listaReproduccion = listaReproduccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public archivoVideo(){        
    }
}
