package IU;

import Logica.PoblacionBacterias;

import javax.swing.*;
import java.awt.*;

public class DetallesPoblacionFrame extends JFrame {
    private PoblacionBacterias poblacion;

    public DetallesPoblacionFrame(PoblacionBacterias poblacion) {
        this.poblacion = poblacion;

        setLayout(new GridLayout(0, 2));

        JLabel nombreLabel = new JLabel("Nombre: " + poblacion.getNombre());
        JLabel fechaInicioLabel = new JLabel("Fecha de inicio: " + poblacion.getFechaInicio());
        JLabel fechaFinLabel = new JLabel("Fecha de fin: " + poblacion.getFechaFin());
        JLabel numeroInicialBacteriasLabel = new JLabel("Número inicial de bacterias: " + poblacion.getNumeroInicialBacterias());
        JLabel temperaturaLabel = new JLabel("Temperatura: " + poblacion.getTemperatura());
        JLabel condicionesLuminosidadLabel = new JLabel("Condiciones de luminosidad: " + poblacion.getCondicionesLuminosidad());
        JLabel dosisComidaInicialLabel = new JLabel("Dosis inicial de comida: " + poblacion.getDosisComida());

        add(nombreLabel);
        add(fechaInicioLabel);
        add(fechaFinLabel);
        add(numeroInicialBacteriasLabel);
        add(temperaturaLabel);
        add(condicionesLuminosidadLabel);
        add(dosisComidaInicialLabel);

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}