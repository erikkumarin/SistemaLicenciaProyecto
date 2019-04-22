package Personas;

public abstract class clsPersonas {

    private String cedula;
    private String nombre;
    private String telefono;
    private String correo;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula.length() == 9) {
            this.cedula = cedula;
        } else {
            System.out.println("Error al guardar la cedula");
        }
    }

    public String getNombre() {
        return nombre.toUpperCase();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono.length() == 8) {
            this.telefono = telefono;
        } else {
            System.out.println("Error al guardar el telefono");
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
