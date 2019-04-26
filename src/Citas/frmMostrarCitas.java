package Citas;

import Errores.ErrorConexion;
import Main.frmPrincipal;
import Personas.Usuarios.frmIniciarSesion;
import Pruebas.frmPruebas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class frmMostrarCitas extends javax.swing.JInternalFrame {

    private ControladorCitas citas;
    int cont = 0;

    public frmMostrarCitas() {
        initComponents();
        Utilidades.AjustarVentana.ajustar(this, 3, 3.5);
        citas = new ControladorCitas();
        cargarTabla();
        Utilidades.Orientar.ordenar(tblCitas);
    }

    private void cargarTabla() {
        try {
            citas.cargarTabla(this);
        } catch (ErrorConexion ex) {
            Logger.getLogger(frmMostrarCitas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCitas = new javax.swing.JTable();

        setClosable(true);
        setTitle("Lista de citas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/Cita.png"))); // NOI18N

        tblCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "N° de Cédula", "Fecha", "Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCitas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCitasMouseClicked
        int i = tblCitas.getSelectedRow();
        if (i != -1) {
            try {
                int opc = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea aplicar esta Cita?", "Confirmación", 0, 2);
                if (opc == 0) {
                    clsCitas cita = citas.pasarDatos(this, i);
                    frmPruebas prueba = new frmPruebas();
                    prueba.setNombre(cita.getCliente().getNombre());
                    prueba.setCedula(cita.getCliente().getCedula());
                    prueba.setEdad(String.valueOf(cita.getCliente().calcularEdad()));
                    prueba.setFecha(cita.getFecha());
                    prueba.setHora(cita.getHora());
                    prueba.setCedulaOficial(frmIniciarSesion.getCedulaOficial());
                    prueba.setOficial(frmIniciarSesion.getNombreOficial());
                    frmPrincipal.agregar(prueba);
                }
            } catch (ErrorConexion ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
            }
        }
    }//GEN-LAST:event_tblCitasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCitas;
    // End of variables declaration//GEN-END:variables

    public JTable getTblCitas() {
        return tblCitas;
    }

    public void setTblCitas(JTable tblCitas) {
        this.tblCitas = tblCitas;
    }
}
