package Archivos;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Main.frmPrincipal;
import Personas.Clientes.clsClientes;
import Personas.Usuarios.Oficiales.clsOficial;
import Pruebas.clsPruebas;

public class ControladorXml {

    private BaseDatos BD;
    private clsClientes cliente;
    private clsOficial oficial;
    private clsPruebas prueba;
    private InformacionXml xml;

    public void importarXml(String cedula) throws ErrorConexion {
        BD = new BaseDatos("SELECT cliente.Cedula, cliente.Nombre, cliente.`Fecha Nac`, cliente.Telefono, cliente.Correo, "
                + "prueba.Id, prueba.Fecha, prueba.Hora, prueba.Observaciones, prueba.Nota, oficial.Cedula, oficial.Nombre, "
                + "oficial.Correo FROM tblclientes AS cliente INNER JOIN tblpruebas as prueba on prueba.IdCliente = cliente.Cedula "
                + "INNER JOIN tbloficiales oficial on prueba.IdOficial = oficial.Cedula WHERE prueba.IdCliente = ?");
        BD.ejecutar(new Object[]{cedula});
        Object[] obj = BD.getObjet();
        cliente = new clsClientes((String) obj[0], (String) obj[1], (String) obj[2], (String) obj[3], (String) obj[4]);
        prueba = new clsPruebas((int) obj[5], (String) obj[6], (String) obj[7], new clsOficial(), (String) obj[8], (int) obj[9]);
        oficial = new clsOficial();
        oficial.setCedula((String) obj[10]);
        oficial.setNombre((String) obj[11]);
        oficial.setCorreo((String) obj[12]);
        xml = new InformacionXml();
        xml.generarInformacion(cliente.getCedula(), cliente.getNombre(), String.valueOf(cliente.calcularEdad()), cliente.getCorreo(),
                cliente.getTelefono(), String.valueOf(prueba.getIdPrueba()), prueba.getFecha(), String.valueOf(prueba.getNota()),
                prueba.getObservaciones(), "1", oficial.getCedula(), oficial.getNombre(), oficial.getCorreo());
    }

}
