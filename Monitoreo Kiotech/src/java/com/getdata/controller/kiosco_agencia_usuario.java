/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.model.controller.denominacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class kiosco_agencia_usuario {
    
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public kiosco_agencia_usuario(){
        this.dbSource = new ConnectionDB();
    }
    
    public List<Integer> obtenerKioscoAgencia(int id_usuario){
        List<Integer> listKiosco = new ArrayList<>();
        String sql ="select * from vw_kiosco_agencia_usuario where id_usuario = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement kiosco = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          kiosco.setInt(1, id_usuario);
          kiosco.execute();
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet kioscoRS =(ResultSet)kiosco.getResultSet(); ){
              while(kioscoRS.next())
                {
                  
                    int kio = kioscoRS.getInt(2);
                    
                    listKiosco.add(kio);
                }
            // System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return listKiosco;
    }
}
