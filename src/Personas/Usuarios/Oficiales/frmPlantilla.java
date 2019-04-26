package Personas.Usuarios.Oficiales;

import Errores.ErrorConexion;
import Errores.ErrorMensaje;
import javax.swing.JOptionPane;

public class frmPlantilla extends javax.swing.JInternalFrame {

    private ControladorOficial controlOficial;
    
    public frmPlantilla() {
        initComponents();
        Utilidades.AjustarVentana.ajustar(this, 2.55, 2.55);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEnferYMater = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtInvaYMuert = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAporYTrab = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAporYAsoc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSalarioBruto = new javax.swing.JTextField();
        txtSalarioNeto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Planilla");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/Prueba.png"))); // NOI18N

        jLabel1.setText("Nombre");

        txtNombre.setEditable(false);

        txtEnferYMater.setEditable(false);

        jLabel2.setText("Enfermedad y maternidad");

        txtInvaYMuert.setEditable(false);

        jLabel3.setText("Invalidez y muerte");

        txtAporYTrab.setEditable(false);

        jLabel4.setText("Aporte del trabajo");

        txtAporYAsoc.setEditable(false);

        jLabel5.setText("Aporte a la asociación");

        jLabel6.setText("Impusto sobre la renta");

        txtImpuesto.setEditable(false);

        jLabel7.setText("Salario bruto");

        txtSalarioNeto.setEditable(false);

        jLabel8.setText("Salario neto");

        jLabel9.setText("Cedula");

        txtCedula.setEditable(false);

        btnActualizar.setText("Actualizar Salario");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtSalarioBruto)
                    .addComponent(txtCedula)
                    .addComponent(txtEnferYMater, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(txtAporYTrab)
                    .addComponent(txtImpuesto)
                    .addComponent(txtSalarioNeto))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addGap(70, 70, 70))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(txtNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtAporYAsoc)
                            .addComponent(txtInvaYMuert))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCedula)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSalarioBruto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEnferYMater)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtInvaYMuert))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAporYTrab)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAporYAsoc))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtImpuesto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSalarioNeto)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            ErrorMensaje.crear();
            controlOficial =  new ControladorOficial();
            controlOficial.modificarSalario(this);
        } catch (ErrorConexion ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAporYAsoc;
    private javax.swing.JTextField txtAporYTrab;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtEnferYMater;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtInvaYMuert;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalarioBruto;
    private javax.swing.JTextField txtSalarioNeto;
    // End of variables declaration//GEN-END:variables

    public String getCedula() {
        return txtCedula.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getAporYAsoc() {
        return txtAporYAsoc.getText();
    }

    public String getAporYTrab() {
        return txtAporYTrab.getText();
    }

    public String getEnferYMater() {
        return txtEnferYMater.getText();
    }

    public String getInvaYMuert() {
        return txtInvaYMuert.getText();
    }

    public String getSalarioBruto() {
        return txtSalarioBruto.getText();
    }

    public String getSalarioNeto() {
        return txtSalarioNeto.getText();
    }

    public void setCedula(String valor) {
        this.txtCedula.setText(valor);
    }

    public void setNombre(String valor) {
        this.txtNombre.setText(valor);
    }

    public void setAporYAsoc(double valor) {
        this.txtAporYAsoc.setText(String.valueOf(valor));
    }

    public void setAporYTrab(double valor) {
        this.txtAporYTrab.setText(String.valueOf(valor));
    }

    public void setEnferYMater(double valor) {
        this.txtEnferYMater.setText(String.valueOf(valor));
    }

    public void setInvaYMuert(double valor) {
        this.txtInvaYMuert.setText(String.valueOf(valor));
    }

    public void setImpuesto(double valor) {
        this.txtImpuesto.setText(String.valueOf(valor));
    }

    public void setSalarioBruto(double valor) {
        this.txtSalarioBruto.setText(String.valueOf(valor));
    }

    public void setSalarioNeto(double valor) {
        this.txtSalarioNeto.setText(String.valueOf(valor));
    }

}
