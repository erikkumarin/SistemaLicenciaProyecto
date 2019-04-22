package Personas;

import Utilidades.Fecha;
import java.util.regex.Pattern;

public abstract class clsPersona {

    protected String cedula;
    protected String nombre;
    protected Fecha fechaNac;
    protected String telefono;
    protected String correo;
    
    protected String msjError = null;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula.length() == 9) {
            this.cedula = cedula;
        } else {
            msjError = "Error: Cedula no Valida";
        }
    }

    public String getNombre() {
        return nombre.toUpperCase();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono.length() == 8) {
            this.telefono = telefono;
        } else {
            msjError = "Error: Telefono no Valido";
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        String correoPatron = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
        if (Pattern.matches(correoPatron, correo)) {
            this.correo = correo;
        }else{
            msjError = "Error: El Correo es Invalido";
        }
    }
    
    public String getFechaNac() {
        if (this.fechaNac.getFecha() != null) {
            return this.fechaNac.toString();
        }
        return null;
    }

    public void setFechaNac(String fecha) {
        this.fechaNac.setFecha(fecha);
    }

    public clsPersona(String cedula, String nombre, String fechaNac, String telefono, String correo) {
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setFechaNac(fechaNac);
        this.setTelefono(telefono);
        this.setCorreo(correo);
    }

    public clsPersona() {
    }
    
}
