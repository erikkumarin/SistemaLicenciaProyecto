package Personas.Usuarios.Secretarias;
public class ControladorSecretarias {

    private ModeloSecretarias secretaria;
//hola
    
    public ControladorSecretarias() {

    }

    public void eliminarSecretaria() {
//Sentencia
    }

    public void modificarSecretaria() {
//Sentencia
    }

    public void leerSecretaria() {
//Sentencia
    }

    public void agregarSecretaria() {
//Sentencia   
    }

    private boolean verificarNombre(String nombre) {
        return !nombre.trim().equals("");
    }

    private boolean verificarCedula(String cedula) {
        try {
            long id= Long.parseLong((cedula.replaceAll("-","0")));
            return id==11;
        } catch (NumberFormatException e) {
        }
        return false;
    }
    
    private boolean verificarTelefono(String telefono){
        try {
            long numero=Long.parseLong(telefono);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
    
//    private void 
}
