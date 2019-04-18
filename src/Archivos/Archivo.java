package Archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Shorlax
 */
public class Archivo {

    private String ruta;
    private String nombre;
    private String tipo;
    private ArrayList<String> lista;
    private File archivo;
    private BufferedReader lector;
    private BufferedWriter escritor;

    public File getArchivo() {
        return archivo;
    }
    
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Archivo(String ruta, String nombre, String tipo) {
        this.lista = new ArrayList();
        this.ruta = ruta;
        this.nombre = nombre;
        this.tipo = tipo;
        abrir();
    }

    public Archivo(String nombre, String tipo) {
        this.lista = new ArrayList();
        this.ruta = System.getProperty("user.dir");
        this.nombre = nombre;
        this.tipo = tipo;
        abrir();
    }

    public Archivo(String nombre) {
        this.lista = new ArrayList();
        this.ruta = System.getProperty("user.dir");
        this.nombre = nombre;
        this.tipo = ".utn";
        abrir();
    }

    public Archivo(File archivo) {
        try {
            this.lista = new ArrayList();
            this.archivo = archivo;
            this.lector = new BufferedReader(new FileReader(archivo));
            this.escritor = new BufferedWriter(new FileWriter(archivo, true));
        } catch (IOException ex) {
        }
    }

    public void abrir() {
        this.archivo = new File(ruta + "\\" + nombre + tipo);
        try {
            if (!this.existe()) {
                this.crear();
            }
            this.lector = new BufferedReader(new FileReader(archivo));
            this.escritor = new BufferedWriter(new FileWriter(archivo, true));
        } catch (IOException ex) {
            System.out.println("Error al momento de abrir");
        }
    }

    public void cerrar() {
        try {
            this.lector.close();
            this.escritor.close();
        } catch (IOException ex) {
            System.out.println("Error al momento de cerrar");
        }
    }

    public void crear() {
        try {
            this.archivo.createNewFile();
        } catch (IOException ex) {
            System.out.println("Error al momento de crear");
        }
    }

    public boolean existe() {
        return this.archivo.exists();
    }

    public void guardar() {
        try {
            this.escritor.flush();
        } catch (IOException ex) {
            System.out.println("Error al momento de guardar");
        }
    }

    public String leer() {
        try {
            return this.lector.readLine();
        } catch (IOException ex) {
            System.out.println("Error al momento de leer");
            return null;
        }
    }

    public void escribir(String contenido) {
        try {
            this.escritor.write(contenido);
            this.escritor.newLine();
        } catch (IOException ex) {
            System.out.println("Error al momento de escribir");
        }
    }

    public void eliminar() {
        cerrar();
        this.archivo.delete();
    }

    /**
     * Elimina una linea en especifico del archivo y trabaja en base 1.
     *
     * @param n Linea a eliminar
     */
    public void eliminarLinea(int n) {
        String dato;
        int cont = 0;
        while ((dato = this.leer()) != null) {
            if (++cont != n) {
                this.lista.add(dato);
            }
        }
        this.limpiar();
        for (String linea : this.lista) {
            this.escribir(linea);
        }
        this.lista.clear();
        this.abrir();
        this.guardar();
    }

    public void limpiar() {
        try {
            this.escritor = new BufferedWriter(new FileWriter(archivo));
        } catch (IOException ex) {
            System.out.println("Error al momento de limpiar");
        }
    }

    public void cambiarNombre(String nombre) {
        File nuevoArchivo = new File(nombre);
        this.archivo.renameTo(nuevoArchivo);
    }

}
