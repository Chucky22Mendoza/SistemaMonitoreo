/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;

/**

 */
public class VistaJFrame extends javax.swing.JFrame implements IVista {
    ControladorCliente controlador;
    /**
     * Creates new form VistaJFrame
     */
    public VistaJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaTrasiego = new javax.swing.JTextArea();
        jLabelTextoAEnviar = new javax.swing.JLabel();
        jTextFieldTextoAEnviar = new javax.swing.JTextField();
        jButtonEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTextoPassword = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextAreaTrasiego.setBackground(new java.awt.Color(153, 153, 153));
        jTextAreaTrasiego.setColumns(20);
        jTextAreaTrasiego.setRows(5);
        jScrollPane1.setViewportView(jTextAreaTrasiego);

        jLabelTextoAEnviar.setText("Usuario:");

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cliente");

        jButton1.setText("Solicitar Status");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Contraseña:");

        jButton2.setText("Update Status");
        jButton2.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabelTextoAEnviar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTextoAEnviar)
                            .addComponent(jTextFieldTextoPassword)))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTextoAEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTextoAEnviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldTextoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
 
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButtonEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTextoAEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaTrasiego;
    public static javax.swing.JTextField jTextFieldTextoAEnviar;
    public static javax.swing.JTextField jTextFieldTextoPassword;
    // End of variables declaration//GEN-END:variables

    @Override
    public void habilitarEnviar() {
        jButtonEnviar.setEnabled(true);
    }
    
    @Override
    public void habilitarBtnStatus() {
        jButton1.setEnabled(true);
        jButtonEnviar.setEnabled(false);
    }

    @Override
    public void deshabilitarEnviar() {
        jButtonEnviar.setEnabled(false);
        jButton1.setEnabled(true);
        jTextFieldTextoAEnviar.setEnabled(false);
        jTextFieldTextoPassword.setEnabled(false);
    }

    @Override
    public void agnadirMensajeATrasiego(String mensaje) {
        jTextAreaTrasiego.append(mensaje + "\n");
    }

    @Override
    public void borrarTextoAEnviar() {
        jTextFieldTextoAEnviar.setText("");
        jTextFieldTextoPassword.setText("");
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
        jButtonEnviar.setActionCommand(ENVIAR);
        jButtonEnviar.addActionListener(controlador);
        
        jButton1.setActionCommand(STATUSMantenimiento);
        jButton1.addActionListener(controlador);
        
        jButton2.setActionCommand(ModificarSTATUS);
        jButton2.addActionListener(controlador);


    }

    @Override
    public String getMensajeAEnviar() {
        return jTextFieldTextoAEnviar.getText();
    }

    @Override
    public String getMensajeAEnviarPassword() {
        return jTextFieldTextoPassword.getText();
    }

   
}
