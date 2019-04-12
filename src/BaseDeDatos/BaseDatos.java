package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Archivos.Configuracion;
import java.io.File;

public class BaseDatos {

    private static Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet datos;
    private Configuracion config;
    private File conf;

    public BaseDatos() {
        this.conectar();
        if (!conf.exists()) {
            config = new Configuracion();
        }
    }

    public BaseDatos(String sql) {
        this.conectar();
        this.setSentencia(sql);
    }

    private boolean conectar() {
        config = new Configuracion();
        if (conexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection(config.getPropiedades("Servidor"), config.getPropiedades("Usuario"), config.getPropiedades("Contra"));
                return true;
            } catch (ClassNotFoundException ex) {
                System.out.println("Driver No Cargado");
            } catch (SQLException ex) {
                System.out.println("Error al Conectar");
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public boolean setSentencia(String sql) {
        try {
            this.sentencia = conexion.prepareStatement(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en la Sentencia");
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean setParametros(Object[] param) {
        for (int i = 0; i < param.length; i++) {
            try {
                if (param[i] instanceof String) {
                    this.sentencia.setString(i + 1, param[i].toString());
                }
                if (param[i] instanceof Integer) {
                    this.sentencia.setInt(i + 1, Integer.parseInt(param[i].toString()));
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean ejecutar() {
        try {
            this.sentencia.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean ejecutar(Object[] param) {
        this.setParametros(param);
        return this.ejecutar();
    }

    public Object[] getObjet() {
        try {
            if (this.datos.next()) {
                ArrayList<Object> obj = new ArrayList<>();
                int cols = this.datos.getMetaData().getColumnCount();
                for (int i = 1; i <= cols; i++) {
                    obj.add(this.datos.getObject(i));
                }
                return obj.toArray();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

}
