package Montecarlo;

import java.util.ArrayList;
import java.util.List;

public class Celda {
    private int comida;
    private List<Bacteria> bacterias;
    private int fila;
    private int columna;
    private Plato platoDeCultivo;

    public Celda(int fila, int columna, Plato platoDeCultivo){
        this.comida = comida;
        this.bacterias = new ArrayList<Bacteria>();
        this.fila = fila;
        this.columna = columna;
        this.platoDeCultivo = platoDeCultivo;
    }

    public int getComida() {
        return comida;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    public List<Bacteria> getBacterias() {
        return bacterias;
    }

    public void setBacterias(List<Bacteria> bacterias) {
        this.bacterias = bacterias;
    }
    public void moverBacteria (Bacteria bacteria, int direccion){
        bacterias.remove(bacteria);

        Celda celdaAdyacente = obtenerCeldaAdyacente(direccion);

        celdaAdyacente.getBacterias().add(bacteria);

        bacteria.setCeldaActual(celdaAdyacente);
    }
    public Celda obtenerCeldaAdyacente(int direccion) {
        int filaActual = this.fila;
        int columnaActual = this.columna;

        switch (direccion) {
            case 0:
                filaActual--;
                break;
            case 1:
                columnaActual++;
                break;
            case 2:
                filaActual++;
                break;
            case 3:
                columnaActual--;
                break;
        }

        if (filaActual >= 0 && filaActual < platoDeCultivo.getFilas() && columnaActual >= 0 && columnaActual < platoDeCultivo.getColumnas()) {
            return platoDeCultivo.getCelda(filaActual, columnaActual);
        } else {
            return this;
        }
    }
}
