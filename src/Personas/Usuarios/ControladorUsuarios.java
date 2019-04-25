package Personas.Usuarios;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Errores.ErrorMensaje;
import Main.frmPrincipal;
import Personas.Usuarios.Oficiales.clsOficial;
import Personas.Usuarios.Secretarias.clsSecretaria;
import javax.swing.JOptionPane;

public class ControladorUsuarios {

    private clsUsuarios usuario;
    private BaseDatos BD;

    public ControladorUsuarios() {
    }

    public void agregar(frmRegistarUsuario vista) throws ErrorConexion {
        BD = new BaseDatos("INSERT INTO tblusuarios VALUES (?,?,?,?,?,?,?,?)");
        if (vista.getTipo().equals("Oficial")) {
            usuario = new clsOficial(vista.getCedula(), vista.getNombre(), vista.getFecha(), vista.getTelefono(), vista.getCorreo(),
                    vista.getUsuario(), vista.getContrasena(), vista.getTipo().toString());
        } else {
            usuario = new clsSecretaria(vista.getCedula(), vista.getNombre(), vista.getFecha(), vista.getTelefono(), vista.getCorreo(),
                    vista.getUsuario(), vista.getContrasena(), vista.getTipo().toString());
        }
        if (ErrorMensaje.mostrarMensajes()) {
            JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
        } else {
            BD.ejecutar(new Object[]{usuario.getCedula(), usuario.getNombre(), usuario.getFechaNac(), usuario.getTelefono(), usuario.getCorreo(),
                usuario.getNomUsuario(), usuario.getContra(), usuario.getTipoUsuario().toString()});
        }
    }

    public void eliminar(frmRegistarUsuario vista) throws ErrorConexion {
        usuario = new clsUsuarios();
        usuario.setCedula(vista.getCedula());
        BD = new BaseDatos("DELETE FROM tblusuarios WHERE Cedula =" + usuario.getCedula());
        BD.ejecutar();
    }

    public void leer(frmRegistarUsuario vista) throws ErrorConexion {
        usuario = new clsUsuarios();
        usuario.setCedula(vista.getCedula());
        BD = new BaseDatos("SELECT * FROM tblusuarios WHERE Cedula =" + usuario.getCedula());
        BD.ejecutar();
    }

    public void modificarContraseña(frmCambiarContrasena vistaContra, frmIniciarSesion vistaSesion) throws ErrorConexion {
        BD = new BaseDatos("SELECT Contraseña FROM tblusuarios WHERE Usuario = ?");
        usuario = new clsUsuarios();
        usuario.setNomUsuario(vistaSesion.getUsuario());
        BD.ejecutar(new Object[]{usuario.getNomUsuario()});
        usuario.setContra((String) BD.getObjet()[0]);
        if (usuario.cambiarContrasena(vistaContra.getContrasena(), vistaContra.getNuevaContrasena()) && !ErrorMensaje.mostrarMensajes()) {
            BD.setSentencia("UPDATE tblusuarios SET Contraseña = ? WHERE Usuario = ? ");
            BD.ejecutar(new Object[]{usuario.getContra(), usuario.getNomUsuario()});
            JOptionPane.showMessageDialog(vistaContra, "La Contraseña se ha cambiado con Exito", "Cambiar Contraseña", 1);
            vistaContra.dispose();
        } else {
            JOptionPane.showMessageDialog(vistaContra, ErrorMensaje.getMsj(), "Error", 0);
        }
    }

    public void iniciarSesion(frmIniciarSesion vistaSesion, frmPrincipal vistaPrincipal) throws ErrorConexion {
        BD = new BaseDatos("SELECT Usuario, Contraseña, `Tipo Usuario` FROM tblusuarios WHERE Usuario = ? AND Contraseña = ?");
        usuario = new clsUsuarios();
        usuario.setNomUsuario(vistaSesion.getUsuario());
        usuario.setContra(vistaSesion.getContrasena());
        BD.ejecutar(new Object[]{usuario.getNomUsuario(), usuario.getContra()});
        Object[] obj = BD.getObjet();
        if (obj != null) {
            verificarTipoUsuario((String) obj[2], vistaPrincipal);
            JOptionPane.showMessageDialog(vistaSesion, "Sesion iniciada correctamente", "Iniciar Sesion", 1);
            vistaSesion.dispose();
        } else {
            JOptionPane.showMessageDialog(vistaSesion, "Error: Usuario o Contraseña Invalidos", "Error", 0);
        }
    }

    private void verificarTipoUsuario(String tipo, frmPrincipal vistaPrincipal) {
        if (tipo.equals("Oficial")) {
            vistaPrincipal.habilitarOfical();
        } else {
            vistaPrincipal.habilitarSecretario();
        }
    }

}
