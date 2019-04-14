package BaseDeDatos;

import Archivos.Configuracion;
import Errores.TipoErrorConexion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VistaConfiguracion extends javax.swing.JInternalFrame {

    Configuracion config;
    ControladorBaseDatos controladorBD;

    public VistaConfiguracion() {
        initComponents();
        config = new Configuracion();
        controladorBD = new ControladorBaseDatos();
        //ajustarVista();
        editar(false);
        cargarDatos();
    }

    private void ajustarVista() {
        int x = this.getToolkit().getScreenSize().width, y = this.getToolkit().getScreenSize().height;
        this.setLocation((x - this.getWidth()) / 2, (y - this.getHeight()) / 2);
        this.setSize((int) (x / 4.5), (int) (y / 2.5));
    }

    private void cargarDatos() {
        txtIP.setText(config.getPropiedades("Servidor"));
        txtUsuario.setText(config.getPropiedades("Usuario"));
        txtContrasena.setText(config.getPropiedades("Contra"));
        txtBD.setText(config.getPropiedades("BD"));
    }
    
    private void LimpiarDatos() {
        txtIP.setText("");
        txtUsuario.setText("");
        txtContrasena.setText("");
        txtBD.setText("");
    }

    private void editar(boolean accion) {
        this.txtIP.setEnabled(accion);
        this.txtUsuario.setEnabled(accion);
        this.txtContrasena.setEnabled(accion);
        this.txtBD.setEnabled(accion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblServidor = new javax.swing.JLabel();
        lblBD = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        txtIP = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtBD = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        MEIP = new javax.swing.JLabel();
        MEU = new javax.swing.JLabel();
        MEC = new javax.swing.JLabel();
        MEBD = new javax.swing.JLabel();

        setClosable(true);

        lblUser.setText("Usuario");

        lblPass.setText("Contraseña ");

        lblServidor.setText("Dirección IP");

        lblBD.setText("Base de Datos");

        txtIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIPKeyTyped(evt);
            }
        });

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        MEIP.setForeground(new java.awt.Color(255, 0, 0));
        MEIP.setText("Ejemplo:127.0.0.1");
        MEIP.setEnabled(false);

        MEU.setForeground(new java.awt.Color(255, 0, 0));
        MEU.setText("Ejemplo: Java");
        MEU.setEnabled(false);

        MEC.setForeground(new java.awt.Color(255, 0, 0));
        MEC.setText("Ejemplo: 123");
        MEC.setEnabled(false);

        MEBD.setForeground(new java.awt.Color(255, 0, 0));
        MEBD.setText("Ejemplo: tblclientes");
        MEBD.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBD, javax.swing.GroupLayout.PREFERRED_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblServidor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MEIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(101, 101, 101))
                    .addComponent(txtContrasena)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MEC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIP)
                            .addComponent(MEU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar)
                            .addComponent(MEBD)
                            .addComponent(txtBD, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIP))
                .addGap(18, 18, 18)
                .addComponent(MEIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario))
                .addGap(18, 18, 18)
                .addComponent(MEU)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContrasena))
                .addGap(18, 18, 18)
                .addComponent(MEC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBD))
                .addGap(18, 18, 18)
                .addComponent(MEBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (this.btnEditar.getText().equals("Editar")) {
            editar(true);
            btnEditar.setText("Probar Conexion");
        } else if (this.btnEditar.getText().equals("Probar Conexion")) {
            if (controladorBD.probarConexion(this)) {
                JOptionPane.showMessageDialog(this, "Conexion Exitosa", "Probar Conexion", 1);
                btnEditar.setText("Enviar");
            }else{
                JOptionPane.showMessageDialog(this, TipoErrorConexion.ERRORSERVIDOR.getMensaje(), "Probar Conexion", 0);
                btnEditar.setText("Probar Conexion");
            }
        } else {
            editar(false);
            btnEditar.setText("Editar");
            this.dispose();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtIPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIPKeyTyped
        char caracter = evt.getKeyChar();
        if (Character.isDigit(caracter) || Character.toString(caracter).equals(".")) {
            this.MEIP.setEnabled(false);
        } else {
            this.getToolkit().beep();
            evt.consume();
            this.MEIP.setEnabled(true);
        }
    }//GEN-LAST:event_txtIPKeyTyped

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MEBD;
    private javax.swing.JLabel MEC;
    private javax.swing.JLabel MEIP;
    private javax.swing.JLabel MEU;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel lblBD;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblServidor;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtBD;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public String getTxtBD() {
        return txtBD.getText();
    }

    public String getTxtContrasena() {
        return txtContrasena.getText();
    }

    public String getTxtIP() {
        return txtIP.getText();
    }

    public String getTxtUsuario() {
        return txtUsuario.getText();
    }

}
