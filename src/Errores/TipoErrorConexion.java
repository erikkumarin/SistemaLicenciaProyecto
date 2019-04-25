package Errores;

public enum TipoErrorConexion {
    ERRORDRIVER("Error: Dirver no Cargado"),
    ERRORSERVIDOR("Error: No se ha podido Conectar al Servidor"),
    ERRORBD("Error: Error con la Base de Datos");
    
    private String mensaje;

    private TipoErrorConexion(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
