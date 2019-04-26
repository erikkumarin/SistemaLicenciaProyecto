package Pruebas;

import Citas.ControladorCitas;
import Errores.ErrorConexion;
import Main.frmPrincipal;
import Utilidades.AjustarVentana;
import java.util.logging.Level;
import java.util.logging.Logger;

public class frmPruebas extends javax.swing.JInternalFrame {

    ControladorPruebas controlPrueba;
    private static int idPrueba;

    public frmPruebas() {
        initComponents();
        AjustarVentana.ajustarPorPantalla(this, 2.5, 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblEdad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblHora = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        lblOficial = new javax.swing.JLabel();
        txtOficial = new javax.swing.JTextField();
        lblObservacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        lblNota = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        lblAsistencia = new javax.swing.JLabel();
        cbAsistencia = new javax.swing.JComboBox<>();
        lblCedulaOficial = new javax.swing.JLabel();
        txtCedulaOficial = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setTitle("Prueba de licencia");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/EditarPrueba.png"))); // NOI18N

        lblNombre.setText("Nombre");

        txtNombre.setEnabled(false);

        lblCedula.setText("N° de Cédula");
        lblCedula.setToolTipText("Ejemplo 501470258");

        txtCedula.setEnabled(false);

        lblEdad.setText("Edad");
        lblEdad.setToolTipText("Ejemplo 501470258");

        txtEdad.setEnabled(false);

        lblFecha.setText("Fecha");

        txtFecha.setEnabled(false);

        lblHora.setText("Hora");

        txtHora.setEnabled(false);

        lblOficial.setText("Oficial");

        txtOficial.setEnabled(false);

        lblObservacion.setText("Observacion");

        txtObservacion.setColumns(20);
        txtObservacion.setLineWrap(true);
        txtObservacion.setRows(5);
        jScrollPane1.setViewportView(txtObservacion);

        lblNota.setText("Nota");

        txtNota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNotaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNotaKeyTyped(evt);
            }
        });

        lblEstado.setText("Estado");

        txtEstado.setEnabled(false);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblAsistencia.setText("Asistencia");

        cbAsistencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Presente", "Ausente" }));
        cbAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAsistenciaActionPerformed(evt);
            }
        });

        lblCedulaOficial.setText("Identificación");

        txtCedulaOficial.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblOficial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCedulaOficial, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCedula)
                    .addComponent(txtNombre)
                    .addComponent(txtCedulaOficial)
                    .addComponent(txtFecha)
                    .addComponent(txtHora)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNota, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                    .addComponent(txtEdad)
                    .addComponent(txtOficial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAsistencia, 0, 83, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNombre)
                    .addComponent(cbAsistencia)
                    .addComponent(lblAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCedula)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtEdad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHora)
                            .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblCedulaOficial, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE))
                            .addComponent(txtCedulaOficial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOficial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addComponent(txtOficial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNota)
                            .addComponent(lblNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotaKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        } else if (!txtNota.getText().equals("")) {
            if (Integer.parseInt(txtNota.getText() + evt.getKeyChar()) < 0 || Integer.parseInt(txtNota.getText() + evt.getKeyChar()) > 100) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtNotaKeyTyped

    private void txtNotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotaKeyReleased
        if (!txtNota.getText().equals("")) {
            if (Integer.parseInt(txtNota.getText()) >= 80) {
                txtEstado.setText("Aprobado");
            } else {
                txtEstado.setText("Reprobado");
            }
        }
    }//GEN-LAST:event_txtNotaKeyReleased

    private void cbAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAsistenciaActionPerformed
        if (cbAsistencia.getSelectedIndex() == 0) {
            if (txtNota.getText().equals("0")) {
                txtNota.setText(null);
                txtObservacion.setText(null);
            }
        } else {
            txtNota.setText("0");
            txtObservacion.setText("El cliente no se presnetó a la cita");
        }
    }//GEN-LAST:event_cbAsistenciaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            controlPrueba = new ControladorPruebas();
            controlPrueba.agregar(this);
            ControladorCitas citas = new ControladorCitas();
            citas.eliminar(getIdPrueba());
            this.dispose();
        } catch (ErrorConexion ex) {
            Logger.getLogger(frmPruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbAsistencia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAsistencia;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCedulaOficial;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblObservacion;
    private javax.swing.JLabel lblOficial;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedulaOficial;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNota;
    private javax.swing.JTextArea txtObservacion;
    private javax.swing.JTextField txtOficial;
    // End of variables declaration//GEN-END:variables

    public String getCedula() {
        return txtCedula.getText();
    }

    public String getNombre() {
        return txtNombre.getText().toUpperCase();
    }

    public String getOficial() {
        return txtOficial.getText();
    }

    public String getObservacion() {
        return txtObservacion.getText();
    }

    public String getNota() {
        return txtNota.getText();
    }

    public String getEstado() {
        return txtEstado.getText();
    }

    public String getAsistencia() {
        return cbAsistencia.getSelectedItem().toString();
    }

    public String getEdad() {
        return txtEdad.getText();
    }

    public String getFecha() {
        return txtFecha.getText();
    }

    public String getHora() {
        return txtHora.getText();
    }

    public String getCedulaOficial() {
        return txtCedulaOficial.getText();
    }

    public void setCedula(String cedula) {
        this.txtCedula.setText(cedula);
    }

    public void setNombre(String nombre) {
        this.txtNombre.setText(nombre);
    }

    public void setOficial(String oficial) {
        this.txtOficial.setText(oficial);
    }

    public void setEdad(String edad) {
        this.txtEdad.setText(edad);
    }

    public void setFecha(String Fecha) {
        this.txtFecha.setText(Fecha);
    }

    public void setHora(String Hora) {
        this.txtHora.setText(Hora);
    }

    public void setCedulaOficial(String cedula) {
        this.txtCedulaOficial.setText(cedula);
    }

    @Override
    public String toString() {
        return "N° de cedula: " + this.getCedula() + " Nombre: " + this.getNombre() + " Edad: " + this.getEdad() + "\n"
                + " Fecha: " + this.getFecha() + " Hora: " + this.getHora()
                + " N° de cedula: " + this.getCedulaOficial() + " Oficial: " + this.getOficial() + "\nObservacion: " + this.getObservacion()
                + " Nota: " + this.getNota() + " Estado: " + this.getEstado()
                + " Asistencia: " + this.getAsistencia().toString();
    }

    public static int getIdPrueba() {
        return idPrueba;
    }

    public static void setIdPrueba(int idPrueba) {
        frmPruebas.idPrueba = idPrueba;
    }

}
