package Citas;

import Personas.Clientes.clsClientes;
import Utilidades.Fecha;

public class clsCitas {

    private int id;
    private Fecha fecha;
    private String hora;
    private clsClientes cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha.toString();
    }

    public void setFecha(String fecha) {
        this.fecha = new Fecha(fecha);
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public clsClientes getCliente() {
        return cliente;
    }

    public void setCliente(clsClientes cliente) {
        this.cliente = cliente;
    }

    public clsCitas(int id, String fecha, String hora, clsClientes cliente) {
        this.setCliente(cliente);
        this.setFecha(fecha);
        this.setHora(hora);
        this.setId(id);
    }

    public clsCitas(clsClientes cliente, String cedula) {
        this.setCliente(cliente);
        this.getCliente().setCedula(cedula);
    }

    public clsCitas(Object[] obj) {
        if (obj != null) {
            this.setCliente(new clsClientes());
            this.setId((int) obj[0]);
            this.getCliente().setCedula((String) obj[1]);
            this.setFecha((String) obj[2]);
            this.setHora((String) obj[3]);
        }
    }

    public clsCitas() {
    }

    public Object[] toObject() {
        return new Object[]{this.getId(), this.getCliente().getCedula(), this.getFecha(), this.getHora()};
    }
}
