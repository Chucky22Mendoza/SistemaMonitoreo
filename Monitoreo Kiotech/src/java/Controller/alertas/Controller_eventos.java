/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.alertas;

import java.io.IOException;
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
public class Controller_eventos {
    @RequestMapping("eventos.htm")
    public ModelAndView eventos(HttpServletRequest request, HttpServletResponse response) throws IOException{
         
            //VALIDAR EL ACCESO CON VARIABLES DE SESIÓN
            HttpSession session = request.getSession();
            String user = session.getAttribute("usuario").toString();
            String correo = session.getAttribute("correo").toString();
            String agencia = session.getAttribute("agencia").toString();            
            //System.err.println("USUARIO " + user + " CORREO " + correo + " AGENCIA " + agencia);
            
            
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            //ACCEDEMOS A HOME
            mav.setViewName("alertas/configuracion_eventos");
            
            return mav;
    }
}
