package Errores;

public class ErrorConexion extends Exception{

    public ErrorConexion(TipoErrorConexion tipo) {
        super(tipo.getMensaje());
    }
    
}
