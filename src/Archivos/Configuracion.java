package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Configuracion {

    private File archivo;
    private Properties config;

    public Configuracion() {
        this.archivo = new File(System.getProperty("user.dir") + "\\Config.ini");
        this.config = new Properties();
        try {
            config.load(new FileReader(this.archivo));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPropiedades(String valor) {
        return this.config.getProperty(valor);
    }

    public void setPropiedades(String dato, String valor) {
        this.config.setProperty(dato, valor);
    }
}
