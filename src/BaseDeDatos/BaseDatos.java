package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatos {

    private static Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet datos;

    public BaseDatos() {
        this.conectar();
    }

    public BaseDatos(String sql) {
        this.conectar();
        this.setSentencia(sql);
    }

    private boolean conectar() {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdlicencias?useServerPrepStmts=true", "Java", "1234");
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

    public Object[][] getDatos() {
        Object resultados[][] = null;
        try {
            datos = sentencia.getResultSet();
            datos.last();
            resultados = new Object[datos.getRow()][datos.getMetaData().getColumnCount()];
            datos.beforeFirst();

            for (Object[] resultado : resultados) {
                datos.next();
                for (int c = 0; c < resultado.length; c++) {
                    resultado[c] = datos.getObject(c + 1);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return resultados;
    }

}
