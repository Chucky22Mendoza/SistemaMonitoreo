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

    public archivoVideo(int duracion, String ubicacion) {
        this.duracion = duracion;
        this.ubicacion = ubicacion;
    }
    
    public archivoVideo(){        
    }
}
