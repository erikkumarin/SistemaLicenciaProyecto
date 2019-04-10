package Personas.Clientes;

import BaseDeDatos.BaseDatos;

public class ControladorClientes {
    
    private ModeloClientes cliente;
     
    public void eliminar(String cedula){
        BaseDatos BD = new BaseDatos("DELETE FROM clientes WHERE Cedula ="+cedula);
    }
    public void agregar(String cedula, String nombre, String fecha, String telefono, String correo){
         BaseDatos BD = new BaseDatos("INSERT INTO clientes VALUES (?,?,?,?,?)");
         BD.ejecutar(new Object[]{nombre,fecha,telefono,correo});
    }
    public void leer(String cedula){
        BaseDatos BD = new BaseDatos("SELECT * FROM Clientes WHERE Cedula ="+cedula);
    }
    public void modificarCedula(){
        BaseDatos BD = new BaseDatos("UPDATE Clientes");
    }
    public void modificarNombre(){
        
    }
    public void modificarFecha(){
        
    }
    public void modificarTelefono(){
        
    }
    public void modificarCorreo(){
        
    }
    

}
