package Conexion_Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread{

    public static void main(String[] args) {
              
    }
    public static  void llamar(){
        Thread hilo1=new Servidor(); 
              hilo1.start();
    }

    @Override
    public void run() {
        
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        //puerto de nuestro servidor
        final int PUERTO = 5000;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(PUERTO);
         
            System.out.println("Servidor Iniciado");
            Vista.TextServidor.append("Servidor Iniciado");
            Vista.TextServidor.append(System.getProperty("line.separator")); // Esto para el salto de línea 
            
            System.out.println("Esperando Cliente");
              Vista.TextServidor.append("Esperando Cliente"); 
            //Siempre estara escuchando peticiones
            while (true) {

                //Espero a que un cliente se conecte
                sc = servidor.accept();
               Vista.TextServidor.append(System.getProperty("line.separator"));// Esto para el salto de línea 
                 System.out.println("-------------------");
                 Vista.TextServidor.append("-----------------");
                 
                 Vista.TextServidor.append(System.getProperty("line.separator"));// Esto para el salto de línea 
                System.out.println("Cliente Conectado");
                Vista.TextServidor.append("Cliente Conectado");
                
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                     
                //Leo el mensaje que me envia
                String mensaje = in.readUTF();
                
                System.out.println(mensaje);
                 Vista.TextServidor.append(System.getProperty("line.separator"));// Esto para el salto de línea 
                Vista.TextServidor.append("........");
                 Vista.TextServidor.append(System.getProperty("line.separator"));// Esto para el salto de línea 
                Vista.TextServidor.append(mensaje);

                //Le envio un mensaje al cliente
                out.writeUTF("¡Hola mundo desde el servidor!");
                
                 Vista.TextServidor.append(System.getProperty("line.separator"));// Esto para el salto de línea 
               System.out.println("-----------------");
                //Cierro el servidor OPCIONAL
                //PUEDE SEGUIR ABIERTO ELS ERVIDOR EN ESTE CASO YO LO CERRE
                sc.close();
                 Vista.TextServidor.append(System.getProperty("line.separator"));// Esto para el salto de línea 
                System.out.println("Cliente Desconectado");
                Vista.TextServidor.append("Cliente Desconectado");
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}
