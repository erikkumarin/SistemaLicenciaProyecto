package Personas.Usuarios.Oficiales;

import Personas.Usuarios.clsUsuarios;

public class clsOficial extends clsUsuarios {

    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
        }
    }

    public clsOficial(String cedula, String nombre, String correo, String telefono, String fecha, String nomUsuario, String contra, String tipoUsuario) {
        super(cedula, nombre, correo, telefono, fecha, nomUsuario, contra, tipoUsuario);
    }

    public clsOficial(String cedula, String nombre, String fechaNac, String telefono, String correo, double salario) {
        super(cedula, nombre, fechaNac, telefono, correo);
        this.salario = salario;
    }
    
    

    public clsOficial() {
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
