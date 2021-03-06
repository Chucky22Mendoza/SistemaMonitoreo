/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import GetData.GetFile;
import Model.Envio;
import Model.archivoVideo;
import Model.checarNuevasListas;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.commons.io.FilenameUtils;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

/**
 *
 * @author nipan
 */
public final class PantallaServicios extends javax.swing.JFrame {

    /**
     * Creates new form PantallaServicios
     *
     * @param img
     */
    public PantallaServicios(ImageIcon img) throws IOException {
        initComponents();
        imagen(img);
        tamañoPantalla();
        cambiarLibrerias();
        Lista list = new Lista();
        list.setVisible(true);
        reproducirVideo();
        setLocationRelativeTo(null);
    }

    public PantallaServicios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        video = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();

        jButton4.setText("jButton1");

        jButton7.setText("Servicio 5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        video.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout videoLayout = new javax.swing.GroupLayout(video);
        video.setLayout(videoLayout);
        videoLayout.setHorizontalGroup(
            videoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );
        videoLayout.setVerticalGroup(
            videoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jButton1.setText("Servicio 3");

        jButton2.setText("Servicio 1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Servicio 4");

        jButton5.setText("Servicio 2");

        jButton6.setText("Servicio 5");

        jButton8.setText("Otros servicios");

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(video, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(video, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private static EmbeddedMediaPlayerComponent player;
    static List<archivoVideo> file = new ArrayList<archivoVideo>();

    //Método para reproducir el video en la pantalla
    public void reproducirVideo() throws IOException {
        List<archivoVideo> hora = new ArrayList<archivoVideo>();
        Envio envio = new Envio();
        String hour;
        hora = new GetFile().obtenerHora();

        if (!hora.isEmpty()) {
            MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
            EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(this));
            player = new EmbeddedMediaPlayerComponent();
            //se añade reproductor 
            video.add(player);
            player.setSize(video.getSize());
            player.setVisible(true);

            try {
                checarNuevasListas checar = new checarNuevasListas();
                checar.start();

                //Prepara el video a reproducir
                recargaLista();
                cargarMedia(mediaPlayer);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    static int archivo = -1, duracion;
    static String ruta;

    public static void cargarMedia(EmbeddedMediaPlayer mediaPlayer) {
        archivo++;
        ruta = rutaArchivo();
        if (!ruta.equalsIgnoreCase("")) {
            duracion = duracionMedio();
            player.getMediaPlayer().playMedia(ruta);
            System.out.println(ruta);
            //player.getMediaPlayer().playMedia("C:\\Users\\mario\\Desktop\\SistemaMonitoreo\\Publicidad\\src\\Video\\" + listOfFiles[archivo].getName());
            //mediaPlayer.prepareMedia("http://192.168.1.139:1080/smp/Publicidad/src/Video/Kiosco_" + kiosko + "/" + listOfFiles[archivo].getName()); //Servidor
            player.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
                @Override
                public void playing(MediaPlayer prueba) {
                    Timer timer = new Timer();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            if (!prueba.isPlaying()) {
                                prueba.stop();
                                timer.cancel();
                            }
                        }
                    };
                    timer.schedule(task, 10, (duracion * 1000 - 800));
                }

                @Override
                public void finished(MediaPlayer prueba) {
                    if (archivo == (file.size() - 1)) {
                        archivo = -1;

                        try {
                            recargaLista();
                            Lista.recargaLista();
                        } catch (IOException ex) {
                            Logger.getLogger(PantallaExclusiva.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        cargarMedia(mediaPlayer);

                        prueba.removeMediaPlayerEventListener(this);
                    } else {
                        cargarMedia(mediaPlayer);
                        prueba.removeMediaPlayerEventListener(this);
                    }

                }

                @Override
                public void error(MediaPlayer prueba) {
                    if (archivo == (file.size() - 1)) {
                        archivo = -1;

                        try {
                            recargaLista();
                            Lista.recargaLista();
                        } catch (IOException ex) {
                            Logger.getLogger(PantallaExclusiva.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        cargarMedia(mediaPlayer);

                        prueba.removeMediaPlayerEventListener(this);
                    } else {
                        cargarMedia(mediaPlayer);
                        prueba.removeMediaPlayerEventListener(this);
                    }
                }
            });
        }
    }

    //Método para obtener la ruta del archivo
    public static String rutaArchivo() {
        if (file.isEmpty()) {
            return "";
        } else {
            return file.get(archivo).getUbicacion();
        }
    }

    //Método para reinicializar variable archivo
    public static void reinicializarArchivo() {
        archivo = -1;
    }

    //Método para obtener la duracion del medio
    public static int duracionMedio() {
        return file.get(archivo).getDuracion();
    }

    //Método para saber la extensión del archivo
    public String extensionArchivo(String ruta) {
        //Obtiene la extensión del archivo        
        return FilenameUtils.getExtension(ruta);
    }

    //Método para recargar
    public static void recargaLista() throws IOException {
        file = new GetFile().obtenerArchivo();
    }

    //Método para leer librerias directas del VLC de 64 bits
    static void cambiarLibrerias() {
        NativeLibrary.addSearchPath(
                RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        LibXUtil.initialise();
    }

    //método para fijar el tamaño de la pantalla
    public void tamañoPantalla() {
        this.setSize(new Dimension(Envio.getAncho(), Envio.getAlto()));
    }

    //Método para fijar la imagen 
    public void imagen(ImageIcon img) {
        try {

            Icon icon = new ImageIcon(img.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
            imagen.setIcon(icon);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ABRIR: " + e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run(ImageIcon img) throws IOException {
                new PantallaServicios(img).setVisible(true);
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel video;
    // End of variables declaration//GEN-END:variables
}
