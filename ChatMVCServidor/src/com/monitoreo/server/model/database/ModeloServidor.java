package com.monitoreo.server.model.database;


import com.monitoreo.server.model.objects.Kiosco;
import com.monitoreo.server.model.objects.Session;
import com.monitoreo.server.controller.ControladorServidor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ModeloServidor extends Thread {
    ControladorServidor controlador;
    final int PUERTO = 5000;
    ServerSocket sk;
    Socket socket;
    BufferedReader br;
    BufferedWriter bw;

   
    public void setControlador(ControladorServidor controlador){
        this.controlador = controlador;
    }
     
    public void abrirPuerto(){
        try {
            sk = new ServerSocket(PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void esperarAlCliente(){
        try {  
            
           socket = sk.accept();     
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearFlujos(){
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMensaje(String mensaje){
        try {
            bw.write(mensaje);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recibirMensaje(){
        try {
            String mensaje = br.readLine();
            return mensaje;
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String recibirPassword(){
        try {
            String mensaje = br.readLine();
            return mensaje;
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public void Sincronizar(){
       
    }
    
    
     
    public Kiosco ConsultarStatusKiosco(int idUsuario){
        GetDataUser data=new GetDataUser();
        Kiosco k=new Kiosco();  
        k = data.GetConsultarStatusKiosco(idUsuario);
        return k;
    }
    
      
    public Session VerificarKiosco(String usuario, String contraseña){
        GetDataUser data=new GetDataUser();
        Session s=new Session();
        
        s= data.GetVerificarKiosco(usuario,contraseña);
         return s;
    }
    
     public int UpdateStatusKiosco(int id_kiosco,int señal_bandera) {
         GetDataUser data=new GetDataUser();
         int result=data.GetUpdateKiosco(id_kiosco,señal_bandera);
         return result;
     }
    
   boolean bandera=true;
   Session Usuario2;
   String NombreUsuario;
   //Kiosco resultado;
   //public static int señal_bandera;
    public void run(){
       
        while(true){
            
            
            
     /*   if (bandera==false){
            NombreUsuario = recibirMensaje();
            String password = recibirPassword();
             //System.out.println(NombreUsuario);
              //System.out.println(password);
            
              
            //AQUI SE CHECA SI EL USUARIO ES CORRECTO
            Usuario2 = VerificarKiosco(NombreUsuario,password);
            //System.out.println(Usuario2.getStatus());
            //System.out.println(Usuario2.getId());
            
              if (Usuario2.getStatus()==null){
                  
                  enviarMensaje("ACCESO DENEGADO --DATOS NO ENCONTRADOS-- ");
                bandera=false;
              }else{
                  controlador.agnadirMensajeATrasiego( NombreUsuario +" Se conecto");
                enviarMensaje("ACCESO PERMITIDO");
                bandera=true;
              }
         }*/
      
            if (bandera) {
                String mensaje=recibirMensaje();
                /*if (mensaje.equals("Status: 200 \n Sincronizado: ''''''fn_registrar_alerta'''''' \n Response: OK")) {
                     controlador.agnadirMensajeATrasiego(mensaje);
                }
                if(mensaje.equals("Status: 404 \n Sincronizado: ''''''fn_registrar_alerta'''''' \n Response: ERROR")){
                    controlador.agnadirMensajeATrasiego(mensaje);
                }
                if (mensaje.equals("Status: 200 \n Sincronizado: ''''''fn_registrar_alerta_enviada'''''' \n Response: OK")) {
                     controlador.agnadirMensajeATrasiego(mensaje);
                }
                if(mensaje.equals("Status: 404 \n Sincronizado: ''''''fn_registrar_alerta_enviada'''''' \n Response: ERROR")){
                    controlador.agnadirMensajeATrasiego(mensaje);
                }
                if (mensaje.equals("Status: 200 \n Sincronizado: ''''''fn_registrar_corte_caja'''''' \n Response: OK")) {
                     controlador.agnadirMensajeATrasiego(mensaje);
                }
                if(mensaje.equals("Status: 404 \n Sincronizado: ''''''fn_registrar_corte_caja'''''' \n Response: ERROR")){
                    controlador.agnadirMensajeATrasiego(mensaje);
                }
                if (mensaje.equals("Status: 200 \n Sincronizado: ''''''fn_sincronizar_configuracion_envio'''''' \n Response: OK")) {
                     controlador.agnadirMensajeATrasiego(mensaje);
                }
                if(mensaje.equals("Status: 404 \n Sincronizado: ''''''fn_sincronizar_configuracion_envio'''''' \n Response: ERROR")){
                    controlador.agnadirMensajeATrasiego(mensaje);
                }
                if (mensaje.equals("Status: 200 \n Sincronizado: ''''''fn_sincronizar_dispositivo_vending'''''' \n Response: OK")) {
                     controlador.agnadirMensajeATrasiego(mensaje);
                }
                if(mensaje.equals("Status: 404 \n Sincronizado: ''''''fn_sincronizar_dispositivo_vending'''''' \n Response: ERROR")){
                    controlador.agnadirMensajeATrasiego(mensaje);
                }
                if (mensaje.equals("Status: 200 \n Sincronizado: ''''''fn_sincronizar_dispositivo_vending_kiosco'''''' \n Response: OK")) {
                     controlador.agnadirMensajeATrasiego(mensaje);
                }
                if(mensaje.equals("Status: 404 \n Sincronizado: ''''''fn_sincronizar_dispositivo_vending_kiosco'''''' \n Response: ERROR")){
                    controlador.agnadirMensajeATrasiego(mensaje);
                }
                if (mensaje.equals("Status: 200 \n Sincronizado: ''''''fn_sincronizar_kiosco'''''' \n Response: OK")) {
                     controlador.agnadirMensajeATrasiego(mensaje);
                }
                if(mensaje.equals("Status: 404 \n Sincronizado: ''''''fn_sincronizar_kiosco'''''' \n Response: ERROR")){
                    controlador.agnadirMensajeATrasiego(mensaje);
                }
                if (mensaje.equals("Status: 200 \n Sincronizado: ''''''fn_sincronizar_impresora'''''' \n Response: OK")) {
                     controlador.agnadirMensajeATrasiego(mensaje);
                }
                if(mensaje.equals("Status: 404 \n Sincronizado: ''''''fn_sincronizar_impresora'''''' \n Response: ERROR")){
                    controlador.agnadirMensajeATrasiego(mensaje);
                }*/
                if(mensaje.equals("ERROR")){
                    controlador.agnadirMensajeATrasiego("ERROR DE SINCRONIZACION");
                }
                if(mensaje.equals("OK")){
                    controlador.agnadirMensajeATrasiego("SINCRONIZACION CORRECTA");
                }
                
            }
                
            /*        
                if(mensaje.equals("Solicito Status")){
                controlador.agnadirMensajeATrasiego("El cliente"+ NombreUsuario +"solicito SU STATUS");
                
                resultado = ConsultarStatusKiosco(Usuario2.getId());
                
                  if (resultado.isStatus()==true) {
                     enviarMensaje("Tu Status esta en MANTENIMIENTO"); 
                  }if(resultado.isStatus()==false){
                     enviarMensaje("Tu Sstatus esta ACTIVO"); 
                  }
                  
                }
                if(mensaje.equals("Modifico Status")){
                    resultado = ConsultarStatusKiosco(Usuario2.getId()); //consulta el status nuevamente, por si da click en modificar status antes de consultarlo
                    System.out.println(resultado.isStatus());
                    
                    if (resultado.isStatus()==true) {
                         señal_bandera=1;//se modificara a falso el status del kiosco a Activo
                    } if (resultado.isStatus()==false){
                         señal_bandera=0; //se modificara a true el status del kiosco A mantenimiento
                    }
                       int respuesta=UpdateStatusKiosco(resultado.getId_kisoco(),señal_bandera);
                        
                       if (respuesta==1) {
                         enviarMensaje("Se Modifico con exito"); 
                       }else {
                         enviarMensaje("Hubo un error.... intente denuevo"); 
                       }  
                        
                }
             */
     
        }
    }

   
}
