package Personas.Usuarios;

import Errores.ErrorConexion;
import Errores.ErrorMensaje;
import Main.frmPrincipal;
import Utilidades.AjustarVentana;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class frmIniciarSesion extends javax.swing.JInternalFrame {

    private ControladorUsuarios controlUsuario;
    private static frmPrincipal frmPrincipal;
    private static String CedulaOficial;
    private static String NombreOficial;

    public frmIniciarSesion() {
        initComponents();
        AjustarVentana.ajustar(this, 4.5, 4.5);
    }

    private void boton() {
        try {
            ErrorMensaje.crear();
            controlUsuario = new ControladorUsuarios();
            controlUsuario.iniciarSesion(this, frmPrincipal);
        } catch (ErrorConexion ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCambiar = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblContra = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtContra = new javax.swing.JPasswordField();

        setClosable(true);
        setTitle("Iniciar sesión");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/Usuario.png"))); // NOI18N

        lblCambiar.setText("Cambiar contraseña");
        lblCambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCambiarMouseClicked(evt);
            }
        });

        lblUsuario.setText("Usuario");

        lblContra.setText("Contraseña");

        btnIniciar.setText("Iniciar Sesión");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCambiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(134, 134, 134))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(135, 135, 135))
                            .addComponent(txtContra))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContra))
                .addGap(18, 18, 18)
                .addComponent(lblCambiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCambiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCambiarMouseClicked
        frmCambiarContrasena vec = new frmCambiarContrasena(true);
        frmPrincipal.Escritorio.add(vec);
        vec.setVisible(true);
        frmCambiarContrasena.setIniciarSecion(this);
    }//GEN-LAST:event_lblCambiarMouseClicked

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        this.boton();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void txtContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.boton();
        }
    }//GEN-LAST:event_txtContraKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel lblCambiar;
    private javax.swing.JLabel lblContra;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public static void setFrmPrincipal(frmPrincipal frm) {
        frmPrincipal = frm;
    }

    public static void setCedulaOficial(String Cedula) {
        CedulaOficial = Cedula;
    }

    public static void setNombreOficial(String Nombre) {
        NombreOficial = Nombre;
    }

    public static String getCedulaOficial() {
        return CedulaOficial;
    }

    public static String getNombreOficial() {
        return NombreOficial;
    }

    public String getContrasena() {
        return txtContra.getText();
    }

    public void setContra(String contra) {
        this.txtContra.setText(contra);
    }

    public String getUsuario() {
        return txtUsuario.getText();
    }

    public void setUsuario(String usuario) {
        this.txtUsuario.setText(usuario);
    }

}
