package Logica;

import java.util.ArrayList;
import java.util.List;

public class EstrategiaComidaAlternante implements EstrategiaComida{
    @Override
    public List<Integer> calcularDosisComida(PoblacionBacterias poblacion) {
        List<Integer> dosisComida = new ArrayList<>();
        for (int i = 0; i < poblacion.getDuracion(); i++) {
            if (i % 2 == 0) {
                dosisComida.add(poblacion.getDosisComida().get(0));
            } else {
                dosisComida.add(0);
            }
        }
        return dosisComida;
    }
}
