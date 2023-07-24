/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.java.practica02mvc.vistaCantante;

import ec.edu.ups.java.practica02mvc.controlador.ControladorCantante;
import ec.edu.ups.java.practica02mvc.modelo.Cantante;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class VentanaActualizarCantante extends javax.swing.JInternalFrame {

    private ControladorCantante controladorCantante;
    private ResourceBundle mensajes;

    /**
     * Creates new form VentanaActualizarCantante
     */
    public VentanaActualizarCantante(ControladorCantante controladorCantante) {
        initComponents();
        this.controladorCantante = controladorCantante;

    }
    public void cambiarIdioma(Locale localizacion){
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        jLabel13.setText(mensajes.getString("txtCodigo"));
        jLabel9.setText(mensajes.getString("txtNombre"));
        jLabel10.setText(mensajes.getString("txtApellido"));        
        jLabel6.setText(mensajes.getString("txtEdad"));
        jLabel11.setText(mensajes.getString("txtNacionalidad"));
        jLabel12.setText(mensajes.getString("txtSalario"));
        
        jLabel2.setText(mensajes.getString("txtGeneroMusical"));
        jLabel5.setText(mensajes.getString("txtNumeroDeSencillos"));
        jLabel3.setText(mensajes.getString("txtNumeroDeConciertos"));
        jLabel4.setText(mensajes.getString("txtNumeroDeGiras"));
        
        jLabelCantante3.setText(mensajes.getString("jLabelCantante3"));
        
        btnAceptar.setText(mensajes.getString("btnAceptar"));
        btnCancelar.setText(mensajes.getString("btnCancelar"));
        btnBuscar.setText(mensajes.getString("btnBuscar"));

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
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtSalario = new javax.swing.JTextField();
        txtNumeroDeSencillos = new javax.swing.JTextField();
        txtGeneroMusical = new javax.swing.JTextField();
        txtNumeroDeGiras = new javax.swing.JTextField();
        txtNumeroDeConciertos = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtNacionalidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelCantante3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, 40));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 80, 40));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 80, 30));

        txtSalario.setEditable(false);
        getContentPane().add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 210, -1));

        txtNumeroDeSencillos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDeSencillosActionPerformed(evt);
            }
        });
        getContentPane().add(txtNumeroDeSencillos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 210, -1));
        getContentPane().add(txtGeneroMusical, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 210, -1));
        getContentPane().add(txtNumeroDeGiras, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 210, -1));
        getContentPane().add(txtNumeroDeConciertos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 210, -1));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 211, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 211, -1));

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 211, -1));

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        getContentPane().add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 211, -1));
        getContentPane().add(txtNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 211, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Genero musical");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 104, 41));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Numero de conciertos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 144, 41));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Numero de giras ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 136, 41));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Numero de sencillos");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 144, 41));

        jLabelCantante3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelCantante3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantante3.setText("Actualizar cantante");
        getContentPane().add(jLabelCantante3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 240, 41));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 104, 41));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Apellido");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 104, 41));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Edad");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 104, 41));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nacionalidad");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 104, 41));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Salario");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 104, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Codigo");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 104, 41));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sodapdf-converted (4).png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 670, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroDeSencillosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDeSencillosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDeSencillosActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       String cod = txtCodigo.getText();
        try {
           
            Cantante cantante = controladorCantante.buscar(cod);
            txtApellido.setText(cantante.getApellido());
            txtEdad.setText(String.valueOf(cantante.getEdad()));
            txtGeneroMusical.setText(cantante.getGeneroMusical());
            txtNacionalidad.setText(cantante.getNacionalidad());
            txtNombre.setText(cantante.getNombre());
            txtNumeroDeConciertos.setText(String.valueOf(cantante.getNumeroDeConciertos()));
            txtNumeroDeGiras.setText(String.valueOf(cantante.getNumeroDeGiras()));
            txtNumeroDeSencillos.setText(String.valueOf(cantante.getNumeroDeSencillos()));
            txtSalario.setText(String.valueOf(cantante.getSalario()));
        } catch (Exception ex) {
            Logger.getLogger(VentanaActualizarCantante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            String apellido = txtApellido.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String generoMusical = txtGeneroMusical.getText();
            String nacionalidad = txtNacionalidad.getText();
            String nombre = txtNombre.getText();
            int numCo = Integer.parseInt(txtNumeroDeConciertos.getText());
            int numGi = Integer.parseInt(txtNumeroDeGiras.getText());
            int numSe = Integer.parseInt(txtNumeroDeSencillos.getText());
            double salario = Integer.parseInt(txtSalario.getText());
            String cod = txtCodigo.getText();
            Cantante cantante = controladorCantante.buscar(cod);
            cantante.setApellido(apellido);
            cantante.setEdad(edad);
            cantante.setNacionalidad(nacionalidad);
            cantante.setNombre(nombre);
            cantante.setNumeroDeConciertos(numCo);
            cantante.setNumeroDeGiras(numGi);
            cantante.setNumeroDeSencillos(numSe);
            cantante.setSalario(salario);
            
            controladorCantante.update(cantante, Integer.parseInt(cod));
            
            String mensajeCantanteActualizado = mensajes.getString("mensaje.cantanteActualizado");
            JOptionPane.showMessageDialog(this, mensajeCantanteActualizado);
        } catch (Exception ex) {
            Logger.getLogger(VentanaActualizarCantante.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
this.setVisible(false);
limpiarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

 public void limpiarCampos() {
        txtApellido.setText("");
        txtCodigo.setText("");
        txtEdad.setText("");
        txtGeneroMusical.setText("");
        txtNacionalidad.setText("");
        txtNombre.setText("");
        txtNumeroDeConciertos.setText("");
        txtNumeroDeGiras.setText("");
        txtNumeroDeSencillos.setText("");
        txtSalario.setText("");

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCantante3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtGeneroMusical;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroDeConciertos;
    private javax.swing.JTextField txtNumeroDeGiras;
    private javax.swing.JTextField txtNumeroDeSencillos;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
