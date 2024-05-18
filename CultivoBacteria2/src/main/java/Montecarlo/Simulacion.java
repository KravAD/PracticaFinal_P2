package Montecarlo;

import java.util.ArrayList;
import java.util.List;

public class Simulacion {
    private Plato plato;
    private int dias;
    private int[][][] resultados;

    public Simulacion(int dias) {
        this.plato = new Plato(20, 20);
        this.dias = dias;
        this.resultados = new int[dias][plato.getFilas()][plato.getColumnas()];
    }

    public int getDias() {
        return dias;
    }

    public void iniciarSimulacion() {
        int startRow = plato.getFilas() / 2 - 2;
        int startCol = plato.getColumnas() / 2 - 2;

        for (int row = startRow; row < startRow + 4; row++) {
            for (int col = startCol; col < startCol + 4; col++) {
                Celda celda = plato.getCelda(row, col);
                for (int i = 0; i < 100; i++) {
                    celda.getBacterias().add(new Bacteria(celda));
                }
            }
        }

        for (int dia = 0; dia < dias; dia++) {
            for (int fila = 0; fila < plato.getFilas(); fila++) {
                for (int columna = 0; columna < plato.getColumnas(); columna++) {
                    Celda celda = plato.getCelda(fila, columna);

                    List<Bacteria> bacteriasDelDia = new ArrayList<>(celda.getBacterias());
                    for (Bacteria bacteria : bacteriasDelDia) {
                        for (int i = 0; i < 10; i++) {
                            bacteria.mover();
                            bacteria.comer();
                            bacteria.reproducir();
                        }
                    }
                }
            }

            for (int fila = 0; fila < plato.getFilas(); fila++) {
                for (int columna = 0; columna < plato.getColumnas(); columna++) {
                    Celda celda = plato.getCelda(fila, columna);
                    resultados[dia][fila][columna] = celda.getBacterias().size();
                }
            }
        }
    }

    public String finalizarSimulacion() {
        StringBuilder resultadosStr = new StringBuilder("Simulación finalizada. Resultados:\n");

        int totalBacterias = 0;
        for (int fila = 0; fila < plato.getFilas(); fila++) {
            for (int columna = 0; columna < plato.getColumnas(); columna++) {
                int bacterias = resultados[dias - 1][fila][columna];
                totalBacterias += bacterias;
                resultadosStr.append(String.format("Celda (%d, %d): %d bacterias\n", fila, columna, bacterias));
            }
        }

        resultadosStr.append(String.format("Total de bacterias: %d\n", totalBacterias));
        return resultadosStr.toString();
    }

    public int[][] getBacteriasUltimoDia() {
        int[][] bacteriasUltimoDia = new int[plato.getFilas()][plato.getColumnas()];
        for (int fila = 0; fila < plato.getFilas(); fila++) {
            for (int columna = 0; columna < plato.getColumnas(); columna++) {
                Celda celda = plato.getCelda(fila, columna);
                bacteriasUltimoDia[fila][columna] = celda.getBacterias().size();
            }
        }
        return bacteriasUltimoDia;
    }
}