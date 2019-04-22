package Personas.Usuarios;

import Personas.clsPersona;

public class ModeloUsuarios extends clsPersona {

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

    public ModeloUsuarios(String cedula, String nombre, String correo, String telefono, String fecha,
            String nomUsuario, String contra, String tipoUsuario) {
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setTelefono(telefono);
        this.setFechaNac(fecha);
        this.nomUsuario = nomUsuario;
        this.contra = contra;
        this.tipoUsuario = tipoUsuario;
    }
    
    

    public ModeloUsuarios() {
    }

    public void cambiarContra(String contraAntig, String contraNueva1, String contraNueva2) {
        if (this.contra.equals(contraAntig) && contraNueva1.equals(contraNueva2)) {
            this.contra = contraNueva1;
        }
    }

}
