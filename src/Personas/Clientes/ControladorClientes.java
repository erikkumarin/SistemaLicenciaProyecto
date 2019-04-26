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

    public int cargarClientes(frmMostrarClientes vista) throws ErrorConexion {
        BD = new BaseDatos("SELECT cliente.Cedula, cliente.Nombre, cliente.`Fecha Nac`, cliente.Telefono, "
                + "cliente.Correo FROM tblclientes AS cliente INNER JOIN tblpruebas as prueba on cliente.Cedula = prueba.IdCliente");
        BD.ejecutar();
        DefaultTableModel modelo = (DefaultTableModel) vista.getTblClientes().getModel();
        modelo.setNumRows(0);
        Object obj[];
        int x = 0;
        do {
            obj = BD.getObjet();
            if (obj != null) {
                x = validar(vista, cliente);
                cliente = new clsClientes(obj);
                if (x == 0) {
                    modelo.addRow(cliente.toObjects());
                }
            }
        } while (obj != null);
        return x;
    }

    public String pasarClientes(frmMostrarClientes vista, int indice) throws ErrorConexion {
        BD = new BaseDatos("SELECT * from tblClientes WHERE Cedula = ?");
        BD.ejecutar(new Object[]{vista.getTblClientes().getValueAt(indice, 0).toString()});
        Object obj[] = BD.getObjet();
        cliente = new clsClientes(obj);
        return cliente.getCedula();
    }

    public int validar(frmMostrarClientes vista, clsClientes cliente) {
        int fila = vista.getTblClientes().getRowCount();
        int cantidad = 0;
        for (int i = 0; i < fila; i++) {
            if (vista.getTblClientes().getValueAt(i, 0).toString().equals(cliente.getCedula())) {
                cantidad++;
            }
        }
        return cantidad;
    }
}
