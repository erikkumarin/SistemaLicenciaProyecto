package Utilidades;

import Archivos.XMl.Información;
import Personas.Clientes.clsClientes;
import Pruebas.clsPruebas;

public class pasarXML {
    private Información xml;

    public pasarXML(clsClientes cliente) {
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
