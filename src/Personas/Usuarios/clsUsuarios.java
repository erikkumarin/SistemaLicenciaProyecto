package Personas.Usuarios;

import Errores.ErrorMensaje;
import Personas.clsPersona;

public class clsUsuarios extends clsPersona {

    private String nomUsuario;
    private String contra;
    private String tipoUsuario;

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public clsUsuarios(String cedula, String nombre, String fechaNac, String telefono, String correo, String nomUsuario, String contra, String tipoUsuario) {
        super(cedula, nombre, fechaNac, telefono, correo);
        this.nomUsuario = nomUsuario;
        this.contra = contra;
        this.tipoUsuario = tipoUsuario;
    }

    public clsUsuarios(String cedula, String nombre, String fechaNac, String telefono, String correo) {
        super(cedula, nombre, fechaNac, telefono, correo);
    }
    
    public clsUsuarios(Object[] obj) {
        super((String) obj[0], (String) obj[1], (String) obj[2], (String) obj[3], (String) obj[4]);
        this.nomUsuario = (String) obj[5];
        this.contra = (String) obj[6];
        this.tipoUsuario = (String) obj[7];
    }
    
    public clsUsuarios() {
    }
    
    public boolean cambiarContrasena(String contrasena, String contraNueva){
        if (this.contra.equals(contrasena)) {
            this.setContra(contraNueva);
            return true;
        }
        ErrorMensaje.agregarMensaje("Error: Contraseña Invalida");
        return false;
    }

}
