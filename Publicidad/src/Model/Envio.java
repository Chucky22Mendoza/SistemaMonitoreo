package Model;

public class Envio {

    /**
     * @return the posicion
     */
    public static int getPosicion() {
        return posicion;
    }

    /**
     * @param aPosicion the posicion to set
     */
    public static void setPosicion(int aPosicion) {
        posicion = aPosicion;
    }

    /**
     * @return the tamaño
     */
    public static int getTamaño() {
        return tamaño;
    }

    /**
     * @param aTamaño the tamaño to set
     */
    public static void setTamaño(int aTamaño) {
        tamaño = aTamaño;
    }

    /**
     * @return the alto
     */
    public static int getAlto() {
        return alto;
    }

    /**
     * @param aAlto the alto to set
     */
    public static void setAlto(int aAlto) {
        alto = aAlto;
    }

    public static int getAncho() {
        return ancho;
    }

    public static void setAncho(int aAncho) {
        ancho = aAncho;
    }

    public static int ancho;
    public static int alto;
    public static int posicion;
    public static int tamaño;

    //Datos del Correo
    public static String getCorreo() {
        return "controlinventariosandstudio@gmail.com";
    }

    public static String getContrasena() {
        return "controlAndroid";
    }

    public static String Correo;
    public static String Contrasena;

    //Datos para video    
    public static int duracion;

    public static int getDuracion() {
        return duracion;
    }

    public static void setDuracion(int duracion) {
        Envio.duracion = duracion;
    }

    //Id del Kiosko
    public static int kiosko = 1;

    public static int getKiosko() {
        return kiosko;
    }

    //Hora inicial de la lista de reproducción del kiosko correspondiente y el día que es
    public static int horaInicio;
    public static int minutoInicio;

    public static int getHoraInicio() {
        return horaInicio;
    }

    public static void setHoraInicio(int horaInicio) {
        Envio.horaInicio = horaInicio;
    }

    public static int getMinutoInicio() {
        return minutoInicio;
    }

    public static void setMinutoInicio(int minutoInicio) {
        Envio.minutoInicio = minutoInicio;
    }
    
    public static String dia;

    public static String getDia() {
        return dia;
    }

    public static void setDia(String dia) {
        Envio.dia = dia;
    }
}
