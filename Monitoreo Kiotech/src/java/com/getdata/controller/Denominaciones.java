/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.model.controller.denominacion;
import com.objects.controller.Historial;
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
public class Denominaciones {
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public Denominaciones(){
        this.dbSource = new ConnectionDB();
    }
    
    public List<denominacion> denominaciones(){
        List<denominacion> denom = new ArrayList<>();
        String sql ="select * from vw_denominaciones";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement obtenerDenom = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          obtenerDenom.execute();
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet denomsRS =(ResultSet)obtenerDenom.getResultSet(); ){
              while(denomsRS.next())
                {

                    denominacion den= new denominacion();
                    den.setCantidad_min(denomsRS.getInt(1));
                    den.setId_denonominacion(denomsRS.getInt(2));
                    den.setValor(denomsRS.getFloat(3));
                    den.setTipo(denomsRS.getString(4));
                    
                    denom.add(den);
                }
            // System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return denom;
    }
    
    public int minFolios(int folio){
        
        String sql ="update impresora set min_folios = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement updateFolio = dbConnection.prepareCall(sql);       )            {
            
          dbConnection.setAutoCommit(false);
          //Variables de Entrada (IN)
          updateFolio.setInt(1, folio);
          int res = updateFolio.executeUpdate();
            //System.err.println(res);
          if(res >= 1){
              dbConnection.commit();
              //System.err.println(res);
              return 1;
          }else{
              dbConnection.rollback();
              return 0;
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return 0;
        }
        
    }
    
    public int minFolios(int folio, int id_kiosco){
        
        String sql ="update impresora set min_folios = ? where id_kiosco = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement updateFolio = dbConnection.prepareCall(sql);       )            {
            
          dbConnection.setAutoCommit(false);
          //Variables de Entrada (IN)
          updateFolio.setInt(1, folio);
          updateFolio.setInt(2, id_kiosco);
          int res = updateFolio.executeUpdate();
            //System.err.println(res);
          if(res >= 1){
              dbConnection.commit();
              //System.err.println(res);
              return 1;
          }else{
              dbConnection.rollback();
              return 0;
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return 0;
        }
        
    }
    
    private int folio;
    public int obtMinFolios(int id){
        
        String sql ="select min_folios from impresora where id_kiosco = ? limit 1";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement selectFolio = dbConnection.prepareCall(sql);       )            {
          //Variables de Entrada (IN)
          //updateFolio.setInt(1, folio);
          selectFolio.setInt(1, id);
          selectFolio.execute();
            //System.err.println(res);
          try(  ResultSet folioRS =(ResultSet)selectFolio.getResultSet(); ){
              while(folioRS.next())
                { 
                    folio = folioRS.getInt(1);
                }
            // System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
          return folio;
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            return 0;
        }
        
    }
}
