package IU;

import javax.swing.*;
import java.awt.*;
import Montecarlo.Simulacion;

public class InterfazMontecarlo extends JFrame {
    private JButton botonSimular;
    private JButton botonReiniciar;
    private JTextArea areaTexto;
    private JPanel panelPlato;
    private JLabel[][] celdas;
    private Simulacion simulacion;

    public InterfazMontecarlo(Simulacion simulacion) {
        this.simulacion = simulacion;

        botonSimular = new JButton("Iniciar simulación");
        botonReiniciar = new JButton("Reiniciar simulación");
        areaTexto = new JTextArea();
        panelPlato = new JPanel(new GridLayout(20, 20));
        celdas = new JLabel[20][20];

        botonSimular.addActionListener(e -> iniciarSimulacion());
        botonReiniciar.addActionListener(e -> reiniciarSimulacion());

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.getContentPane().add(botonSimular);
        this.getContentPane().add(botonReiniciar);
        this.getContentPane().add(new JScrollPane(areaTexto));
        this.getContentPane().add(panelPlato);

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        for (int fila = 0; fila < 20; fila++) {
            for (int columna = 0; columna < 20; columna++) {
                JLabel celda = new JLabel();
                celda.setOpaque(true);
                celdas[fila][columna] = celda;
                panelPlato.add(celda);
            }
        }
    }

    private void iniciarSimulacion() {
        simulacion.iniciarSimulacion();
        String resultados = simulacion.finalizarSimulacion();
        areaTexto.setText(resultados);
        actualizarPanelPlato();
    }

    private void reiniciarSimulacion() {
        simulacion = new Simulacion(simulacion.getDias());
        areaTexto.setText("");
        actualizarPanelPlato();
    }

    private void actualizarPanelPlato() {

    }

}