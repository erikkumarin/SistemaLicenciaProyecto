/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Personas.Usuarios.VistaUsuario;

public class VistaMenu extends javax.swing.JFrame {
//Hola actualizacion

    /**
     * Creates new form VistaMenu
     */
    public VistaMenu() {
        initComponents();
        this.setExtendedState(6);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MInicar = new javax.swing.JMenu();
        BtnInicar = new javax.swing.JMenuItem();
        Btncrear = new javax.swing.JMenuItem();
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

        MInicar.setText("Sesión");

        BtnInicar.setText("Iniciar sesión");
        BtnInicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInicarActionPerformed(evt);
            }
        });
        MInicar.add(BtnInicar);

        Btncrear.setText("Crear sesión");
        Btncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtncrearActionPerformed(evt);
            }
        });
        MInicar.add(Btncrear);

        jMenuBar1.add(MInicar);

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

    private void BtncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtncrearActionPerformed
        VistaUsuario vu = new VistaUsuario();
        this.Escritorio.add(vu);
        vu.setVisible(true);
    }//GEN-LAST:event_BtncrearActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
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
    private javax.swing.JMenuItem BtnInicar;
    private javax.swing.JMenuItem Btncrear;
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenu MConfig;
    private javax.swing.JMenu MInicar;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
