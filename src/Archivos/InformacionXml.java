package Archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class InformacionXml {

    private Document doc;
    private Element clientes;
    private Element cliente;
    private Element prueba;
    private Element oficial;

    /**
     * Instancia las clases necesarias para crear el archivo xml. Ademas, genera
     * la raiz del archivo.
     */
    public InformacionXml() {
        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factoria.newDocumentBuilder();
            doc = builder.newDocument();
            clientes = doc.createElement("Clientes");
            generarRaiz();
        } catch (ParserConfigurationException ex) {
        }
    }

    /**
     * Genera todo un cliente en el archivo xml con todos los datos necesarios
     * para crearlo.
     *
     * @param cedula
     * @param nom
     * @param edad
     * @param correo
     * @param tel
     * @param idPrueba
     * @param fechaPrueba
     * @param nota
     * @param Observ
     * @param numIntent
     * @param nomOficial
     * @param correoOficial
     */
    public void generarInformacion(String cedula, String nom, String edad, String correo, String tel, String idPrueba, String fechaPrueba, String nota, String Observ, String numIntent, String cedulaOficial, String nomOficial, String correoOficial) {
        generarCliente(cedula, nom, edad, correo, tel);
        generarPruebaCliente(idPrueba, nota, nota, Observ, numIntent);
        generarOficialPrueba(cedulaOficial, nomOficial, correoOficial);
        generarXML();
    }

    /**
     * Crea la raiz de xml. Solo puede haber 1.
     */
    public void generarRaiz() {
        doc.appendChild(clientes);
    }

    /**
     * Genera todos los datos del cliente.
     *
     * @param cedula
     * @param nom
     * @param edad
     * @param correo
     * @param telefono
     */
    public void generarCliente(String cedula, String nom, String edad, String correo, String telefono) {
        cliente = doc.createElement("Cliente");
        clientes.appendChild(cliente);
        crearTagCedulaCliente(cedula);
        crearTagNombreCliente(nom);
        crearTagEdadCliente(edad);
        crearTagCorreoCliente(correo);
        crearTagTelefonoCliente(telefono);
    }

    /**
     * Genera todos los datos de la prueba del cliente.
     *
     * @param idPrueba
     * @param fecha
     * @param nota
     * @param Observaciones
     * @param numIntentos
     */
    public void generarPruebaCliente(String idPrueba, String fecha, String nota, String Observaciones, String numIntentos) {
        prueba = doc.createElement("Prueba");
        cliente.appendChild(prueba);
        crearTagIdPrueba(idPrueba);
        crearTagFechaPrueba(fecha);
        crearTagNotaPrueba(nota);
        crearTagObservacionesPrueba(Observaciones);
        crearTagNumIntentosPrueba(numIntentos);
    }

    /**
     * Genera todos los datos del oficial que realizo la prueba del cliente.
     *
     * @param cedula
     * @param nombre
     * @param correo
     */
    public void generarOficialPrueba(String cedula, String nombre, String correo) {
        oficial = doc.createElement("Oficial");
        prueba.appendChild(oficial);
        crearTagCedulaOficial(cedula);
        crearTagNombreOficial(nombre);
        crearTagCorreoOficial(correo);
    }

    public void crearTagCedulaOficial(String cedula) {
        Element id = doc.createElement("Cedula");
        id.appendChild(doc.createTextNode(cedula));
        oficial.appendChild(id);
    }

    /**
     * Crea el nombre del oficial en el arhivo.
     *
     * @param nombre
     */
    public void crearTagNombreOficial(String nombre) {
        Element nom = doc.createElement("Nombre");
        nom.appendChild(doc.createTextNode(nombre));
        oficial.appendChild(nom);
    }

    /**
     * crea el correo del oficial en el archivo.
     *
     * @param correo
     */
    public void crearTagCorreoOficial(String correo) {
        Element mail = doc.createElement("Correo");
        mail.appendChild(doc.createTextNode(correo));
        oficial.appendChild(mail);
    }

    /**
     * Crea el id de la prueba en el archivo.
     *
     * @param idPrueba
     */
    public void crearTagIdPrueba(String idPrueba) {
        Element id = doc.createElement("Id");
        id.appendChild(doc.createTextNode(idPrueba));
        prueba.appendChild(id);
    }

    /**
     * Crea la fecha de la prueba en el archivo.
     *
     * @param fecha
     */
    public void crearTagFechaPrueba(String fecha) {
        Element fech = doc.createElement("Fecha");
        fech.appendChild(doc.createTextNode(fecha));
        prueba.appendChild(fech);
    }

    /**
     * Crea la nota de la prueba en el archivo.
     *
     * @param nota
     */
    public void crearTagNotaPrueba(String nota) {
        Element not = doc.createElement("Nota");
        not.appendChild(doc.createTextNode(nota));
        prueba.appendChild(not);
    }

    /**
     * Crea las observaciones de la prueba en el archivo.
     *
     * @param observaciones
     */
    public void crearTagObservacionesPrueba(String observaciones) {
        Element observ = doc.createElement("Observaciones");
        observ.appendChild(doc.createTextNode(observaciones));
        prueba.appendChild(observ);
    }

    /**
     * Crea el numero de intento que el cliente realizo la prueba en el archivo.
     *
     * @param numIntentos
     */
    public void crearTagNumIntentosPrueba(String numIntentos) {
        Element numIntent = doc.createElement("Numero_Intentos");
        numIntent.appendChild(doc.createTextNode(numIntentos));
        prueba.appendChild(numIntent);
    }

    /**
     * Crea la cedula del cliente en el archivo.
     *
     * @param cedula
     */
    public void crearTagCedulaCliente(String cedula) {
        Element id = doc.createElement("Cedula");
        id.appendChild(doc.createTextNode(cedula));
        cliente.appendChild(id);
    }

    /**
     * Crea el nombre del cliente en el archivo.
     *
     * @param nombre
     */
    public void crearTagNombreCliente(String nombre) {
        Element nom = doc.createElement("Nombre");
        nom.appendChild(doc.createTextNode(nombre));
        cliente.appendChild(nom);
    }

    /**
     * Crea el telefono del cliente en el archivo.
     *
     * @param telefono
     */
    public void crearTagTelefonoCliente(String telefono) {
        Element tel = doc.createElement("Telefono");
        tel.appendChild(doc.createTextNode(telefono));
        cliente.appendChild(tel);
    }

    /**
     * Crea el correo del cliente en el archivo.
     *
     * @param correo
     */
    public void crearTagCorreoCliente(String correo) {
        Element mail = doc.createElement("Correo");
        mail.appendChild(doc.createTextNode(correo));
        cliente.appendChild(mail);
    }

    /**
     * Crea la edad del cliente en el archivo
     *
     * @param edad
     */
    public void crearTagEdadCliente(String edad) {
        Element ed = doc.createElement("Edad");
        ed.appendChild(doc.createTextNode(edad));
        cliente.appendChild(ed);
    }

    /**
     * Crea el archivo Xml, una vez instanciada la clase y escrito todos los
     * datos que incluiran el archivo.
     */
    public void generarXML() {
        try {
            TransformerFactory transFactoria = TransformerFactory.newInstance();
            Transformer transformer = transFactoria.newTransformer();

            Source source = new DOMSource(doc);

            File archivoXml = new File("Informacion.xml");
            FileWriter fw = new FileWriter(archivoXml);
            PrintWriter pw = new PrintWriter(fw);
            Result result = new StreamResult(pw);

            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(InformacionXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException | IOException ex) {
            Logger.getLogger(InformacionXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
