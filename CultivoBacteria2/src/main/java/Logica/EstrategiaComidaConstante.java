package Logica;

import java.util.ArrayList;
import java.util.List;

public class EstrategiaComidaConstante implements EstrategiaComida{
    @Override
    public List<Integer> calcularDosisComida(int dosisComidaInicial, int diaIncremento, int dosisComidaDiaIncremento, int dosisComidaFinal) {
        List<Integer> dosisComida = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            dosisComida.add(dosisComidaInicial);
        }
        return dosisComida;
    }
}
