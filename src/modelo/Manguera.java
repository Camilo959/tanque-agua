package modelo;

import javax.swing.*;

public class Manguera extends Thread {

    private JProgressBar barra;
    private boolean abierta = true; // Estado de la llave
    private boolean tipo = true;
    private static int cantidad = 50;
    private int velocidad;

    public Manguera(String nombre, JProgressBar barra) {
        super(nombre);
        this.barra = barra;
    }

    public void run() {

        // Un algoritmo cambia el valor de una variable
        // Otro algoritmo lee el valor de la varible
        while (cantidad>0 && cantidad<100) {

            cantidad = barra.getValue();

            if(tipo) {
                cantidad++;
            } else {
                cantidad--;
            }
            System.out.println("i: " + cantidad);
            barra.setValue(cantidad);
            try {
                sleep(velocidad);

                // synchronized es para variables que son modificadas por otros hilos (hay dos formas)
                // Dos hilos que usan la misma variable
                synchronized(this) {
                    System.out.println("Abierta: " + abierta);
                    if (!abierta) { // cuando esta variable sea falso el espera
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // (Este es el hilo principal) 
    public synchronized void switchAbierta() {
        abierta = !abierta; // cambiar el estado de la manguera ( abierta cerrado)
        notify(); // se notifica a ver si la variable cambio
    }

    public boolean getAbierta() {
        return abierta;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }


}
