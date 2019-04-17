package Citas;

//package Citas;
import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Personas.Clientes.ModeloClientes;
import Utilidades.CRUD;

public class ControladorCitas implements CRUD {

    private VistaCitas cita;
    private ModeloClientes cliente;
    private BaseDatos bd;

    public ControladorCitas(VistaCitas vista) {
        cita = vista;
    }

    @Override
    public void agregar() throws ErrorConexion {
        bd = new BaseDatos("INSERT INTO tblcitas VALUES (null,?,?,?)");
    }

    @Override
    public void eliminar() throws ErrorConexion {
        bd = new BaseDatos("DELETE FROM tblcitas WHERE Cedula =" + cliente.getCedula());
    }

    @Override
    public void modificar() throws ErrorConexion {

    }

    @Override
    public void leer() throws ErrorConexion {
        this.cliente = new ModeloClientes();
        this.cliente.setCedula(cita.getCedula());
        BaseDatos bd = new BaseDatos("Select * from tblcitas where idCliente like ?");
//        "Select * from clientes where idCliente like ?"
    }
}
