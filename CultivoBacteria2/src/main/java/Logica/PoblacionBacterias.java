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
    private List<Integer> dosisComida;

    public PoblacionBacterias(String nombre, String fechaInicio, String fechaFin, int numeroInicialBacterias, int temperatura, String condicionesLuminosidad, int dosisComidaInicial, int diaIncremento, int dosisComidaDiaIncremento, int dosisComidaFinal) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroInicialBacterias = numeroInicialBacterias;
        this.temperatura = temperatura;
        this.condicionesLuminosidad = condicionesLuminosidad;
        this.dosisComida = calcularDosisComida(dosisComidaInicial, diaIncremento, dosisComidaDiaIncremento, dosisComidaFinal);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getNumeroInicialBacterias() {
        return numeroInicialBacterias;
    }

    public void setNumeroInicialBacterias(int numeroInicialBacterias) {
        this.numeroInicialBacterias = numeroInicialBacterias;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getCondicionesLuminosidad() {
        return condicionesLuminosidad;
    }

    public void setCondicionesLuminosidad(String condicionesLuminosidad) {
        this.condicionesLuminosidad = condicionesLuminosidad;
    }

    public List<Integer> getDosisComida() {
        return dosisComida;
    }

    public void setDosisComida(List<Integer> dosisComida) {
        this.dosisComida = dosisComida;
    }

    private List<Integer> calcularDosisComida(int dosisComidaInicial, int diaIncremento, int dosisComidaDiaIncremento, int dosisComidaFinal) {
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