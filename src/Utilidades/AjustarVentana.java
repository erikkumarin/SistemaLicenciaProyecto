package Utilidades;

import Main.frmPrincipal;
import javax.swing.JInternalFrame;

public class AjustarVentana {

    public static void ajustar(JInternalFrame vista, double vx, double vy) {
        int x = frmPrincipal.Escritorio.getWidth(), y = frmPrincipal.Escritorio.getHeight();
        vista.setSize((int) (x / vx), (int) (y / vy));
        vista.setLocation((x - vista.getWidth()) / 2, (y - vista.getHeight()) / 2);
    }

    public static void ajustarPorPantalla(JInternalFrame vista, double vx, double vy) {
        int x = vista.getToolkit().getScreenSize().width, y = vista.getToolkit().getScreenSize().height;
        vista.setSize((int) (x / vx), (int) (y / vy));
        vista.setLocation((x - vista.getWidth()) / 2, (y - vista.getHeight()) / 2);
    }
}
