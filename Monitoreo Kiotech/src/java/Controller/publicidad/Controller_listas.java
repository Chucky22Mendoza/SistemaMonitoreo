/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.publicidad;

import com.objects.controller.Archivo;
import com.objects.controller.EditarArchivos;
import com.objects.controller.ListaReproduccion;
import com.objects.controller.ListasArchivos;
import com.getdata.controller.DeletePlayList;
import com.getdata.controller.GetFile;
import com.getdata.controller.GetPlayList;
import com.getdata.controller.NewPlayList;
import com.getdata.controller.PlayListsFiles;
import com.getdata.controller.UpdatePlayList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jesús Mendoza
 */
@Controller
public class Controller_listas {
    //PÁGINA PRINCIPAL
    @RequestMapping("listas.htm")
    public ModelAndView listas(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.err.println("hola");
        try{
            //VALIDAR EL ACCESO CON VARIABLES DE SESIÓN
            HttpSession session = request.getSession();
            String id = session.getAttribute("id_usuario").toString();
            String user = session.getAttribute("usuario").toString();
            String correo = session.getAttribute("correo").toString();
            String agencia = session.getAttribute("agencia").toString(); 
            //System.err.println("USUARIO " + user + " CORREO " + correo + " AGENCIA " + agencia);
            
            //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
            List<ListaReproduccion> lista = new ArrayList<>();
            List<Archivo> archivo = new ArrayList<>();
            
            //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
            lista = new GetPlayList().obtenerPlayLists();
            archivo =new GetFile().obtenerArchivo();
            //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("List", lista);
            mav.addObject("File", archivo);
            
            //ACCEDEMOS A HOME
            mav.setViewName("publicidad/listas_reproduccion");
            
            return mav;
            
        }catch(Exception e){
            System.err.println("ERROR INTENTANDO INICIAR SESIÓN");
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
        //lista.setId(0);
        lista.setNombre(nombre);
        lista.setDescripcion(descripcion);
        
        //OBTENEMOS EL RESULTADO
        int resultadoInsert = newList.nuevaLista(lista);
        System.err.println(resultadoInsert);
        if (resultadoInsert==1){
             //RECARGAMOS HOME
            return new ModelAndView("redirect:/home.htm");
            
        }else{
            return new ModelAndView("/");
            
        }
        
    }
    @RequestMapping("/NewsFiles.htm")
    protected ModelAndView NewsFiles(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
        
        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
        String listaSTR = request.getParameter("idLista");
        String archivoSTR = request.getParameter("idArchivo");
        String ordenSTR = request.getParameter("orden");
        
        int idLista = Integer.parseInt(listaSTR);
        int idArchivo = Integer.parseInt(archivoSTR);
        int orden = Integer.parseInt(ordenSTR);
        
        //OBJETOS NECESARIOS PARA REALIZAR EL ACCESO A LA DB
        ListasArchivos la = new ListasArchivos();
        PlayListsFiles plf = new PlayListsFiles();
        
        //UTILIZAMOS LA CLASE ARCHIVO PARA MANDAR LOS PARAMETROS
        la.setIdLista(idLista);
        la.setIdArchivo(idArchivo);
        la.setOrden(orden);
        
        //OBTENEMOS EL RESULTADO
        int resultadoInsert = plf.ListasArchivos(la);
        
        if (resultadoInsert==1){
             //RECARGAMOS HOME
            return new ModelAndView("redirect:/home.htm");
            
        }else{
            return new ModelAndView("/");
            
        }
        
    }
    
    @RequestMapping("/edit_files.htm")
    protected ModelAndView edit_files(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
        
        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
        String listaSTR = request.getParameter("idLista");
        int idLista = Integer.parseInt(listaSTR);
        
        //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
        List<EditarArchivos> lista = new ArrayList<>();
            
        //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
        lista = new GetFile().EditarArchivos(idLista);
        System.err.println(lista.isEmpty());
         if(lista.isEmpty()){
             //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            mav.addObject("exTitle", 1);
        
            mav.setViewName("templates/noresultado");
        
            return mav;
         }else{
             
            int rows = new GetFile().contarArchivos(idLista);
              //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("lista", lista);
            mav.addObject("rows", rows);
        
            mav.setViewName("templates/tablaArchivos");
        
            return mav;
            
         }
            
    }
    
    @RequestMapping("/ver_dif.htm")
    protected ModelAndView ver_dif(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
        
        //LLAMAMOS LAS VARIABLES MANDADAS POR EL AJAX
        String listaSTR = request.getParameter("idLista");
        int idLista = Integer.parseInt(listaSTR);
        
        System.err.println(idLista);
        //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
        List<Archivo> lista = new ArrayList<>();
            
        //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
        lista = new GetFile().NuevosArchivos(idLista);
        //System.err.println(lista.isEmpty());
         
              //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("lista", lista);
        
            mav.setViewName("templates/tablaArchivosAgregar");

            return mav;
    }
    
    @RequestMapping("/all_files.htm")
    protected ModelAndView all_files(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
        
        //OBTENEMOS LOS ARCHIVOS DE LA BASE DE DATOS Y LOS GUARDAMOS EN UN ARRAY TIPO ARCHIVO
        List<Archivo> lista = new ArrayList<>();
            
        //MÉTODO QUE RETORNA UNA LISTA TIPO ARCHIVO
        lista = new GetFile().obtenerArchivo();
        //System.err.println(lista.isEmpty());
         
              //NUEVA VISTA
            ModelAndView mav = new ModelAndView();
            
            //PASAMOS EL ARRAY A LA VISTA
            mav.addObject("lista", lista);
        
            mav.setViewName("templates/tablaArchivosAgregar");

            return mav;
    }
    
    @RequestMapping("/new_files.htm")
    protected ModelAndView new_files(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
        
        String id1STR = request.getParameter("idLista");
        String id2STR = request.getParameter("idArchivo");
        int idLista = Integer.parseInt(id1STR);
        int idArchivo = Integer.parseInt(id2STR);
        
        int res = new GetFile().InsertarArchivos(idLista, idArchivo);
        //System.err.println(res);
        //NUEVA VISTA
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("publicidad/listas_reproduccion");

        return mav;
    }
    
    @RequestMapping("/order_files.htm")
    protected ModelAndView order_files(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
        
        String id1STR = request.getParameter("idLista");
        String id2STR = request.getParameter("idArchivo");
        String ordenSTR = request.getParameter("orden");
        int idLista = Integer.parseInt(id1STR);
        int idArchivo = Integer.parseInt(id2STR);
        int orden = Integer.parseInt(ordenSTR);
        
        int res = new GetFile().ordenarArchivos(idLista, idArchivo,orden);
        //System.err.println(res);
        //NUEVA VISTA
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("publicidad/listas_reproduccion");

        return mav;
    }
    
    @RequestMapping("/delete_files.htm")
    protected ModelAndView delete_files(HttpServletRequest request, HttpServletResponse response/*2*/ ) throws ServletException, IOException{
        
        String id1STR = request.getParameter("idLista");
        String id2STR = request.getParameter("idArchivo");
        int idLista = Integer.parseInt(id1STR);
        int idArchivo = Integer.parseInt(id2STR);
        
        
        new GetFile().borrarArchivos(idLista, idArchivo);
        //System.err.println(res);
        //NUEVA VISTA
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("publicidad/listas_reproduccion");

        return mav;
    }
}
