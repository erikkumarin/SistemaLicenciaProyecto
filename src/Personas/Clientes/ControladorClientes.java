package Personas.Clientes;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Errores.ErrorMensaje;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorClientes {

    private clsClientes cliente;
    private BaseDatos BD;

    public ControladorClientes() {
    }

    public void agregar(frmRegistrarCliente vista) throws ErrorConexion {
        BD = new BaseDatos("INSERT INTO tblclientes VALUES (?,?,?,?,?)");
        cliente = new clsClientes(vista.getCedula(), vista.getNombre(), vista.getFecha(), vista.getTelefono(), vista.getCorreo());
        if (ErrorMensaje.mostrarMensajes()) {
            JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
        } else {
            BD.ejecutar(new Object[]{cliente.getCedula(), cliente.getNombre(), cliente.getFechaNac(), cliente.getTelefono(), cliente.getCorreo()});
            vista.dispose();
        }
    }

    public void eliminar(frmRegistrarCliente vista) throws ErrorConexion {
        cliente = new clsClientes();
        cliente.setCedula(vista.getCedula());
        BD = new BaseDatos("DELETE FROM tblclientes WHERE Cedula =" + cliente.getCedula());
        BD.ejecutar();
    }

    public void leer(frmRegistrarCliente vista) throws ErrorConexion {
        cliente = new clsClientes();
        cliente.setCedula(vista.getCedula());
        BD = new BaseDatos("SELECT * FROM tblclientes WHERE Cedula =" + cliente.getCedula());
        BD.ejecutar();
    }

    public void cargarUsuarios(frmMostrarClientes vista) throws ErrorConexion {
        BD = new BaseDatos("Select * from tblClientes");
        BD.ejecutar();
        DefaultTableModel modelo = (DefaultTableModel) vista.getTblClientes().getModel();
        modelo.setNumRows(0);
        Object obj[];
        do {
            obj = BD.getObjet();
            if (obj != null) {
                cliente = new clsClientes(obj);
                modelo.addRow(cliente.toObject());
            }
        } while (obj != null);
    }

    public String pasarClientes(frmMostrarClientes vista, int indice) throws ErrorConexion {
        BD = new BaseDatos("SELECT * from tblClientes WHERE Cedula = ?");
        BD.ejecutar(new Object[]{vista.getTblClientes().getValueAt(indice, 0).toString()});
        Object obj[] = BD.getObjet();
        cliente = new clsClientes(obj);
        return cliente.getCedula();
    }
}
