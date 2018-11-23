/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.objects.controller.Login;
import com.getdata.controller.GetDataUser;
import com.getdata.controller.kiosco_agencia_usuario;
import com.getdata.controller.kiosco_usuario_permiso;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jesús Mendoza
 */
@Controller
public class Controller_login extends HttpServlet {
    
    @RequestMapping("login.htm")
    public ModelAndView login(HttpServletRequest request/*2*/ ){
        return  new ModelAndView("login");
    }
 
    @RequestMapping("/sesion.htm") //1  
    protected ModelAndView sesion(HttpServletRequest request/*2*/ ) throws ServletException, IOException{
        //HttpServletRequest used to take data to the controller
        String user = request.getParameter("user");
        String contraseña = request.getParameter("pass");
        
        GetDataUser datos = new GetDataUser();
         
         try {
             Login dataUser = datos.obtenerUsuario(user,contraseña);
             //Request for session
             HttpSession sesion= request.getSession(true);
             //Here you set your values to the session
             sesion.setAttribute("id_usuario", dataUser.getId_usuario());
             sesion.setAttribute("usuario", dataUser.getNombre());
             sesion.setAttribute("correo", dataUser.getCorreo());
             sesion.setAttribute("agencia", dataUser.getAgencia());
             
             List<Integer> listKioscoAgencia = new kiosco_agencia_usuario().obtenerKioscoAgencia(dataUser.getId_usuario());
             List<Integer> listKioscoPermiso = new kiosco_usuario_permiso().obtenerKioscoPermiso(dataUser.getId_usuario());
             sesion.setAttribute("kioscos_usuario_agencia",listKioscoAgencia);
             sesion.setAttribute("kioscos_usuario_permiso",listKioscoPermiso);
             
             return new ModelAndView("redirect:/home.htm","command",dataUser);

        } catch (NullPointerException e) {
            return new ModelAndView("/");
        }
    }
}
