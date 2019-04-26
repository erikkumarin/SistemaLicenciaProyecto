package Pruebas;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Personas.Usuarios.Oficiales.clsOficial;
import Personas.frmBuscarPersona;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

    public void cargarTabla(frmBuscarPrueba vista) throws ErrorConexion {
        BD = new BaseDatos("SELECT * from tblpruebas WHERE id LIKE ?");
        BD.ejecutar(new Object[]{"%" + vista.getId() + "%"});
        DefaultTableModel modelo = (DefaultTableModel) vista.getTblPruebas().getModel();
        modelo.setNumRows(0);
        Object obj[];
        do {
            obj = BD.getObjet();
            if (obj != null) {
                prueba = new clsPruebas(obj);
                modelo.addRow(prueba.toObject((String) obj[6]));
            }
        } while (obj != null);
    }

    public boolean hayPrueba(frmBuscarPersona vista, int indice) throws ErrorConexion {
        BD = new BaseDatos("SELECT * FROM tblpruebas WHERE IdCliente=?");
        BD.ejecutar(new Object[]{vista.getPersonas().getValueAt(indice, 0).toString()});
        if (BD.getObjet() != null) {
            return true;
        }
        return false;
    }

}
