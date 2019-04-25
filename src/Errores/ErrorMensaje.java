package Errores;

import java.util.ArrayList;

public abstract class ErrorMensaje {

    private static ArrayList<String> msjErrores;
    private static String msj;

    public static ArrayList<String> getMsjErrores() {
        return msjErrores;
    }

    public static String getMsj() {
        mostrarMensajes();
        return msj;
    }

    public static void crear() {
        msjErrores = new ArrayList<String>();
        msj = "";
    }

    public static void agregarMensaje(String msjError) {
        msjErrores.add(msjError);
    }

    public static boolean mostrarMensajes() {
        if (!msjErrores.isEmpty()) {
            for (String msjError : msjErrores) {
                msj += msjError + "\n";
            }
            return true;
        }
        return false;
    }

}
