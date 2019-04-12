package Test;

import Personas.Clientes.*;


public class Main {

    public static void main(String[] args) {
        VistaCliente vc = new VistaCliente();
        vc.setCedula("501470255");
        vc.setNombre("Cliente");
        vc.setFecha("10/10/2000");
        vc.setTelefono("84858687");
        vc.setCorreo("cliente@gmail.com");
        System.out.println(vc.toString());
        ControladorClientes cc = new ControladorClientes(vc);
        cc.agregar();
    }
}
