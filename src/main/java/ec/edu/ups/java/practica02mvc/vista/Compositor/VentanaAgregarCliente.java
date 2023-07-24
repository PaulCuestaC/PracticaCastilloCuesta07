/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.vista.Compositor;

import ec.edu.ups.java.practica02mvc.controlador.ControladorCantante;
import ec.edu.ups.java.practica02mvc.controlador.ControladorCompositor;
import ec.edu.ups.java.practica02mvc.modelo.Cantante;
import ec.edu.ups.java.practica02mvc.modelo.Compositor;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class VentanaAgregarCliente extends javax.swing.JInternalFrame {

    private ControladorCompositor controladorCompositor;
    private ControladorCantante controladorCantante;
    private ResourceBundle mensajes;

    /**
     * Creates new form VentanaAgregarCliente
     */
    public VentanaAgregarCliente(ControladorCompositor controladorCompositor, ControladorCantante controladorCantante) {
        initComponents();
        this.controladorCantante = controladorCantante;
        this.controladorCompositor = controladorCompositor;
    }
    public void cambiarIdioma(Locale localizacion){
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        jLabel8.setText(mensajes.getString("txtCodigoCompositor"));
        jLabel10.setText(mensajes.getString("txtNombreCom"));
        jLabel7.setText(mensajes.getString("txtCodigoCliente"));
        jLabel9.setText(mensajes.getString("txtNombreCan"));
        jLabel12.setText(mensajes.getString("jLabel12"));
        btnAceptar.setText(mensajes.getString("btnAceptar"));
        btnCancelar.setText(mensajes.getString("btnCancelar"));
        btnBuscarCliente.setText(mensajes.getString("btnBuscarCliente"));
        btnBuscar.setText(mensajes.getString(" btnBuscar"));
        
    }
            /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoCompositor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNombreCan = new javax.swing.JTextField();
        txtNombreCom = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Agregar Cliente");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 200, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Codigo del Cliente");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 150, 41));
        getContentPane().add(txtCodigoCompositor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 211, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre Artistico");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 41));

        txtCodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 211, -1));

        btnBuscarCliente.setText("Buscar");
        getContentPane().add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        btnAceptar.setText("Aceptar");
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, 37));

        btnCancelar.setText("Cancelar");
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, -1, 37));
        getContentPane().add(txtNombreCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 211, -1));
        getContentPane().add(txtNombreCom, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 211, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Codigo del Compositor");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 62, 150, 41));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 109, 104, 41));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Compositor.png"))); // NOI18N
        jLabel1.setText(" ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoClienteActionPerformed
       String cod = txtCodigoCliente.getText();
        try {
            
            Cantante cantante = controladorCantante.buscar(cod);
            txtNombreCom.setText(cantante.getNombre());
        } catch (Exception ex) {
            Logger.getLogger(VentanaAgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCodigoClienteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String cod = txtCodigoCompositor.getText();
        try {
            
            Compositor compositor = controladorCompositor.buscar(cod);
            txtNombreCom.setText(compositor.getNombre());
        } catch (Exception ex) {
            Logger.getLogger(VentanaAgregarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtCodigoCompositor;
    private javax.swing.JTextField txtNombreCan;
    private javax.swing.JTextField txtNombreCom;
    // End of variables declaration//GEN-END:variables
}
