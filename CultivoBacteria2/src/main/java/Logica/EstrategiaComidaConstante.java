package Logica;

import java.util.ArrayList;
import java.util.List;

public class EstrategiaComidaConstante implements EstrategiaComida{
    @Override
    public List<Integer> calcularDosisComida(PoblacionBacterias poblacion) {
        List<Integer> dosisComida = new ArrayList<>();
        for (int i = 0; i < poblacion.getDuracion(); i++) {
            dosisComida.add(poblacion.getDosisComida().get(0));
        }
        return dosisComida;
    }
}
