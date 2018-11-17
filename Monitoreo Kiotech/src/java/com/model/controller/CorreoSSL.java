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
public class CorreoSSL {
    public void CorreoSSL(Servidor_smtp config, Correo mail){
        System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", config.getServer()); //SMTP Host
        props.put("mail.smtp.socketFactory.port", config.getPuerto()); //SSL Port
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", config.getPuerto()); //SMTP Port
        
        String fromEmail = config.getUsuario();
        String toEmail = mail.getCorreo();
        String msg = mail.getMsg();

        Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, config.getContrasena());
                }
        };

        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");
        
        EnvioCorreo correo = new EnvioCorreo(session, toEmail,"Envio de correo desde página web de Monitoreo: apartado 'Medios de envío'", msg, fromEmail);
        correo.start();
        
        //EnvioCorreo.sendEmail(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");

        //EnvioCorreo.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");

        //EnvioCorreo.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");
    }
}
