/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.alertas;

import Objects.Archivo;
import Objects.Usuario;
import getData.GetDataUser;
import getData.GetFile;
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
public class Controller_asignar_usuario {
    @RequestMapping("asignar_usuario.htm")
    public ModelAndView asig_usuario(HttpServletRequest request, HttpServletResponse response) throws IOException{
         
            //VALIDAR EL ACCESO CON VARIABLES DE SESIÓN
            HttpSession session = request.getSession();
            String user = session.getAttribute("usuario").toString();
            String correo = session.getAttribute("correo").toString();
            String agencia = session.getAttribute("agencia").toString();            
            //System.err.println("USUARIO " + user + " CORREO " + correo + " AGENCIA " + agencia);
            
            
            List<Usuario> usuarios = new ArrayList<>();
            
            
            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            usuarios =new GetDataUser().obtenerUsuarios();
            
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("usuarios", usuarios);
            
            //ACCEDEMOS A HOME
            mav.setViewName("alertas/asig_usuario");
            
            return mav;
    }
}
