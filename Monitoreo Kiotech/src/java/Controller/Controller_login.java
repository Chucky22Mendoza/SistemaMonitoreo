/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Objects.Login;
import getData.GetDataUser;
import java.io.IOException;
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
             sesion.setAttribute("usuario", dataUser.getNombre());
             sesion.setAttribute("correo", dataUser.getCorreo());
             sesion.setAttribute("agencia", dataUser.getAgencia());
             
             return new ModelAndView("redirect:/home.htm","command",dataUser);

        } catch (NullPointerException e) {
            return new ModelAndView("/");
        }
    } 
}
