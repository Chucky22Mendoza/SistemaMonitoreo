/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getData;

import Model.ConnectionDB;
import Objects.Kiosco;
import Objects.Programadas;
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
public class GetKioscos {
     private ConnectionDB dbSource = null;
    public GetKioscos(){
        this.dbSource = new ConnectionDB();
    }
    
    public List<Kiosco> obtenerKioscos(){
        List<Kiosco> kiosco = new ArrayList<>();
        String sql ="select * from vw_kiosco_agencia order by id_kiosco";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement obtenerKioscos = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          obtenerKioscos.execute();
          
          try(  ResultSet kioscosRS =(ResultSet)obtenerKioscos.getResultSet(); ){
              while(kioscosRS.next())
                {
                  
                    Kiosco kioscos= new Kiosco();
                    kioscos.setId(kioscosRS.getInt(1));
                    kioscos.setNombre(kioscosRS.getString(2));
                    kioscos.setAgencia(kioscosRS.getString(3));
                    
                    kiosco.add(kioscos);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return kiosco;
    }
    
    public List<Programadas> obtenerProgramadas(int id){
        List<Programadas> programada = new ArrayList<>();
        String sql ="select * from vw_listas_programadas where id_kiosco=? order by id_lista_reproduccion";
        try (   Connection dbConnection = dbSource.conectar().getConnection();
                 CallableStatement obtenerProgramadas = dbConnection.prepareCall(sql);       )            {

          //Variables de Entrada (IN)
          obtenerProgramadas.setInt(1, id);
          obtenerProgramadas.execute();
          
          
          try(  ResultSet programadasRS =(ResultSet)obtenerProgramadas.getResultSet(); ){
              while(programadasRS.next())
                {
                  
                    Programadas programadas= new Programadas();
                    
                    programadas.setId_kiosco(programadasRS.getInt(1));
                    programadas.setNombreKiosco(programadasRS.getString(2));
                    programadas.setAgencia(programadasRS.getString(3));
                    programadas.setId_lista_reproduccion(programadasRS.getInt(4));
                    programadas.setNombreLista(programadasRS.getString(5));
                    programadas.setHora_inicio(programadasRS.getString(6));
                    programadas.setD(programadasRS.getBoolean(7));
                    programadas.setL(programadasRS.getBoolean(8));
                    programadas.setMa(programadasRS.getBoolean(9));
                    programadas.setMi(programadasRS.getBoolean(10));
                    programadas.setJ(programadasRS.getBoolean(11));
                    programadas.setV(programadasRS.getBoolean(12));
                    programadas.setS(programadasRS.getBoolean(13));
                    
                    programada.add(programadas);
                }
             //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
          }
        }
        catch(SQLException ex){
            System.out.println("Excepcion: "+ ex.getMessage());
            //ex.printStackTrace();
        }
        return programada;
    }
}
