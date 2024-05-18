package Logica;

import java.util.List;

public interface EstrategiaComida {
    List<Integer> calcularDosisComida(int dosisComidaInicial, int diaIncremento, int dosisComidaDiaIncremento, int dosisComidaFinal);
}