package Personas.Clientes;

import BaseDeDatos.BaseDatos;

public class ControladorClientes {

    private ModeloClientes cliente;
    private BaseDatos BD;

    public void eliminar(String cedula) {
        if (verificarCedula(cedula)) {
            BD = new BaseDatos("DELETE FROM tblclientes WHERE Cedula =" + cedula);
            BD.ejecutar();
            
        }
    }

    public void agregar(String cedula, String nombre, String fecha, String telefono, String correo) {
        if (verificarCedula(cedula) && verificarNombre(nombre) && verificarTelefono(telefono)) {
            BD = new BaseDatos("INSERT INTO tblclientes VALUES (?,?,?,?,?)");
            BD.ejecutar(new Object[]{cedula, nombre, fecha, telefono, correo});
        }
    }
    public void agregarCorreo(String cedula, String nombre, String fecha, String correo) {
        if (verificarCedula(cedula) && verificarNombre(nombre)) {
            BD = new BaseDatos("INSERT INTO tblclientes VALUES (?,?,?,?,?)");
            BD.ejecutar(new Object[]{cedula, nombre, fecha, null, correo});
        }
    }
    public void agregartelefono(String cedula, String nombre, String fecha, String telefono) {
        if (verificarCedula(cedula) && verificarNombre(nombre) && verificarTelefono(telefono)) {
            BD = new BaseDatos("INSERT INTO tblclientes VALUES (?,?,?,?,?)");
            BD.ejecutar(new Object[]{cedula, nombre, fecha, telefono, null});
        }
    }

    public void leer(String dato,String cedula) {
        if (verificarCedula(cedula)) {
            BD = new BaseDatos("SELECT" +dato+ "FROM tblclientes WHERE Cedula =" + cedula);
            BD.ejecutar();
        }
    }
 

    public void setTelefono(String telefono, String cedula) {
        if (verificarCedula(cedula)) {
            BD = new BaseDatos("UPDATE tblclientes SET Telefono =" + telefono + " WHERE Cedula =" + cedula);
            BD.ejecutar();
        }
    }

    public void setCorreo(String correo, String cedula) {
        if (verificarCedula(cedula)) {
            BD = new BaseDatos("UPDATE tblclientes SET Correo =" + correo + " WHERE Cedula =" + cedula);
            BD.ejecutar();
        }
    }
    

    private boolean verificarCedula(String cedula) {
        try {
            return (Long.parseLong((cedula.replaceAll("-", "0")))) == 9;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    private boolean verificarNombre(String nombre) {
        return !nombre.trim().equals("");
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
