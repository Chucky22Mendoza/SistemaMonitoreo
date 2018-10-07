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
 */
public class GetArchive {
    private ConnectionDB dbSource = null;
    public GetArchive(){
        this.dbSource = new ConnectionDB();
    }
    public List<Archivo> obtenerPlayLists(){
        List<Archivo> listasReproduccion = new ArrayList<>();
        String sql ="select * from archivo order by idarchivo";
        try (
                Connection dbConnection = dbSource.conectar().getConnection();
                CallableStatement obtenerListas = dbConnection.prepareCall(sql);
               )            
            {

          //Variables de Entrada (IN)
          System.out.println("Preparando llamada a procedimiento almacenado.");
          obtenerListas.execute();
          System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
          try(  ResultSet listasRS =(ResultSet)obtenerListas.getResultSet(); ){
              while(listasRS.next())
                {
                  System.out.println("--> "+listasRS.getInt(1));
                  System.out.println("--> "+listasRS.getString(2));
                  
                    Archivo listas= new Archivo();
                    listas.setId(listasRS.getInt(1));
                    listas.setNombre(listasRS.getString(2));
                    listas.setTipo(listasRS.getString(3));
                    listas.setDuracion(listasRS.getInt(4));
                    
                    listasReproduccion.add(listas);
                }
             System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return listasReproduccion;
    }
}
