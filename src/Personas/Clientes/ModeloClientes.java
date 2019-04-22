package Personas.Clientes;

import Personas.clsPersona;
import Utilidades.Fecha;

public class ModeloClientes extends clsPersona {

    public ModeloClientes(String cedula, String nombre, String correo, String telefono, String fecha) {
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setTelefono(telefono);
        this.setFechaNac(fecha);
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
            this.fechaNac.setPeriodo(this.fechaNac.getFecha());
            int edad = this.fechaNac.getPeriodo().getYears();
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
