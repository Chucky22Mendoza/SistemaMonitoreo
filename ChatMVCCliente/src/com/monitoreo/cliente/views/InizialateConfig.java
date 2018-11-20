/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.cliente.views;

import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class InizialateConfig extends javax.swing.JFrame {

    /**
     * Creates new form InizialateConfig
     */
    
    private ImageIcon imgIcon;
    private TrayIcon trayIcon;
    private SystemTray sysTray;
    public InizialateConfig() {
        imgIcon = new ImageIcon(getClass().getResource("/com/monitoreo/images/conf.png")); //IMAGEN QUE SERÁ USADA COMO ICONO
        initComponents();
        this.setIconImage(imgIcon.getImage());
        this.setResizable(false);
        this.setLocationRelativeTo(null);        //COLOCAR LA APP EN EL CENTRO
        this.setTitle("Configuracion"); //TÍTULO DE LA APP
        instanciarTray();
        sysTray();
        int res = iniciar();
        if(res == 1){
            texto();
        }else{
            if(res==10){
                JOptionPane.showMessageDialog(null, "Error en la configuración","Error",2);
            }else{
                JOptionPane.showMessageDialog(null, "Configuración de monitoreo","Bienvendio",1);
            }
        }
    }
    
    private int iniciar(){
        try {
            Properties p = new Properties();
            //Forma de buscar la ruta dentro del proyecto
            InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("com/monitoreo/properties/configuracion.properties");
            p.load(propertiesStream);
            
            //Forma de mandar valor a una propiedad
            String ini = p.getProperty("inizializate.config");
            /*String host = p.getProperty("database.host");
            String puerto = p.getProperty("database.port");
            String name = p.getProperty("database.name");
            String user = p.getProperty("database.user");
            String pass = p.getProperty("database.password");
            String id_kiosco = p.getProperty("database.id_kiosco");
            String ws = p.getProperty("webservice.url");
            
            int id = Integer.parseInt(id_kiosco);*/
            int ret = Integer.parseInt(ini);
            
            //Prop pr = new Prop(ret,pass,puerto,user,id,name,ws,host);
            propertiesStream.close();
            sysTray.remove(trayIcon);
            sysTray();
            return ret;
        } catch (IOException ex) {
            Logger.getLogger(InizialateConfig.class.getName()).log(Level.SEVERE, null, ex);
            return 10;
        }
    }
    
    void texto(){
        try {
            Properties p = new Properties();
            //Forma de buscar la ruta dentro del proyecto
            InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("com/monitoreo/properties/configuracion.properties");
            p.load(propertiesStream);
            
            //Forma de mandar valor a una propiedad
            String ini = p.getProperty("inizializate.config");
            String host = p.getProperty("database.host");
            String puerto = p.getProperty("database.port");
            String name = p.getProperty("database.name");
            String user = p.getProperty("database.user");
            String pass = p.getProperty("database.password");
            String id_kiosco = p.getProperty("database.id_kiosco");
            String ws = p.getProperty("webservice.url");
            
            txtHost.setText(host);
            txtPort.setText(puerto);
            txtDB.setText(name);
            txtUser.setText(user);
            txtPass.setText(pass);
            txtIdKiosco.setText(id_kiosco);
            txtWS.setText(ws);
            
            propertiesStream.close();
        } catch (IOException ex) {
            Logger.getLogger(InizialateConfig.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //MÉTODO PARA INSTANCIAR SYSTEM TRAY
    private void instanciarTray(){
        //ANTES DE ESTA LINEA DE CODIGO DEBERÁ CREARSE UN POPUP MENÚ EN AWT DE JAVA
        //SE INGRESA LA IMAGEN DE ICONO, UN TOOLTIP Y EL POPUP ANTES MENCIONADO QUE SERÁN LAS OPCIONES DEL USUARIO EN SEGUNDO PLANO
        trayIcon = new TrayIcon(imgIcon.getImage(), "Monitoreo", popup);
        //ACOPLAR ICONO
        trayIcon.setImageAutoSize(true);
        //INSTANCIAR SYSTEM TRAY
        sysTray = SystemTray.getSystemTray();
        
    }
    
    private void sysTray(){
        try {
            //SOLO SE INICIALIZA SI EL SISTEMA SOPORTA SYSTEM TRAY
            if(SystemTray.isSupported()){
                //SE AGREGA LA VARIABLE QUE CONTIENE EL ÍCONO, TOOLTIP Y POPUP
                sysTray.add(trayIcon);                
                //OCULTAR LA VENTANA
                this.setVisible(false);
            }
        } catch (Exception e) {
            //EN CASO DE ERROR, MOSTRARLO
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new java.awt.PopupMenu();
        Sincronización = new java.awt.MenuItem();
        Configuración = new java.awt.MenuItem();
        Salir = new java.awt.MenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPass = new org.edisoncor.gui.passwordField.PasswordFieldRoundBackground();
        txtUser = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        txtHost = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        txtPort = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        txtDB = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        buttonAeroLeft1 = new org.edisoncor.gui.button.ButtonAeroLeft();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtIdKiosco = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        jLabel7 = new javax.swing.JLabel();
        txtWS = new org.edisoncor.gui.textField.TextFieldRoundBackground();

        popup.setLabel("popupMenu1");

        Sincronización.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Sincronización.setLabel("Sincronización");
        Sincronización.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SincronizaciónActionPerformed(evt);
            }
        });
        popup.add(Sincronización);

        Configuración.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Configuración.setLabel("Configuración");
        Configuración.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiguraciónActionPerformed(evt);
            }
        });
        popup.add(Configuración);

        Salir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Salir.setLabel("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        popup.add(Salir);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Host:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Puerto:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Base de datos:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Usuario:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Contraseña:");

        txtPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPass.setDescripcion("Ingrese su contraseña");
        txtPass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser.setDescripcion("Ingrese su usuario");
        txtUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        txtHost.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHost.setDescripcion("Ingrese el host");
        txtHost.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        txtPort.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPort.setDescripcion("Ingrese puerto del host");
        txtPort.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        txtDB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDB.setDescripcion("Ingrese nombre de base de datos");
        txtDB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        buttonAeroLeft1.setBackground(new java.awt.Color(102, 102, 102));
        buttonAeroLeft1.setText("Guardar");
        buttonAeroLeft1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAeroLeft1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Configuración de Monitoreo");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("ID Kiosco:");

        txtIdKiosco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdKiosco.setDescripcion("ID: 9");
        txtIdKiosco.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Web Service:");

        txtWS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtWS.setDescripcion("Ingrese URL");
        txtWS.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(112, 112, 112))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtWS, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtHost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtIdKiosco, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonAeroLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAeroLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtIdKiosco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void buttonAeroLeft1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAeroLeft1ActionPerformed
        
        try {
            Properties p = new Properties();
            //Forma de buscar la ruta dentro del proyecto
            InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("com/monitoreo/properties/configuracion.properties");
            p.load(propertiesStream);
            String host = txtHost.getText();
            String puerto = txtPort.getText();
            String db = txtDB.getText();
            String user = txtUser.getText();
            String pass = txtPass.getText();
            String id_kiosco = txtIdKiosco.getText();
            String ws = txtWS.getText();
            
            if(!host.isEmpty() && !puerto.isEmpty() && !db.isEmpty() && !user.isEmpty() && !pass.isEmpty() && !id_kiosco.isEmpty()){
                //Forma de mandar valor a una propiedad
                p.setProperty("inizializate.config", "1");
                p.setProperty("database.host", host);
                p.setProperty("database.port", puerto);
                p.setProperty("database.name", db);
                p.setProperty("database.user", user);
                p.setProperty("database.password", pass);
                p.setProperty("database.id_kiosco", id_kiosco);
                p.setProperty("webservice.url", ws);
                //Forma de guardar properties
                FileOutputStream os = null;	   
                
                try {
                  os=new FileOutputStream("C:\\Users\\Jesús Mendoza\\Documents\\GitHub\\SistemaMonitoreo\\ChatMVCCliente\\src\\com\\monitoreo\\properties\\configuracion.properties");	
                  //os=new FileOutputStream(p.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
                  p.store(os, "Configuración de base de datos");
                  
                } catch(IOException ioe) {
                    ioe.printStackTrace();
                }
                
                propertiesStream.close();
                JOptionPane.showMessageDialog(null, "Guardado correctamente","Completado",1);
                sysTray.remove(trayIcon);
                sysTray();
                BackFrame bf = new BackFrame();
                bf.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Favor de ingresar todos los campos correctamente","Error",2);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(InizialateConfig.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_buttonAeroLeft1ActionPerformed

    private void ConfiguraciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguraciónActionPerformed
        this.setVisible(true);
    }//GEN-LAST:event_ConfiguraciónActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        sysTray.remove(trayIcon);
        sysTray();
    }//GEN-LAST:event_formWindowClosing

    private void SincronizaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SincronizaciónActionPerformed
        BackFrame bf = new BackFrame();
        bf.setVisible(true);
    }//GEN-LAST:event_SincronizaciónActionPerformed

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
            java.util.logging.Logger.getLogger(InizialateConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InizialateConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InizialateConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InizialateConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InizialateConfig().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.MenuItem Configuración;
    private java.awt.MenuItem Salir;
    private java.awt.MenuItem Sincronización;
    private org.edisoncor.gui.button.ButtonAeroLeft buttonAeroLeft1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.PopupMenu popup;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtDB;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtHost;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtIdKiosco;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundBackground txtPass;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtPort;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtUser;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtWS;
    // End of variables declaration//GEN-END:variables
}
