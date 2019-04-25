package Archivos;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Main.frmPrincipal;
import Personas.Clientes.clsClientes;
import Personas.Usuarios.Oficiales.clsOficial;
import Pruebas.clsPruebas;

/**
 *
 * @author Shorlax
 */
public class ControladorXml {

    private BaseDatos BD;
    private clsClientes cliente;
    private clsOficial oficial;
    private clsPruebas prueba;
    private InformacionXml xml;

    public void importarXml(frmPrincipal frm) throws ErrorConexion {
        BD = new BaseDatos("SELECT * FROM `tblclientes`");
        BD.ejecutar();
        Object[] objCliente = BD.getObjet();
        cliente = new clsClientes(objCliente);
        
        BD.setSentencia("SELECT * FROM `tblpruebas` WHERE `IdCliente` = ?");
        
        
        
    }

}
