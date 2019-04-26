package Main;

import BaseDeDatos.*;
import Citas.*;
import Personas.Clientes.frmMostrarClientes;
import Personas.Clientes.frmRegistrarCliente;
import Personas.Usuarios.*;
import Personas.Usuarios.Oficiales.frmMostrarPlantilla;
import Personas.frmBuscarPersona;
import Pruebas.frmBuscarPrueba;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class frmPrincipal extends javax.swing.JFrame {

    private ControladorBaseDatos controladorBD;

    public frmPrincipal() {
        initComponents();
        this.setExtendedState(6);
        controladorBD = new ControladorBaseDatos();
        conexion();
        //deshabilitarTodo();
        this.setIconImage(new ImageIcon(getClass().getResource("/Utilidades/Imagenes/Menu.png")).getImage());
    }

    public static void agregar(JInternalFrame vista) {
        Escritorio.add(vista);
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
        btnLista.setEnabled(false);
        btnExportar.setEnabled(false);
        btnConfig.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnPlanilla.setEnabled(false);
    }

    public void habilitarOfical() {
        btnLista.setEnabled(true);
        btnCrear.setEnabled(true);
        btnConfig.setEnabled(true);
        btnExportar.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnPlanilla.setEnabled(true);
    }

    public void habilitarSecretario() {
        btnCrear.setEnabled(true);
        btnCita.setEnabled(true);
        btnCliente.setEnabled(true);
        btnExportar.setEnabled(true);
        btnConfig.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnPlanilla.setEnabled(true);
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
        menuSesion = new javax.swing.JMenu();
        btnInicar = new javax.swing.JMenuItem();
        menuRegistro = new javax.swing.JMenu();
        btnCliente = new javax.swing.JMenuItem();
        btnCrear = new javax.swing.JMenuItem();
        menuManejo = new javax.swing.JMenu();
        btnCita = new javax.swing.JMenuItem();
        btnLista = new javax.swing.JMenuItem();
        btnBuscarPrueba = new javax.swing.JMenuItem();
        menuHerramientas = new javax.swing.JMenu();
        btnExportar = new javax.swing.JMenuItem();
        btnBuscar = new javax.swing.JMenuItem();
        btnPlanilla = new javax.swing.JMenuItem();
        menuConfiguracion = new javax.swing.JMenu();
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

        menuSesion.setText("Sesión");

        btnInicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/Usuario.png"))); // NOI18N
        btnInicar.setText("Iniciar sesión");
        btnInicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicarActionPerformed(evt);
            }
        });
        menuSesion.add(btnInicar);

        BarraMenu.add(menuSesion);

        menuRegistro.setText("Registro");

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/AñadirCliente.png"))); // NOI18N
        btnCliente.setText("Registrar cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        menuRegistro.add(btnCliente);

        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/AñadirUsuario.png"))); // NOI18N
        btnCrear.setText("Registrar usuario");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        menuRegistro.add(btnCrear);

        BarraMenu.add(menuRegistro);

        menuManejo.setText("Prueba de manejo");

        btnCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/AñadirCita.png"))); // NOI18N
        btnCita.setText("Registrar cita ");
        btnCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitaActionPerformed(evt);
            }
        });
        menuManejo.add(btnCita);

        btnLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/Cita.png"))); // NOI18N
        btnLista.setText("Mostrar citas");
        btnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaActionPerformed(evt);
            }
        });
        menuManejo.add(btnLista);

        btnBuscarPrueba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/Buscar.png"))); // NOI18N
        btnBuscarPrueba.setText("Buscar pruebas");
        btnBuscarPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPruebaActionPerformed(evt);
            }
        });
        menuManejo.add(btnBuscarPrueba);

        BarraMenu.add(menuManejo);

        menuHerramientas.setText("Herramientas");

        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/Exportar.png"))); // NOI18N
        btnExportar.setText("Exportar datos");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        menuHerramientas.add(btnExportar);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/Buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        menuHerramientas.add(btnBuscar);

        btnPlanilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/Prueba.png"))); // NOI18N
        btnPlanilla.setText("Mostrar planilla");
        btnPlanilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlanillaActionPerformed(evt);
            }
        });
        menuHerramientas.add(btnPlanilla);

        BarraMenu.add(menuHerramientas);

        menuConfiguracion.setText("Configuración");

        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/Imagenes/Conexion.png"))); // NOI18N
        btnConfig.setText("Configuración");
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });
        menuConfiguracion.add(btnConfig);

        BarraMenu.add(menuConfiguracion);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        conexion();
    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        agregar(new frmRegistarUsuario());
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        agregar(new frmRegistrarCliente());
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
        agregar(new frmMostrarCitas());
    }//GEN-LAST:event_btnListaActionPerformed

    private void btnCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitaActionPerformed
        agregar(new frmRegistrarCitas());
    }//GEN-LAST:event_btnCitaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        agregar(new frmBuscarPersona());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        agregar(new frmMostrarClientes());
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnPlanillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlanillaActionPerformed
        agregar(new frmMostrarPlantilla());
    }//GEN-LAST:event_btnPlanillaActionPerformed

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

    private void btnBuscarPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPruebaActionPerformed
        agregar(new frmBuscarPrueba());
    }//GEN-LAST:event_btnBuscarPruebaActionPerformed

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
    private javax.swing.JMenuItem btnBuscar;
    private javax.swing.JMenuItem btnBuscarPrueba;
    private javax.swing.JMenuItem btnCita;
    private javax.swing.JMenuItem btnCliente;
    private javax.swing.JMenuItem btnConfig;
    private javax.swing.JMenuItem btnCrear;
    private javax.swing.JMenuItem btnExportar;
    private javax.swing.JMenuItem btnInicar;
    private javax.swing.JMenuItem btnLista;
    private javax.swing.JMenuItem btnPlanilla;
    private javax.swing.JMenu menuConfiguracion;
    private javax.swing.JMenu menuHerramientas;
    private javax.swing.JMenu menuManejo;
    private javax.swing.JMenu menuRegistro;
    private javax.swing.JMenu menuSesion;
    // End of variables declaration//GEN-END:variables

}
