package Citas;

import BaseDeDatos.BaseDatos;
import Errores.ErrorConexion;
import Errores.ErrorMensaje;
import Main.frmPrincipal;
import Personas.Clientes.clsClientes;
import Pruebas.frmPruebas;
import Utilidades.Fecha;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorCitas {
    
    private clsCitas cita;
    private BaseDatos bd;
    
    public void agregar(frmRegistrarCitas vista) throws ErrorConexion {
        cita = new clsCitas(0, vista.getFecha(), vista.getHora(), new clsClientes());
        if (verificarCantCitas(vista) < 4) {
            bd = new BaseDatos("INSERT INTO tblcitas VALUES (null,?,?,?)");
            cita.getCliente().setCedula(vista.getCedula());
            cita.getCliente().setNombre(vista.getNombre());
            if (ErrorMensaje.mostrarMensajes()) {
                JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
            } else {
                bd.ejecutar(new Object[]{cita.getCliente().getCedula(), cita.getFecha(), cita.getHora()});
                JOptionPane.showMessageDialog(vista, "Se Registro Exitosamente", "Registro Cita", 1);
                vista.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Limite de citas Alcanzado\nFecha: " + cita.getFecha() + " y Hora: " + cita.getHora(), "Cita Activa", 2);
        }
    }
    
    public boolean existeCliente(frmRegistrarCitas vista) throws ErrorConexion {
        bd = new BaseDatos("Select Nombre From tblclientes Where Cedula=?");
        cita = new clsCitas(new clsClientes(), vista.getCedula());
        if (ErrorMensaje.mostrarMensajes()) {
            JOptionPane.showMessageDialog(vista, ErrorMensaje.getMsj(), "Error", 0);
        } else {
            bd.ejecutar(new Object[]{cita.getCliente().getCedula()});
            Object obj[] = bd.getObjet();
            if (obj != null) {
                vista.setNombre((String) obj[0]);
                verificarCitaActiva(vista);
                return true;
            }
        }
        return false;
    }
    
    public void eliminar() throws ErrorConexion {
        //bd = new BaseDatos("DELETE FROM tblcitas WHERE Cedula =" + cliente.getCedula());
    }
    
    public void modificar() throws ErrorConexion {
        
    }

    public void cargarTabla(frmMostrarCitas vista) throws ErrorConexion {
        bd = new BaseDatos("Select * from tblCitas where Fecha=?");
        Fecha fecha = new Fecha();
        bd.ejecutar(new Object[]{fecha.toStringActual()});
        DefaultTableModel modelo = (DefaultTableModel) vista.getTblCitas().getModel();
        modelo.setNumRows(0);
        Object obj[];
        do {
            obj = bd.getObjet();
            if (obj != null) {
                cita = new clsCitas(obj);
                modelo.addRow(cita.toObject());
            }
        } while (obj != null);
    }
    
    public clsCitas pasarDatos(frmMostrarCitas vista, int filaSeleccionanda) throws ErrorConexion{
        bd = new BaseDatos("SELECT cita.Id, cita.Fecha, cita.Hora, cliente.Cedula, cliente.Nombre, cliente.`Fecha Nac` "
                + "FROM tblcitas AS cita INNER JOIN tblclientes AS cliente on cita.IdCliente = cliente.Cedula WHERE cita.Id = ?");
        bd.ejecutar(new Object[]{vista.getTblCitas().getValueAt(filaSeleccionanda, 0).toString()});
        Object obj[] = bd.getObjet();
        cita = new clsCitas((Integer)obj[0],(String)obj[1],(String)obj[2],new clsClientes());
        cita.getCliente().setCedula((String) obj[3]);
        cita.getCliente().setNombre((String) obj[4]);
        cita.getCliente().setFechaNac((String) obj[5]);
        return cita;
    }
    
    
    public int verificarCantCitas(frmRegistrarCitas vista) throws ErrorConexion {
        bd = new BaseDatos("SELECT * FROM tblcitas WHERE Fecha=? AND Hora=?");
        bd.ejecutar(new Object[]{vista.getFecha(), vista.getHora()});
        Object[] obj;
        int cont = 0;
        do {
            obj = bd.getObjet();
            if (obj != null) {
                cont++;
            }
        } while (obj != null);
        return cont;
    }
    
    public void verificarCitaActiva(frmRegistrarCitas vista) throws ErrorConexion {
        bd = new BaseDatos("Select * From tblcitas Where IdCliente=?");
        String[] hoy = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).split("/");
        bd.ejecutar(new Object[]{vista.getCedula()});
        Object obj[];
        do {
            obj = bd.getObjet();
            if (obj != null) {
                cita = new clsCitas(obj);
                String[] fecha = cita.getFecha().split("/");
                if (Integer.parseInt(hoy[0]) <= Integer.parseInt(fecha[0]) && Integer.parseInt(hoy[1]) <= Integer.parseInt(fecha[1])) {
                    JOptionPane.showMessageDialog(vista, "Cliente: " + vista.getNombre()
                            + "\nTiene Cita para la Fecha: " + cita.getFecha() + " y Hora: " + cita.getHora(), "Cita Activa", 2);
                    vista.dispose();
                }
            }
        } while (obj != null);
    }
    
//    public Object [] datosCliente(){
//        
//    }  
}
