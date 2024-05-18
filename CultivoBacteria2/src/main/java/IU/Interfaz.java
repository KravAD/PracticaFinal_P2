package IU;

import Datos.*;
import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Logica.GestorExperimentos;
import Logica.PoblacionBacterias;

public class Interfaz extends JFrame {
    private GestorExperimentos gestor;
    private JFileChooser fileChooser;

    public Interfaz() {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton openButton = new JButton("Abrir");
        JButton createExperimentButton = new JButton("Crear Experimento");
        JButton saveButton = new JButton("Guardar");
        JButton saveAsButton = new JButton("Guardar Como");

        gestor = new GestorExperimentos();
        fileChooser = new JFileChooser();

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestor.abrirExperimento();
                } catch (IOException | ClassNotFoundException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        createExperimentButton.addActionListener(e -> {
            Map<String, EstrategiaComida> estrategiasComida = new HashMap<>();
            estrategiasComida.put("EstrategiaComidaConstante", new EstrategiaComidaConstante());
            estrategiasComida.put("EstrategiaComidaLineal", new EstrategiaComidaLineal());
            estrategiasComida.put("EstrategiaComidaAlternante", new EstrategiaComidaAlternante());

            String estrategiaSeleccionada = (String) JOptionPane.showInputDialog(null, "Selecciona una estrategia de comida:", "Creación de Experimento", JOptionPane.QUESTION_MESSAGE, null, estrategiasComida.keySet().toArray(), estrategiasComida.keySet().toArray()[0]);
            EstrategiaComida estrategiaComida = estrategiasComida.get(estrategiaSeleccionada);


            String duracionExperimento = JOptionPane.showInputDialog("Introduce la duración del experimento:");
            int duracion = Integer.parseInt(duracionExperimento);

            Experimento experimento = new Experimento(estrategiaComida, duracion);

            gestor.crearExperimento(experimento);

            new ExperimentoFrame(gestor).setVisible(true);
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestor.guardar(fileChooser.getSelectedFile().getPath());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        saveAsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        gestor.guardarComo(fileChooser.getSelectedFile().getPath());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });


        buttonPanel.add(openButton);
        buttonPanel.add(createExperimentButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(saveAsButton);

        add(buttonPanel, BorderLayout.NORTH);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}