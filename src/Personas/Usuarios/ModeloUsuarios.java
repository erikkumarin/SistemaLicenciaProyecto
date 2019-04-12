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

    @Override
    public void setCorreo(String correo) {
        super.setCorreo(correo);
    }

    @Override
    public String getCorreo() {
        return super.getCorreo();
    }

    @Override
    public void setTelefono(String telefono) {
        super.setTelefono(telefono);
    }

    @Override
    public String getTelefono() {
        return super.getTelefono();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setCedula(String cedula) {
        super.setCedula(cedula);
    }

    @Override
    public String getCedula() {
        return super.getCedula();
    }

    public void cambiarContra(String contraAntig, String contraNueva1, String contraNueva2) {
        if (this.contra.equals(contraAntig) && contraNueva1.equals(contraNueva2)) {
            this.contra = contraNueva1;
        }
    }
    
}
