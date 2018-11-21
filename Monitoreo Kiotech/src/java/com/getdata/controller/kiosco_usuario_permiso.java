/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.objects.controller.PermisoAlertaKiosco;
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
public class kiosco_usuario_permiso {
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public kiosco_usuario_permiso(){
        this.dbSource = new ConnectionDB();
    }
    
    public List<Integer> obtenerKioscoPermiso(int id_usuario){
        List<Integer> listKiosco = new ArrayList<>();
        String sql ="select id_kiosco from permiso_alerta_kiosco where id_usuario = ?";
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
                  
                    int kio = kioscoRS.getInt(1);
                    
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
    
    public List<PermisoAlertaKiosco> obtenerKiosco(int id_usuario){
        List<PermisoAlertaKiosco> listKiosco = new ArrayList<>();
        String sql ="select ki.id_kiosco,ki.nombre,pak.id_usuario,pak.recibir_alerta from permiso_alerta_kiosco as pak inner join kiosco as ki on ki.id_kiosco = pak.id_kiosco where id_usuario = ?";
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
                    PermisoAlertaKiosco permiso = new PermisoAlertaKiosco();                   
                    
                    permiso.setId_kiosco(kioscoRS.getInt(1));
                    permiso.setNombre(kioscoRS.getString(2));
                    permiso.setId_usuario(kioscoRS.getInt(3));
                    permiso.setRecibir_alerta(kioscoRS.getBoolean(4));
                    
                    listKiosco.add(permiso);
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
