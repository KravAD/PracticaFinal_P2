package Logica;

import java.util.ArrayList;
import java.util.List;

public class EstrategiaComidaLineal implements EstrategiaComida{
    @Override
    public List<Integer> calcularDosisComida(int dosisComidaInicial, int diaIncremento, int dosisComidaDiaIncremento, int dosisComidaFinal) {
        List<Integer> dosisComida = new ArrayList<>();
        int incremento = (dosisComidaFinal - dosisComidaInicial) / (diaIncremento - 1);
        for (int i = 0; i < diaIncremento; i++) {
            dosisComida.add(dosisComidaInicial + i * incremento);
        }
        return dosisComida;
    }
}
