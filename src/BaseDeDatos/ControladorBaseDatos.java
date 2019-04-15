package BaseDeDatos;

import Archivos.Configuracion;
import Errores.ErrorConexion;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorBaseDatos {

    Configuracion config;
    BaseDatos BD;

    public Boolean probarConexion(VistaConfiguracion frm) {

        try {
            config = new Configuracion();
            BD = new BaseDatos(frm.getTxtIP(), frm.getTxtBD(), frm.getTxtUsuario(), frm.getTxtContrasena());
            BaseDatos.setConexion(DriverManager.getConnection(BD.getUrl(), BD.getUsuario(), BD.getContrasena()));
            config.setPropiedades("Servidor", BD.getServidor());
            config.setPropiedades("BD", BD.getBD());
            config.setPropiedades("Usuario", BD.getUsuario());
            config.setPropiedades("Contra", BD.getContrasena());
            config.guardar();
            return true;
        } catch (ErrorConexion ex) {

        } catch (SQLException ex) {

        }
        return false;

    }
}
