package Archivos;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Personas.Clientes.clsClientes;
import Personas.Usuarios.Oficiales.clsOficial;
import Pruebas.clsPruebas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorXml {

    private BaseDatos BD;
    private clsClientes cliente;
    private clsOficial oficial;
    private clsPruebas prueba;
    private InformacionXml xml;

    public void importarXml(String cedula, String numIntentos) throws ErrorConexion, SQLException {
        BD = new BaseDatos("SELECT cliente.Cedula, cliente.Nombre, cliente.`Fecha Nac`, cliente.Telefono, cliente.Correo, "
                + "prueba.Id, prueba.Fecha, prueba.Hora, prueba.Observaciones, prueba.Nota, oficial.Cedula, oficial.Nombre, "
                + "oficial.Correo FROM tblclientes AS cliente INNER JOIN tblpruebas as prueba on prueba.IdCliente = cliente.Cedula "
                + "INNER JOIN tbloficiales oficial on prueba.IdOficial = oficial.Cedula WHERE prueba.IdCliente = ?");
        BD.ejecutar(new Object[]{cedula});
        Object[] obj = BD.getObjet();
        cliente = new clsClientes((String) obj[0], (String) obj[1], (String) obj[2], (String) obj[3], (String) obj[4]);
        xml = new InformacionXml();
        xml.generarCliente(cliente.getCedula(), cliente.getNombre(), String.valueOf(cliente.calcularEdad()), cliente.getCorreo(), cliente.getTelefono());
        ResultSet x = BD.getSentencia().executeQuery();
        while (x.next()) {
            ArrayList<Object> obj2 = new ArrayList<>();
            int cols = x.getMetaData().getColumnCount();
            for (int i = 1; i <= cols; i++) {
                obj2.add(x.getObject(i));
            }
            obj = obj2.toArray();
            prueba = new clsPruebas((int) obj[5], (String) obj[6], (String) obj[7], new clsOficial(), (String) obj[8], (int) obj[9]);
            oficial = new clsOficial();
            oficial.setCedula((String) obj[10]);
            oficial.setNombre((String) obj[11]);
            oficial.setCorreo((String) obj[12]);
            xml.generarPruebaCliente(String.valueOf(prueba.getIdPrueba()), prueba.getFecha(), String.valueOf(prueba.getNota()), prueba.getObservaciones(), numIntentos);
            xml.generarOficialPrueba(oficial.getCedula(), oficial.getNombre(), oficial.getCorreo());
        }
        xml.generarXML();
    }

}
