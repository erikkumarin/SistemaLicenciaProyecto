package Utilidades;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class Fondo implements Border {
private Image imagen;
    
    public Fondo() {
     try {
            ImageIcon icono = new ImageIcon(getClass().getResource("/Utilidades/Fondo.jpg"));
            imagen = icono.getImage();
        } catch (Exception ex) {
         System.out.println("error");            
        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(imagen, 0, 0, null);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
