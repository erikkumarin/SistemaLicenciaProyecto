package Utilidades;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class Orientar {

    public static void ordenar(JTable tbl) {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        int can = tbl.getColumnCount();
        for (int i = 0; i < can; i++) {
            tbl.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
        }
    }

}