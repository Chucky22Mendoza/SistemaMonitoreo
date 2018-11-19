/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.model.controller;

import com.objects.controller.Correo;
import com.objects.controller.Servidor_smtp;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class CorreoTLS {
    public void CorreoTLS(Servidor_smtp config, Correo mail){
        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        //System.err.println(config.getPuerto() + " - " + config.getServer());
        props.put("mail.smtp.host", config.getServer()); //SMTP Host
        props.put("mail.smtp.port", config.getPuerto()); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        
        String fromEmail = config.getUsuario();
        String toEmail = mail.getCorreo();
        String msg = mail.getMsg();

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, config.getContrasena());
                }
        };
        Session session = Session.getInstance(props, auth);
        
        EnvioCorreo correo = new EnvioCorreo(session, toEmail,"Envio de correo desde página web de Monitoreo: apartado 'Medios de envío'", msg, fromEmail);
        correo.start();
        
    }
}
