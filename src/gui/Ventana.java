package gui;

import modelo.Controlador;
import modelo.Manguera;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private Container panel;


    private JTextField entrada;
    private JTextField volumen;
    private JTextField salida;

    private JButton btnEntrada;
    private JButton btnVolumen;
    private JButton btnSalida;

    private JProgressBar barra;

    public Ventana() {
        super("Lab: Deposito de agua");
        setBounds(300,20,360,400);
        setLayout(null);
        panel = getContentPane();

        JLabel L_entrada = new JLabel("Entrada");
        JLabel L_volumen = new JLabel("Volumen");
        JLabel L_salida = new JLabel("Salida");

        L_entrada.setBounds(10,10,100,30);
        L_volumen.setBounds(120,10,100,30);
        L_salida.setBounds(240,10,100,30);

        // fila 1
        panel.add(L_entrada);
        panel.add(L_volumen);
        panel.add(L_salida);


        // fila 2

        entrada = new JTextField("500");
        entrada.setBounds(10,50,100,30);



        volumen = new JTextField("");
        volumen.setBounds(120,50,100,30);


        salida = new JTextField("500");
        salida.setBounds(240,50,100,30);

        panel.add(entrada);
        panel.add(volumen);
        panel.add(salida);

        // fila 3
        btnEntrada = new JButton("Abrir");

        btnVolumen = new JButton("Actualizar");
        btnSalida = new JButton("Abrir");

        btnEntrada.setBounds(10,95,100,30);
        btnVolumen.setBounds(120,95,100,30);
        btnSalida.setBounds(240,95,100,30);

        panel.add(btnEntrada);
        panel.add(btnVolumen);
        panel.add(btnSalida);

        barra = new JProgressBar(0,100);
        barra.setValue(0);
        barra.setBounds(10,130,320,220);
        barra.setStringPainted(true);
        barra.setOrientation(1); // Vertical o horizontal
        barra.setForeground(new Color(10, 92, 169));
        panel.add(barra);

        Controlador.iniciarMangueras(barra);

        btnEntrada.addActionListener(actionEvent -> {
            Controlador.moverManguera("Llena", btnEntrada, entrada );
        });

        btnSalida.addActionListener(actionEvent -> {
            Controlador.moverManguera("Vaciar", btnSalida, salida);
        });


    // controlador despacha eventos 


    }
}
