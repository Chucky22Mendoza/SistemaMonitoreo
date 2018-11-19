package Model;

import GetData.GetFile;
import Views.Lista;
import Views.PantallaExclusiva;
import Views.PantallaServicios;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;

/**
 *
 * @author mario
 */
public class checarNuevasListas extends Thread {

    List<archivoVideo> hora = new ArrayList<archivoVideo>();
    List<archivoVideo> horaComp = new ArrayList<archivoVideo>();

    public void run() {
        try {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    hora = Lista.mandarHoras();
                    horaComp = new GetFile().obtenerHora();
                    System.out.println("MINUTO");

                    if (hora.size() != horaComp.size()) {
                        Lista.recargaLista();

                        PantallaExclusiva.reinicializarArchivo();
                        PantallaExclusiva.recargaLista();

                        PantallaServicios.reinicializarArchivo();
                        PantallaServicios.recargaLista();

                    }
                }
            };
            timer.schedule(task, 10, 60000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
