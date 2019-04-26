package Utilidades;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.JComboBox;

public class Fecha {

    private final DateTimeFormatter fmt;
    private Period periodo;
    private LocalDate fecha;
    private LocalDate fechaActu;

    private static String[] meses = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private static Calendar calendario = Calendar.getInstance();

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

    public String getFechaActu() {
        return fechaActu.toString();
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

    public Fecha() {
        this.fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaActu = LocalDate.now();
    }

    public static void agregarAniosUC(JComboBox cbanio) {
        int anio = (calendario.get(Calendar.YEAR)) - 18;
        for (int i = anio - 100; i <= anio; i++) {
            cbanio.addItem(Integer.toString(i));
        }
    }

    public static void agregarMesesUC(JComboBox cbanio, JComboBox cbmes) {
        int mes = 11;
        if (calendario.get(Calendar.YEAR) - 18 == (Integer.parseInt(cbanio.getItemAt(cbanio.getSelectedIndex()).toString()))) {
            mes = calendario.get(Calendar.MONTH);
        }
        cbmes.removeAllItems();
        for (int i = 0; i <= mes; i++) {
            cbmes.addItem(meses[i]);
        }
    }

    public static void agregarDiasUC(JComboBox cbanio, JComboBox cbmes, JComboBox cbdia) {
        int anio = Integer.valueOf(cbanio.getItemAt(cbanio.getSelectedIndex()).toString());
        int dias = 0;
        String mes;
        if (cbmes.getSelectedItem() == null) {
            mes = "Enero";
        } else {
            mes = cbmes.getSelectedItem().toString();
        }
        if (mes.equals("Enero") || mes.equals("Marzo") || mes.equals("Mayo") || mes.equals("Julio") || mes.equals("Agosto") || mes.equals("Octubre") || mes.equals("Diciembre")) {
            dias = 31;
        } else if (mes.equals("Abril") || mes.equals("Junio") || mes.equals("Septiembre") || mes.equals("Noviembre")) {
            dias = 30;
        } else if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
            dias = 29;
        } else {
            dias = 28;
        }
        definirDiasUC(cbanio, cbmes, cbdia, dias);
    }

    public static void definirDiasUC(JComboBox cbanio, JComboBox cbmes, JComboBox cbdia, int dias) {
        int dia = 1;
        if (meses[calendario.get(Calendar.MONTH)].equals(cbmes.getItemAt(cbmes.getSelectedIndex()))) {
            if (calendario.get(Calendar.YEAR) - 18 == (Integer.parseInt(cbanio.getSelectedItem().toString()))) {
                dias = calendario.get(Calendar.DAY_OF_MONTH);
            }
        }
        cbdia.removeAllItems();
        for (int i = dia; i <= dias; i++) {
            cbdia.addItem(String.valueOf(i));
        }
    }

    public static void agregarAniosCP(JComboBox cbanio) {
        cbanio.addItem(Integer.toString(calendario.get(Calendar.YEAR)));
        cbanio.setEnabled(false);
    }

    public static void agregarMesesCP(JComboBox cbanio, JComboBox cbmes) {
        int mes = 0, cantidad = 12;
        if (calendario.get(Calendar.YEAR) == (Integer.parseInt(cbanio.getItemAt(cbanio.getSelectedIndex()).toString()))) {
            mes = calendario.get(Calendar.MONTH);
        } else {
            cantidad = 12 - calendario.get(Calendar.MONTH);
        }
        cbmes.removeAllItems();
        int mesesAgregados = 0;
        for (int i = mes; i < cantidad; i++) {
            if (mesesAgregados < 3) {
                cbmes.addItem(meses[i]);
                ++mesesAgregados;
            }
        }
        if (mesesAgregados != 3) {
            cbanio.addItem(Integer.toString(calendario.get(Calendar.YEAR) + 1));
            cbanio.setEnabled(true);
        }
    }

    public static void agregarDiasCP(JComboBox cbanio, JComboBox cbmes, JComboBox cbdia) {
        int anio = Integer.valueOf(cbanio.getItemAt(cbanio.getSelectedIndex()).toString());
        int dias = 0;
        String mes;
        if (cbmes.getSelectedItem() == null) {
            mes = "Enero";
        } else {
            mes = cbmes.getSelectedItem().toString();
        }
        if (mes.equals("Enero") || mes.equals("Marzo") || mes.equals("Mayo") || mes.equals("Julio") || mes.equals("Agosto") || mes.equals("Octubre") || mes.equals("Diciembre")) {
            dias = 31;
        } else if (mes.equals("Abril") || mes.equals("Junio") || mes.equals("Septiembre") || mes.equals("Noviembre")) {
            dias = 30;
        } else if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
            dias = 29;
        } else {
            dias = 28;
        }
        definirDiasCP(cbanio, cbmes, cbdia, dias);

    }

    private static void definirDiasCP(JComboBox cbanio, JComboBox cbmes, JComboBox cbdia, int dias) {
        int dia = 1;
        if (meses[calendario.get(Calendar.MONTH)].equals(cbmes.getItemAt(cbmes.getSelectedIndex()))) {
            if (calendario.get(Calendar.YEAR) == (Integer.parseInt(cbanio.getItemAt(cbanio.getSelectedIndex()).toString()))) {
                dia = calendario.get(Calendar.DAY_OF_MONTH);
            }
        }
        cbdia.removeAllItems();
        for (int i = dia; i <= dias; i++) {
            cbdia.addItem(String.valueOf(i));
        }
    }

    public static boolean agregarHora(JComboBox cbdia, JComboBox cbhora) {
        int hora = 8;
        if (cbdia.getItemAt(cbdia.getSelectedIndex()) == null) {
            hora = calendario.get(Calendar.HOUR_OF_DAY);
        } else if (Integer.parseInt(cbdia.getItemAt(cbdia.getSelectedIndex()).toString()) == calendario.get(Calendar.DAY_OF_MONTH)) {
            hora = calendario.get(Calendar.HOUR_OF_DAY);
            if (hora < 8) {
                hora = 8;
            }
        }
        cbhora.removeAllItems();
        if (hora < 23) {
            do {
                cbhora.addItem(hora + ":00");
                hora++;
            } while (hora != 23);
            return true;
        } else {
            cbhora.addItem("Hora limite alcanza");
            return false;
        }
    }

    public static String ubicarMes(JComboBox cbmes) {
        for (int i = 0; i < 12; i++) {
            if (cbmes.getSelectedItem().toString().equals(meses[i])) {
                if (i + 1 < 10) {
                    return "0" + (i + 1);
                }
                return String.valueOf(i + 1);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String fechaInvertida[] = this.getFecha().toString().split("-");
        return fechaInvertida[2] + "/" + fechaInvertida[1] + "/" + fechaInvertida[0];
    }

    public String toStringActual() {
        String fechaInvertida[] = this.getFechaActu().split("-");
        return fechaInvertida[2] + "/" + fechaInvertida[1] + "/" + fechaInvertida[0];
    }

}
