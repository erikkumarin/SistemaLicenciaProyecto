package Personas.Usuarios;

import BaseDeDatos.BaseDatos;

public class ControladorUsuarios {

    private ModeloUsuarios usuario;
    private BaseDatos BD;

    public void eliminar(String cedula) {
        if (verificarCedula(cedula)) {
            BD = new BaseDatos("DELETE FROM tblusuarios WHERE Cedula =" + cedula);
        }
    }

    public void agregar(String cedula, String nombre, String fecha, String telefono, String correo, String tipo, String salario) {
        BD = new BaseDatos("INSERT INTO tblusuarios VALUES (?,?,?,?,?,?,?)");
        BD.ejecutar(new Object[]{cedula, nombre, fecha, telefono, correo, tipo, salario});
    }

    public void leer(String cedula) {
        if (verificarCedula(cedula)) {
            BD = new BaseDatos("SELECT * FROM tblusuarios WHERE Cedula =" + cedula);
        }
    }

    public void modificarTelefono(String telefono, String cedula) {
        if (verificarCedula(cedula)) {
            BD = new BaseDatos("UPDATE tblusuarios SET Telefono =" + telefono + " WHERE Cedula =" + cedula);
        }
    }

    public void modificarCorreo(String correo, String cedula) {
        if (verificarCedula(cedula)) {
            BD = new BaseDatos("UPDATE tblusuarios SET Correo =" + correo + " WHERE Cedula =" + cedula);
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
