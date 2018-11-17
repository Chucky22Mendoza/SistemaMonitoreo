/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.objects.controller.IdArchivo;
import com.objects.controller.ListaReproduccion;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Jesús Mendoza
 */
public class DeletePlayList {
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public DeletePlayList(){
        this.dbSource = new ConnectionDB();
    }
    
    public int borrarLista(ListaReproduccion id){

    String sql ="DELETE FROM lista_reproduccion WHERE id_lista_reproduccion = ?;";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement borrarLista= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
        borrarLista.setInt(1, id.getId());

        int res = borrarLista.executeUpdate();

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
