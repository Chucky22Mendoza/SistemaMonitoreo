/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getData;

import Model.ConnectionDB;
import Objects.Archivo;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Jesús Mendoza
 * 
 * AGREGAR UN ARCHIVO EN LA BASE DE DATOS AL RECIBIR LOS PARAMETROS DEL CONTROLADOR
 */
public class NewFile {
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public NewFile(){
        this.dbSource = new ConnectionDB();
    }
    
    public int nuevoArchivo(Archivo archivo){
    
    String sql ="{call fn_insert_archivos(?,?,?,?)}";
    //String sql ="INSERT INTO archivo(idarchivo, nombre, tipo, duracion, ubicacion)  VALUES(default,?,?,?,?);";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevoArchivo= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
            //System.err.println("fn_insert_archivos('"+archivo.getNombre()+"'," + archivo.getDuracion()+",'"+archivo.getUbicacion()+"','"+archivo.getTipo()+"')");
        //System.err.println("--------------" + archivo.getTipo());
        nuevoArchivo.setString(1, archivo.getNombre());
        nuevoArchivo.setInt(2, archivo.getDuracion());
        nuevoArchivo.setString(3, archivo.getUbicacion());
        nuevoArchivo.setString(4, archivo.getTipo());

        boolean res = nuevoArchivo.execute();

        //System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res){
            //Finalizamos la transaccion
            dbConnection.commit();
            //System.err.println("Llamada a PostgreSQL finalizada.");
            return 1;
        }else{
            //Si hubo un error, cancelamos la transaccion.
            dbConnection.rollback();
            return 0;
        }

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          return 0;
      }
    
    }
}
