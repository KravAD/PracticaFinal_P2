package IU;


import Logica.GestorExperimentos;
import Logica.PoblacionBacterias;

import javax.swing.*;
import java.awt.*;

public class ExperimentoLista extends JFrame {
    private GestorExperimentos gestor;
    private JList<PoblacionBacterias> listaPoblaciones;

    public ExperimentoLista(GestorExperimentos gestor) {
        this.gestor = gestor;

        setLayout(new BorderLayout());

        listaPoblaciones = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaPoblaciones);

        add(scrollPane, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actualizarLista() {
        DefaultListModel<PoblacionBacterias> model = new DefaultListModel<>();
        for (PoblacionBacterias poblacion : gestor.getExperimentoActual().getPoblaciones()) {
            model.addElement(poblacion);
        }
        listaPoblaciones.setModel(model);
    }

    public PoblacionBacterias getPoblacionSeleccionada() {
        return listaPoblaciones.getSelectedValue();
    }
}
