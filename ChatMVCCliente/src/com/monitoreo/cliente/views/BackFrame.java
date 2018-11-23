/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreo.cliente.views;

import com.monitoreo.cliente.controller.ControladorCliente;
import com.monitoreo.cliente.model.objects.ModeloCliente;
import com.monitoreo.cliente.model.objects.fn_sincronizar_dispositivo_vendingModel;
import com.monitoreo.restful.set.WebService;
import javax.swing.ImageIcon;
import javax.ws.rs.core.Response;

/**
 */
public class BackFrame extends javax.swing.JFrame implements IVista {
    ControladorCliente controlador;
    /**
     * Creates new form VistaJFrame
     */
    private ImageIcon imgIcon;
    public BackFrame() {
        imgIcon = new ImageIcon(getClass().getResource("/com/monitoreo/images/sync.png")); //IMAGEN QUE SERÁ USADA COMO ICONO
        initComponents();
        this.setIconImage(imgIcon.getImage());
        this.setResizable(false);
        this.setLocationRelativeTo(null);        //COLOCAR LA APP EN EL CENTRO
        this.setTitle("Sincronización"); //TÍTULO DE LA APP
        txtResponse.setLineWrap(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResponse = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnSincronizar = new org.edisoncor.gui.button.ButtonAeroRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(493, 335));
        setMinimumSize(new java.awt.Dimension(493, 335));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        txtResponse.setBackground(new java.awt.Color(204, 204, 204));
        txtResponse.setColumns(20);
        txtResponse.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtResponse.setLineWrap(true);
        txtResponse.setRows(5);
        txtResponse.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        txtResponse.setEnabled(false);
        jScrollPane1.setViewportView(txtResponse);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Sincronización de base de datos");

        btnSincronizar.setBackground(new java.awt.Color(102, 102, 102));
        btnSincronizar.setText("Sincronizar");
        btnSincronizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSincronizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(btnSincronizar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSincronizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSincronizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSincronizarActionPerformed
        WebService ws = new WebService();
        /*List<fn_registrar_alertaModel> historial_alerta = new Sincronizacion().get_alertas();
        
        int ha_lng = historial_alerta.size();
        
        for(int i = 0; i < ha_lng;i++){
        fn_registrar_alertaModel obj = new fn_registrar_alertaModel();
        
        obj.setId_historial_alerta(historial_alerta.get(i).getId_historial_alerta());
        obj.setMensaje(historial_alerta.get(i).getMensaje());
        obj.setFecha_hora(historial_alerta.get(i).getFecha_hora());
        obj.setStatus(historial_alerta.get(i).isStatus());
        obj.setId_evento(historial_alerta.get(i).getId_evento());
        obj.setId_kiosco(historial_alerta.get(i).getId_kiosco());
        */
        ModeloCliente model = new ModeloCliente();
        model.enviarMensaje("OK");
        /*
        fn_sincronizar_dispositivo_vendingModel obj = new fn_sincronizar_dispositivo_vendingModel(2,"prueba desde cliente");
        int status = ws.fn_sincronizar_dispositivo_vending(obj).getStatus();
        
        if(status == 200){
            ModeloCliente model=new ModeloCliente();
            //String response = "OK";
            //String response = "Status: 200 Sincronizado: ''''''fn_registrar_alerta'''''' Response: OK";
            model.enviarMensaje("OK");
        }else{
            ModeloCliente model=new ModeloCliente();
            //String response = "ERROR";
            //String response = "Status: 404 \n Sincronizado: ''''''fn_registrar_alerta'''''' \n Response: ERROR";
            model.enviarMensaje("ERROR");
        }
        //}*/
        /*
        List<fn_registrar_alerta_enviadaModel> alerta_enviada = new Sincronizacion().get_alerta_enviada();
        int ae_lng = alerta_enviada.size();
        
        for(int i = 0; i < ae_lng;i++){
        fn_registrar_alerta_enviadaModel obj = new fn_registrar_alerta_enviadaModel();
        
        obj.setId_alerta_enviada(alerta_enviada.get(i).getId_alerta_enviada());
        obj.setFecha_hora(alerta_enviada.get(i).getFecha_hora());
        obj.setEmisor(alerta_enviada.get(i).getEmisor());
        obj.setCorreo_enviado(alerta_enviada.get(i).isCorreo_enviado());
        obj.setSms_enviado(alerta_enviada.get(i).isCorreo_enviado());
        obj.setId_usuario(alerta_enviada.get(i).getId_usuario());
        obj.setId_historial_alerta(alerta_enviada.get(i).getId_historial_alerta());
        obj.setId_kiosco(alerta_enviada.get(i).getId_kiosco());
        
        Response stts = ws.fn_registrar_alerta_enviada(obj);
        int status = stts.getStatus();
        
        if(status == 200){
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 200 \n Sincronizado: ''''''fn_registrar_alerta_enviada'''''' \n Response: OK";
        model.enviarMensaje(response);
        }else{
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 404 \n Sincronizado: ''''''fn_registrar_alerta_enviada'''''' \n Response: ERROR";
        model.enviarMensaje(response);
        }
        }
        List<fn_registrar_corte_cajaModel> corte_caja = new Sincronizacion().get_corte_caja();
        int cc_lng = corte_caja.size();
        
        for(int i = 0; i < cc_lng;i++){
        fn_registrar_corte_cajaModel obj = new fn_registrar_corte_cajaModel();
        
        obj.setId_corte_caja(corte_caja.get(i).getId_corte_caja());
        obj.setFecha_hora(corte_caja.get(i).getFecha_hora());
        obj.setId_kiosco(corte_caja.get(i).getId_kiosco());
        
        Response stts = ws.fn_registrar_corte_caja(obj);
        int status = stts.getStatus();
        
        if(status == 200){
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 200 \n Sincronizado: ''''''fn_registrar_corte_caja'''''' \n Response: OK";
        model.enviarMensaje(response);
        }else{
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 404 \n Sincronizado: ''''''fn_registrar_corte_caja'''''' \n Response: ERROR";
        model.enviarMensaje(response);
        }
        }
        
        List<fn_sincronizar_configuracion_envioModel> configuracion_envio = new Sincronizacion().get_configuracion_envio();
        int ce_lng = configuracion_envio.size();
        
        for(int i = 0; i < ce_lng;i++){
        fn_sincronizar_configuracion_envioModel obj = new fn_sincronizar_configuracion_envioModel();
        
        obj.setId_configuracion_envio(configuracion_envio.get(i).getId_configuracion_envio());
        obj.setServidor_smtp(configuracion_envio.get(i).getServidor_smtp());
        obj.setSeguridad(configuracion_envio.get(i).getSeguridad());
        obj.setUsuario(configuracion_envio.get(i).getUsuario());
        obj.setContrasena(configuracion_envio.get(i).getContrasena());
        obj.setPuerto(configuracion_envio.get(i).getPuerto());
        obj.setPuerto_tarjeta_sms(configuracion_envio.get(i).getPuerto_tarjeta_sms());
        
        
        Response stts = ws.fn_sincronizar_configuracion_envio(obj);
        int status = stts.getStatus();
        
        if(status == 200){
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 200 \n Sincronizado: ''''''fn_sincronizar_configuracion_envio'''''' \n Response: OK";
        model.enviarMensaje(response);
        }else{
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 404 \n Sincronizado: ''''''fn_sincronizar_configuracion_envio'''''' \n Response: ERROR";
        model.enviarMensaje(response);
        }
        }
        
        List<fn_sincronizar_dispositivo_vendingModel> dispositivo_vending = new Sincronizacion().get_dispositivo_vending();
        int dv_lng = dispositivo_vending.size();
        
        for(int i = 0; i < dv_lng;i++){
        fn_sincronizar_dispositivo_vendingModel obj = new fn_sincronizar_dispositivo_vendingModel();
        
        obj.setId_dispositivo_vending(dispositivo_vending.get(i).getId_dispositivo_vending());
        obj.setNombre(dispositivo_vending.get(i).getNombre());
        
        Response stts = ws.fn_sincronizar_dispositivo_vending(obj);
        int status = stts.getStatus();
        
        if(status == 200){
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 200 \n Sincronizado: ''''''fn_sincronizar_dispositivo_vending'''''' \n Response: OK";
        model.enviarMensaje(response);
        }else{
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 404 \n Sincronizado: ''''''fn_sincronizar_dispositivo_vending'''''' \n Response: ERROR";
        model.enviarMensaje(response);
        }
        }
        
        List<fn_sincronizar_dispositivo_vending_kioscoModel> dispositivo_vending_kiosco = new Sincronizacion().get_dispositivo_vending_kiosco();
        int dvk_lng = dispositivo_vending_kiosco.size();
        
        for(int i = 0; i < dvk_lng;i++){
        fn_sincronizar_dispositivo_vending_kioscoModel obj = new fn_sincronizar_dispositivo_vending_kioscoModel();
        
        obj.setId_dispositivo_vending_kiosco(dispositivo_vending_kiosco.get(i).getId_dispositivo_vending_kiosco());
        obj.setStatus(dispositivo_vending_kiosco.get(i).isStatus());
        obj.setId_kiosco(dispositivo_vending_kiosco.get(i).getId_kiosco());
        obj.setId_dispositivo_vending(dispositivo_vending_kiosco.get(i).getId_dispositivo_vending());
        
        Response stts = ws.fn_sincronizar_dispositivo_vending_kiosco(obj);
        int status = stts.getStatus();
        
        if(status == 200){
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 200 \n Sincronizado: ''''''fn_sincronizar_dispositivo_vending_kiosco'''''' \n Response: OK";
        model.enviarMensaje(response);
        }else{
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 404 \n Sincronizado: ''''''fn_sincronizar_dispositivo_vending_kiosco'''''' \n Response: ERROR";
        model.enviarMensaje(response);
        }
        }
        
        List<fn_sincronizar_kioscoModel> kiosco = new Sincronizacion().get_kiosco();
        int k_lng = kiosco.size();
        
        for(int i = 0; i < k_lng;i++){
        fn_sincronizar_kioscoModel obj = new fn_sincronizar_kioscoModel();
        
        obj.setId_kiosco(kiosco.get(i).getId_kiosco());
        obj.setNombre(kiosco.get(i).getNombre());
        obj.setStatus_mantenimiento(kiosco.get(i).isStatus_mantenimiento());
        obj.setIp(kiosco.get(i).getIp());
        obj.setId_status(kiosco.get(i).getId_status());
        obj.setId_agencia(kiosco.get(i).getId_agencia());
        obj.setId_configuracion_envio(kiosco.get(i).getId_configuracion_envio());
        
        Response stts = ws.fn_sincronizar_kiosco(obj);
        int status = stts.getStatus();
        
        if(status == 200){
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 200 \n Sincronizado: ''''''fn_sincronizar_kiosco'''''' \n Response: OK";
        model.enviarMensaje(response);
        }else{
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 404 \n Sincronizado: ''''''fn_sincronizar_kiosco'''''' \n Response: ERROR";
        model.enviarMensaje(response);
        }
        }
        List<fn_sincronizar_impresoraModel> impresora = new Sincronizacion().get_impresora();
        int i_lng = impresora.size();
        
        for(int i = 0; i < i_lng;i++){
        fn_sincronizar_impresoraModel obj = new fn_sincronizar_impresoraModel();
        
        obj.setId_impresora(impresora.get(i).getId_impresora());
        obj.setNombre(impresora.get(i).getNombre());
        obj.setId_kiosco(impresora.get(i).getId_kiosco());
        obj.setFecha_actualizacion(impresora.get(i).getFecha_actualizacion());
        
        Response stts = ws.fn_sincronizar_kiosco(obj);
        int status = stts.getStatus();
        
        if(status == 200){
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 200 \n Sincronizado: ''''''fn_sincronizar_impresora'''''' \n Response: OK";
        model.enviarMensaje(response);
        }else{
        ModeloCliente model=new ModeloCliente();
        String response = "Status: 404 \n Sincronizado: ''''''fn_sincronizar_impresora'''''' \n Response: ERROR";
        model.enviarMensaje(response);
        }
        }*/
    }//GEN-LAST:event_btnSincronizarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static org.edisoncor.gui.button.ButtonAeroRound btnSincronizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea txtResponse;
    // End of variables declaration//GEN-END:variables

    @Override
    public void agnadirMensajeATrasiego(String mensaje) {
        txtResponse.append(mensaje + "\n");
    }
    
    @Override
    public void setControlador(ControladorCliente controlador) {
        this.controlador = controlador;
    }

    @Override
    public void hacerVisible() {
        setVisible(true);
    }

    public void inicializar(){
        btnSincronizar.setActionCommand(Sincronizar);
        btnSincronizar.addActionListener(controlador);

    }

    @Override
    public void deshabilitarEnviar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarTextoAEnviar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMensajeAEnviar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMensajeAEnviarPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void habilitarEnviar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void habilitarBtnStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
