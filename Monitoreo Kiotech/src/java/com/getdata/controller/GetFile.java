/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getdata.controller;

import com.model.controller.ConnectionDB;
import com.objects.controller.Archivo;
import com.objects.controller.EditarArchivos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús Mendoza
 * 
 *  OBTENER LA LISTA DE ARCHIVOS PARA ENVIARLAS AL CONTROLADOR
 */
public class GetFile {
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public GetFile(){
        this.dbSource = new ConnectionDB();
    }
    
    public List<Archivo> obtenerArchivo(){
        List<Archivo> archivosLista = new ArrayList<>();
        String sql ="select * from vw_archivos order by id_archivo";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement obtenerArchivos = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          obtenerArchivos.execute();
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet archivosRS =(ResultSet)obtenerArchivos.getResultSet(); ){
              while(archivosRS.next())
                {
                  //System.out.println("--> "+archivosRS.getInt(1));
                  //System.out.println("--> "+archivosRS.getString(2));
                  
                    Archivo archivos= new Archivo();
                    archivos.setId(archivosRS.getInt(1));
                    archivos.setNombre(archivosRS.getString(2));
                    archivos.setTipo(archivosRS.getString(3));
                    archivos.setDuracion(archivosRS.getInt(4));
                    
                    archivosLista.add(archivos);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return archivosLista;
    }
    
     public List<EditarArchivos> EditarArchivos(int id){
        List<EditarArchivos> editArch = new ArrayList<>();
        String sql ="select * from vw_posicion_archivos where id_lista_reproduccion = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement obtenerArchivos = dbConnection.prepareCall(sql);       )            {
          
          
          obtenerArchivos.setInt(1, id);
          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          obtenerArchivos.execute();
          
            
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet archivosRS =(ResultSet)obtenerArchivos.getResultSet(); ){
              while(archivosRS.next())
                {
                  //System.out.println("--> "+archivosRS.getInt(1));
                  //System.out.println("--> "+archivosRS.getString(2));
                  
                    EditarArchivos archivos= new EditarArchivos();
                    archivos.setIdArchivo(archivosRS.getInt(2));
                    archivos.setOrden(archivosRS.getInt(3));
                    archivos.setNombre(archivosRS.getString(4));
                    archivos.setTipo(archivosRS.getString(5));
                    archivos.setDuracion(archivosRS.getInt(6));
                    
                    editArch.add(archivos);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
          //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return editArch;
    }
     
     private int rows;
     public int contarArchivos(int id){
        
        String sql ="select count(posicion) from vw_posicion_archivos where id_lista_reproduccion = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement obtenerArchivos = dbConnection.prepareCall(sql);       )            {
          
          
          obtenerArchivos.setInt(1, id);
          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          obtenerArchivos.execute();
          
            
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet archivosRS =(ResultSet)obtenerArchivos.getResultSet(); ){
              while(archivosRS.next()){
                    rows = archivosRS.getInt(1);   
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
          //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return rows;
    }
     
     public List<Archivo> NuevosArchivos(int id){
        List<Archivo> listado = new ArrayList<>();
        String sql ="{call fn_lista_dif_archivos(?)}";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement obtenerArchivos = dbConnection.prepareCall(sql);       )            {
          
          
          obtenerArchivos.setInt(1, id);
          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          obtenerArchivos.execute();
          
            
          //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet archivosRS =(ResultSet)obtenerArchivos.getResultSet(); ){
              while(archivosRS.next())
                {
                  //System.out.println("--> "+archivosRS.getInt(1));
                  //System.out.println("--> "+archivosRS.getString(2));
                  
                    Archivo archivos= new Archivo();
                    archivos.setId(archivosRS.getInt(1));
                    archivos.setNombre(archivosRS.getString(2));
                    archivos.setTipo(archivosRS.getString(3));
                    archivos.setDuracion(archivosRS.getInt(4));
                    
                    listado.add(archivos);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return listado;
    }
     
     public int InsertarArchivos(int lista, int archivo){
        
        String sql ="{call fn_lista_insert_archivos(?,?)}";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement insertarArchivos = dbConnection.prepareCall(sql);       )            {
          
          
          insertarArchivos.setInt(1, lista);
          insertarArchivos.setInt(2, archivo);
          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          boolean res = insertarArchivos.execute();
          
          if(res){
              dbConnection.commit();
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
     
     public int ordenarArchivos(int lista, int archivo,int orden){
        
        String sql ="update det_lista_reproduccion_archivo set orden = ? where id_lista_reproduccion = ? and id_archivo = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement ordenarArchivos = dbConnection.prepareCall(sql);       )            {
          
          
          ordenarArchivos.setInt(1, orden);
          ordenarArchivos.setInt(2, lista);
          ordenarArchivos.setInt(3, archivo);
          
          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          boolean res = ordenarArchivos.execute();
            //System.err.println("-------------------------------------"+res);
          if(res){
              dbConnection.commit();
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
     
     public int borrarArchivos(int lista, int archivo){
        
        String sql ="delete from det_lista_reproduccion_archivo where id_lista_reproduccion = ? and id_archivo = ?";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement borrarArchivos = dbConnection.prepareCall(sql);       )            {
          
          borrarArchivos.setInt(1, lista);
          borrarArchivos.setInt(2, archivo);
          
          //Variables de Entrada (IN)
          //System.out.println("Preparando llamada a procedimiento almacenado.");
          boolean res = borrarArchivos.execute();
            //System.err.println("-------------------------------------"+res);
          if(res){
              dbConnection.commit();
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
}
