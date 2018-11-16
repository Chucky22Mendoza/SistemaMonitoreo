/**
 * @author Katia Cortés : katia.cortes.01@gmail.com
 */

package com.service.monitoreo.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que permite la generación y almacenamiento de logs.
 * @author Katia Cortés 
 */
public class Log {
    private static final String DIRECTORIO = "logs/";
    private static final String PREFIJO_NOMBRE_ARCHIVO = "LogManager";

    Date fecha = new Date();
    SimpleDateFormat f = new SimpleDateFormat("h:m:s:S a");    
    
    public static void generarLog(String mensaje) {
        Date fecha = new Date();

        String fechaActual = new SimpleDateFormat("ddMMY").format(fecha);
        String horaActual = new SimpleDateFormat("hh:mm:ss:SSS a").format(fecha);

        String archivo = PREFIJO_NOMBRE_ARCHIVO + fechaActual + ".txt";
        String cadena=horaActual + " -->> " + mensaje + " \r\n";
        
        guardarLog(archivo, cadena);

    }
    
    public static void generarLogError(String referenciaCodigo, String mensaje) {      
        Date fecha = new Date();

        String fechaActual = new SimpleDateFormat("ddMMY").format(fecha);
        String horaActual = new SimpleDateFormat("hh:mm:ss:SSS a").format(fecha);
    
        String archivo = PREFIJO_NOMBRE_ARCHIVO + fechaActual + ".txt";
        String archivoError = PREFIJO_NOMBRE_ARCHIVO+"Error" + fechaActual + ".txt";
  
        String cadena=horaActual + " -->> " + referenciaCodigo + " -> " + mensaje + " \r\n";  
          
        guardarLog(archivo, cadena);
        guardarLog(archivoError, cadena);
       
    }
      
    private static void guardarLog(String archivo, String cadena){   
        try {
            File dir = new File(DIRECTORIO);         
            if(!dir.exists()){
                dir.mkdirs();
            }
            FileWriter output = new FileWriter(DIRECTORIO+archivo, true);
            output.write(cadena);
            output.close();
        } catch (IOException e) {
            System.out.println("Ourrió un error al intentar generar un log: "+e.getMessage());
        }
    }
}