package Utilidades;

import Errores.ErrorConexion;

public interface CRUD {

    public void agregar() throws ErrorConexion;

    public void eliminar() throws ErrorConexion;

    public void modificar() throws ErrorConexion;

    public void leer() throws ErrorConexion;

}
