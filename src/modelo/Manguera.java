package modelo;

import javax.swing.*;

public class Manguera extends Thread {

    JProgressBar barra;

    public Manguera(String nombre, JProgressBar barra) {
        super(nombre);
        this.barra = barra;
    }

    public void run() {

        for (int i = 0; i<100; i++) {
            barra.setValue(i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
