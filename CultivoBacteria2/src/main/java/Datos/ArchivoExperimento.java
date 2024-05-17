package Datos;

import Logica.*;
import java.io.*;

public class ArchivoExperimento {
    private Experimento experimentoActual;

    public static void guardarExperimento(Experimento experimento, String nombreArchivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(experimento);
        }
    }

    public static Experimento cargarExperimento(String nombreArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (Experimento) ois.readObject();
        }
    }

}