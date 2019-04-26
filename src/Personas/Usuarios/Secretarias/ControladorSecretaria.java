package Personas.Usuarios.Secretarias;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;

public class ControladorSecretaria {

    private clsSecretaria secretaria;

    public ControladorSecretaria() {
    }

    public void eliminar(String cedula) throws ErrorConexion {
        BaseDatos BD = new BaseDatos("DELETE FROM tblusuarios WHERE Cedula =" + cedula);
    }

    public void agregar(String cedula, String nombre, String fecha, String telefono, String correo) throws ErrorConexion {
        BaseDatos BD = new BaseDatos("INSERT INTO tblusuarios VALUES (?,?,?,?,?)");
        BD.ejecutar(new Object[]{cedula, nombre, fecha, telefono, correo});
    }

    public void agregarSinCorreo(String cedula, String nombre, String fecha, String telefono) throws ErrorConexion {
        BaseDatos BD = new BaseDatos("INSERT INTO tblusuarios VALUES (?,?,?,?,?)");
        BD.ejecutar(new Object[]{cedula, nombre, fecha, telefono, null});
    }

    public void agregarSinTelefono(String cedula, String nombre, String fecha, String correo) throws ErrorConexion {
        BaseDatos BD = new BaseDatos("INSERT INTO tblusuarios VALUES (?,?,?,?,?)");
        BD.ejecutar(new Object[]{cedula, nombre, fecha, null, correo});
    }

    public void leer(String cedula, String datos) throws ErrorConexion {
        BaseDatos BD = new BaseDatos("SELECT " + datos + " FROM tblusuarios WHERE Cedula =" + cedula);
    }

    public void modificarTelefono(String telefono, String cedula) throws ErrorConexion {
        BaseDatos BD = new BaseDatos("UPDATE tblusuarios SET Telefono =" + telefono + " WHERE Cedula =" + cedula);
    }

    public void modificarCorreo(String correo, String cedula) throws ErrorConexion {
        BaseDatos BD = new BaseDatos("UPDATE tblusuarios SET Correo =" + correo + " WHERE Cedula =" + cedula);
    }

}
