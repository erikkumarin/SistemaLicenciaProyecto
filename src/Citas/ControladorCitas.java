package Citas;

//package Citas;
import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Personas.Clientes.ModeloClientes;
import Utilidades.CRUD;
import java.util.Arrays;

public class ControladorCitas implements CRUD {

    private final VistaCitas cita;
    private ModeloClientes cliente;
    private BaseDatos bd;

    public ControladorCitas(VistaCitas vista) {
        cita = vista;
    }

    @Override
    public void agregar() throws ErrorConexion {
        this.cliente = new ModeloClientes();
        bd = new BaseDatos("INSERT INTO tblcitas VALUES (null,?,?,?)");
    }

    @Override
    public void eliminar() throws ErrorConexion {
        this.cliente = new ModeloClientes();
        bd = new BaseDatos("DELETE FROM tblcitas WHERE Cedula =" + cliente.getCedula());
    }

    @Override
    public void modificar() throws ErrorConexion {

    }

    @Override
    public void leer() throws ErrorConexion {
        this.cliente = new ModeloClientes();
        this.cliente.setCedula(cita.getCedula());
        System.out.println(cliente.getCedula());
        BaseDatos bd = new BaseDatos("Select * from tblclientes where cedula=?");
        bd.setParametros(new Object[]{cita.getCedula()});
        Object Infocliente[];
        Infocliente = this.bd.getObjet();
        Arrays.toString(Infocliente);
//        "Select * from clientes where idCliente like ?"
    }
}
