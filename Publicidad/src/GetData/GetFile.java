/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetData;

import Model.ConnectionDB;
import Model.Envio;
import Model.archivoVideo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mario
 */
public class GetFile {
    //Llamar a la base de datos para conectividad

    private ConnectionDB dbSource = null;

    public GetFile() {
        this.dbSource = new ConnectionDB();
    }

    public List<archivoVideo> obtenerArchivo() {
        List<archivoVideo> archivosLista = new ArrayList<>();
        
        String sql = "SELECT * FROM public.vw_ubicacion_archivos WHERE id_kiosco = ? AND EXTRACT(HOUR FROM hora_inicio) = ? "
                + "AND EXTRACT(MINUTE FROM hora_inicio) = ? AND CASE ? WHEN 'LUNES' THEN lunes = true WHEN 'MARTES' THEN martes = true "
                + "WHEN 'MIERCOLES' THEN miercoles = true WHEN 'JUEVES' THEN jueves = true WHEN 'VIERNES' THEN viernes = true WHEN 'SABADO' "
                + "THEN sabado = true WHEN 'DOMINGO' THEN domingo = true END ORDER BY orden";
        
        try (Connection dbConnection = dbSource.conectar();
                
                CallableStatement obtenerArchivos = dbConnection.prepareCall(sql);) {

            //Variables de Entrada (IN)
            obtenerArchivos.setInt(1, Envio.getKiosko());
            obtenerArchivos.setInt(2, Envio.getHoraInicio());
            obtenerArchivos.setInt(3, Envio.getMinutoInicio());
            obtenerArchivos.setString(4, Envio.getDia());
            //System.out.println("Preparando llamada a procedimiento almacenado.");
            obtenerArchivos.execute();
            //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
            
            try (ResultSet archivosRS = (ResultSet) obtenerArchivos.getResultSet();) {
                while (archivosRS.next()) {
                    //System.out.println("--> "+archivosRS.getInt(1));
                    //System.out.println("--> "+archivosRS.getString(2));

                    archivoVideo archivos = new archivoVideo();
                    archivos.setNombre(archivosRS.getString(2));
                    archivos.setDuracion(archivosRS.getInt(3));
                    archivos.setUbicacion(archivosRS.getString(4));
                    archivos.setTipo(archivosRS.getString(5));
                    archivos.setListaReproduccion(archivosRS.getString(8));
                    archivos.setHora(archivosRS.getTimestamp(10));

                    archivosLista.add(archivos);
                }
                //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Excepcion: " + ex.getMessage());
            //ex.printStackTrace();
        }        
        
        return archivosLista;
    }
    
    public List<archivoVideo> obtenerHora() {
        List<archivoVideo> archivosLista = new ArrayList<>();
        
        String sql = "SELECT EXTRACT(HOUR FROM hora_inicio), EXTRACT(MINUTE FROM hora_inicio) FROM public.vw_listas_programadas "
                + "where id_kiosco = ? AND CASE ? WHEN 'DOMINGO' THEN d = true WHEN 'LUNES' THEN l = true WHEN 'MARTES' THEN ma = true "
                + "WHEN 'MIERCOLES' THEN mi = true WHEN 'JUEVES' THEN j = true WHEN 'VIERNES' THEN v = true WHEN 'SABADO' then s = true END "
                + "ORDER BY hora_inicio";
        
        try (Connection dbConnection = dbSource.conectar();
                CallableStatement obtenerArchivos = dbConnection.prepareCall(sql);) {

            //Variables de Entrada (IN)
            obtenerArchivos.setInt(1, Envio.getKiosko());            
            obtenerArchivos.setString(2, Envio.getDia());            
            //System.out.println("Preparando llamada a procedimiento almacenado.");
            obtenerArchivos.execute();
            //System.out.println("Procesando resultados de llamada a procedimiento almacenado.");
            try (ResultSet archivosRS = (ResultSet) obtenerArchivos.getResultSet();) {
                while (archivosRS.next()) {
                    //System.out.println("--> "+archivosRS.getInt(1));
                    //System.out.println("--> "+archivosRS.getString(2));

                    archivoVideo archivos = new archivoVideo();
                    archivos.setHoraInicio(archivosRS.getInt(1));
                    archivos.setMinutosInicio(archivosRS.getInt(2));

                    archivosLista.add(archivos);
                }
                //System.out.println("Llamada a procedimiento almacenado finalizada correctamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Excepcion: " + ex.getMessage());
            //ex.printStackTrace();
        }
        
        return archivosLista;
    }
    
}
