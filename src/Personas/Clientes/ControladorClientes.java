package Personas.Clientes;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Errores.ErrorMensaje;
import Personas.frmBuscarPersona;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorClientes {

    private clsClientes cliente;
    private BaseDatos BD;

    public ControladorClientes() {
    }

    public void agregar(frmRegistrarCliente vista) throws ErrorConexion {
        cliente = new clsClientes(vista.getCedula(), vista.getNombre(), vista.getFecha(), vista.getTelefono(), vista.getCorreo());
        BD = new BaseDatos("INSERT INTO tblclientes VALUES (?,?,?,?,?)");
        if (ErrorMensaje.mostrarMensajes()) {
            JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
        } else {
            BD.ejecutar(cliente.toObjects());
            JOptionPane.showMessageDialog(vista, "Registro Exitoso", "Registrar Cliente", 1);
            vista.dispose();
        }
    }

    public void eliminar(frmBuscarPersona vista) throws ErrorConexion {
        cliente = new clsClientes();
        cliente.setCedula(vista.getPersonas().getValueAt(vista.getPersonas().getSelectedRow(), 0).toString());
        if (ErrorMensaje.mostrarMensajes()) {
            JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
        } else {
            BD = new BaseDatos("DELETE FROM tblclientes WHERE Cedula = ?");
            BD.ejecutar(new Object[]{cliente.getCedula()});
            JOptionPane.showMessageDialog(vista, "El Registro se Elimino", "Eliminar Cliente", 1);
        }
    }

    public void filtar(frmBuscarPersona vista) throws ErrorConexion {
        if (Pattern.matches("[a-zA-Z]+", vista.getBusqueda())) {
            BD = new BaseDatos("SELECT * FROM tblclientes WHERE Nombre LIKE ?");
        } else {
            BD = new BaseDatos("SELECT * FROM tblclientes WHERE Cedula LIKE ?");
        }
        BD.ejecutar(new Object[]{"%" + vista.getBusqueda() + "%"});
        DefaultTableModel modelo = (DefaultTableModel) vista.getPersonas().getModel();
        Object obj[];
        do {
            obj = BD.getObjet();
            if (obj != null) {
                cliente = new clsClientes(obj);
                modelo.addRow(cliente.toObjects("Cliente"));
            }
        } while (obj != null);
    }

    public void modificar(frmEditarCliente vista) throws ErrorConexion {
        BD =  new BaseDatos("UPDATE tblclientes SET Nombre=?, Telefono=?, Correo=? WHERE Cedula=?");
        cliente = new clsClientes(vista.getCedula(), vista.getNombre(), "01/01/2019", vista.getTelefono(), vista.getCorreo());
        if (ErrorMensaje.mostrarMensajes()) {
            JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
        }else{
            BD.ejecutar(new Object[]{cliente.getNombre(), cliente.getTelefono(), cliente.getCorreo(), cliente.getCedula()});
            JOptionPane.showMessageDialog(vista, "Registro Exitoso", "Actualizar Cliente", 1);
            vista.dispose();
        }
    }

    public void cargarClientes(frmMostrarClientes vista) throws ErrorConexion {
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
                cliente = new clsClientes(obj);
                if (validar(vista, cliente)) {
                    modelo.addRow(cliente.toObjects());
                }
            }
        } while (obj != null);
    }

    public clsClientes pasarDatos(frmMostrarClientes vista, int indice) throws ErrorConexion {
        BD = new BaseDatos("SELECT * from tblClientes WHERE Cedula = ?");
        BD.ejecutar(new Object[]{vista.getTblClientes().getValueAt(indice, 0).toString()});
        Object obj[] = BD.getObjet();
        cliente = new clsClientes(obj);
        return cliente;
    }

    public clsClientes editar(frmBuscarPersona vista, int indice) throws ErrorConexion {
        BD = new BaseDatos("SELECT * from tblClientes WHERE Cedula = ?");
        BD.ejecutar(new Object[]{vista.getPersonas().getValueAt(indice, 0).toString()});
        Object obj[] = BD.getObjet();
        cliente = new clsClientes(obj);
        return cliente;
    }

    public boolean validar(frmMostrarClientes vista, clsClientes cliente) {
        int fila = vista.getTblClientes().getRowCount();
        for (int i = 0; i < fila; i++) {
            if (vista.getTblClientes().getValueAt(i, 0).toString().equals(cliente.getCedula())) {
                return false;
            }
        }
        return true;
    }

    public int comprobarPrueba(frmMostrarClientes vista) throws ErrorConexion {
        BD = new BaseDatos("SELECT count(Id) FROM tblpruebas WHERE IdCliente = ?");
        BD.ejecutar(new Object[]{vista.getTblClientes().getValueAt(vista.getTblClientes().getSelectedRow(), 0).toString()});
        return (int) BD.getObjet()[0];
    }

}
