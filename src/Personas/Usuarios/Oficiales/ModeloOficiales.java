package Personas.Usuarios.Oficiales;

import Personas.Usuarios.ModeloUsuarios;

public class ModeloOficiales extends ModeloUsuarios {

    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
        }
    }

    public ModeloOficiales(String cedula, String nombre, String nombreUsuario, String contra, String telefono, String tipoUsuario, String correo, double salario) {
        super(cedula, nombre, nombreUsuario, contra, telefono, tipoUsuario, correo);
        this.setSalario(salario);
    }

    public ModeloOficiales() {
    }

    public double calcularDeducEnfMat() {
        return salario * 0.055;
    }

    public double calcularDeducInvaMuer() {
        return salario * 0.0384;
    }

    public double calcularDeducAporTrab() {
        return salario * 0.01;
    }

    public double calcularDeducAsocSoli() {
        return salario * 0.033;
    }

    public double calcularDeducImpRenta() {
        if (salario > 817000 && salario <= 1226000) {
            return salario * 0.1;
        } else if (salario > 1226000) {
            return salario * 0.15;
        } else {
            return salario;
        }
    }

    public double calcularsalarioNeto() {
        return salario -= (calcularDeducInvaMuer() + calcularDeducImpRenta() + calcularDeducEnfMat() + calcularDeducAsocSoli() + calcularDeducAporTrab());
    }

}
