/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.objects.controller.Archivo;
import com.objects.controller.ListaReproduccion;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Jesús Mendoza
 */
public class UpdatePlayList {
        //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public UpdatePlayList(){
        this.dbSource = new ConnectionDB();
    }
    
    public int actualizarLista(ListaReproduccion editLista){

    String sql ="Update lista_reproduccion set nombre=?, descripcion=? where id_lista_reproduccion=?;";
    
    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement actualizarLista= dbConnection.prepareCall(sql);
           )            
        {
     
      dbConnection.setAutoCommit(false);
      //Variables de Entrada (IN)
      //System.err.println("Preparando llamada a PostgreSQL. ---> ");
      actualizarLista.setString(1, editLista.getNombre());
      actualizarLista.setString(2, editLista.getDescripcion());
      actualizarLista.setInt(3,editLista.getId());
      
      int res = actualizarLista.executeUpdate();
        
      //System.err.println("<------------------------------------------------ !!!!  " + res);
      
      if(res == 1){
          //Finalizamos la transaccion
          dbConnection.commit();
        //  System.err.println("Llamada a PostgreSQL finalizada.");
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
