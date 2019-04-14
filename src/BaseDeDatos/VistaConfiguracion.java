package BaseDeDatos;

import Archivos.Configuracion;

public class VistaConfiguracion extends javax.swing.JInternalFrame {
    
    Configuracion config;

    public VistaConfiguracion() {
        initComponents();
        config = new Configuracion();
        ajustarVista();
        editar(false);
        cargarDatos();
    }

    private void ajustarVista() {
        int x = this.getToolkit().getScreenSize().width, y = this.getToolkit().getScreenSize().height;
        this.setLocation((x - this.getWidth()) / 2, (y - this.getHeight()) / 2);
        this.setSize((int) (x/4.5), (int) (y/2.5));
    }

    private void cargarDatos() {
        txtIP.setText(config.getPropiedades("Servidor"));
        txtUsuario.setText(config.getPropiedades("Usuario"));
        txtContrasena.setText(config.getPropiedades("Contra"));
    }

    private void editar(boolean accion) {
        this.txtIP.setEnabled(accion);
        this.txtUsuario.setEnabled(accion);
        this.txtContrasena.setEnabled(accion);
        this.txtBD.setEnabled(accion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña ");

        jLabel3.setText("Dirección IP");

        jLabel5.setText("Base de Datos");

        txtIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIPKeyTyped(evt);
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
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MEIP, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
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
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIP))
                .addGap(18, 18, 18)
                .addComponent(MEIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario))
                .addGap(18, 18, 18)
                .addComponent(MEU)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContrasena))
                .addGap(18, 18, 18)
                .addComponent(MEC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            btnEditar.setText("Enviar");
        } else {
            editar(false);
            btnEditar.setText("Editar");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MEBD;
    private javax.swing.JLabel MEC;
    private javax.swing.JLabel MEIP;
    private javax.swing.JLabel MEU;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtBD;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
