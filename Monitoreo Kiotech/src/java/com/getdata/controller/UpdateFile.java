/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.objects.controller.Archivo;
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

    String sql ="Update archivo set duracion=? where id_archivo=?;";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement actualizarArchivo= dbConnection.prepareCall(sql);
           )            
        {
      
      dbConnection.setAutoCommit(false);
      //Variables de Entrada (IN)
      //System.err.println("Preparando llamada a PostgreSQL. ---> ");
      actualizarArchivo.setInt(1, editFile.getDuracion());
      actualizarArchivo.setInt(2, editFile.getId());
      int res = actualizarArchivo.executeUpdate();
        
      //System.err.println("<------------------------------------------------ !!!!  " + res);
      
      if(res == 1){
          //Finalizamos la transaccion
          dbConnection.commit();
          //System.err.println("Llamada a PostgreSQL finalizada.");
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
