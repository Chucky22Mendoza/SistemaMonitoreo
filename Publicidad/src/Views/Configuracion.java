/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Model.Envio;
import Model.EnvioCorreo;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 *
 * @author 
 */
public class Configuracion extends javax.swing.JFrame {

    //COMPONENTES DEL SEGUNDO PLANO
    private ImageIcon imgIcon;
    private TrayIcon trayIcon;
    private SystemTray sysTray;
    
    public Configuracion() throws IOException {
        
        initComponents();  
        ///////////////////////
        //parte para cargar el archivo de propiedades en cuanto inicia el programa
        Properties p = new Properties();
        InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("properties/configuracion.properties");
        p.load(propertiesStream);
        String tipo = p.getProperty("tipo.configuracion");
        int con = Integer.parseInt(tipo);
        if(con == 1){
            try {
                  Properties prop = new Properties();
                  InputStream propertiesStream2 = ClassLoader.getSystemResourceAsStream("properties/exclusiva.config.properties");
                    prop.load(propertiesStream2);
                    txtHost.setText(prop.getProperty("conexiones.Host"));
                    txtUsuario.setText(prop.getProperty("conexiones.usuario"));
                    txtPuerto.setText(prop.getProperty("conexiones.Puerto"));
                    txtPassword.setText(prop.getProperty("conexiones.contraseña"));

                    txtLinkWS.setText(prop.getProperty("conexiones.WSM"));
                    txtDescarga.setText(prop.getProperty("conexiones.Archivos"));

                    txtPosicion.setText(prop.getProperty("pantalla.posicion"));
                    txtTamaño.setText(prop.getProperty("pantalla.tamaño"));
                    txtX.setText(prop.getProperty("pantalla.x"));
                    txtY.setText(prop.getProperty("pantalla.y"));
                  
                        
                } catch(IOException e) {
	JOptionPane.showMessageDialog(this,e.toString());
        
                }
        }else{
             try {
                  Properties prop = new Properties();
                  InputStream propertiesStream2 = ClassLoader.getSystemResourceAsStream("properties/compartida.config.properties");
                    prop.load(propertiesStream2);
                    txtHost.setText(prop.getProperty("conexiones.Host"));
                    txtUsuario.setText(prop.getProperty("conexiones.usuario"));
                    txtPuerto.setText(prop.getProperty("conexiones.Puerto"));
                    txtPassword.setText(prop.getProperty("conexiones.contraseña"));

                    txtLinkWS.setText(prop.getProperty("conexiones.WSM"));
                    txtDescarga.setText(prop.getProperty("conexiones.Archivos"));

                    txtPosicion.setText(prop.getProperty("pantalla.posicion"));
                    txtTamaño.setText(prop.getProperty("pantalla.tamaño"));
                    txtX.setText(prop.getProperty("pantalla.x"));
                    txtY.setText(prop.getProperty("pantalla.y"));

                    txtHeader.setText(prop.getProperty("pantalla.servicios.imagenHeader")); 
                  
                        
                } catch(IOException e) {
	JOptionPane.showMessageDialog(this,e.toString());
                }
        }
                
                
                
                
        ////////////////////////
        
        ImagenHLabel.setVisible(false);
        txtHeader.setVisible(false);
        ExaminarBtn.setVisible(false);
        rbExclusiva.setSelected(true);
        setLocationRelativeTo(null);
        
        /////////////SEGUNDO PLANO////////////////////////////////////////////////777
        imgIcon = new ImageIcon(getClass().getResource("../Images/app.png")); //IMAGEN QUE SERÁ USADA COMO ICONO
        try {
            setIconImage(imgIcon.getImage());         //MANDAR IMAGEN AL FRAME
        } catch (Exception e) {
        }
        this.setTitle("Configuracion"); //TÍTULO DE LA APP
        instanciarTray(); //LLAMADO DEL MÉTODO AL INICIAR LA APP (DESDE ENTONCES LA APP YA SE ENCUENTRA EN SEGUNDO PLANO (VER A DETALLE ESTE MÉTODO)
    }
    
    //MÉTODO PARA INSTANCIAR SYSTEM TRAY
    private void instanciarTray(){
        //ANTES DE ESTA LINEA DE CODIGO DEBERÁ CREARSE UN POPUP MENÚ EN AWT DE JAVA
        //SE INGRESA LA IMAGEN DE ICONO, UN TOOLTIP Y EL POPUP ANTES MENCIONADO QUE SERÁN LAS OPCIONES DEL USUARIO EN SEGUNDO PLANO
        trayIcon = new TrayIcon(imgIcon.getImage(), "tooltip del icono", popup);
        //ACOPLAR ICONO
        trayIcon.setImageAutoSize(true);
        //INSTANCIAR SYSTEM TRAY
        sysTray = SystemTray.getSystemTray();
        initSysTray(); //MANDAR A SEGUNDO PLANO LA APP DESDE QUE SE INICIA
    }
    
