package Test;

import BaseDeDatos.BaseDatos;

public class Main {

    public static void main(String[] args) {
        BaseDatos BD = new BaseDatos("INSERT INTO tblclientes VALUES (?,?,?,null,null)");
        BD.ejecutar(new Object[]{"501230123","Maria Luis Prueba","10/10/1001"});
        
    }

}