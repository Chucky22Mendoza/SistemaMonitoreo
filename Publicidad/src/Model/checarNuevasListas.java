package Model;

import GetData.GetFile;
import Views.Lista;
import Views.PantallaExclusiva;
import Views.PantallaServicios;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;

/**
 *
 * @author mario
 */
public class checarNuevasListas extends Thread {

    List<archivoVideo> hora = new ArrayList<archivoVideo>();
    static String hor, min;
    static int horaInicio[];

    public void run() {
        try {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {                    
                    try {
                        String hour;
                        hora = new GetFile().obtenerHora();
                        horaInicio = new int[hora.size()];

                        for (int i = 0; i < hora.size(); i++) {

                            if (hora.get(i).getMinutosInicio() >= 0 && hora.get(i).getMinutosInicio() < 10) {
                                hour = "" + hora.get(i).getHoraInicio() + "0" + hora.get(i).getMinutosInicio();
                            } else {
                                hour = "" + hora.get(i).getHoraInicio() + hora.get(i).getMinutosInicio();
                            }
                            horaInicio[i] = Integer.parseInt(hour);
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(checarNuevasListas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Lista.obtencionDia();
                    String list = Integer.toString(Envio.getHoraInicio() + Envio.getMinutoInicio());
                    int listaActual = Integer.parseInt(list);

                    diferenciador(listaActual);
                }
            };
            timer.schedule(task, 60000, 60000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void diferenciador(int listaActual) {
        int horaNueva = obtencionLista();
        
        if (horaNueva != listaActual) {
            actualizarListas();
        }
    }

    public static void actualizarListas() {
        try {
            Lista.recargaLista();

            PantallaExclusiva.reinicializarArchivo();
            PantallaExclusiva.recargaLista();

            PantallaServicios.reinicializarArchivo();
            PantallaServicios.recargaLista();

        } catch (IOException ex) {
            Logger.getLogger(checarNuevasListas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Método para conseguir la Lista de Reproduccion de ese momento 
    public int obtencionLista() {
        hor = Lista.obtencionHora();
        min = Lista.obtencionMinutos();
        String prueba = hor + min;
        int hour = Integer.parseInt(prueba);
        Integer lista = 0, guardar = -1;

        if (horaInicio.length == 1) {
            lista = 0;
        } else {
            for (int i = 0; i < horaInicio.length; i++) {
                if (hour == horaInicio[i]) {
                    lista = i;
                    break;
                } else {
                    if (hour < horaInicio[i]) {
                        guardar = i;
                    } else {
                        if (hour > horaInicio[i]) {
                            if (guardar == -1) {
                                lista = i;
                            } else {
                                lista = guardar;
                                break;
                            }
                        }
                    }
                }
            }
        }        
        
        String list = Integer.toString(hora.get(lista).getHoraInicio());
        String list2 = Integer.toString(hora.get(lista).getMinutosInicio());
        int listaActual = Integer.parseInt(list + list2);
        System.out.println(listaActual);
        
        return listaActual;
    }
}
