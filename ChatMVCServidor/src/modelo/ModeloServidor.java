package modelo;

import GetData.GetDataUser;
import Objects.Kiosco;
import Objects.Session;
import controlador.ControladorServidor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.IVista;


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
    
   boolean bandera=false;
   Session Usuario2;
   String NombreUsuario;
   Kiosco resultado;
    public void run(){
       
        while(true){
        if (bandera==false){
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
         }
          
            if (bandera==true) {
                String mensaje=recibirMensaje();
                if(mensaje.equals("Solicito Status")){
                controlador.agnadirMensajeATrasiego("El cliente solicito SU STATUS");
                
                resultado = ConsultarStatusKiosco(Usuario2.getId());
                
                  if (resultado.isStatus()==true) {
                     enviarMensaje("Tu Status esta ACTIVO"); 
                  }else {
                     enviarMensaje("Tu Sstatus esta en MANTENIMEINTO"); 
                  }
                }
            }
     
        }
    }
}
