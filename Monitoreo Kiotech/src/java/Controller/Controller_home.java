/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Login;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Controller_home {
    
    @RequestMapping("home.htm")
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response) throws IOException{
       /* HttpSession session = request.getSession();
        
        String user = session.getAttribute("usuario").toString();
        String correo = session.getAttribute("correo").toString();
        String agencia = session.getAttribute("agencia").toString();
        System.err.println("USUARIO " + user);
        */
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }
    
}
