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
 * EDITAR UN ARCHIVO EN LA BASE DE DATOS AL RECIBIR LOS PARAMETROS DEL CONTROLADOR
 */
public class UpdateFile {
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public UpdateFile(){
        this.dbSource = new ConnectionDB();
    }
    
    public int actualizarArchivo(Archivo editFile){

    String sql ="Update archivo set nombre=?, tipo=?, duracion=? where idarchivo=?;";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement actualizarArchivo= dbConnection.prepareCall(sql);
           )            
        {
      //fechaestreno,duracion,fecha_registro,fecha_actualizacion
      dbConnection.setAutoCommit(false);
      //Variables de Entrada (IN)
      System.err.println("Preparando llamada a PostgreSQL. ---> ");
      actualizarArchivo.setString(1, editFile.getNombre());
      actualizarArchivo.setString(2, editFile.getTipo());
      actualizarArchivo.setInt(3, editFile.getDuracion());
      actualizarArchivo.setInt(4, editFile.getId());
      int res = actualizarArchivo.executeUpdate();
        
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
