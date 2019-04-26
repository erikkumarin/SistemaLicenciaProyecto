package Personas.Usuarios;

import Errores.ErrorConexion;
import Errores.ErrorMensaje;
import Main.frmPrincipal;
import Personas.Usuarios.Oficiales.ControladorOficial;
import javax.swing.JOptionPane;

public class frmEditarUsuario extends javax.swing.JInternalFrame {

    private ControladorUsuarios controlUsuarios;
    private ControladorOficial controlOficial;

    private static String user;

    public frmEditarUsuario() {
        initComponents();
        Utilidades.AjustarVentana.ajustar(this, 4, 2.1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblMETelefono = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblCambiar = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Editar");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/EditarUsuario.png"))); // NOI18N

        lblCedula.setText("N° de Cédula");

        txtCedula.setEditable(false);
        txtCedula.setEnabled(false);

        jLabel1.setText("Nombre");

        lblMETelefono.setForeground(new java.awt.Color(255, 0, 0));
        lblMETelefono.setText("Ejemplo: 85848786");
        lblMETelefono.setEnabled(false);

        lblTelefono.setText("Teléfono");

        lblCorreo.setText("Correo Electrónico");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblUsuario.setText("Usuario");

        lblCambiar.setText("Cambiar contraseña");
        lblCambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCambiarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(159, 159, 159))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMETelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(85, 85, 85))
                            .addComponent(txtCedula)
                            .addComponent(txtNombre)
                            .addComponent(txtTelefono)
                            .addComponent(txtCorreo)
                            .addComponent(txtUsuario)))
                    .addComponent(lblCambiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCedula))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono))
                .addGap(18, 18, 18)
                .addComponent(lblMETelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCorreo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario))
                .addGap(18, 18, 18)
                .addComponent(lblCambiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char caracter = evt.getKeyChar();
        if (txtTelefono.getText().length() == 8 || !Character.isDigit(caracter)) {
            evt.consume();
            if (Character.isLetter(caracter)) {
                this.lblMETelefono.setEnabled(true);
            } else {
                this.lblMETelefono.setEnabled(false);
            }
        } else {
            this.lblMETelefono.setEnabled(false);
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            ErrorMensaje.crear();
            controlUsuarios = new ControladorUsuarios();
            if (this.getTitle().contains("Oficial")) {
                controlOficial = new ControladorOficial();
                controlOficial.modificar(this);
            }
            controlUsuarios.modificar(this);
        } catch (ErrorConexion ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void lblCambiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCambiarMouseClicked
        frmCambiarContrasena vec = new frmCambiarContrasena(false);
        System.out.println(getUser());
        frmPrincipal.agregar(vec);
    }//GEN-LAST:event_lblCambiarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCambiar;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblMETelefono;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public String getCedula() {
        return txtCedula.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getCorreo() {
        return txtCorreo.getText();
    }

    public String getTelefono() {
        return txtTelefono.getText();
    }

    public String getUsuario() {
        return txtUsuario.getText();
    }

    public void setNombre(String nombre) {
        this.txtNombre.setText(nombre);
    }

    public void setCedula(String Cedula) {
        this.txtCedula.setText(Cedula);
    }

    public void setCorreo(String Correo) {
        this.txtCorreo.setText(Correo);
    }

    public void setTelefono(String Telefono) {
        this.txtTelefono.setText(Telefono);
    }

    public void setUsuario(String usuario) {
        this.txtUsuario.setText(usuario);
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String usuario) {
        user = usuario;
    }

    @Override
    public String toString() {
        return "txtCedula=" + txtCedula + ", txtCorreo=" + txtCorreo + ", txtNombre=" + txtNombre + ", txtTelefono=" + txtTelefono + ", txtUsuario=" + txtUsuario + '}';
    }

}
