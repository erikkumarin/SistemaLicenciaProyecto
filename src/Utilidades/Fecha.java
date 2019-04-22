package Utilidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Fecha {

    private final DateTimeFormatter fmt;
    private Period periodo;
    private LocalDate fecha;
    private LocalDate fechaActu;
    
    public static String[] meses = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static final Calendar calendario = Calendar.getInstance();


    /**
     * Se ingresa la fecha de nacimiento de la Persona.
     *
     * @param fecha dd/MM/yyyy
     */
    public void setFecha(String fecha) {
        this.fecha = LocalDate.parse(fecha, fmt);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Calcula la edad de la Persona.
     *
     * @param fecha
     */
    public void setPeriodo(LocalDate fecha) {
        this.periodo = Period.between(fecha, fechaActu);
    }

    public Period getPeriodo() {
        return periodo;
    }

    public Fecha(String fecha) {
        this.fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaActu = LocalDate.now();
        this.setFecha(fecha);
    }

    @Override
    public String toString() {
        String fechaInvertida[] = this.getFecha().toString().split("-");
        return fechaInvertida[2] + "/" + fechaInvertida[1] + "/" + fechaInvertida[0];
    }

}
