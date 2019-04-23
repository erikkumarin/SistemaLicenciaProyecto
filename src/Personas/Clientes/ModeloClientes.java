package Personas.Clientes;

import Personas.clsPersona;

public class ModeloClientes extends clsPersona {

    public ModeloClientes(String cedula, String nombre, String fechaNac, String telefono, String correo) {
        super(cedula, nombre, fechaNac, telefono, correo);
    }

    public ModeloClientes() {
    }
    
    /**
     * Requiere haberse ingresado anteriormente la fecha de nacimiento.
     *
     * @return Edad del cliente
     */
    public int calcularEdad() {
        if (this.getFechaNac() != null) {
            this.fechaNac.setPeriodo(this.fechaNac.getFecha());
            int edad = this.fechaNac.getPeriodo().getYears();
            if (edad >= 18) {
                return edad;
            } else {
                msjError = "Error: No eres mayor de edad";
            }
        }
        return 0;
    }
}
