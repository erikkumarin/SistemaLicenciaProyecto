package Personas.Clientes;

import Personas.clsPersonas;
import Utilidades.Fecha;

public class ModeloClientes extends clsPersonas {

    private Fecha fechaNac;

    public String getFechaNac() {
        if (this.fechaNac.getFecha() == null) {
            return null;
        } else {
            return this.fechaNac.toString();
        }
    }

    public void setFechaNac(String fecha) {
        this.fechaNac.setFecha(fecha);
    }

    public ModeloClientes(String cedula, String nombre, String correo, String telefono, String fecha) {
        this.fechaNac = new Fecha(fecha);
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setTelefono(telefono);
    }

    public ModeloClientes(String fecha) {
        this.fechaNac = new Fecha(fecha);
    }

    public ModeloClientes() {
        
    }

    /**
     * Requiere haberse ingresado anteriormente la fecha de nacimiento.
     *
     * @return Edad del cliente
     */
    public int calcularEdad() {
        if (this.getFechaNac()== null) {
            return 0;
        } else {
            fechaNac.setPeriodo(fechaNac.getFecha());
            int edad = fechaNac.getPeriodo().getYears();
            if (edad >= 18) {
                return edad;
            } else {
                return 0;
            }
        }
    }

    public String eliminarCliente() {
        this.setCedula(null);
        return this.getCedula();
    }

}
