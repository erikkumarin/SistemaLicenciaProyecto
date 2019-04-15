package Utilidades;

import Menu.VistaMenu;
import javax.swing.JInternalFrame;

public class AjustarVentana {

    public static void ajustar(JInternalFrame vista, double vx, double vy) {
        int x = VistaMenu.Escritorio.getWidth(), y = VistaMenu.Escritorio.getHeight();
        vista.setSize((int) (x / vx), (int) (y / vy));
        vista.setLocation((x - vista.getWidth()) / 2, (y - vista.getHeight()) / 2);
    }
}
