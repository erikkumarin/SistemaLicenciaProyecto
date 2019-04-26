package Archivos;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Errores.ErrorMensaje;
import Personas.Clientes.clsClientes;
import Personas.Clientes.frmMostrarClientes;
import Personas.Usuarios.Oficiales.clsOficial;
import Personas.frmBuscarPersona;
import Pruebas.clsPruebas;
import javax.swing.JOptionPane;

public class ControladorXML {

    BaseDatos BD;
    Información xml;
    clsClientes cliente;

    public ControladorXML() {
        cliente = new clsClientes();
    }

    public void exportar(frmBuscarPersona vista, int indice) throws ErrorConexion {
        BD = new BaseDatos("SELECT cliente.Cedula, cliente.Nombre, cliente.`Fecha Nac`, cliente.Telefono, cliente.Correo, "
                + "prueba.Id, prueba.Fecha, prueba.Hora, prueba.Observaciones, prueba.Nota, oficial.Cedula, oficial.Nombre, "
                + "oficial.Correo FROM tblclientes AS cliente INNER JOIN tblpruebas as prueba on prueba.IdCliente = cliente.Cedula "
                + "INNER JOIN tbloficiales oficial on prueba.IdOficial = oficial.Cedula WHERE prueba.IdCliente = ?");
        BD.ejecutar(new Object[]{vista.getPersonas().getValueAt(indice, 0)});
        Object obj[];
        int cont = 0;
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
            JOptionPane.showMessageDialog(vista, "El Cliente se Exporto con Exito", "Exportar Cliente", 1);
        }
    }
    
    public void exportar(frmMostrarClientes vista, int indice) throws ErrorConexion {
        BD = new BaseDatos("SELECT cliente.Cedula, cliente.Nombre, cliente.`Fecha Nac`, cliente.Telefono, cliente.Correo, "
                + "prueba.Id, prueba.Fecha, prueba.Hora, prueba.Observaciones, prueba.Nota, oficial.Cedula, oficial.Nombre, "
                + "oficial.Correo FROM tblclientes AS cliente INNER JOIN tblpruebas as prueba on prueba.IdCliente = cliente.Cedula "
                + "INNER JOIN tbloficiales oficial on prueba.IdOficial = oficial.Cedula WHERE prueba.IdCliente = ?");
        BD.ejecutar(new Object[]{vista.getTblClientes().getValueAt(indice, 0)});
        Object obj[];
        int cont = 0;
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
            JOptionPane.showMessageDialog(vista, "El Cliente se Exporto con Exito", "Exportar Cliente", 1);
        }
    }

    public void toXML() {
        xml = new Información("Clientes");
        xml.crearNivel1("Cliente", "Cedula", cliente.getCedula());
        xml.crearInfoNivel1("Nombre", cliente.getNombre());
        xml.crearInfoNivel1("Fecha_Nacimiento", cliente.getFechaNac());
        xml.crearInfoNivel1("Telefono", cliente.getTelefono());
        xml.crearInfoNivel1("Correo", cliente.getCorreo());
        for (clsPruebas prueba : cliente.getPruebas()) {
            xml.crearNivel2("Prueba", "ID", String.valueOf(prueba.getIdPrueba()));
            xml.crearInfoNivel2("Fecha", prueba.getFecha());
            xml.crearInfoNivel2("Hora", prueba.getHora());
            xml.crearInfoNivel2("Observaciones", prueba.getObservaciones());
            xml.crearInfoNivel2("Nota", String.valueOf(prueba.getIdPrueba()));
            xml.crearInfoNivel2("Estado", prueba.getEstado());
            xml.crearNivel3("Oficial", "Cedula", prueba.getOficial().getCedula());
            xml.crearInfoNivel3("Nombre", prueba.getOficial().getNombre());
            xml.crearInfoNivel3("Correo", prueba.getOficial().getCorreo());
        }
        xml.crearInfoNivel1("Num_Intentos", String.valueOf(cliente.getPruebas().size()));
        xml.generarXML();
    }

}
