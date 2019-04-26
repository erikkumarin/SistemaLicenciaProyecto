package Personas.Usuarios.Secretarias;

import Personas.Usuarios.clsUsuarios;

public class clsSecretaria extends clsUsuarios {

    public clsSecretaria(String cedula, String nombre, String fechaNac, String telefono, String correo,
            String nomUsuario, String contra, String tipoUsuario) {
        super(cedula, nombre, fechaNac, telefono, correo, nomUsuario, contra, tipoUsuario);
    }

    public clsSecretaria(String cedula, String nombre, String fechaNac, String telefono, String correo) {
        super(cedula, nombre, fechaNac, telefono, correo);
    }

    public clsSecretaria(Object[] obj) {
        super(obj);
    }

    public clsSecretaria() {
    }

}
