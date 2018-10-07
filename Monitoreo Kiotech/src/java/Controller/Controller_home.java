/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConnectionDB;
import Objects.Archivo;
import getData.GetArchive;
import getData.UpdateArchive;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jesús Mendoza
 */
@Controller
public class Controller_home {
    private JdbcTemplate jdbc;
    public Controller_home(){
        ConnectionDB con = new ConnectionDB();
        this.jdbc = new JdbcTemplate(con.conectar());
    }   
    
    @RequestMapping("home.htm")
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            HttpSession session = request.getSession();
            String user = session.getAttribute("usuario").toString();
            String correo = session.getAttribute("correo").toString();
            String agencia = session.getAttribute("agencia").toString();            
            System.err.println("USUARIO " + user + " CORREO " + correo + " AGENCIA " + agencia);
            
            List<Archivo> lista = new ArrayList<>();
            lista =new GetArchive().obtenerPlayLists();
            ModelAndView mav = new ModelAndView();
            mav.addObject("PlayLists", lista);
            mav.setViewName("home");
            return mav;
            
        }catch(Exception e){
            System.err.println("ERROR INTENTANDO INICIAR SESIÓN");
            return new ModelAndView("redirect:/error.htm");
        }
        
    }
    
    @RequestMapping("/archiveEdit.htm")
    protected ModelAndView archiveEdit(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
        
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String duracion = request.getParameter("duracion");
        
        String id = request.getParameter("id");
        System.err.println("IIIIIIIIIIIDDDDDDDDDD: " + tipo + " - " + duracion + " - " + id + " - " + nombre);
        
        int idArchivo = Integer.parseInt(id);
        int duracionArchivo = Integer.parseInt(duracion);
        
        
        UpdateArchive updArc = new UpdateArchive();
        Archivo archivo = new Archivo();
        
        archivo.setId(idArchivo);
        archivo.setNombre(nombre);
        archivo.setTipo(tipo);
        archivo.setDuracion(duracionArchivo);
        
        int resultadoUpdate = updArc.actualizarArchivo(archivo);
        
        if (resultadoUpdate==1){
            String alert = "<script>alert('Se actualizado correctamente');</script> ";
            PrintWriter  out = response.getWriter();
            out.println(alert);
            return new ModelAndView("redirect:home.htm#tab3");
        }else{
            String alert = "<script>alert('Error');</script> ";
            PrintWriter  out = response.getWriter();
            out.println(alert);
            return null;
        }
        
    }
    
}
