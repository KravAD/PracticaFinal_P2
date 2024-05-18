package IU;

import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ExperimentoLista extends JFrame {
    private GestorExperimentos gestor;
    private JList<String> listaPoblaciones;
    private JComboBox<String> ordenarPorComboBox;

    public ExperimentoLista(GestorExperimentos gestor) {
        this.gestor = gestor;

        setLayout(new BorderLayout());

        listaPoblaciones = new JList<>();
        ordenarPorComboBox = new JComboBox<>(new String[]{"Por nombre", "Por fecha de inicio", "Por número de bacterias"});

        ordenarPorComboBox.addActionListener(e -> actualizarLista());

        add(new JScrollPane(listaPoblaciones), BorderLayout.CENTER);
        add(ordenarPorComboBox, BorderLayout.NORTH);

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actualizarLista() {
        String ordenarPor = (String) ordenarPorComboBox.getSelectedItem();
        Comparator<PoblacionBacterias> comparador;

        switch (ordenarPor) {
            case "Por nombre":
                comparador = Comparator.comparing(PoblacionBacterias::getNombre);
                break;
            case "Por fecha de inicio":
                comparador = Comparator.comparing(PoblacionBacterias::getFechaInicio);
                break;
            case "Por número de bacterias":
                comparador = Comparator.comparingInt(PoblacionBacterias::getNumeroInicialBacterias);
                break;
            default:
                throw new IllegalArgumentException("Criterio de ordenación no reconocido: " + ordenarPor);
        }

        java.util.List<PoblacionBacterias> poblacionesOrdenadas = new ArrayList<>(gestor.getExperimentoActual().getPoblaciones());
        Collections.sort(poblacionesOrdenadas, comparador);

        DefaultListModel<String> model = new DefaultListModel<>();
        for (PoblacionBacterias poblacion : poblacionesOrdenadas) {
            model.addElement(poblacion.getNombre());
        }
        listaPoblaciones.setModel(model);
    }

    public PoblacionBacterias getPoblacionSeleccionada() {
        String nombrePoblacion = listaPoblaciones.getSelectedValue();
        return gestor.getExperimentoActual().obtenerInformacionPoblacion(nombrePoblacion);
    }
}