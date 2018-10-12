/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Objects.Archivo;
import Objects.IdArchivo;
import Objects.ListaReproduccion;
import getData.DeleteFile;
import getData.DeletePlayList;
import getData.GetFile;
import getData.GetPlayList;
import getData.NewFile;
import getData.NewPlayList;
import getData.UpdateFile;
import getData.UpdatePlayList;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            List<Archivo> archivo = new ArrayList<>();
            List<ListaReproduccion> lista = new ArrayList<>();
            
            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            archivo =new GetFile().obtenerArchivo();
            lista = new GetPlayList().obtenerPlayLists();
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("File", archivo);
            mav.addObject("List", lista);
            
            //ACCEDEMOS A HOME
            mav.setViewName("home");
            
            return mav;
            
        }catch(Exception e){
            System.err.println("ERROR INTENTANDO INICIAR SESIÓN");
            return new ModelAndView("/");
        }
        
    }
    
    
    //***************************************************ARCHIVOS MULTIMEDIA****************************************************************
    
    //ESTE ES EL PATH ABSOLUTO DONDE SE GUARDA EL ARCHIVO, AÚN FALTA HACERLO RELATIVO
    private final String upload_folder = "C:\\Users\\Jesús Mendoza\\Documents\\GitHub\\SistemaMonitoreo\\Monitoreo Kiotech\\web\\resources\\files\\";
    private boolean flagFile = true;
    //AGREGAR UN NUEVO ARCHIVO
    @RequestMapping("/New_File.htm")
    public ModelAndView upload(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) throws ServletException, IOException{
        
        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String duracion = request.getParameter("duracion");
        String ubicacion = upload_folder + file.getOriginalFilename();
        
        //CONVERTIMOS LAS VARIABLES NECESARIAS A INTEGER
        int dur = Integer.parseInt(duracion);
        
        System.err.println("------------------------------------>    " + upload_folder);
        
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
            if (resultadoInsert==1){
                 //RECARGAMOS HOME
                return new ModelAndView("redirect:/home.htm");

            }else{
                return new ModelAndView("/");

            }
        }else{
            return new ModelAndView("/");
        }
    }
    
   /* @RequestMapping("/research.htm")
    protected ModelAndView research(){
        
        //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
        List<Archivo> lista = new ArrayList<>();

        //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
        lista =new GetFile().obtenerArchivo();

        //NUEVA VISTA
        ModelAndView mav = new ModelAndView();
        
        mav.getModel();
        //PASAMOS EL ARRAY A LA VISTA
        mav.addObject("File", lista);

        return mav;
    }*/
    
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
        //int resultadoDeleteArchivo = delFile.borrarFichero(archivo);
        
        System.err.println("-----> "+resultadoDelete);
        //System.err.println("-----> "+resultadoDeleteArchivo);
        
        if (resultadoDelete==1 /*&& resultadoDeleteArchivo ==1*/){
             //RECARGAMOS HOME
            return new ModelAndView("redirect:/home.htm");
        }else{
            return new ModelAndView("/");
        }
        
    }
        
    //***************************************************LISTAS DE REPRODUCCIÓN****************************************************************
    
        //EDITAR UN ARCHIVO
    @RequestMapping("/Edit_List.htm")
    protected ResponseEntity<?> Edit_List(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
       
        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
        String nombre = request.getParameter("nombreList");
        String descripcion = request.getParameter("descripcion");
        String id = request.getParameter("idList");
        
        //CONVERTIMOS LAS VARIABLES NECESARIAS A INTEGER
        int idLista = Integer.parseInt(id);
        
        //OBJETOS NECESARIOS PARA REALIZAR EL ACCESO A LA DB
        UpdatePlayList updLis = new UpdatePlayList();
        ListaReproduccion lista = new ListaReproduccion();
        
        //UTILIZAMOS LA CLASE ARCHIVO PARA MANDAR LOS PARAMETROS
        lista.setId(idLista);
        lista.setNombre(nombre);
        lista.setDescripcion(descripcion);
        
        //OBTENEMOS EL RESULTADO
        int resultadoUpdate = updLis.actualizarLista(lista);
        
        if (resultadoUpdate==1){
            //RECARGAMOS HOME
            return new ResponseEntity<Object>("Lista actualizada correctamente", HttpStatus.OK);
        }else{
            return new ResponseEntity<Object>("Error al guardar lista", HttpStatus.CONFLICT);
        }
        
    }
    

    
    //BORRAR UN ARCHIVO
    @RequestMapping("/Delete_List.htm")
    protected ModelAndView Delete_List(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
       
        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
        String id = request.getParameter("idList");
        
        //CONVERTIMOS LAS VARIABLES NECESARIAS A INTEGER
        int idList = Integer.parseInt(id);
        
        //OBJETOS NECESARIOS PARA REALIZAR EL ACCESO A LA DB
        DeletePlayList delList = new DeletePlayList();
        ListaReproduccion lista = new ListaReproduccion();
        
        //UTILIZAMOS LA CLASE IDARCHIVO PARA MANDAR LOS PARAMETROS
        lista.setId(idList);
        
        //OBTENEMOS EL RESULTADO
        int resultadoDelete = delList.borrarLista(lista);
        
        System.err.println("-----> "+resultadoDelete);
        
        if (resultadoDelete==1){
             //RECARGAMOS HOME
            return new ModelAndView("redirect:/home.htm");
        }else{
            return new ModelAndView("/");
        }
        
    }
    
    //AGREGAR UN NUEVO ARCHIVO
    @RequestMapping("/New_List.htm")
    protected ModelAndView New_List(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
        
        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
        String nombre = request.getParameter("nombreList");
        String descripcion = request.getParameter("descripcion");
        
        //OBJETOS NECESARIOS PARA REALIZAR EL ACCESO A LA DB
        NewPlayList newList = new NewPlayList();
        ListaReproduccion lista = new ListaReproduccion();
        
        //UTILIZAMOS LA CLASE ARCHIVO PARA MANDAR LOS PARAMETROS
        lista.setId(0);
        lista.setNombre(nombre);
        lista.setDescripcion(descripcion);
        
        //OBTENEMOS EL RESULTADO
        int resultadoInsert = newList.nuevaLista(lista);
        
        if (resultadoInsert==1){
             //RECARGAMOS HOME
            return new ModelAndView("redirect:/home.htm");
            
        }else{
            return new ModelAndView("/");
            
        }
        
    }
}




