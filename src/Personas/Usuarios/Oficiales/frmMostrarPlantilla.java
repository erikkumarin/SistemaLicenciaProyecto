
package Personas.Usuarios.Oficiales;

import Errores.ErrorConexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class frmMostrarPlantilla extends javax.swing.JInternalFrame {

    ControladorOficial controlOficial;
    
    public frmMostrarPlantilla() {
        try {
            initComponents();
            Utilidades.AjustarVentana.ajustar(this, 2.5, 2.3);
            controlOficial = new ControladorOficial();
            controlOficial.cargarOficiales(this);
        } catch (ErrorConexion ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlanilla = new javax.swing.JTable();

        setClosable(true);
        setTitle("Planilla de oficiales");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/Prueba.png"))); // NOI18N

        tblPlanilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° de Cédula", "Nombre", "Fecha Nacimiento", "Salario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPlanilla.setToolTipText("");
        jScrollPane1.setViewportView(tblPlanilla);
        if (tblPlanilla.getColumnModel().getColumnCount() > 0) {
            tblPlanilla.getColumnModel().getColumn(0).setResizable(false);
            tblPlanilla.getColumnModel().getColumn(1).setResizable(false);
            tblPlanilla.getColumnModel().getColumn(2).setResizable(false);
            tblPlanilla.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPlanilla;
    // End of variables declaration//GEN-END:variables

    public JTable getTblPlanilla() {
        return tblPlanilla;
    }

    public void setTblPlanilla(JTable tblPlanilla) {
        this.tblPlanilla = tblPlanilla;
    }
    
}
