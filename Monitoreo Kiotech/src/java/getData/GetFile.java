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
}
