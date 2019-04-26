package Personas.Usuarios;

import Errores.ErrorConexion;
import Utilidades.AjustarVentana;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class frmCambiarContrasena extends javax.swing.JInternalFrame {

    private ControladorUsuarios controlUsuario;
    private static frmIniciarSesion frmIS;

    public frmCambiarContrasena() {
        initComponents();
        AjustarVentana.ajustar(this, 3.5, 4);
    }

    private void boton(){
        if (this.getNuevaContrasena().equals(this.getConfirmarContrasena())) {
            try {
                controlUsuario = new ControladorUsuarios();
                controlUsuario.modificarContraseña(this, frmIS);
            } catch (ErrorConexion ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblContra1 = new javax.swing.JLabel();
        lblContra2 = new javax.swing.JLabel();
        lblContra3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtContrasena = new javax.swing.JPasswordField();
        txtNuevaContrasena = new javax.swing.JPasswordField();
        txtConfirmarContrasena = new javax.swing.JPasswordField();

        setClosable(true);
        setTitle("Cambiar contraseña");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/Contraseña.png"))); // NOI18N

        lblContra1.setText("Contraseña actual");

        lblContra2.setText("Contraseña nueva");

        lblContra3.setText("Verificar contraseña");

        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtConfirmarContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConfirmarContrasenaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContra3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContra2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContra1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtContrasena)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtConfirmarContrasena, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNuevaContrasena))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContra1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContrasena))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNuevaContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(lblContra2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContra3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtConfirmarContrasena))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.boton();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtConfirmarContrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarContrasenaKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             this.boton();
        } 
    }//GEN-LAST:event_txtConfirmarContrasenaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblContra1;
    private javax.swing.JLabel lblContra2;
    private javax.swing.JLabel lblContra3;
    private javax.swing.JPasswordField txtConfirmarContrasena;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JPasswordField txtNuevaContrasena;
    // End of variables declaration//GEN-END:variables

    public static void setIniciarSecion(frmIniciarSesion frm) {
        frmIS = frm;
    }

    public String getConfirmarContrasena() {
        return txtConfirmarContrasena.getText();
    }

    public void setConfirmarContrasena(String contrasena) {
        this.txtConfirmarContrasena.setText(contrasena);
    }

    public String getContrasena() {
        return txtContrasena.getText();
    }

    public void setContrasena(String contrasena) {
        this.txtContrasena.setText(contrasena);
    }

    public String getNuevaContrasena() {
        return txtNuevaContrasena.getText();
    }

    public void setNuevaContrasena(String contrasena) {
        this.txtNuevaContrasena.setText(contrasena);
    }
}
