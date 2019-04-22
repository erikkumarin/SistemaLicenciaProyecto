package Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarCorreo {

    //"[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@(\\.[a-z0-9]+)(\\.[a-z]{2,4})*(\\.[a-z]{2,3})*"
    private static String correo = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-z]+(\\.[a-z]{2,4})*(\\.[a-z]{2,3})*";
    private static Pattern patron;
    private static Matcher comparar;
    
    public static boolean Validar(String correo){
         patron = Pattern.compile(ValidarCorreo.correo);
        comparar = patron.matcher(correo);
        return comparar.matches();
    }
}
