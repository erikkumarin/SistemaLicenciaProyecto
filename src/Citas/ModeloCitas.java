package Citas;

import Personas.Clientes.ModeloClientes;
import Utilidades.Fecha;

public class ModeloCitas {

    private int id;
    private Fecha fecha;
    private String hora;
    private ModeloClientes cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.setFecha(fecha);
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public ModeloClientes getCliente() {
        return cliente;
    }

    public void setCliente(ModeloClientes cliente) {
        this.cliente = cliente;
    }

    public ModeloCitas(int id, String fecha, String hora, ModeloClientes cliente) {
        this.setCliente(cliente);
        this.setFecha(fecha);
        this.setHora(hora);
        this.setId(id);
    }

    public ModeloCitas() {
    }

    public boolean existeCliente() {
        return false;
    }
}
