package Personas.Clientes;

import java.awt.event.KeyEvent;

public class VistaCliente extends javax.swing.JInternalFrame {

    public VistaCliente() {
        initComponents();
        ajustarVentana();
        definirAnios();
        ajustarfecha();
    }

    private void ajustarVentana() {
        int x = this.getToolkit().getScreenSize().width, y = this.getToolkit().getScreenSize().height;
        this.setSize(x / 3, (int) (y / 1.5));
        this.setLocation((x - this.getWidth()) / 2, (y - this.getHeight()) / 2);
    }

    private void ajustarfecha() {
        int mes = this.cbMes.getSelectedIndex() + 1;
        int anio = Integer.valueOf(this.cbAnio.getSelectedItem().toString());
        int dia = 0;
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dia = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dia = 30;
                break;
            case 2:
                if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
                    dia = 29;
                } else {
                    dia = 28;
                }
                break;
        }
        this.definirDias(dia);
    }

    private void definirDias(int dia) {
        this.cbDia.removeAllItems();
        for (int i = dia; i > 0; i--) {
            this.cbDia.addItem(String.valueOf(i));
        }
    }

    private void definirAnios() {
        for (int i = 2002; i > 1900; i--) {
            this.cbAnio.addItem(String.valueOf(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        btn = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        cbDia = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        cbAnio = new javax.swing.JComboBox<>();
        lblDia = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        lblMECedula = new javax.swing.JLabel();
        lblMETelefono = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Registro de clientes");
        setToolTipText("");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        setOpaque(true);

        lblCedula.setText("N° de Cédula");
        lblCedula.setToolTipText("Ejemplo 501470258");

        lblNombre.setText("Nombre Completo");

        lblFecha.setText("Fecha de Nacimiento");

        lblTelefono.setText("Teléfono");

        lblCorreo.setText("Correo Electrónico");

        btn.setText("Registrar");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        txtCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCedulaMouseClicked(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefonoMouseClicked(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesActionPerformed(evt);
            }
        });

        cbAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAnioActionPerformed(evt);
            }
        });

        lblDia.setText("Día");

        lblMes.setText("Mes");

        lblAnio.setText("Año");

        lblMECedula.setForeground(new java.awt.Color(255, 0, 0));
        lblMECedula.setText("Ejemplo: 512540258");
        lblMECedula.setEnabled(false);

        lblMETelefono.setForeground(new java.awt.Color(255, 0, 0));
        lblMETelefono.setText("Ejemplo: 85848786");
        lblMETelefono.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblMECedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(132, 132, 132))
                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMETelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(153, 153, 153))
                    .addComponent(txtCedula))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCedula))
                .addGap(18, 18, 18)
                .addComponent(lblMECedula, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbDia)
                    .addComponent(cbMes)
                    .addComponent(cbAnio)
                    .addComponent(lblDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnio)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono))
                .addGap(18, 18, 18)
                .addComponent(lblMETelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCorreo))
                .addGap(18, 18, 18)
                .addComponent(btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesActionPerformed
        this.ajustarfecha();
    }//GEN-LAST:event_cbMesActionPerformed

    private void cbAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnioActionPerformed
        this.ajustarfecha();
    }//GEN-LAST:event_cbAnioActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        ControladorClientes cc = new ControladorClientes(this);
        cc.agregar();
    }//GEN-LAST:event_btnActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        if (txtCedula.getText().length() == 9 || !Character.isDigit(evt.getKeyChar())) {
            this.getToolkit().beep();
            this.lblMECedula.setEnabled(true);
            anular(evt);
        } else {
            this.lblMECedula.setEnabled(false);
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void anular(KeyEvent evt) {
        evt.consume();
    }
    private void txtCedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaMouseClicked
        this.txtCedula.setText(null);
        this.lblMECedula.setEnabled(false);
    }//GEN-LAST:event_txtCedulaMouseClicked

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) || this.txtTelefono.getText().length() == 8) {
            this.getToolkit().beep();
            this.lblMETelefono.setEnabled(true);
            anular(evt);
        } else {
            this.lblMETelefono.setEnabled(false);
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseClicked
        this.txtTelefono.setText(null);
        this.lblMETelefono.setEnabled(false);
    }//GEN-LAST:event_txtTelefonoMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char caracter = evt.getKeyChar();
        if (!Character.isAlphabetic(caracter) && Character.isSpaceChar(caracter)) {
            this.getToolkit().beep();
            anular(evt);
        }
     }//GEN-LAST:event_txtNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JComboBox<String> cbAnio;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMECedula;
    private javax.swing.JLabel lblMETelefono;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public String getFecha() {
        if (this.cbMes.getSelectedIndex() + 1 < 10) {
            return this.cbDia.getSelectedItem().toString() + "/0" + (this.cbMes.getSelectedIndex() + 1) + "/" + this.cbAnio.getSelectedItem().toString();
        }
        return this.cbDia.getSelectedItem().toString() + "/" + (this.cbMes.getSelectedIndex() + 1) + "/" + this.cbAnio.getSelectedItem().toString();
    }

    public String getCedula() {
        return this.txtCedula.getText();
    }

    public String getCorreo() {
        return txtCorreo.getText();
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getTelefono() {
        return txtTelefono.getText();
    }

    public void setCedula(String cedula) {
        this.txtCedula.setText(cedula);
    }

    public void setFecha(String fecha) {
        String fec[] = fecha.split("/");
        this.cbDia.addItem(fec[0]);
        this.cbMes.setSelectedIndex(Integer.parseInt(fec[1]) - 1);
        this.cbAnio.addItem(fec[2]);
    }

    public void setCorreo(String correo) {
        this.txtCorreo.setText(correo);
    }

    public void setNombre(String nombre) {
        this.txtNombre.setText(nombre);
    }

    public void setTelefono(String telefono) {
        this.txtTelefono.setText(telefono);
    }

    @Override
    public String toString() {
        return "N° de cedula: " + this.getCedula() + " Nombre: " + this.getNombre()
                + " Fecha de Nac': " + this.getFecha() + " Telefono: " + this.getTelefono()
                + " Correo: " + this.getCorreo();
    }

}
