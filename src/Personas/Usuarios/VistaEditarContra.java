package Personas.Usuarios;

import Utilidades.AjustarVentana;

public class VistaEditarContra extends javax.swing.JInternalFrame {

    public VistaEditarContra() {
        initComponents();
        AjustarVentana.ajustar(this, 3.5, 4);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblContra1 = new javax.swing.JLabel();
        lblContra2 = new javax.swing.JLabel();
        lblContra3 = new javax.swing.JLabel();
        txtContraActual = new javax.swing.JTextField();
        txtContraNueva1 = new javax.swing.JTextField();
        txtContraNueva2 = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);

        lblContra1.setText("Contraseña actual");

        lblContra2.setText("Contraseña nueva");

        lblContra3.setText("Verificar contraseña");

        btnGuardar.setText("Guardar");

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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(159, 159, 159))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContraNueva2)
                            .addComponent(txtContraNueva1)
                            .addComponent(txtContraActual))
                        .addGap(11, 11, 11))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblContra1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtContraActual))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblContra2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtContraNueva1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblContra3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtContraNueva2))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblContra1;
    private javax.swing.JLabel lblContra2;
    private javax.swing.JLabel lblContra3;
    private javax.swing.JTextField txtContraActual;
    private javax.swing.JTextField txtContraNueva1;
    private javax.swing.JTextField txtContraNueva2;
    // End of variables declaration//GEN-END:variables

    public String getContraActual() {
        return txtContraActual.getText();
    }

    public void setContraActual(String contra) {
        this.txtContraActual.setText(contra);
    }

    public String getContraNueva1() {
        return txtContraNueva1.getText();
    }

    public void setContraNueva1(String contra) {
        this.txtContraNueva1.setText(contra);
    }

    public String getContraNueva2() {
        return txtContraNueva2.getText();
    }

    public void setContraNueva2(String contra) {
        this.txtContraNueva2.setText(contra);
    }



}
