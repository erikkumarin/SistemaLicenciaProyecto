package Archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Información {
    private Document doc;
    private Element raiz;
    private Element tagNivel1;
    private Element tagNivel2;
    private Element tagNivel3;
    private Element infoNivel1;
    private Element infoNivel2;
    private Element infoNivel3;

    public Información(String raiz) {
        try {
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factoria.newDocumentBuilder();
            doc = builder.newDocument();
            generarRaiz(raiz);
        } catch (ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void generarXML() {
        try {
            TransformerFactory transFactoria = TransformerFactory.newInstance();
            Transformer transformer = transFactoria.newTransformer();

            Source source = new DOMSource(doc);

            File archivoXml = new File("Cliente.xml");
            FileWriter fw = new FileWriter(archivoXml);
            PrintWriter pw = new PrintWriter(fw);
            Result result = new StreamResult(pw);

            transformer.transform(source, result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void generarRaiz(String raiz) {
        this.raiz = doc.createElement(raiz);
        doc.appendChild(this.raiz);
    }
    
    public void crearNivel1(String tag, String key, String valor) {
        this.tagNivel1 = doc.createElement(tag);
        this.tagNivel1.setAttribute(key, valor);
        raiz.appendChild(this.tagNivel1);
    }
    
    public void crearInfoNivel1(String llave, String valor) {
        this.infoNivel1 = doc.createElement(llave);
        this.infoNivel1.appendChild(doc.createTextNode(valor));
        tagNivel1.appendChild(infoNivel1);
    }
    
    public void crearNivel2(String tag, String key, String valor) {
        this.tagNivel2 = doc.createElement(tag);
        this.tagNivel2.setAttribute(key, valor);
        tagNivel1.appendChild(this.tagNivel2);
    }
    
    public void crearInfoNivel2(String llave, String valor) {
        this.infoNivel2 = doc.createElement(llave);
        this.infoNivel2.appendChild(doc.createTextNode(valor));
        tagNivel2.appendChild(infoNivel2);
    }
    
    public void crearNivel3(String tag, String key, String valor) {
        this.tagNivel3 = doc.createElement(tag);
        this.tagNivel3.setAttribute(key, valor);
        tagNivel2.appendChild(this.tagNivel3);
    }
    
    public void crearInfoNivel3(String llave, String valor) {
        this.infoNivel3 = doc.createElement(llave);
        this.infoNivel3.appendChild(doc.createTextNode(valor));
        tagNivel3.appendChild(infoNivel3);
    }   
}