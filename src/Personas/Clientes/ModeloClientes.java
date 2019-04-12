package Personas.Clientes;

import Personas.clsPersonas;
import Utilidades.FechaNac;

public class ModeloClientes extends clsPersonas {

    private FechaNac fechaNac;

    public String getFechaNac() {
        if (this.fechaNac.getFechaNac() == null) {
            return null;
        } else {
            String fechaInvertida[] = this.fechaNac.getFechaNac().toString().split("-");
            return fechaInvertida[2] + "/" + fechaInvertida[1] + "/" + fechaInvertida[0];
        }
    }

    public void setFechaNac(String fecha) {
        this.fechaNac.ingresarFechaNac(fecha);
    }

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

    public ModeloClientes(String cedula, String nombre, String nombreUsuario, String contra, String telefono, String tipoUsuario, String correo, String fecha) {
        this.fechaNac = new FechaNac();
        this.setFechaNac(fecha);
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setTelefono(telefono);
    }

    public ModeloClientes() {
        this.fechaNac = new FechaNac();
    }

    /**
     * Calcula la edad del cliente ingresando su fecha de nacimiento.
     *
     * @param fechaNac dd/mm/yyyy
     * @return la edad del cliente
     */
    public int calcularEdad(String fechaNac) {
        int edad = this.fechaNac.calcularMotrarEdad(fechaNac);
        if (edad >= 18) {
            return edad;
        } else {
            return 0;
        }
    }

    /**
     * Requiere haberse ingresado anteriormente la fecha de nacimiento.
     *
     * @return Edad del cliente
     */
    public int calcularEdad() {
        if (this.getFechaNac() == null) {
            return 0;
        } else {
            int edad = this.fechaNac.calcularMotrarEdad(this.getFechaNac());
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
