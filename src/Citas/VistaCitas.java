package Citas;

import Errores.ErrorConexion;
import java.util.Calendar;
import Utilidades.AjustarVentana;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VistaCitas extends javax.swing.JInternalFrame {

    private String[] meses;
    private final Calendar calendario;
    private ControladorCitas ControladorCita;

    public VistaCitas() {
        initComponents();
        ControladorCita = new ControladorCitas(this);
        AjustarVentana.ajustar(this, 3, 4);
        calendario = Utilidades.Fecha.calendario;
        meses = Utilidades.Fecha.meses;
        agregarAnios();
        agregarMeses();
        agregarDias();
        agregarHora();
    }

    private void agregarHora() {
        int hora = 8;
        if (this.cbDia.getItemAt(this.cbDia.getSelectedIndex()) == null) {
            System.out.println(this.cbDia.getItemAt(this.cbDia.getSelectedIndex()) );
            hora = calendario.get(Calendar.HOUR_OF_DAY);
            System.out.println(hora);
        } else if (Integer.parseInt(this.cbDia.getItemAt(this.cbDia.getSelectedIndex())) == calendario.get(Calendar.DAY_OF_MONTH)) {
            hora = calendario.get(Calendar.HOUR_OF_DAY);
            if(hora < 8){
                hora = 8;
            }
        }
        this.cbHora.removeAllItems();
        if (hora < 17) {
            do {
                this.cbHora.addItem(hora + ":00");
                hora++;
            } while (hora != 17);
            activarResgistrar(true);
        } else {
            this.cbHora.addItem("Hora limite alcanza");
            activarResgistrar(false);
        }

    }

    private void agregarAnios() {
        this.cbAnio.addItem(Integer.toString(calendario.get(Calendar.YEAR)));
        this.cbAnio.setEnabled(false);
    }

    private void agregarMeses() {
        int mes = 0, cantidad = 12;
        if (calendario.get(Calendar.YEAR) == (Integer.parseInt(this.cbAnio.getItemAt(this.cbAnio.getSelectedIndex())))) {
            mes = calendario.get(Calendar.MONTH);
        } else {
            cantidad = 12 - calendario.get(Calendar.MONTH);
        }
        cbMes.removeAllItems();
        int mesesAgregados = 0;
        for (int i = mes; i < cantidad; i++) {
            if (mesesAgregados < 3) {
                cbMes.addItem(this.meses[i]);
                ++mesesAgregados;
            }
        }
        if (mesesAgregados != 3) {
            this.cbAnio.addItem(Integer.toString(calendario.get(Calendar.YEAR) + 1));
            this.cbAnio.setEnabled(true);
        }
    }

    private void agregarDias() {
        int anio = Integer.valueOf(this.cbAnio.getItemAt(cbAnio.getSelectedIndex()));
        int dias = 0;
        String mes;
        if (cbMes.getSelectedItem() == null) {
            mes = "Enero";
        } else {
            mes = cbMes.getSelectedItem().toString();
        }
        if (mes.equals("Enero") || mes.equals("Marzo") || mes.equals("Mayo") || mes.equals("Julio") || mes.equals("Agosto") || mes.equals("Octubre") || mes.equals("Diciembre")) {
            dias = 31;
        } else if (mes.equals("Abril") || mes.equals("Junio") || mes.equals("Septiembre") || mes.equals("Noviembre")) {
            dias = 30;
        } else if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
            dias = 29;
        } else {
            dias = 28;
        }
        this.definirDias(dias);
    }

    private void definirDias(int dias) {
        int dia = 1;
        if (meses[calendario.get(Calendar.MONTH)].equals(cbMes.getItemAt(cbMes.getSelectedIndex()))) {
            if (calendario.get(Calendar.YEAR) == (Integer.parseInt(this.cbAnio.getItemAt(cbAnio.getSelectedIndex())))) {
                dia = calendario.get(Calendar.DAY_OF_MONTH);
            }
        }
        this.cbDia.removeAllItems();
        for (int i = dia; i <= dias; i++) {
            this.cbDia.addItem(String.valueOf(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        cbDia = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        cbAnio = new javax.swing.JComboBox<>();
        lblDia = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        cbHora = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblDatosIncorrectos = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Registro de Citas");

        lblCedula.setText("N° de Cedula");

        lblNombre.setText("Nombre completo");

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtNombre.setEditable(false);

        btnGuardar.setText("Registar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cbDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDiaActionPerformed(evt);
            }
        });

        cbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesActionPerforme(evt);
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

        lblFecha.setText("Fecha");

        jLabel1.setText("Hora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCedula)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDia, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbDia, 0, 33, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblMes, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                                    .addComponent(cbHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMes, 0, 43, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAnio, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnio, 0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbDia)
                    .addComponent(lblMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMes)
                    .addComponent(lblAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbAnio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) || this.txtCedula.getText().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void cbAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnioActionPerformed
        agregarMeses();
    }//GEN-LAST:event_cbAnioActionPerformed

    private void cbMesActionPerforme(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesActionPerforme
        agregarDias();
      }//GEN-LAST:event_cbMesActionPerforme

    private void cbDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDiaActionPerformed
        agregarHora();
    }//GEN-LAST:event_cbDiaActionPerformed

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        if (this.txtCedula.getText().length() == 9) {
            try {
                ControladorCita.leer();
            } catch (ErrorConexion ex) {
                Logger.getLogger(VistaCitas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (this.txtNombre.getText().trim().length() == 0 && !this.txtNombre.getText().equals("No se ha ingresado un usuario")) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado un usuario");
        }else if (this.verificarDatos()){
            try {
                ControladorCita.agregar();
            } catch (ErrorConexion ex) {
                Logger.getLogger(VistaCitas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbAnio;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbHora;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDatosIncorrectos;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public String getFecha() {
        return this.getDias() + "/" + this.ubicarMes() + "/" + this.cbAnio.getSelectedItem().toString();
    }

    public void setFecha(String fecha) {
        String fec[] = fecha.split("/");
        this.cbDia.addItem(fec[0]);
        this.cbMes.setSelectedIndex(Integer.parseInt(fec[1]) - 1);
        this.cbAnio.addItem(fec[2]);
    }

    public Object getAnio() {
        return cbAnio.getSelectedItem();
    }

    public void setAnio(Component anio) {
        this.cbAnio.add(anio);
    }

    public Object getDias() {
        return cbDia.getSelectedItem();
    }

    public void setDias(Component dias) {
        this.cbDia.add(dias);
    }

    public Object getMes() {
        return cbMes.getSelectedItem();
    }

    public void setMes(Component mes) {
        this.cbMes.add(mes);
    }

    public String getCedula() {
        return txtCedula.getText();
    }

    public void setCedula(String cedula) {
        this.txtCedula.setText(cedula);
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public void setNombre(String nombre) {
        this.txtNombre.setText(nombre);
    }

    public Object getHora() {
        return cbHora.getSelectedItem();
    }

    public void setHora(Component hora) {
        this.cbHora.add(hora);
    }

    @Override
    public String toString() {
        return "N° de cedula: " + this.getCedula() + " Nombre: " + this.getNombre()
                + " Fecha: " + this.getFecha() + " Hora: " +this.getHora().toString();
    }

    private String ubicarMes() {
        for (int i = 0; i < 12; i++) {
            if (cbMes.getSelectedItem().toString().equals(meses[i])) {
                if (i + 1 < 10) {
                    return "0" + (i + 1);
                }
                return i + "" + 1;
            }
        }
        return null;
    }

    private void activarResgistrar(boolean estado) {
        this.btnGuardar.setEnabled(estado);
    }

    private boolean verificarDatos(){
        if (this.getCedula().length()!=9 || !btnGuardar.isEnabled()) {
            lblDatosIncorrectos.setText("Datos incorrectos, revise los datos");
            return false;
        }
        return true;
    }
}
