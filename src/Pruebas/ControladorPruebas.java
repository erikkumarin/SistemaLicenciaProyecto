package Pruebas;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Personas.Usuarios.Oficiales.clsOficial;
import Utilidades.CRUD;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ControladorPruebas {

    private BaseDatos BD;
    private clsPruebas prueba;

    public void agregar(frmPruebas vista) throws ErrorConexion {
        BD = new BaseDatos("INSERT INTO tblpruebas VALUES(null,?,?,?,?,?,?)");
        prueba = new clsPruebas(0, vista.getFecha(), vista.getHora(), new clsOficial(), vista.getObservacion(), Integer.parseInt(vista.getNota()));
        prueba.getOficial().setCedula(vista.getCedulaOficial());
        BD.ejecutar(prueba.toObject(vista.getCedula()));
        JOptionPane.showMessageDialog(vista, "Se Registro Exitosamente", "Aplicar Prueba", 1);
    }

    public void eliminar() throws ErrorConexion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void modificar() throws ErrorConexion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void leer() throws ErrorConexion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
