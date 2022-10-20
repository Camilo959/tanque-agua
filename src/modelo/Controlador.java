package modelo;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Controlador {

    //Esta clase solo tiene metodos
    private static Manguera llena, vaciar;

    public static void iniciarMangueras(JProgressBar barra) {

        llena = new Manguera("Entrada", barra); // es un subproceso concurrente, que va llenando la barra
        vaciar = new Manguera("Salida", barra); // es un subproceso concurrente, que va llenando la barra
        vaciar.setTipo(false);
    }

    public static void moverManguera(String tipo, JButton boton, JTextField inVelocidad) {

        Manguera temp = tipo.equals("Llena") ? llena : vaciar;
        temp.setVelocidad(Integer.parseInt(inVelocidad.getText()));

        if(temp.getState() == Thread.State.NEW) {
            temp.start();
            boton.setText("Cerrar");
        } else {
            temp.switchAbierta();
            if (temp.getAbierta()){
                boton.setText("Cerrar");
            } else {
                boton.setText("Abrir");
            }
        }
    }
    
}
