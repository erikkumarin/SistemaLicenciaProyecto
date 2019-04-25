package Personas.Usuarios.Oficiales;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Errores.ErrorMensaje;
import Personas.Usuarios.frmRegistarUsuario;
import javax.swing.JOptionPane;

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
        }
    }

}
