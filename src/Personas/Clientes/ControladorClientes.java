package Personas.Clientes;

import BaseDeDatos.BaseDatos;
import Utilidades.CRUD;

public class ControladorClientes implements CRUD {

    private ModeloClientes cliente;
    private BaseDatos BD;
    private VistaCliente vista;

    public ControladorClientes(VistaCliente vista) {
        this.vista = vista;
    }
    
    @Override
    public void agregar() {
        BD = new BaseDatos("INSERT INTO tblclientes VALUES (?,?,?,?,?)");
        cliente = new ModeloClientes(vista.getCedula(), vista.getNombre(), vista.getTelefono(), vista.getCorreo(), vista.getFecha());
        BD.ejecutar(new Object[]{cliente.getCedula(), cliente.getNombre(), cliente.getFechaNac(), cliente.getTelefono(), cliente.getCorreo()});

    }

    @Override
    public void eliminar() {
        cliente = new ModeloClientes();
        cliente.setCedula(vista.getCedula());
        BD = new BaseDatos("DELETE FROM tblclientes WHERE Cedula =" + cliente.getCedula());
        BD.ejecutar();
    }
    
    @Override
    public void leer() {
        cliente = new ModeloClientes();
        cliente.setCedula(vista.getCedula());
        BD = new BaseDatos("SELECT * FROM tblclientes WHERE Cedula =" + cliente.getCedula());
        BD.ejecutar();
    }

    @Override
    public void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
