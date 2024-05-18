package Logica;

import java.util.ArrayList;
import java.util.List;

public class EstrategiaComidaAlternante implements EstrategiaComida{
    @Override
    public List<Integer> calcularDosisComida(int dosisComidaInicial, int diaIncremento, int dosisComidaDiaIncremento, int dosisComidaFinal) {
        List<Integer> dosisComida = new ArrayList<>();
        for (int i = 0; i < diaIncremento; i++) {
            if (i % 2 == 0) {
                dosisComida.add(dosisComidaInicial);
            } else {
                dosisComida.add(0);
            }
        }
        return dosisComida;
    }
}
