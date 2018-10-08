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

    String sql ="INSERT INTO archivo(idarchivo, nombre, tipo, duracion)  VALUES(default,?,?,?);";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevoArchivo= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        System.err.println("Preparando llamada a PostgreSQL. ---> ");
        nuevoArchivo.setString(1, archivo.getNombre());
        nuevoArchivo.setString(2, archivo.getTipo());
        nuevoArchivo.setInt(3, archivo.getDuracion());

        int res = nuevoArchivo.executeUpdate();

        System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res == 1){
            //Finalizamos la transaccion
            dbConnection.commit();
            System.err.println("Llamada a PostgreSQL finalizada.");
            return res;
        }else{
            //Si hubo un error, cancelamos la transaccion.
            dbConnection.rollback();
            return res;
        }

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          return 0;
      }
    
    }
}
