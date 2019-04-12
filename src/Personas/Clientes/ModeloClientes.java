package Personas.Clientes;

import Personas.clsPersonas;
import Utilidades.Fecha;
import java.time.Period;

public class ModeloClientes extends clsPersonas {

    private Fecha fecha;

    public String getFecha() {
        if (this.fecha.getFecha() == null) {
            return null;
        } else {
            String fechaInvertida[] = this.fecha.getFecha().toString().split("-");
            return fechaInvertida[2] + "/" + fechaInvertida[1] + "/" + fechaInvertida[0];
        }
    }

    public void setFechaNac(String fecha) {
        this.fecha.setFecha(fecha);
    }

    public ModeloClientes(String cedula, String nombre, String nombreUsuario, String contra, String telefono, String tipoUsuario, String correo, String fecha) {
        this.fecha = new Fecha(fecha);
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setTelefono(telefono);
    }

    public ModeloClientes(String fecha) {
        this.fecha = new Fecha(fecha);
    }

    /**
     * Requiere haberse ingresado anteriormente la fecha de nacimiento.
     *
     * @return Edad del cliente
     */
    public int calcularEdad() {
        if (this.getFecha() == null) {
            return 0;
        } else {
            fecha.setPeriodo(fecha.getFecha());
            int edad = fecha.getPeriodo().getYears();
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
