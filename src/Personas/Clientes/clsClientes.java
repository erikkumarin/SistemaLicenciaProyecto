package Personas.Clientes;

import Errores.ErrorMensaje;
import Personas.clsPersona;
import Pruebas.clsPruebas;
import java.util.ArrayList;

public class clsClientes extends clsPersona {

    private ArrayList<clsPruebas> pruebas;

    public ArrayList<clsPruebas> getPruebas() {
        return pruebas;
    }

    public clsClientes(String cedula, String nombre, String fechaNac, String telefono, String correo) {
        super(cedula, nombre, fechaNac, telefono, correo);
        pruebas = new ArrayList<clsPruebas>();
        pruebas.clear();
    }

    public clsClientes(Object[] obj) {
        super((String) obj[0], (String) obj[1], (String) obj[2], (String) obj[3], (String) obj[4]);
        pruebas = new ArrayList<clsPruebas>();
        pruebas.clear();
    }

    public clsClientes() {
        pruebas = new ArrayList<clsPruebas>();
        pruebas.clear();
    }

    public void setDatos(String cedula, String nombre, String fechaNac, String telefono, String correo) {
        this.setCedula(cedula);
        this.setNombre(nombre);;
        this.setFechaNac(fechaNac);
        this.setTelefono(telefono);
        this.setCorreo(correo);
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
                ErrorMensaje.agregarMensaje("Error: No eres mayor de edad");
            }
        }
        return 0;
    }

    public void agregarPrueba(clsPruebas prueba) {
        this.pruebas.add(prueba);
    }

    public Object[] toObject() {
        return new Object[]{this.getCedula(), this.getNombre(), this.calcularEdad(), this.getTelefono(), this.getCorreo()};
    }

    public Object[] toObjects() {
        return new Object[]{this.getCedula(), this.getNombre(), this.getFechaNac(), this.getTelefono(), this.getCorreo()};
    }

    int cont = 0;
    String msjPruebas = "";

    public void toStringPrueba() {
        for (clsPruebas prueba : pruebas) {
            msjPruebas += "Pruebas:\n" + prueba.toString();
        }
        msjPruebas += "\nIntentos: " + pruebas.size();
    }

    @Override
    public String toString() {
        this.toStringPrueba();
        return "Cedula: " + this.getCedula() + " Nombre: " + this.getNombre() + " Fecha Nacimiento: " + this.getFechaNac() + ""
                + " Telefono: " + this.getTelefono() + " Correo: " + this.getCorreo() + "\n" + this.msjPruebas;
    }

}
