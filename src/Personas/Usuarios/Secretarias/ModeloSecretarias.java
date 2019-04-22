package Personas.Usuarios.Secretarias;

import Personas.Usuarios.ModeloUsuarios;

public class ModeloSecretarias extends ModeloUsuarios {

    public ModeloSecretarias(String nomUsuario, String contra, String tipoUsuario, String cedula, String nombre, String fechaNac, String telefono, String correo) {
        super(cedula, nombre, fechaNac, telefono, correo, nomUsuario, contra, tipoUsuario);
    }

    public ModeloSecretarias() {
    }

}
