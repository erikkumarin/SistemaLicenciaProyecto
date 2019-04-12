package Personas.Clientes;

import Personas.clsPersonas;
import Utilidades.FechaNac;

public class ModeloClientes extends clsPersonas {

    private FechaNac fecha;

    @Override
    public void setCorreo(String correo) {
        super.setCorreo(correo);
    }

    @Override
    public String getCorreo() {
        return super.getCorreo();
    }

    @Override
    public void setTelefono(String telefono) {
        super.setTelefono(telefono);
    }

    @Override
    public String getTelefono() {
        return super.getTelefono();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre.toUpperCase());
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setCedula(String cedula) {
        super.setCedula(cedula);
    }

    @Override
    public String getCedula() {
        return super.getCedula();
    }

    public int calcularEdad(String fechaNac) {
        int edad = this.fecha.calcularMotrarEdad(fechaNac);
        if (edad >= 18) {
            return edad;
        } else {
            return 0;
        }
    }

    public String eliminarCliente() {
        this.setCedula(null);
        return this.getCedula();
    }

}
