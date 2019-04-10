package Personas.Clientes;

import BaseDeDatos.BaseDatos;

public class ControladorClientes {
    
    private ModeloClientes cliente;
     
    public void eliminar(String cedula){
        BaseDatos BD = new BaseDatos("DELETE FROM clientes WHERE Cedula ="+cedula);
    }
    public void agregar(String cedula, String nombre, String fecha, String telefono, String correo){
         BaseDatos BD = new BaseDatos("INSERT INTO tblclientes VALUES (?,?,?,?,?)");
         BD.ejecutar(new Object[]{cedula,nombre,fecha,telefono,correo});
    }
    public void leer(String cedula){
        BaseDatos BD = new BaseDatos("SELECT * FROM tblclientes WHERE Cedula ="+cedula);
    }

    public void modificarTelefono(String valor, String telefono){
        BaseDatos BD = new BaseDatos("UPDATE tblclientes SET Telefono ="+valor+ " WHERE Telefono="+ telefono);
    }
    public void modificarCorreo(String valor, String correo){
        BaseDatos BD = new BaseDatos("UPDATE tblclientes SET Correo ="+valor+ " WHERE Correo="+ correo);
    }
    

}
