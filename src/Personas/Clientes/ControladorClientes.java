package Personas.Clientes;

import BaseDeDatos.BaseDatos;

public class ControladorClientes {

    private ModeloClientes cliente;

    public void eliminar(String cedula) {
        if (verificarCedula(cedula)) {
             BaseDatos BD = new BaseDatos("DELETE FROM tblclientes WHERE Cedula =" + cedula);
        }
    }

    public void agregar(String cedula, String nombre, String fecha, String telefono, String correo) {
        BaseDatos BD = new BaseDatos("INSERT INTO tblclientes VALUES (?,?,?,?,?)");
        BD.ejecutar(new Object[]{cedula, nombre, fecha, telefono, correo});
    }

    public void leer(String cedula) {
         if (verificarCedula(cedula)) {
        BaseDatos BD = new BaseDatos("SELECT * FROM tblclientes WHERE Cedula =" + cedula);
         }
    }

    public void modificarTelefono(String telefono, String cedula) {
         if (verificarCedula(cedula)) {
        BaseDatos BD = new BaseDatos("UPDATE tblclientes SET Telefono =" + telefono + " WHERE Cedula =" + cedula);
         }
    }

    public void modificarCorreo(String correo, String cedula) {
         if (verificarCedula(cedula)) {
        BaseDatos BD = new BaseDatos("UPDATE tblclientes SET Correo =" + correo + " WHERE Cedula =" + cedula);
         }
    }

    private boolean verificarNombre(String nombre) {
        return !nombre.trim().equals("");
    }

    private boolean verificarCedula(String cedula) {
        try {
            long id = Long.parseLong((cedula.replaceAll("-", "0")));
            return id == 11;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    private boolean verificarTelefono(String telefono) {
        try {
            long numero = Long.parseLong(telefono);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

}