    private void initSysTray(){
        try {
            //SOLO SE INICIALIZA SI EL SISTEMA SOPORTA SYSTEM TRAY
            if(SystemTray.isSupported()){
                //SE AGREGA LA VARIABLE QUE CONTIENE EL ÍCONO, TOOLTIP Y POPUP
                sysTray.add(trayIcon);
                //OCULTAR LA VENTANA
                this.setVisible(false);
            }
        } catch (AWTException e) {
            //EN CASO DE ERROR, MOSTRARLO
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
    ///////////////////// SEGUNDO PLANO ////////////////////////////////////////////
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        jFrame1 = new javax.swing.JFrame();
        jSeparator1 = new javax.swing.JSeparator();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        popup = new java.awt.PopupMenu();
        Configuración = new java.awt.MenuItem();
        Salir = new java.awt.MenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtPuerto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLinkWS = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDescarga = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rbExclusiva = new javax.swing.JRadioButton();
        rbServicios = new javax.swing.JRadioButton();
        txtPosicion = new javax.swing.JTextField();
        txtY = new javax.swing.JTextField();
        txtX = new javax.swing.JTextField();
        txtTamaño = new javax.swing.JTextField();
        PosicionLabel = new javax.swing.JLabel();
        TamañoLabel = new javax.swing.JLabel();
        XLabel = new javax.swing.JLabel();
        YLabel = new javax.swing.JLabel();
        pxLabel1 = new javax.swing.JLabel();
        pxLabel2 = new javax.swing.JLabel();
        ImagenHLabel = new javax.swing.JLabel();
        txtHeader = new javax.swing.JTextField();
        ExaminarBtn = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        menu5.setLabel("File");
        menuBar3.add(menu5);

        menu6.setLabel("Edit");
        menuBar3.add(menu6);

        popup.setLabel("popupMenu1");
        popup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupActionPerformed(evt);
            }
        });

        Configuración.setLabel("Abrir");
        Configuración.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiguraciónActionPerformed(evt);
            }
        });
        popup.add(Configuración);

        Salir.setLabel("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        popup.add(Salir);

        setTitle("Reproductor Publicidad -  Configuraciones");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Base de Datos Local"));
        jPanel3.setToolTipText("Base de Datos Local");

        jLabel1.setText("Host");

        jLabel2.setText("Usuario");

        jLabel3.setText("Puerto");

        jLabel4.setText("Contraseña");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHost, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(txtUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel5.setText("Webservices de monitoreo");

        jLabel6.setText("Descarga de Archivos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLinkWS, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtLinkWS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Conexiones", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rbExclusiva.setText("Publicidad en Pantalla Exclusiva");
        rbExclusiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbExclusivaActionPerformed(evt);
            }
        });

        rbServicios.setText("Publicidad en Pantalla de Servicios");
        rbServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbServiciosActionPerformed(evt);
            }
        });

        txtPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosicionActionPerformed(evt);
            }
        });

        txtTamaño.setToolTipText("");

        PosicionLabel.setText("Posición:");
        PosicionLabel.setName("PosicionLabel"); // NOI18N

        TamañoLabel.setText("Tamaño: ");

        XLabel.setText("X");

        YLabel.setText("Y");

        pxLabel1.setText("px");

        pxLabel2.setText("px");

        ImagenHLabel.setText("Imagen Header");

        ExaminarBtn.setText("Examinar");
        ExaminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExaminarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbExclusiva)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(PosicionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TamañoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbServicios)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(YLabel)
                                        .addGap(28, 28, 28)
                                        .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(XLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ExaminarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pxLabel2)
                                    .addComponent(pxLabel1)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ImagenHLabel)
                        .addGap(18, 18, 18)
                        .addComponent(txtHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbExclusiva)
                    .addComponent(rbServicios))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PosicionLabel)
                    .addComponent(XLabel)
                    .addComponent(pxLabel1))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TamañoLabel)
                    .addComponent(YLabel)
                    .addComponent(pxLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImagenHLabel)
                    .addComponent(txtHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExaminarBtn))
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Pantalla", jPanel2);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Conexiones");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbExclusivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbExclusivaActionPerformed
       
        ImagenHLabel.setVisible(false);
        txtHeader.setVisible(false);
        ExaminarBtn.setVisible(false);
        
        rbServicios.setSelected(false);
        
        
    }//GEN-LAST:event_rbExclusivaActionPerformed

    private void rbServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbServiciosActionPerformed
       
        ImagenHLabel.setVisible(true);
        txtHeader.setVisible(true);
        ExaminarBtn.setVisible(true);

        rbExclusiva.setSelected(false);
    }//GEN-LAST:event_rbServiciosActionPerformed
        
        File archivo;
        ImageIcon img;
    private void ExaminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExaminarBtnActionPerformed
        
        Seleccion Buscador = new Seleccion();

        /*jf.showOpenDialog(this);
        File archivo= jf.getSelectedFile();*/
        
        int resultado;
        
        FileNameExtensionFilter formato = new FileNameExtensionFilter("JPG, PNG Y GIF", "jpg", "png", "gif");
        
        Buscador.fileChooser.setFileFilter(formato);        

        resultado = Buscador.fileChooser.showOpenDialog(null);
        
        if (JFileChooser.APPROVE_OPTION == resultado) {
            archivo = Buscador.fileChooser.getSelectedFile();
            txtHeader.setText(archivo.getAbsolutePath());
            
            try{
                img = new ImageIcon(archivo.toString());                

                //PRUEBA.setIcon(icon);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERROR AL ABRIR: " + e.getMessage());
            }
        }
        
        /*if (archivo != null) {
            ImagenHText.setText(archivo.getAbsolutePath());
        }*/
        
    }//GEN-LAST:event_ExaminarBtnActionPerformed
 

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(rbExclusiva.isSelected()){
            System.err.println(1);
        }
        
        if(rbServicios.isSelected()){
            System.err.println(2);
        }
        
        ////////////modificacion o no la configuracion sera guardada 
        /*prop.setProperty("conexiones.Host",txtHost.getText());
        prop.setProperty("conexiones.usuario",txtUsuario.getText());
        prop.setProperty("conexiones.Puerto", txtPuerto.getText());
        prop.setProperty("conexiones.contraseña",txtPassword.getText());

        prop.setProperty("conexiones.WSM",txtLinkWS.getText());
        prop.setProperty("conexiones.Archivos",txtDescarga.getText());

        prop.setProperty("pantalla.posicion",txtPosicion.getText());
        prop.setProperty("pantalla.tamaño",txtTamaño.getText());
        prop.setProperty("pantalla.x", txtX.getText());
        prop.setProperty("pantalla.y",txtY.getText());

        prop.setProperty("pantalla.servicios.imagenHeader",txtHeader.getText()); 
        
        //Cuando se cierra la aplicacion se debe de mandar a segundo plano
        //parte para guardar los datos si son o no modificados en el archivo de propiedades
            
        try {
            InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("properties/configuracion.properties");
            prop.load(propertiesStream);
            prop.store(new FileWriter("out.properties"),"Guardado correctamente");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,ex.toString());
        }*/
        ///////////////////////////
        //parte de enviar a las pantallas de exclusiva y servicios
        
        int x = Integer.parseInt(txtX.getText());
        int y = Integer.parseInt(txtY.getText());
        int p = Integer.parseInt(txtPosicion.getText());
        int t = Integer.parseInt(txtTamaño.getText());
        
        Envio.setAlto(y);
        Envio.setAncho(x);
        Envio.setPosicion(p);
        Envio.setTamaño(t);
        
        //correoTLS();
        //correoSSL();        
        
        if (rbServicios.isSelected()) {          

           PantallaServicios abrir=new PantallaServicios(img);
           this.setVisible(false);
           abrir.setVisible(true);
        }else{
            this.setVisible(false);
           PantallaExclusiva a=new PantallaExclusiva();
           a.setVisible(true);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

        final String fromEmail = Envio.getCorreo(); //requires valid gmail id
        final String password = Envio.getContrasena(); // correct password for gmail id
        final String toEmail = "mariodeltoro2009@live.com.mx"; // can be any email id 
    
    //Método para el envio de correo mediante autenticación TLS
    public void correoTLS(){
        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                }
        };
        Session session = Session.getInstance(props, auth);
        
        EnvioCorreo correo = new EnvioCorreo(session, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body");
        correo.start();
    }
    
    //Método  para el envío de correo mediante autenticación SSL
    public void correoSSL(){		
        System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port

        Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                }
        };

        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");
        
        EnvioCorreo correo = new EnvioCorreo(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");
        correo.start();
        
        //EnvioCorreo.sendEmail(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");

        //EnvioCorreo.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");

        //EnvioCorreo.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");
    }
    
    private void popupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popupActionPerformed

    
    
    private void ConfiguraciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguraciónActionPerformed
        // Cuando le da click en abrir en el popout
        this.setVisible(true);
    }//GEN-LAST:event_ConfiguraciónActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // Cuando le da click en el cerrar en el popout
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

         
         initSysTray();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
    }//GEN-LAST:event_formWindowClosing

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPosicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPosicionActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Configuracion().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.MenuItem Configuración;
    private javax.swing.JButton ExaminarBtn;
    private javax.swing.JLabel ImagenHLabel;
    private javax.swing.JLabel PosicionLabel;
    private java.awt.MenuItem Salir;
    private javax.swing.JLabel TamañoLabel;
    private javax.swing.JLabel XLabel;
    private javax.swing.JLabel YLabel;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    private java.awt.PopupMenu popup;
    private javax.swing.JLabel pxLabel1;
    private javax.swing.JLabel pxLabel2;
    private javax.swing.JRadioButton rbExclusiva;
    private javax.swing.JRadioButton rbServicios;
    private javax.swing.JTextField txtDescarga;
    public static javax.swing.JTextField txtHeader;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtLinkWS;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPosicion;
    private javax.swing.JTextField txtPuerto;
    private javax.swing.JTextField txtTamaño;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtX;
    private javax.swing.JTextField txtY;
    // End of variables declaration//GEN-END:variables
  
   

}
