package Personas.Usuarios.Secretarias;

import Personas.Usuarios.ModeloUsuarios;

public class ModeloSecretarias extends ModeloUsuarios {

    public ModeloSecretarias(String cedula, String nombre, String nombreUsuario, String contra, String telefono, String tipoUsuario, String correo) {
        super(cedula, nombre, nombreUsuario, contra, telefono, tipoUsuario, correo);
    }

    public ModeloSecretarias() {
    }

}
