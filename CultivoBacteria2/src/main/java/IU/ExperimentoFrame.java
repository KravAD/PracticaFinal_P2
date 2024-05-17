package IU;
import Logica.GestorExperimentos;
import Logica.PoblacionBacterias;

import javax.swing.*;
import java.awt.*;

class ExperimentoFrame extends JFrame {
    private GestorExperimentos gestor;

    private JTextField nombreField = new JTextField(5);
    private JLabel nombreLabel = new JLabel("Nombre:");
    private JTextField fechaInicioField = new JTextField(5);
    private JLabel fechaInicioLabel = new JLabel("Fecha de inicio:");
    private JTextField fechaFinField = new JTextField(5);
    private JLabel fechaFinLabel = new JLabel("Fecha de fin:");
    private JTextField numeroInicialBacteriasField = new JTextField(5);
    private JLabel numeroInicialBacteriasLabel = new JLabel("Número inicial de bacterias:");
    private JTextField temperaturaField = new JTextField();
    private JLabel temperaturaLabel = new JLabel("Temperatura:");
    private JTextField condicionesLuminosidadField = new JTextField(5);
    private JLabel condicionesLuminosidadLabel = new JLabel("Condiciones de luminosidad:");
    private JTextField dosisComidaInicialField = new JTextField(5);
    private JLabel dosisComidaInicialLabel = new JLabel("Dosis inicial de comida:");
    private JTextField dosisComidaFinalField = new JTextField(5);
    private JLabel dosisComidaFinalLabel = new JLabel("Dosis final de comida:");
    private JTextField diaIncrementoField = new JTextField(5);
    private JLabel diaIncrementoLabel = new JLabel("Día de incremento:");
    private JTextField dosisComidaDiaIncrementoField = new JTextField(5);
    private JLabel dosisComidaDiaIncrementoLabel = new JLabel("Dosis de comida en el día de incremento:");

    private ExperimentoLista experimentoLista;

    public ExperimentoFrame(GestorExperimentos gestor) {
        this.gestor = gestor;

        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JPanel fieldPanel = new JPanel(new GridLayout(0, 2));

        JButton createPopulationButton = new JButton("Crear Poblacion");
        JButton deletePopulationButton = new JButton("Eliminar Poblacion");
        JButton detailsButton = new JButton("Detalles");

        fieldPanel.add(nombreLabel);
        fieldPanel.add(nombreField);
        fieldPanel.add(fechaInicioLabel);
        fieldPanel.add(fechaInicioField);
        fieldPanel.add(fechaFinLabel);
        fieldPanel.add(fechaFinField);
        fieldPanel.add(numeroInicialBacteriasLabel);
        fieldPanel.add(numeroInicialBacteriasField);
        fieldPanel.add(temperaturaLabel);
        fieldPanel.add(temperaturaField);
        fieldPanel.add(condicionesLuminosidadLabel);
        fieldPanel.add(condicionesLuminosidadField);
        fieldPanel.add(dosisComidaInicialLabel);
        fieldPanel.add(dosisComidaInicialField);
        fieldPanel.add(dosisComidaFinalLabel);
        fieldPanel.add(dosisComidaFinalField);
        fieldPanel.add(diaIncrementoLabel);
        fieldPanel.add(diaIncrementoField);
        fieldPanel.add(dosisComidaDiaIncrementoLabel);
        fieldPanel.add(dosisComidaDiaIncrementoField);

        experimentoLista = new ExperimentoLista(gestor);

        createPopulationButton.addActionListener(e -> {
            PoblacionBacterias poblacion = new PoblacionBacterias(
                    nombreField.getText(),
                    fechaInicioField.getText(),
                    fechaFinField.getText(),
                    Integer.parseInt(numeroInicialBacteriasField.getText()),
                    Integer.parseInt(temperaturaField.getText()),
                    condicionesLuminosidadField.getText(),
                    Integer.parseInt(dosisComidaInicialField.getText()),
                    Integer.parseInt(diaIncrementoField.getText()),
                    Integer.parseInt(dosisComidaDiaIncrementoField.getText()),
                    Integer.parseInt(dosisComidaFinalField.getText())
            );
            gestor.getExperimentoActual().agregarPoblacion(poblacion);
            experimentoLista.actualizarLista();
            experimentoLista.setVisible(true);
        });

        deletePopulationButton.addActionListener(e -> {
            experimentoLista.setVisible(true);
            PoblacionBacterias poblacion = experimentoLista.getPoblacionSeleccionada();
            if (poblacion != null) {
                gestor.getExperimentoActual().eliminarPoblacion(poblacion);
                experimentoLista.actualizarLista();
            }
        });

        detailsButton.addActionListener(e -> {
            PoblacionBacterias poblacion = experimentoLista.getPoblacionSeleccionada();
            if (poblacion != null) {
                new DetallesPoblacionFrame(poblacion).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No se seleccionó ninguna población.");
            }
        });

        buttonPanel.add(createPopulationButton);
        buttonPanel.add(deletePopulationButton);
        buttonPanel.add(detailsButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(fieldPanel, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}