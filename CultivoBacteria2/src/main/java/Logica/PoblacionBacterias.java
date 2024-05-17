package Logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PoblacionBacterias implements Serializable {
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private int numeroInicialBacterias;
    private int temperatura;
    private String condicionesLuminosidad;
    private int dosisComidaInicial;
    private int diaIncremento;
    private int dosisComidaDiaIncremento;
    private int dosisComidaFinal;
    private List<Integer> dosisComida;

    public PoblacionBacterias(String nombre, String fechaInicio, String fechaFin, int numeroInicialBacterias, int temperatura, String condicionesLuminosidad, int dosisComidaInicial, int diaIncremento, int dosisComidaDiaIncremento, int dosisComidaFinal) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroInicialBacterias = numeroInicialBacterias;
        this.temperatura = temperatura;
        this.condicionesLuminosidad = condicionesLuminosidad;
        this.dosisComidaInicial = dosisComidaInicial;
        this.diaIncremento = diaIncremento;
        this.dosisComidaDiaIncremento = dosisComidaDiaIncremento;
        this.dosisComidaFinal = dosisComidaFinal;
        this.dosisComida = calcularDosisComida();    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public int getNumeroInicialBacterias() {
        return numeroInicialBacterias;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public String getCondicionesLuminosidad() {
        return condicionesLuminosidad;
    }

    public List<Integer> getDosisComida() {
        return dosisComida;
    }

    private List<Integer> calcularDosisComida() {
        List<Integer> dosisComida = new ArrayList<>();
        int incremento = (dosisComidaDiaIncremento - dosisComidaInicial) / diaIncremento;
        int decremento = (dosisComidaDiaIncremento - dosisComidaFinal) / (30 - diaIncremento);

        for (int i = 0; i < 30; i++) {
            if (i < diaIncremento) {
                dosisComida.add(dosisComidaInicial + incremento * i);
            } else {
                dosisComida.add(dosisComidaDiaIncremento - decremento * (i - diaIncremento));
            }
        }

        return dosisComida;
    }

    public int getDuracion() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
        LocalDate fin = LocalDate.parse(fechaFin, formatter);
        return (int) ChronoUnit.DAYS.between(inicio, fin);
    }
}