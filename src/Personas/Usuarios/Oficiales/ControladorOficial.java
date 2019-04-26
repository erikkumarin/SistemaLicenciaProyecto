package Personas.Usuarios.Oficiales;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Errores.ErrorMensaje;
import Personas.Usuarios.frmEditarUsuario;
import Personas.Usuarios.frmRegistarUsuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorOficial {

    private clsOficial oficial;
    private BaseDatos BD;

    public void agregar(frmRegistarUsuario vista) throws ErrorConexion {
        BD = new BaseDatos("INSERT INTO tbloficiales VALUES (?,?,?,?,?,?)");
        oficial = new clsOficial(vista.getCedula(), vista.getNombre(), vista.getFecha(), vista.getTelefono(), vista.getCorreo(), Double.parseDouble(vista.getSalario()));
        if (ErrorMensaje.mostrarMensajes()) {
            JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
        } else {
            BD.ejecutar(new Object[]{oficial.getCedula(), oficial.getNombre(), oficial.getFechaNac(), oficial.getTelefono(), oficial.getCorreo(), oficial.getSalario()});
            vista.dispose();
        }
    }
    
    public void modificar(frmEditarUsuario vista) throws ErrorConexion {
        BD =  new BaseDatos("UPDATE tblOficiales SET Nombre=?, Telefono=?, Correo=? WHERE Cedula=?");
        oficial = new clsOficial(vista.getCedula(), vista.getNombre(), "01/01/2019", vista.getTelefono(), vista.getCorreo(), 0.0);
        if (ErrorMensaje.mostrarMensajes()) {
            JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
        }else{
            BD.ejecutar(new Object[]{oficial.getNombre(), oficial.getTelefono(), oficial.getCorreo(), oficial.getCedula()});
        }
    }

    public void cargarOficiales(frmMostrarPlantilla vista) throws ErrorConexion {
        BD = new BaseDatos("Select * from tblOficiales");
        BD.ejecutar();
        DefaultTableModel modelo = (DefaultTableModel) vista.getTblPlanilla().getModel();
        modelo.setNumRows(0);
        Object obj[];
        do {
            obj = BD.getObjet();
            if (obj != null) {
                oficial = new clsOficial(obj);
                modelo.addRow(new Object[]{oficial.getCedula(), oficial.getNombre(), oficial.getFechaNac(), oficial.getSalario()});
            }
        } while (obj != null);
    }
    
}
