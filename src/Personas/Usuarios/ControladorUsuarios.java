package Personas.Usuarios;

import BaseDeDatos.BaseDatos;
import Personas.Usuarios.Oficiales.ModeloOficiales;
import Personas.Usuarios.Secretarias.ModeloSecretarias;
import Utilidades.CRUD;

public class ControladorUsuarios implements CRUD {

    private ModeloUsuarios usuario;
    private ModeloOficiales oficial;
    private ModeloSecretarias secretaria;
    private BaseDatos BD;
    private VistaUsuario vista;

    public ControladorUsuarios(VistaUsuario vista) {
        this.vista = vista;
    }

    @Override
    public void agregar() {
        BD = new BaseDatos("INSERT INTO tblusuarios VALUES (?,?,?,?,?,?,?,?)");
        if (vista.getTipo().equals("Oficial")) {
            oficial = new ModeloOficiales(vista.getCedula(), vista.getNombre(), vista.getUsuario(), vista.getContrasena(),
                    vista.getTelefono(), vista.getTipo(), vista.getCorreo(), Double.parseDouble(vista.getSalario()));
        } else {
            secretaria = new ModeloSecretarias(vista.getCedula(), vista.getNombre(), vista.getUsuario(), vista.getContrasena(),
                    vista.getTelefono(), vista.getTipo(), vista.getCorreo());
        }
        BD.ejecutar();
    }

    @Override
    public void eliminar() {
        usuario = new ModeloUsuarios();
        usuario.setCedula(vista.getCedula());
        BD = new BaseDatos("DELETE FROM tblusuarios WHERE Cedula =" +  usuario.getCedula());
        BD.ejecutar();
    }
    
      @Override
    public void leer() {
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
