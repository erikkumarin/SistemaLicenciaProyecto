package Errores;

public enum TipoErrorConexion {
    ERRORDRIVER(0,"Error: Dirver no Cargado"),
    ERRORSERVIDOR(1, "Error: No se ha podido Conectar al Servidor"),
    ERRORBD(2, "Error: Error con la Base de Datos");
    
    private int tipoError;
    private String mensaje;

    private TipoErrorConexion(int tipoError, String mensaje) {
        this.tipoError = tipoError;
        this.mensaje = mensaje;
    }
    
    public int getTipoError() {
        return tipoError;
    }

    public void setTipoError(int tipoError) {
        this.tipoError = tipoError;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
