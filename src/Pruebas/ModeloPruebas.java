package Pruebas;

import Personas.Usuarios.Oficiales.ModeloOficiales;

public class ModeloPruebas {
    private int id;
    private String fecha;
    private String hora;
    private ModeloOficiales oficial;
    private String observaciones;
    private int nota;

    public int getIdPrueba() {
        return id;
    }

    public void setIdPrueba(int idPrueba) {
        this.id = idPrueba;
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

    public ModeloOficiales getOficial() {
        return oficial;
    }

    public void setOficial(ModeloOficiales oficial) {
        this.oficial = oficial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public ModeloPruebas() {
    }

    public ModeloPruebas(int idPrueba, String fecha, String hora, ModeloOficiales oficial, String observaciones, int nota) {
        this.id = idPrueba;
        this.fecha = fecha;
        this.hora = hora;
        this.oficial = oficial;
        this.observaciones = observaciones;
        this.nota = nota;
    }
    
    public String getEstado(){
        if (this.nota >= 80) {
            return "Aprobado";
        }
        
        return "Reprobado";
    }
}
