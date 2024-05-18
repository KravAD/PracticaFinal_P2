package Logica;

import java.util.ArrayList;
import java.util.List;

public class EstrategiaComidaLineal implements EstrategiaComida{
    @Override
    public List<Integer> calcularDosisComida(PoblacionBacterias poblacion) {
        List<Integer> dosisComida = new ArrayList<>();
        int dosisInicial = poblacion.getDosisComida().get(0);
        int dosisFinal = poblacion.getDosisComida().get(1);
        int incremento = (dosisFinal - dosisInicial) / (poblacion.getDuracion() - 1);
        for (int i = 0; i < poblacion.getDuracion(); i++) {
            dosisComida.add(dosisInicial + i * incremento);
        }
        return dosisComida;
    }
}
