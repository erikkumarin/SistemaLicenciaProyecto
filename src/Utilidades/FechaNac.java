package Utilidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class FechaNac {

    private final DateTimeFormatter fmt;
    private Period periodo;
    private LocalDate fechaNac;
    private LocalDate fechaActu;

    public Period getPeriodo() {
        return periodo;
    }

    public FechaNac() {
        this.fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaActu = LocalDate.now();
    }

    /**
     * Se ingresa la fecha de nacimiento de la Persona.
     *
     * @param fecha dd/MM/yyyy
     */
    public void ingresarFechaNac(String fecha) {
        this.fechaNac = LocalDate.parse(fecha, fmt);
    }

    /**
     * Calcula la edad de la Persona.
     */
    public void calcularEdad() {
        this.periodo = Period.between(fechaNac, fechaActu);
    }

    /**
     * Muestra la edad de la Persona como un int.
     *
     * @return La edad.
     */
    public int mostrarEdad() {
        return this.periodo.getYears();
    }

    /**
     * Muestra y calcula la edad de la persona.
     *
     * @param fecha dd/MM/yyyy
     * @return La edad.
     */
    public int calcularMotrarEdad(String fecha) {
        this.ingresarFechaNac(fecha);
        this.calcularEdad();
        return this.mostrarEdad();
    }

}
