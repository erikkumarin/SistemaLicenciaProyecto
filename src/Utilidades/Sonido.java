package Utilidades;

import java.applet.AudioClip;

public class Sonido extends Thread {

    public Sonido() {
    }

    public void reproducir() {
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Utilidades/wiiu.wav"));
        sonido.play();
    }

    @Override
    public void run() {
        reproducir();
    }

}
