package Main;

import BaseDeDatos.BaseDatos;
import BaseDeDatos.ControladorBaseDatos;
import BaseDeDatos.frmConfiguracion;
import Citas.frmRegistrarCitas;
//import Citas.VistaCitas;
import Personas.Clientes.frmRegistrarCliente;
import Personas.Usuarios.*;
import Pruebas.frmPruebas;
//import Pruebas.VistaPruebas;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class frmPrincipal extends javax.swing.JFrame {

    ControladorBaseDatos controladorBD;

    public frmPrincipal() {
        initComponents();
        this.setExtendedState(6);
        controladorBD = new ControladorBaseDatos();
        conexion();
        deshabilitarTodo();
        this.setIconImage(new ImageIcon(getClass().getResource("/Utilidades/Imagenes/IconoMenu.png")).getImage());

    }

    private void agregar(JInternalFrame vista) {
        this.Escritorio.add(vista);
        vista.setVisible(true);
    }

    private void conexion() {
        try {
            frmConfiguracion VC = new frmConfiguracion();
            agregar(VC);
            if (BaseDatos.getConexion() != null && controladorBD.probarConexion(VC)) {
                JOptionPane.showMessageDialog(VC, "Funcionando con normalidad", "Probar Conexion", 1);
                VC.dispose();
            }
        } catch (IOException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deshabilitarTodo() {
        btnCrear.setEnabled(false);
        btnCita.setEnabled(false);
        btnCliente.setEnabled(false);
        btnPrueba.setEnabled(false);
        btnExportar.setEnabled(false);
        btnConfig.setEnabled(false);
    }

    public void habilitarOfical() {
        btnPrueba.setEnabled(true);
        btnCrear.setEnabled(true);
        btnConfig.setEnabled(true);
        btnExportar.setEnabled(true);
    }

    public void habilitarSecretario() {
        btnCrear.setEnabled(true);
        btnCita.setEnabled(true);
        btnCliente.setEnabled(true);
        btnExportar.setEnabled(true);
        btnConfig.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icono = new ImageIcon(getClass().getResource("/Utilidades/Imagenes/Fondo.jpg"));
        Image imagen = icono.getImage();
        Escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            }
        };
        BarraMenu = new javax.swing.JMenuBar();
        MInicar = new javax.swing.JMenu();
        btnInicar = new javax.swing.JMenuItem();
        btnCrear = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        btnCita = new javax.swing.JMenuItem();
        btnCliente = new javax.swing.JMenuItem();
        btnPrueba = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnExportar = new javax.swing.JMenuItem();
        MConfig = new javax.swing.JMenu();
        btnConfig = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        BarraMenu.setBorder(null);

        MInicar.setText("Sesión");

        btnInicar.setText("Iniciar sesión");
        btnInicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicarActionPerformed(evt);
            }
        });
        MInicar.add(btnInicar);

        btnCrear.setText("Crear sesión");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        MInicar.add(btnCrear);

        BarraMenu.add(MInicar);

        jMenu1.setText("Prueba de manejo");

        btnCita.setText("Registrar cita ");
        btnCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitaActionPerformed(evt);
            }
        });
        jMenu1.add(btnCita);

        btnCliente.setText("Registrar cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        jMenu1.add(btnCliente);

        btnPrueba.setText("Aplicar prueba");
        btnPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaActionPerformed(evt);
            }
        });
        jMenu1.add(btnPrueba);

        BarraMenu.add(jMenu1);

        jMenu2.setText("Herramientas");

        btnExportar.setText("Exportar datos");
        jMenu2.add(btnExportar);

        BarraMenu.add(jMenu2);

        MConfig.setText("Configuración");

        btnConfig.setText("Configuración");
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });
        MConfig.add(btnConfig);

        BarraMenu.add(MConfig);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        conexion();
    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnInicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicarActionPerformed
        frmIniciarSesion.setFrmPrincipal(this);
        if (btnInicar.getText().equals("Iniciar Sesión")) {
            agregar(new frmIniciarSesion());
            btnInicar.setText("Cerrar Sesión");
        } else {
            this.deshabilitarTodo();
            btnInicar.setText("Iniciar Sesión");
        }
    }//GEN-LAST:event_btnInicarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        agregar(new frmRegistarUsuario());
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        agregar(new frmRegistrarCliente());
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaActionPerformed
        agregar(new frmPruebas());
    }//GEN-LAST:event_btnPruebaActionPerformed

    private void btnCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitaActionPerformed
        agregar(new frmRegistrarCitas());
    }//GEN-LAST:event_btnCitaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenu;
    public static javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenu MConfig;
    private javax.swing.JMenu MInicar;
    private javax.swing.JMenuItem btnCita;
    private javax.swing.JMenuItem btnCliente;
    private javax.swing.JMenuItem btnConfig;
    private javax.swing.JMenuItem btnCrear;
    private javax.swing.JMenuItem btnExportar;
    private javax.swing.JMenuItem btnInicar;
    private javax.swing.JMenuItem btnPrueba;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    // End of variables declaration//GEN-END:variables

}
