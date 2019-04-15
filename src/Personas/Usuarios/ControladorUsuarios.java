package Personas.Usuarios;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Personas.Usuarios.Oficiales.ModeloOficiales;
import Personas.Usuarios.Secretarias.ModeloSecretarias;
import Utilidades.CRUD;

public class ControladorUsuarios implements CRUD {

    private ModeloUsuarios usuario;
    private ModeloOficiales oficial;
    private ModeloSecretarias secretaria;
    private BaseDatos BD;
    private VistaUsuarios vista;

    public ControladorUsuarios(VistaUsuarios vista) {
        this.vista = vista;
    }

    @Override
    public void agregar() throws ErrorConexion {
        if (vista.getTipo().equals("Oficial")) {
            BD = new BaseDatos("INSERT INTO tblusuarios VALUES (?,?,?,?,?,?,?,?)");
            oficial = new ModeloOficiales(vista.getCedula(), vista.getNombre(), vista.getUsuario(), vista.getContrasena(),
                    vista.getTelefono(), vista.getTipo(), vista.getCorreo(), Double.parseDouble(vista.getSalario()));
        } else {
            BD = new BaseDatos("INSERT INTO tblusuarios VALUES (?,?,?,?,?,?,?,null)");
            secretaria = new ModeloSecretarias(vista.getCedula(), vista.getNombre(), vista.getUsuario(), vista.getContrasena(),
                    vista.getTelefono(), vista.getTipo(), vista.getCorreo());
        }
        BD.ejecutar();
    }

    @Override
    public void eliminar() throws ErrorConexion {
        usuario = new ModeloUsuarios();
        usuario.setCedula(vista.getCedula());
        BD = new BaseDatos("DELETE FROM tblusuarios WHERE Cedula =" +  usuario.getCedula());
        BD.ejecutar();
    }
    
      @Override
    public void leer() throws ErrorConexion {
         usuario = new ModeloUsuarios();
        usuario.setCedula(vista.getCedula());
        BD = new BaseDatos("SELECT * FROM tblusuarios WHERE Cedula =" + usuario.getCedula());
        BD.ejecutar();
    }
    

    @Override
    public void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
