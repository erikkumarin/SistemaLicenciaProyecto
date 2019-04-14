package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Configuracion extends Archivo {

    private Properties config;

    public Configuracion() {
        super(System.getProperty("user.dir"), "Config", ".ini");
        this.config = new Properties();
        abrirConfig();
    }

    public void abrirConfig() {
        try {
            config.load(new FileReader(this.getArchivo()));
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

    public void reemplazarValores(String dato, String valor) {
        this.config.replace(dato, config.getProperty(dato), valor);
    }

    @Override
    public void guardar() {
        try {
            this.config.store(new FileWriter(this.getArchivo()), "Cambio");
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
