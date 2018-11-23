/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreo.cliente.model.objects;

import com.monitoreo.cliente.controller.ControladorCliente;
import com.monitoreo.cliente.database.Sincronizacion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.monitoreo.cliente.views.BackFrame;
import com.monitoreo.restful.set.WebService;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 */
public class ModeloCliente extends Thread {

    ControladorCliente controlador;
    final int PUERTO = 5000;
    // final String HOST = "192.168.1.139";
    final String HOST = "localhost";
    Socket socket;
    BufferedReader br;
    BufferedWriter bw;
    String NombreCliente = "Default";

    public void setControlador(ControladorCliente controlador) {
        this.controlador = controlador;
    }

    public void conectarConElServidor() {
        try {
            socket = new Socket(HOST, PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearFlujos() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje(String mensaje) {
        try {            
            bw.write(mensaje);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensajeNombre(String mensaje) {
        try {
            bw.write(mensaje);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensajePassword(String mensaje) {
        try {
            bw.write(mensaje);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SolicitarStatus() {
        try {
            bw.write("Solicito Status");
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ModificarStatus() {
        try {
            bw.write("Modifico Status");
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Sincronizar() throws IOException {
        
        WebService ws = new WebService();
        List<fn_registrar_alertaModel> historial_alerta = new Sincronizacion().get_alertas();

        int ha_lng = historial_alerta.size();

        for (int i = 0; i < ha_lng; i++) {
            fn_registrar_alertaModel obj = new fn_registrar_alertaModel();

            obj.setId_historial_alerta(historial_alerta.get(i).getId_historial_alerta());
            obj.setMensaje(historial_alerta.get(i).getMensaje());
            obj.setFecha_hora(historial_alerta.get(i).getFecha_hora());
            obj.setStatus(historial_alerta.get(i).isStatus());
            obj.setId_evento(historial_alerta.get(i).getId_evento());
            obj.setId_kiosco(historial_alerta.get(i).getId_kiosco());
            
            Response stts = ws.fn_registrar_alerta(obj);
            int status = stts.getStatus();

            if (status == 200) {

                
                String response = "Status: 200 \n Sincronizado: ''''''fn_registrar_alerta'''''' \n Response: OK";
                enviarMensaje(response);

            } else {
                
                String response = "Status: 404 \n Sincronizado: ''''''fn_registrar_alerta'''''' \n Response: ERROR";
                enviarMensaje(response);
            }
        }

        List<fn_registrar_alerta_enviadaModel> alerta_enviada = new Sincronizacion().get_alerta_enviada();
        int ae_lng = alerta_enviada.size();

        for (int i = 0; i < ae_lng; i++) {
            fn_registrar_alerta_enviadaModel obj = new fn_registrar_alerta_enviadaModel();

            obj.setId_alerta_enviada(alerta_enviada.get(i).getId_alerta_enviada());
            obj.setFecha_hora(alerta_enviada.get(i).getFecha_hora());
            obj.setEmisor(alerta_enviada.get(i).getEmisor());
            obj.setCorreo_enviado(alerta_enviada.get(i).isCorreo_enviado());
            obj.setSms_enviado(alerta_enviada.get(i).isCorreo_enviado());
            obj.setId_usuario(alerta_enviada.get(i).getId_usuario());
            obj.setId_historial_alerta(alerta_enviada.get(i).getId_historial_alerta());
            obj.setId_kiosco(alerta_enviada.get(i).getId_kiosco());

            Response stts = ws.fn_registrar_alerta_enviada(obj);
            int status = stts.getStatus();

            if (status == 200) {
                
                String response = "Status: 200 \n Sincronizado: ''''''fn_registrar_alerta_enviada'''''' \n Response: OK";
                enviarMensaje(response);
            } else {
                
                String response = "Status: 404 \n Sincronizado: ''''''fn_registrar_alerta_enviada'''''' \n Response: ERROR";
                enviarMensaje(response);
            }
        }
        List<fn_registrar_corte_cajaModel> corte_caja = new Sincronizacion().get_corte_caja();
        int cc_lng = corte_caja.size();

        for (int i = 0; i < cc_lng; i++) {
            fn_registrar_corte_cajaModel obj = new fn_registrar_corte_cajaModel();

            obj.setId_corte_caja(corte_caja.get(i).getId_corte_caja());
            obj.setFecha_hora(corte_caja.get(i).getFecha_hora());
            obj.setId_kiosco(corte_caja.get(i).getId_kiosco());

            Response stts = ws.fn_registrar_corte_caja(obj);
            int status = stts.getStatus();

            if (status == 200) {
                
                String response = "Status: 200 \n Sincronizado: ''''''fn_registrar_corte_caja'''''' \n Response: OK";
                enviarMensaje(response);
            } else {
                
                String response = "Status: 404 \n Sincronizado: ''''''fn_registrar_corte_caja'''''' \n Response: ERROR";
                enviarMensaje(response);
            }
        }

        List<fn_sincronizar_configuracion_envioModel> configuracion_envio = new Sincronizacion().get_configuracion_envio();
        int ce_lng = configuracion_envio.size();

        for (int i = 0; i < ce_lng; i++) {
            fn_sincronizar_configuracion_envioModel obj = new fn_sincronizar_configuracion_envioModel();

            obj.setId_configuracion_envio(configuracion_envio.get(i).getId_configuracion_envio());
            obj.setServidor_smtp(configuracion_envio.get(i).getServidor_smtp());
            obj.setSeguridad(configuracion_envio.get(i).getSeguridad());
            obj.setUsuario(configuracion_envio.get(i).getUsuario());
            obj.setContrasena(configuracion_envio.get(i).getContrasena());
            obj.setPuerto(configuracion_envio.get(i).getPuerto());
            obj.setPuerto_tarjeta_sms(configuracion_envio.get(i).getPuerto_tarjeta_sms());

            Response stts = ws.fn_sincronizar_configuracion_envio(obj);
            int status = stts.getStatus();

            if (status == 200) {
                
                String response = "Status: 200 \n Sincronizado: ''''''fn_sincronizar_configuracion_envio'''''' \n Response: OK";
                enviarMensaje(response);
            } else {
                String response = "Status: 404 \n Sincronizado: ''''''fn_sincronizar_configuracion_envio'''''' \n Response: ERROR";
                enviarMensaje(response);
            }
        }

        List<fn_sincronizar_dispositivo_vendingModel> dispositivo_vending = new Sincronizacion().get_dispositivo_vending();
        int dv_lng = dispositivo_vending.size();

        for (int i = 0; i < dv_lng; i++) {
            fn_sincronizar_dispositivo_vendingModel obj = new fn_sincronizar_dispositivo_vendingModel();

            obj.setId_dispositivo_vending(dispositivo_vending.get(i).getId_dispositivo_vending());
            obj.setNombre(dispositivo_vending.get(i).getNombre());

            Response stts = ws.fn_sincronizar_dispositivo_vending(obj);
            int status = stts.getStatus();

            if (status == 200) {
                String response = "Status: 200 \n Sincronizado: ''''''fn_sincronizar_dispositivo_vending'''''' \n Response: OK";
                enviarMensaje(response);
            } else {
                
                String response = "Status: 404 \n Sincronizado: ''''''fn_sincronizar_dispositivo_vending'''''' \n Response: ERROR";
                enviarMensaje(response);
            }
        }

        List<fn_sincronizar_dispositivo_vending_kioscoModel> dispositivo_vending_kiosco = new Sincronizacion().get_dispositivo_vending_kiosco();
        int dvk_lng = dispositivo_vending_kiosco.size();

        for (int i = 0; i < dvk_lng; i++) {
            fn_sincronizar_dispositivo_vending_kioscoModel obj = new fn_sincronizar_dispositivo_vending_kioscoModel();

            obj.setId_dispositivo_vending_kiosco(dispositivo_vending_kiosco.get(i).getId_dispositivo_vending_kiosco());
            obj.setStatus(dispositivo_vending_kiosco.get(i).isStatus());
            obj.setId_kiosco(dispositivo_vending_kiosco.get(i).getId_kiosco());
            obj.setId_dispositivo_vending(dispositivo_vending_kiosco.get(i).getId_dispositivo_vending());

            Response stts = ws.fn_sincronizar_dispositivo_vending_kiosco(obj);
            int status = stts.getStatus();

            if (status == 200) {
                
                String response = "Status: 200 \n Sincronizado: ''''''fn_sincronizar_dispositivo_vending_kiosco'''''' \n Response: OK";
                enviarMensaje(response);
            } else {
                
                String response = "Status: 404 \n Sincronizado: ''''''fn_sincronizar_dispositivo_vending_kiosco'''''' \n Response: ERROR";
                enviarMensaje(response);
            }
        }

        List<fn_sincronizar_kioscoModel> kiosco = new Sincronizacion().get_kiosco();
        int k_lng = kiosco.size();

        for (int i = 0; i < k_lng; i++) {
            fn_sincronizar_kioscoModel obj = new fn_sincronizar_kioscoModel();

            obj.setId_kiosco(kiosco.get(i).getId_kiosco());
            obj.setNombre(kiosco.get(i).getNombre());
            obj.setStatus_mantenimiento(kiosco.get(i).isStatus_mantenimiento());
            obj.setIp(kiosco.get(i).getIp());
            obj.setId_status(kiosco.get(i).getId_status());
            obj.setId_agencia(kiosco.get(i).getId_agencia());
            obj.setId_configuracion_envio(kiosco.get(i).getId_configuracion_envio());

            Response stts = ws.fn_sincronizar_kiosco(obj);
            int status = stts.getStatus();

            if (status == 200) {
                String response = "Status: 200 \n Sincronizado: ''''''fn_sincronizar_kiosco'''''' \n Response: OK";
                enviarMensaje(response);
            } else {
                String response = "Status: 404 \n Sincronizado: ''''''fn_sincronizar_kiosco'''''' \n Response: ERROR";
                enviarMensaje(response);
            }
        }
        List<fn_sincronizar_impresoraModel> impresora = new Sincronizacion().get_impresora();
        int i_lng = impresora.size();

        for (int i = 0; i < i_lng; i++) {
            fn_sincronizar_impresoraModel obj = new fn_sincronizar_impresoraModel();

            obj.setId_impresora(impresora.get(i).getId_impresora());
            obj.setNombre(impresora.get(i).getNombre());
            obj.setId_kiosco(impresora.get(i).getId_kiosco());
            obj.setFecha_actualizacion(impresora.get(i).getFecha_actualizacion());

            Response stts = ws.fn_sincronizar_kiosco(obj);
            int status = stts.getStatus();

            if (status == 200) {
                String response = "Status: 200 \n Sincronizado: ''''''fn_sincronizar_impresora'''''' \n Response: OK";
                enviarMensaje(response);
            } else {
                String response = "Status: 404 \n Sincronizado: ''''''fn_sincronizar_impresora'''''' \n Response: ERROR";
                enviarMensaje(response);
            }
        }
    }

    public String recibirMensaje() {
        try {
            String mensaje = br.readLine();
            return mensaje;
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public void run() {
        while (true) {
            String mensaje = recibirMensaje();
            controlador.agnadirMensajeATrasiego("El Servidor dice: " + mensaje);

        }
    }
}
