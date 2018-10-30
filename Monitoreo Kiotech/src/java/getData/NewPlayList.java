/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getData;

import Model.ConnectionDB;
import Objects.ListaReproduccion;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Jesús Mendoza
 */
public class NewPlayList {
    //Llamar a la base de datos para conectividad
    private ConnectionDB dbSource = null;
    public NewPlayList(){
        this.dbSource = new ConnectionDB();
    }
    
    public int nuevaLista(ListaReproduccion lista){

    String sql ="INSERT INTO lista_reproduccion(id_lista_reproduccion, nombre, descripcion)  VALUES(default,?,?);";

    try (
           Connection dbConnection = dbSource.conectar().getConnection();
            //Tipo CallableStatement, otra variante tambien es usar PrepareStatement
            CallableStatement nuevaLista= dbConnection.prepareCall(sql);
           )            
        {
        //fechaestreno,duracion,fecha_registro,fecha_actualizacion
        dbConnection.setAutoCommit(false);
        //Variables de Entrada (IN)
        //System.err.println("Preparando llamada a PostgreSQL. ---> ");
        nuevaLista.setString(1, lista.getNombre());
        nuevaLista.setString(2, lista.getDescripcion());

        int res = nuevaLista.executeUpdate();

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
