package Model;

import GetData.GetFile;
import Views.Lista;
import Views.PantallaExclusiva;
import Views.PantallaServicios;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author mario
 */
public class checarNuevasListas extends Thread {
    
    List<archivoVideo> hora = new ArrayList<archivoVideo>();
    List<archivoVideo> horaComp = new ArrayList<archivoVideo>();
    
    public void run(){
        try {
            Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {                        
                        hora = Lista.mandarHoras();
                        horaComp = new GetFile().obtenerHora();  
                        
                        if (hora.size() != horaComp.size()) {
                            PantallaExclusiva.reinicializarArchivo();
                            PantallaServicios.reinicializarArchivo();
                            Lista.recargaLista();
                        }
                    }
                };
            timer.schedule(task, 10, 60000);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
