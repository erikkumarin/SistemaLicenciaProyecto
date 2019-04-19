package Pruebas;

import Utilidades.AjustarVentana;
import java.awt.Component;
import java.util.Calendar;

public class VistaPruebas extends javax.swing.JInternalFrame {

    private String[] meses;
    private final Calendar calendario;

    public VistaPruebas() {
        initComponents();
        AjustarVentana.ajustar(this, 2, 3);
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
            hora = calendario.get(Calendar.HOUR_OF_DAY);
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
        int mes = 0, cantidad=12;
        if (calendario.get(Calendar.YEAR) == (Integer.parseInt(this.cbAnio.getItemAt(this.cbAnio.getSelectedIndex())))) {
            mes = calendario.get(Calendar.MONTH);
        }else{
            cantidad=12-calendario.get(Calendar.MONTH);
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

        lblAnio = new javax.swing.JLabel();
        cbDia = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        cbAnio = new javax.swing.JComboBox<>();
        lblFecha = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblOficial = new javax.swing.JLabel();
        lblObservacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        lblHora = new javax.swing.JLabel();
        cbHora = new javax.swing.JComboBox<>();
        lblNota = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        txtOficial = new javax.swing.JTextField();
        lblAsistencia = new javax.swing.JLabel();
        cbAsistencia = new javax.swing.JComboBox<>();

        setClosable(true);
        setResizable(true);
        setTitle("Prueba de Licencia");

        lblAnio.setText("Año");

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

        lblFecha.setText("Fecha");

        lblDia.setText("Día");

        lblMes.setText("Mes");

        txtCedula.setEnabled(false);

        txtNombre.setEnabled(false);

        lblCedula.setText("N° de Cédula");
        lblCedula.setToolTipText("Ejemplo 501470258");

        lblNombre.setText("Nombre");

        lblOficial.setText("Oficial");

        lblObservacion.setText("Observacion");

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane1.setViewportView(txtObservacion);

        lblHora.setText("Hora");

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

        txtOficial.setEnabled(false);

        lblAsistencia.setText("Asistencia");

        cbAsistencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Presente", "Ausente" }));
        cbAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAsistenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(lblOficial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNota)
                        .addGap(18, 18, 18)
                        .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEstado)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtOficial)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblDia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMes, 0, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombre)
                    .addComponent(txtCedula)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbHora, 0, 68, Short.MAX_VALUE)
                        .addGap(167, 167, 167)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addComponent(cbAsistencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(95, 95, 95)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbAsistencia)
                    .addComponent(txtNombre)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtCedula)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbDia)
                            .addComponent(cbMes)
                            .addComponent(cbAnio))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbHora))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblOficial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtOficial)))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtNota)
                    .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEstado)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesActionPerformed
        agregarDias();
    }//GEN-LAST:event_cbMesActionPerformed

    private void cbAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnioActionPerformed
        agregarMeses();
    }//GEN-LAST:event_cbAnioActionPerformed

    private void txtNotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotaKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        } else if (!"".equals(txtNota.getText())) {
            if (Integer.parseInt(txtNota.getText() + evt.getKeyChar()) < 0 || Integer.parseInt(txtNota.getText() + evt.getKeyChar()) > 100) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtNotaKeyTyped

    private void txtNotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotaKeyReleased
        if (!"".equals(txtNota.getText())) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbAnio;
    private javax.swing.JComboBox<String> cbAsistencia;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbHora;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblAsistencia;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblObservacion;
    private javax.swing.JLabel lblOficial;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNota;
    private javax.swing.JTextArea txtObservacion;
    private javax.swing.JTextField txtOficial;
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
        return txtNombre.getText().toUpperCase();
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

    public String getOficial() {
        return txtOficial.getText();
    }

    public void setOficial(String oficial) {
        this.txtOficial.setText(oficial);
    }

    public String getObservacion() {
        return txtNombre.getText();
    }

    public void setObservacion(String ob) {
        this.txtObservacion.setText(ob);
    }

    public String getNota() {
        return txtNota.getText();
    }

    public void setNota(String nota) {
        this.txtNota.setText(nota);
    }

    public String getEstado() {
        return txtEstado.getText();
    }

    public void setEstado(String estado) {
        this.txtEstado.setText(estado);
    }

    public Object getAsistencia() {
        return cbAsistencia.getSelectedItem();
    }

    public void setEstado(Component asistencia) {
        this.cbAsistencia.add(asistencia);
    }

    @Override
    public String toString() {
        return "N° de cedula: " + this.getCedula() + " Nombre: " + this.getNombre()
                + " Fecha: " + this.getFecha() + " Hora: " + this.getHora().toString()
                + " Oficial: " + this.getOficial() + "\nObservacion: " + this.getObservacion()
                + " Nota: " + this.getNota() + " Estado: " + this.getEstado()
                + " Asistencia: " + this.getAsistencia().toString();
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

}
