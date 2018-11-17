/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.publicidad;

import Objects.Archivo;
import Objects.IdArchivo;
import Objects.ListaReproduccion;
import getData.DeleteFile;
import getData.GetFile;
import getData.GetPlayList;
import getData.NewFile;
import getData.UpdateFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jesús Mendoza
 */
@Controller
public class Controller_archivos {
    @RequestMapping("archivos.htm")
    public ModelAndView archivos(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
            //VALIDAR EL ACCESO CON VARIABLES DE SESIÓN
            HttpSession session = request.getSession();
            String id = session.getAttribute("id_usuario").toString();
            String user = session.getAttribute("usuario").toString();
            String correo = session.getAttribute("correo").toString();
            String agencia = session.getAttribute("agencia").toString();          
            //System.err.println("USUARIO " + user + " CORREO " + correo + " AGENCIA " + agencia);
            
            //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
            List<Archivo> archivo = new ArrayList<>();
            
            
            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            archivo =new GetFile().obtenerArchivo();
            
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("File", archivo);
            
            //ACCEDEMOS A HOME
            mav.setViewName("publicidad/archivos_multimedia");
            
            return mav;
            
        }catch(Exception e){
            System.err.println("ERROR INTENTANDO INICIAR SESIÓN");
            return new ModelAndView("error");
        }
        
    }
    
     //***************************************************ARCHIVOS MULTIMEDIA****************************************************************
    
    //ESTE ES EL PATH ABSOLUTO DONDE SE GUARDA EL ARCHIVO, AÚN FALTA HACERLO RELATIVO
    private final String upload_folder = "http://192.168.1.139:1080/smp/Multimedia/";
    //private final String upload_folder = "C:\\Users\\Jesús Mendoza\\Desktop\\files\\";
    private boolean flagFile = true;
    //AGREGAR UN NUEVO ARCHIVO
    @RequestMapping("/New_File.htm")
    public ModelAndView upload(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) throws ServletException, IOException{
        
        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String duracion = request.getParameter("duracion");
        String ubicacion = upload_folder + file.getOriginalFilename();
        
        //System.err.println("--------------------------" + ubicacion);
        //CONVERTIMOS LAS VARIABLES NECESARIAS A INTEGER
        int dur = Integer.parseInt(duracion);
        
        //System.err.println("------------------------------------>    " + upload_folder);
        
        //SI LA IMAGEN NO ESTÁ VACÍA GUARDAMOS EL ARCHIVO
        if(!file.isEmpty()){
             try{
                 File path = new File (upload_folder + file.getOriginalFilename());
                 
                 if(!path.exists()){
                     file.transferTo(new File(upload_folder + file.getOriginalFilename()));
                     System.err.println("Archivo súbido");
                     flagFile = true;
                 }else{
                     System.err.println("Ese archivo ya existe");
                     flagFile = false;
                 }
                  
             }catch(Exception e){
                  System.err.println(e);
             }
         }
        
        //OBJETOS NECESARIOS PARA REALIZAR EL ACCESO A LA DB
        NewFile newFile = new NewFile();
        Archivo archivo = new Archivo();
        
        //UTILIZAMOS LA CLASE ARCHIVO PARA MANDAR LOS PARAMETROS
        archivo.setId(0);
        archivo.setNombre(nombre);
        archivo.setTipo(tipo);
        archivo.setDuracion(dur);
        archivo.setUbicacion(ubicacion);
        
        //OBTENEMOS EL RESULTADO
        if(flagFile){
            int resultadoInsert = newFile.nuevoArchivo(archivo);
            if (resultadoInsert>=1){
                 //RECARGAMOS HOME
                return new ModelAndView("redirect:/archivos.htm");

            }else{
                return new ModelAndView("/");

            }
        }else{
            return new ModelAndView("/");
        }
    }
    
    //EDITAR UN ARCHIVO
    @RequestMapping("/Edit_File.htm")
    protected ModelAndView Edit_File(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
       
        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
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
        archivo.setDuracion(duracionArchivo);
        
        //OBTENEMOS EL RESULTADO
        int resultadoUpdate = updFile.actualizarArchivo(archivo);
        
        if (resultadoUpdate==1){
            //RECARGAMOS HOME
            return new ModelAndView("redirect:/archivos.htm");
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
        int resultadoDeleteArchivo = delFile.borrarFichero(archivo);
        
        if (resultadoDeleteArchivo==1 /*&& resultadoDeleteArchivo ==1*/){
            int resultadoDelete = delFile.borrarArchivo(archivo);
            if(resultadoDelete == 1){
                return new ModelAndView("redirect:/archivos.htm");
            }else{
                return new ModelAndView("/");
            }
        }else{
            return new ModelAndView("/");
        }
        
    }
}
