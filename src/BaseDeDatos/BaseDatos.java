package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Archivos.Configuracion;
import Errores.ErrorConexion;
import Errores.TipoErrorConexion;

public class BaseDatos {

    private static Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet datos;
    private Configuracion config;
    
    private String url;
    private String servidor;
    private String BD;
    private String usuario;
    private String contrasena;

    public static Connection getConexion() {
        return conexion;
    }

    public static void setConexion(Connection conexion) {
        BaseDatos.conexion = conexion;
    }

    public String getUrl() {
        return url;
    }
    
    public String getServidor() {
        return servidor;
    }

    public String getBD() {
        return BD;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public BaseDatos(String servidor, String BD, String usuario, String contrasena) throws ErrorConexion {
        this.servidor = servidor;
        this.BD = BD;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.url = "jdbc:mysql://"+this.servidor+"/"+this.BD+"?useServerPrepStmts=true";
    }

    public BaseDatos(String sql) throws ErrorConexion {
        this.conectar();
        this.setSentencia(sql);
    }

    private boolean conectar() throws ErrorConexion {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection(this.url,this.usuario,this.contrasena);
                return true;
            } catch (ClassNotFoundException ex) {
                throw new ErrorConexion(TipoErrorConexion.ERRORDRIVER);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                throw new ErrorConexion(TipoErrorConexion.ERRORSERVIDOR);
            }
        }
        return false;
    }

    public void setSentencia(String sql) throws ErrorConexion {
        try {
            this.sentencia = conexion.prepareStatement(sql);
        } catch (SQLException ex) {
            throw new ErrorConexion(TipoErrorConexion.ERRORBD);
        }
    }

    public void setParametros(Object[] param) throws ErrorConexion {
        for (int i = 0; i < param.length; i++) {
            try {
                if (param[i] instanceof String) {
                    this.sentencia.setString(i + 1, param[i].toString());
                }
                if (param[i] instanceof Integer) {
                    this.sentencia.setInt(i + 1, Integer.parseInt(param[i].toString()));
                }
            } catch (SQLException ex) {
                throw new ErrorConexion(TipoErrorConexion.ERRORBD);
            }
        }
    }

    public boolean ejecutar() throws ErrorConexion {
        try {
            this.sentencia.execute();
            return true;
        } catch (SQLException ex) {
            throw new ErrorConexion(TipoErrorConexion.ERRORBD);
        }
    }

    public boolean ejecutar(Object[] param) throws ErrorConexion {
        this.setParametros(param);
        return this.ejecutar();
    }

    public Object[] getObjet() throws ErrorConexion {
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
            throw new ErrorConexion(TipoErrorConexion.ERRORBD);
        }
        return null;
    }

}
