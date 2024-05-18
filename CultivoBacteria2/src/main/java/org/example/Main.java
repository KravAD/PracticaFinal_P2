package org.example;
import IU.*;
import Montecarlo.Simulacion;

public class Main {
    public static void main(String[] args) {
        new Interfaz();

        Simulacion simulacion = new Simulacion( 30);
        new InterfazMontecarlo(simulacion);

    }
}