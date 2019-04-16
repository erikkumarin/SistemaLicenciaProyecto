package Utilidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.JInternalFrame;

public class Fecha {

    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Period periodo;
    private LocalDate fecha;
    private LocalDate fechaActu;
    private String[] meses;
    private final Calendar calendario = Calendar.getInstance();

    public Fecha(String fecha) {
        this.fechaActu = LocalDate.now();
        this.setFecha(fecha);
    }

    public Fecha() {
        meses = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    }

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

    
    public void agregarAnios(JInternalFrame vista) {
        int anio = calendario.get(Calendar.YEAR);
        for (int i = anio; i < anio + 100; i++) {
           vista.get addItem(Integer.toString(i));

        }
    }
}
