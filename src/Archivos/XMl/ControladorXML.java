package Archivos.XMl;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Errores.ErrorMensaje;
import Personas.Clientes.clsClientes;
import Personas.Usuarios.Oficiales.clsOficial;
import Personas.frmBuscarPersona;
import Pruebas.clsPruebas;
import Utilidades.pasarXML;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ControladorXML {

    BaseDatos BD;
    pasarXML xml;

    public void exportar(frmBuscarPersona vista, int indice) throws ErrorConexion {
        BD = new BaseDatos("SELECT cliente.Cedula, cliente.Nombre, cliente.`Fecha Nac`, cliente.Telefono, cliente.Correo, "
                + "prueba.Id, prueba.Fecha, prueba.Hora, prueba.Observaciones, prueba.Nota, oficial.Cedula, oficial.Nombre, "
                + "oficial.Correo FROM tblclientes AS cliente INNER JOIN tblpruebas as prueba on prueba.IdCliente = cliente.Cedula "
                + "INNER JOIN tbloficiales oficial on prueba.IdOficial = oficial.Cedula WHERE prueba.IdCliente = ?");
        BD.ejecutar(new Object[]{vista.getPersonas().getValueAt(indice, 0)});
        Object obj[];
        int cont = 0;
        clsClientes cliente = new clsClientes();
        do {
            obj = BD.getObjet();
            if (obj != null) {
                if (cont == 0) {
                    cliente.setDatos((String) obj[0], (String) obj[1], (String) obj[2], (String) obj[3], (String) obj[4]);
                    cont = 1;
                }
                cliente.agregarPrueba(new clsPruebas((int) obj[5], (String) obj[6], (String) obj[7], new clsOficial((String) obj[10], (String) obj[11], "01/01/2001", "88888888", (String) obj[12], 0.0), (String) obj[8], (int) obj[9]));
            }
        } while (obj != null);
        if (ErrorMensaje.mostrarMensajes()) {
            JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
        } else {
            xml = new pasarXML(cliente);
            JOptionPane.showMessageDialog(vista, "El Cliente se Exporto con Exito", "Exportar Cliente", 0);
        }
    }

}
