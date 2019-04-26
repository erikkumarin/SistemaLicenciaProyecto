package Personas.Usuarios.Oficiales;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Errores.ErrorMensaje;
import Personas.Usuarios.frmEditarUsuario;
import Personas.Usuarios.frmRegistarUsuario;
import Personas.frmBuscarPersona;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorOficial {

    private clsOficial oficial;
    private BaseDatos BD;

    public boolean agregar(frmRegistarUsuario vista) throws ErrorConexion {
        BD = new BaseDatos("INSERT INTO tbloficiales VALUES (?,?,?,?,?,?)");
        oficial = new clsOficial(vista.getCedula(), vista.getNombre(), vista.getFecha(), vista.getTelefono(), vista.getCorreo(), Double.parseDouble(vista.getSalario()));
        if (ErrorMensaje.mostrarMensajes()) {
            JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
        } else {
            BD.ejecutar(new Object[]{oficial.getCedula(), oficial.getNombre(), oficial.getFechaNac(), oficial.getTelefono(), oficial.getCorreo(), oficial.getSalario()});
            return true;
        }
        return false;
    }
    
    public void eliminar(frmBuscarPersona vista) throws ErrorConexion {
        oficial = new clsOficial();
        oficial.setCedula(vista.getPersonas().getValueAt(vista.getPersonas().getSelectedRow(), 0).toString());
        if (ErrorMensaje.mostrarMensajes()) {
            JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
        } else {
            BD = new BaseDatos("DELETE FROM tbloficiales WHERE Cedula =?");
            BD.ejecutar(new Object[]{oficial.getCedula()});
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
    
    public void modificarSalario(frmPlantilla vista) throws ErrorConexion {
        BD = new BaseDatos("UPDATE tblOficiales SET Salario = ? WHERE Cedula=?");
        oficial = new clsOficial();
        oficial.setCedula(vista.getCedula());
        oficial.setSalario(Double.parseDouble(vista.getSalarioBruto()));
        if (ErrorMensaje.mostrarMensajes()) {
            JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
        } else {
            BD.ejecutar(new Object[]{oficial.getSalario(), oficial.getCedula()});
            vista.setEnferYMater(oficial.calcularDeducEnfMat());
            vista.setInvaYMuert(oficial.calcularDeducInvaMuer());
            vista.setAporYTrab(oficial.calcularDeducAporTrab());
            vista.setAporYAsoc(oficial.calcularDeducAsocSoli());
            vista.setImpuesto(oficial.calcularDeducImpRenta());
            vista.setSalarioNeto(oficial.calcularsalarioNeto());
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
    
    public clsOficial pasarDatos(frmMostrarPlantilla vista, int indice) throws ErrorConexion {
        BD = new BaseDatos("SELECT * from tblOficiales WHERE Cedula = ?");
        BD.ejecutar(new Object[]{vista.getTblPlanilla().getValueAt(indice, 0).toString()});
        Object obj[] = BD.getObjet();
        oficial = new clsOficial(obj);
        return oficial;
    }
    
}
