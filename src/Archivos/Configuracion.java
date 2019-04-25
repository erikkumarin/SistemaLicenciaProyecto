package Archivos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Configuracion{

    private File archivo; 
    private Properties config;

    public String getPropiedades(String valor) {
        return this.config.getProperty(valor);
    }

    public void setPropiedades(String dato, String valor) {
        this.config.setProperty(dato, valor);
    }
    
    public Configuracion() throws IOException {
        archivo = new File("Config.ini");
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        this.config = new Properties();
        config.load(new FileReader(this.archivo));
    }

    public void guardar() throws IOException {
        this.config.store(new FileWriter(this.archivo), "Cambio");
    }

}
