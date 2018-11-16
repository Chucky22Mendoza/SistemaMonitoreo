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

    public List<archivoVideo> obtenerArchivo(Envio parms) {
        List<archivoVideo> archivosLista = new ArrayList<>();
        String sql = "select * from vw_ubicacion_archivos where id_kiosco = ? order by orden";
        try (Connection dbConnection = dbSource.conectar();
                CallableStatement obtenerArchivos = dbConnection.prepareCall(sql);) {

            //Variables de Entrada (IN)
            obtenerArchivos.setInt(1, parms.getKiosko());
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
}
