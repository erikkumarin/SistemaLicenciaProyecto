package Menu;

import Personas.Clientes.VistaCliente;
import Personas.Usuarios.VistaUsuario;

public class VistaMenu extends javax.swing.JFrame {
    
    public VistaMenu() {
        initComponents();
        this.setExtendedState(6);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MUsuario = new javax.swing.JMenu();
        BtnInicar = new javax.swing.JMenuItem();
        BtnCrear = new javax.swing.JMenuItem();
        btnCilente = new javax.swing.JMenuItem();
        MConfig = new javax.swing.JMenu();
        BtnConfig = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
        );

        MUsuario.setText("Sesión");

        BtnInicar.setText("Iniciar Sesión");
        BtnInicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInicarActionPerformed(evt);
            }
        });
        MUsuario.add(BtnInicar);

        BtnCrear.setText("Crear Sesión");
        BtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearActionPerformed(evt);
            }
        });
        MUsuario.add(BtnCrear);

        btnCilente.setText("Cliente");
        btnCilente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCilenteActionPerformed(evt);
            }
        });
        MUsuario.add(btnCilente);

        jMenuBar1.add(MUsuario);

        MConfig.setText("Configuración");

        BtnConfig.setText("Configuración");
        BtnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfigActionPerformed(evt);
            }
        });
        MConfig.add(BtnConfig);

        jMenuBar1.add(MConfig);

        setJMenuBar(jMenuBar1);

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

    private void BtnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfigActionPerformed

    }//GEN-LAST:event_BtnConfigActionPerformed

    private void BtnInicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInicarActionPerformed

    }//GEN-LAST:event_BtnInicarActionPerformed

    private void BtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearActionPerformed
        VistaUsuario vu = new VistaUsuario();
        this.Escritorio.add(vu);
        vu.setVisible(true);
    }//GEN-LAST:event_BtnCrearActionPerformed

    private void btnCilenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCilenteActionPerformed
        VistaCliente vc = new VistaCliente();
        this.Escritorio.add(vc);
        vc.setVisible(true);
    }//GEN-LAST:event_btnCilenteActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BtnConfig;
    private javax.swing.JMenuItem BtnCrear;
    private javax.swing.JMenuItem BtnInicar;
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenu MConfig;
    private javax.swing.JMenu MUsuario;
    private javax.swing.JMenuItem btnCilente;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

}
