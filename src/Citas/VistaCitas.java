
package Citas;

import java.util.Calendar;

public class VistaCitas extends javax.swing.JInternalFrame {

    private String[] meses;
    private final Calendar calendario;

    public VistaCitas() {
        initComponents();
        calendario = Calendar.getInstance();
        meses = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        agregarAnios();
        agregarMeses();
        agregarDias();
        ajustarVentana();
    }
    
      private void ajustarVentana() {
        int x = this.getToolkit().getScreenSize().width, y = this.getToolkit().getScreenSize().height;
        this.setSize((int) (x / 4), (int) (y / 5));
        this.setLocation((x - this.getWidth()) / 2, (y - this.getHeight()) / 2);
    }

    private void agregarAnios() {
        int anio = calendario.get(Calendar.YEAR);
        for (int i = anio; i < anio + 100; i++) {
            this.cbAnio.addItem(Integer.toString(i));

        }
    }

    private void agregarMeses() {
        int mes = 0;
        if (calendario.get(Calendar.YEAR) == (Integer.parseInt(this.cbAnio.getItemAt(cbAnio.getSelectedIndex())))) {
            mes = calendario.get(Calendar.MONTH);
        }
        this.cbMes.removeAllItems();
        for (int i = mes; i < 12; i++) {
            this.cbMes.addItem(this.meses[i]);
        }
    }

    private void agregarDias() {
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
        this.cbDias.removeAllItems();
        int dias = 1;
        if (meses[calendario.get(Calendar.MONTH)].equals(cbMes.getItemAt(cbMes.getSelectedIndex()))) {
            if (calendario.get(Calendar.YEAR) == (Integer.parseInt(this.cbAnio.getItemAt(cbAnio.getSelectedIndex())))) {
                dias = calendario.get(Calendar.DAY_OF_MONTH);
            }
        }
        for (int i = dia; i >= dias; i--) {
            this.cbDias.addItem(String.valueOf(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        Cedula = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        cbDias = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        cbAnio = new javax.swing.JComboBox<>();
        lblDia = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();

        setClosable(true);

        lblCedula.setText("N° de Cedula");

        lblNombre.setText("Nombre completo");

        Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CedulaKeyTyped(evt);
            }
        });

        Nombre.setEditable(false);

        btnGuardar.setText("Guardar");

        cbDias.setSelectedItem(0);

        cbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesActionPerformed(evt);
            }
        });

        cbAnio.setSelectedItem(0);
        cbAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAnioActionPerformed(evt);
            }
        });

        lblDia.setText("Dia");

        lblMes.setText("Mes");

        lblAnio.setText("Año");

        lblFecha.setText("Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(54, 54, 54)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(157, 157, 157))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbAnio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Cedula, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nombre))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbAnio)
                    .addComponent(lblDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbDias)
                    .addComponent(cbMes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CedulaKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) || this.Cedula.getText().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_CedulaKeyTyped

    private void cbAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAnioActionPerformed
        agregarMeses();
        agregarDias();
    }//GEN-LAST:event_cbAnioActionPerformed

    private void cbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesActionPerformed
        agregarDias();
    }//GEN-LAST:event_cbMesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cedula;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbAnio;
    private javax.swing.JComboBox<String> cbDias;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
