package Citas;

import Personas.Clientes.ModeloClientes;

public class ModeloCitas {
//-IdCita
//-Fecha
//-Hora
//-Cliente
//+ExisteCliente()
    private int id;
    private String fecha;
    private String hora;
    private ModeloClientes cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public ModeloCitas() {
    }

    public ModeloCitas(int id, String fecha, String hora, ModeloClientes cliente) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
    }
    
    public boolean existeCliente(){
        return false;
    }
}
