/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Objects.Archivo;
import Objects.IdArchivo;
import getData.DeleteFile;
import getData.GetFile;
import getData.NewFile;
import getData.UpdateFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
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
    //PÁGINA PRINCIPAL
    @RequestMapping("home.htm")
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            //VALIDAR EL ACCESO CON VARIABLES DE SESIÓN
            HttpSession session = request.getSession();
            String user = session.getAttribute("usuario").toString();
            String correo = session.getAttribute("correo").toString();
            String agencia = session.getAttribute("agencia").toString();            
            System.err.println("USUARIO " + user + " CORREO " + correo + " AGENCIA " + agencia);
            
            //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
            List<Archivo> lista = new ArrayList<>();
            
            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            lista =new GetFile().obtenerArchivo();
            
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("File", lista);
            
            //ACCEDEMOS A HOME
            mav.setViewName("home");
            
            return mav;
            
        }catch(Exception e){
            System.err.println("ERROR INTENTANDO INICIAR SESIÓN");
            return new ModelAndView("/");
        }
        
    }
    
    
    //***************************************************ARCHIVOS MULTIMEDIA****************************************************************
    
    //EDITAR UN ARCHIVO
    @RequestMapping("/Edit_File.htm")
    protected ModelAndView Edit_File(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
       
        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String duracion = request.getParameter("duracion");
        String id = request.getParameter("id");
        
        //CONVERTIMOS LAS VARIABLES NECESARIAS A INTEGER
        int idArchivo = Integer.parseInt(id);
        int duracionArchivo = Integer.parseInt(duracion);
        
        //OBJETOS NECESARIOS PARA REALIZAR EL ACCESO A LA DB
        UpdateFile updFile = new UpdateFile();
        Archivo archivo = new Archivo();
        
        //UTILIZAMOS LA CLASE ARCHIVO PARA MANDAR LOS PARAMETROS
        archivo.setId(idArchivo);
        archivo.setNombre(nombre);
        archivo.setTipo(tipo);
        archivo.setDuracion(duracionArchivo);
        
        //OBTENEMOS EL RESULTADO
        int resultadoUpdate = updFile.actualizarArchivo(archivo);
        
        if (resultadoUpdate==1){
            //RECARGAMOS HOME
            return new ModelAndView("redirect:/home.htm");
        }else{
            return new ModelAndView("/");
        }
        
    }
    
    //BORRAR UN ARCHIVO
    @RequestMapping("/Delete_File.htm")
    protected ModelAndView Delete_File(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
       
        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
        String id = request.getParameter("id");
        
        //CONVERTIMOS LAS VARIABLES NECESARIAS A INTEGER
        int idArchivo = Integer.parseInt(id);
        
        //OBJETOS NECESARIOS PARA REALIZAR EL ACCESO A LA DB
        DeleteFile delFile = new DeleteFile();
        IdArchivo archivo = new IdArchivo();
        
        //UTILIZAMOS LA CLASE IDARCHIVO PARA MANDAR LOS PARAMETROS
        archivo.setId(idArchivo);
        
        //OBTENEMOS EL RESULTADO
        int resultadoDelete = delFile.borrarArchivo(archivo);
        
        System.err.println("-----> "+resultadoDelete);
        
        if (resultadoDelete==1){
             //RECARGAMOS HOME
            return new ModelAndView("redirect:/home.htm");
        }else{
            return new ModelAndView("/");
        }
        
    }
    
    //AGREGAR UN NUEVO ARCHIVO
    @RequestMapping("/New_File.htm")
    protected ModelAndView New_File(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
        
        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String duracion = request.getParameter("duracion");
        
        //CONVERTIMOS LAS VARIABLES NECESARIAS A INTEGER
        int duracionInt = Integer.parseInt(duracion);
        
        //OBJETOS NECESARIOS PARA REALIZAR EL ACCESO A LA DB
        NewFile newFile = new NewFile();
        Archivo archivo = new Archivo();
        
        //UTILIZAMOS LA CLASE ARCHIVO PARA MANDAR LOS PARAMETROS
        archivo.setId(0);
        archivo.setNombre(nombre);
        archivo.setTipo(tipo);
        archivo.setDuracion(duracionInt);
        
        //OBTENEMOS EL RESULTADO
        int resultadoInsert = newFile.nuevoArchivo(archivo);
        
        if (resultadoInsert==1){
             //RECARGAMOS HOME
            return new ModelAndView("redirect:/home.htm");
            
        }else{
            return new ModelAndView("/");
            
        }
        
    }
    
}
