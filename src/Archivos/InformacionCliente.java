package Archivos;

import java.io.File;
import java.sql.*;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Shorlax
 */
public class InformacionCliente extends Archivo {

    public InformacionCliente() {
        super(System.getProperty("user.dir"), "Informacion", ".xml");

    }

    public void escribirFicheroXML() throws SQLException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
//Conexion a la BBDD
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/test";
        String USER = "root";
        String PASS = "";

        Connection conn;
        Statement stmt;
        ResultSet rs;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "datosJugador", null);
        document.setXmlVersion("1.0");

//conexion
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
//Query para acceder a los datos que queramos incluir

        String query = "Aqui pondriamos la query";
        rs = stmt.executeQuery(query);

        Element raiz = document.getDocumentElement();

//Ahora vamos al lio, 
        while (rs.next()) {

            Element elementoRaiz = document.createElement("elementoRaiz");

            Element primerElemento = document.createElement("primerElemento");
            Text primerElementoTexto = document.createTextNode(rs.getString("primerElemento"));
            primerElemento.appendChild(primerElementoTexto);

            Element segundoElemento = document.createElement("segundoElemento");
            Text segundoElementoTexto = document.createTextNode(rs.getString("segundoElemento"));
            segundoElemento.appendChild(segundoElementoTexto);

            Element tercerElemento = document.createElement("tercerElemento");
            Text tercerElementoTexto = document.createTextNode(rs.getString("tercerElemento"));
            tercerElemento.appendChild(tercerElementoTexto);

            elementoRaiz.appendChild(primerElemento);
            elementoRaiz.appendChild(segundoElemento);
            elementoRaiz.appendChild(tercerElemento);

            raiz.appendChild(elementoRaiz);

        }
        Source source = new DOMSource(document);
//Indicamos donde lo queremos guardar
        Result result = new StreamResult(new java.io.File("datosElementos" + ".xml")); //nombre del archivo
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        rs.close();
        stmt.close();
        conn.close();
    }

}
