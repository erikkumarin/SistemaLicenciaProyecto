package Personas.Usuarios;

import Personas.clsPersonas;

public class ModeloUsuarios extends clsPersonas {

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

    public ModeloUsuarios(String cedula, String nombre, String nombreUsuario, String contra, String telefono, String tipoUsuario, String correo) {
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setNomUsuario(nombreUsuario);
        this.setContra(contra);
        this.setCorreo(correo);
        this.setTelefono(telefono);
        this.setTipoUsuario(tipoUsuario);
    }

    public ModeloUsuarios() {
    }

    public void cambiarContra(String contraAntig, String contraNueva1, String contraNueva2) {
        if (this.contra.equals(contraAntig) && contraNueva1.equals(contraNueva2)) {
            this.contra = contraNueva1;
        }
    }

}
