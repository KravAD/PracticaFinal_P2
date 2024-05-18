package Montecarlo;

public class Plato {
    private Celda[][] celdas;

    public Plato(int filas, int columnas) {
        celdas = new Celda[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda(i, j, this);
            }
        }
    }

    public int getFilas() {
        return celdas.length;
    }

    public int getColumnas() {
        return celdas[0].length;
    }

    public Celda getCelda(int fila, int columna) {
        return celdas[fila][columna];
    }
}
