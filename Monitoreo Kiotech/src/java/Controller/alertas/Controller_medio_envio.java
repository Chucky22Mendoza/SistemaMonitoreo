/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.alertas;

import com.model.controller.CorreoSSL;
import com.model.controller.CorreoTLS;
import com.model.controller.EnvioCorreo;
import com.model.controller.Puertos;
import com.objects.controller.Archivo;
import com.objects.controller.Correo;
import com.objects.controller.Mensaje_SMS;
import com.objects.controller.Servidor_smtp;
import com.getdata.controller.NewConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jesús Mendoza
 */
@Controller
public class Controller_medio_envio {
    @RequestMapping("medio_envio.htm")
    public ModelAndView medio_envio(HttpServletRequest request, HttpServletResponse response) throws IOException{
         
            //VALIDAR EL ACCESO CON VARIABLES DE SESIÓN
            HttpSession session = request.getSession();
            String id = session.getAttribute("id_usuario").toString();
            String user = session.getAttribute("usuario").toString();
            String correo = session.getAttribute("correo").toString();
            String agencia = session.getAttribute("agencia").toString();          
            //System.err.println("USUARIO " + user + " CORREO " + correo + " AGENCIA " + agencia);
            List<String> lista = new ArrayList<>();
            
            lista = new Puertos().puertos();
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            mav.addObject("puertos",lista);
            //ACCEDEMOS A HOME
            mav.setViewName("alertas/medio_envio");
            
            return mav;
    }
    
    
    @RequestMapping("servidor_smtp.htm")
    public ModelAndView servidor_smtp(HttpServletRequest request, HttpServletResponse response) throws IOException{
            
        String servidor_smtp = request.getParameter("servidor_smtp");
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        String port = request.getParameter("puerto");
        String seguridad = request.getParameter("seguridad");
        int puerto = Integer.parseInt(port);
        
        Servidor_smtp server = new Servidor_smtp(servidor_smtp,usuario,contrasena,puerto,seguridad);
        
        int result = new NewConfig().nuevaConfiguracion(server);
        System.err.println(result);
        if(result == 1){
            ModelAndView mav = new ModelAndView();
        
            mav.addObject("exTitle", 1);
            mav.setViewName("templates/noresultado");
            
            return mav;
        }else{
            ModelAndView mav = new ModelAndView();
        
            mav.addObject("exTitle", 0);
            mav.setViewName("templates/noresultado");
            
            return mav;
        }
         
         
    }
    
    @RequestMapping("enviar_correo.htm")
    public ModelAndView enviar_correo(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        String id = session.getAttribute("id_usuario").toString();
        int id_usuario = Integer.parseInt(id);
        
        String mensaje = request.getParameter("mensaje");
        String correo = request.getParameter("correo");
        
        Correo mail = new Correo(correo,mensaje);
        Servidor_smtp config = new NewConfig().obtenerConfiguracion(id_usuario);
        String seguridad = config.getSeguridad();
        
        
        if(seguridad.equals("TLS")){
            new CorreoTLS().CorreoTLS(config, mail);
            //System.err.println(EnvioCorreo.correoEnviado);
            //if(EnvioCorreo.correoEnviado){
                ModelAndView mav = new ModelAndView();
        
                mav.addObject("exTitle", 1);
                mav.setViewName("templates/noresultado");
            
                return mav;
            /*}else{
                ModelAndView mav = new ModelAndView();
        
                mav.addObject("exTitle", 0);
                mav.setViewName("templates/noresultado");
            
                return mav;
            } */       
        }else if(seguridad.equals("SSL")){
            new CorreoSSL().CorreoSSL(config, mail);
            //if(EnvioCorreo.correoEnviado){
                ModelAndView mav = new ModelAndView();
        
                mav.addObject("exTitle", 1);
                mav.setViewName("templates/noresultado");
            
                return mav;
            /*}else{
                ModelAndView mav = new ModelAndView();
        
                mav.addObject("exTitle", 0);
                mav.setViewName("templates/noresultado");
            
                return mav;
            } */       

        }else{
            ModelAndView mav = new ModelAndView();
        
            mav.addObject("exTitle", 0);
            mav.setViewName("templates/noresultado");
            return mav;
        }
        
    }
    
    @RequestMapping("puerto_tarjeta_sms.htm")
    public ModelAndView puerto_tarjeta_sms(HttpServletRequest request, HttpServletResponse response) throws IOException{
            
        String puerto = request.getParameter("puerto");
        
        int result = new NewConfig().nuevaConfiguracionSMS(puerto);
        
        if(result == 1){
            ModelAndView mav = new ModelAndView();
            mav.addObject("exTitle", 1);
            mav.setViewName("templates/noresultado");
            
            return mav;
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exTitle", 0);
            mav.setViewName("templates/noresultado");
            
            return mav;
        }
    }
    //Enviar un mensaje sms
    @RequestMapping("enviar_sms.htm")
    public ModelAndView enviar_sms(HttpServletRequest request, HttpServletResponse response) throws IOException{
            
        String msg = request.getParameter("mensaje");
        String celular = request.getParameter("celular");
        
        Mensaje_SMS msg_sms = new Mensaje_SMS(msg,celular);
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("exTitle", 1);
        mav.setViewName("templates/noresultado");
           
        return mav;
    }
}
