package Model;

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
