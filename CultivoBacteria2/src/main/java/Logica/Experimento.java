package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Experimento implements Serializable {
    private List<PoblacionBacterias> poblaciones;
    private int duracionExperimento;


    public Experimento(int duracionExperimento){
        this.poblaciones = new ArrayList<>();
        this.duracionExperimento = duracionExperimento;

    }

    public void agregarPoblacion(PoblacionBacterias poblacion) {
        if (poblacion.getDuracion() != duracionExperimento) {
            throw new IllegalArgumentException("La duración de la población debe ser de " + duracionExperimento + " días.");
        }
        this.poblaciones.add(poblacion);
    }

    public void eliminarPoblacion(PoblacionBacterias poblacion) {
        this.poblaciones.remove(poblacion);
    }
    public List<PoblacionBacterias> getPoblaciones() {
        return this.poblaciones;
    }
    public List<String> obtenerNombresPoblaciones() {
        List<String> nombres = new ArrayList<>();
        for (PoblacionBacterias poblacion : poblaciones) {
            nombres.add(poblacion.getNombre());
        }
        return nombres;
    }

    public PoblacionBacterias obtenerInformacionPoblacion(String nombre) {
        for (PoblacionBacterias poblacion : poblaciones) {
            if (poblacion.getNombre().equals(nombre)) {
                return poblacion;
            }
        }
        return null;
    }

    public void eliminarPoblacion(String nombre) {
        PoblacionBacterias poblacion = obtenerInformacionPoblacion(nombre);
        if (poblacion != null) {
            poblaciones.remove(poblacion);
        }
    }
}