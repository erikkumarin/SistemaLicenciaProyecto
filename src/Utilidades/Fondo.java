package Utilidades;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class Fondo implements Border {

    public BufferedImage imagen;

    public Fondo() {
     try {
            URL imagePath = new URL(getClass().getResource("/Utilidades/Fondo.jpg").toString());
            imagen = ImageIO.read(imagePath);
        } catch (Exception ex) {            
        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(imagen, (x + (width - imagen.getWidth()) / 2), (y + (height - imagen.getHeight()) / 2), null);
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
