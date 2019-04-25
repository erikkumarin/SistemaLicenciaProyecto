package BaseDeDatos;

import Archivos.Configuracion;
import Errores.ErrorConexion;
import Errores.TipoErrorConexion;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControladorBaseDatos {

    Configuracion config;
    BaseDatos BD;

    String msjError = null;

    public String getMsjError() {
        return msjError;
    }

    public Boolean probarConexion(frmConfiguracion frm) {
        try {
            config = new Configuracion();
            BD = new BaseDatos(frm.getIP(), frm.getBD(), frm.getUsuario(), frm.getContrasena());
            BaseDatos.setConexion(DriverManager.getConnection(BD.getUrl(), BD.getUsuario(), BD.getContrasena()));
            config.setPropiedades("Servidor", BD.getServidor());
            config.setPropiedades("BD", BD.getBD());
            config.setPropiedades("Usuario", BD.getUsuario());
            config.setPropiedades("Contraseña", BD.getContrasena());
            config.guardar();
            return true;
        } catch (ErrorConexion ex) {
            msjError = TipoErrorConexion.ERRORSERVIDOR.getMensaje();
        } catch (SQLException ex) {
            msjError = TipoErrorConexion.ERRORBD.getMensaje();
        } catch (IOException ex) {
            msjError = "Archivo no Encontrado";
        }
        return false;
    }
}
