/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package Model;

import Objects.Correo;
import Objects.Servidor_smtp;
import java.util.Date;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class EnvioCorreo extends Thread {

    /**
     * Utility method to send simple HTML email
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */

    public static boolean correoEnviado;

    public EnvioCorreo(Session session, String toEmail, String subject, String body, String fromEmail) {
        this.session = session;
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
        this.fromEmail = fromEmail;
    }
    

    
        Session session;
        String toEmail, subject, body,fromEmail;        
    
        public void run(){
            try
            {
                //Servidor_smtp serv = new Servidor_smtp();
                MimeMessage msg = new MimeMessage(session);
                //set message headers
                msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
                msg.addHeader("format", "flowed");
                msg.addHeader("Content-Transfer-Encoding", "8bit");

                /*msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

                msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));*/

                msg.setFrom(new InternetAddress( fromEmail,"Servidor"));
                //System.err.println(fromEmail);
                msg.setReplyTo(InternetAddress.parse(fromEmail, false));

                msg.setSubject(subject, "UTF-8");

                msg.setText(body, "UTF-8");

                msg.setSentDate(new Date());

                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
                System.out.println("Message is ready");
                Transport.send(msg);  

                System.out.println("EMail Sent Successfully!!");
                correoEnviado = true;
            }
            catch (Exception e) {
                e.printStackTrace();
                correoEnviado = false;
            }
        }
    
}
