/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getData;

import Model.ConnectionDB;
import Objects.Archivo;
import Objects.ListasArchivos;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Jesús Mendoza
 */
public class PlayListsFiles {
     //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public PlayListsFiles(){
        this.dbSource = new ConnectionDB();
    }
    
    public int ListasArchivos(ListasArchivos obj){
    
    String sql ="insert into det_lista_reproduccion_archivo(id_lista_reproduccion_archivo,orden,id_lista_reproduccion,id_archivo) values(default,?,?,?)";
    //String sql ="INSERT INTO archivo(idarchivo, nombre, tipo, duracion, ubicacion)  VALUES(default,?,?,?,?);";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevoArchivo= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
            //System.err.println("fn_insert_archivos('"+archivo.getNombre()+"'," + archivo.getDuracion()+",'"+archivo.getUbicacion()+"','"+archivo.getTipo()+"')");
            
        nuevoArchivo.setInt(1, obj.getOrden());
        nuevoArchivo.setInt(2, obj.getIdLista());
        nuevoArchivo.setInt(3, obj.getIdArchivo());

        int res = nuevoArchivo.executeUpdate();

        System.err.println("<------------------------------------------------ !!!!  " + res);

        if(res == 1){
            //Finalizamos la transaccion
            dbConnection.commit();
            //System.err.println("Llamada a PostgreSQL finalizada.");
            return 1;
        }else{
            //Si hubo un error, cancelamos la transaccion.
            dbConnection.rollback();
            return 0;
        }

      }
      catch(Exception ex){
          System.err.println("Excepcion2: "+ ex.getMessage());
          //ex.printStackTrace();
          return 0;
      }
    
    }
}
