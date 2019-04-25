package Pruebas;

import Personas.Usuarios.Oficiales.clsOficial;
import Utilidades.Fecha;

public class clsPruebas {

    private int id;
    private int nota;
    private Fecha fecha;
    private String hora;
    private String observaciones;
    private clsOficial oficial;

    public int getIdPrueba() {
        return id;
    }

    public void setIdPrueba(int idPrueba) {
        this.id = idPrueba;
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

    public clsOficial getOficial() {
        return oficial;
    }

    public void setOficial(clsOficial oficial) {
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
        if (nota <= 100) {
            this.nota = nota;
        }
    }

    public clsPruebas(int idPrueba, String fecha, String hora, clsOficial oficial, String observaciones, int nota) {
        this.setIdPrueba(idPrueba);
        this.setFecha(fecha);
        this.setHora(hora);
        this.setOficial(oficial);
        this.setObservaciones(observaciones);
        this.setNota(nota);
    }

    public clsPruebas() {
    }

    public String getEstado() {
        if (this.nota >= 80) {
            return "Aprobado";
        }
        return "Reprobado";
    }
}
