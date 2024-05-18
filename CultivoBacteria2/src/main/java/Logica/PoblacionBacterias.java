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
    private EstrategiaComida estrategiaComida;
    private int duracionExperimento;


    public PoblacionBacterias(String nombre, String fechaInicio, String fechaFin, int numeroInicialBacterias, int temperatura, String condicionesLuminosidad, int dosisComidaInicial, int diaIncremento, int dosisComidaDiaIncremento, int dosisComidaFinal, EstrategiaComida estrategiaComida) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroInicialBacterias = numeroInicialBacterias;
        this.temperatura = temperatura;
        this.condicionesLuminosidad = condicionesLuminosidad;
        this.dosisComidaInicial = dosisComidaInicial * 1000;
        this.diaIncremento = diaIncremento;
        this.dosisComidaDiaIncremento = dosisComidaDiaIncremento * 1000;
        this.dosisComidaFinal = dosisComidaFinal * 1000;
        this.estrategiaComida = estrategiaComida;
        this.dosisComida = calcularDosisComida();


    }

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

    public void setEstrategiaComida(EstrategiaComida estrategiaComida) {
        this.estrategiaComida = estrategiaComida;
    }

    private List<Integer> calcularDosisComida() {
        return estrategiaComida.calcularDosisComida(dosisComidaInicial, diaIncremento, dosisComidaDiaIncremento, dosisComidaFinal);
    }

    public int getDuracion() {
        if (fechaInicio != null && fechaFin != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
            LocalDate fin = LocalDate.parse(fechaFin, formatter);
            this.duracionExperimento = (int) ChronoUnit.DAYS.between(inicio, fin) + 1;
        }
        return duracionExperimento;
    }
}