package Logica;

import Datos.ArchivoExperimento;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;

public class GestorExperimentos {
    private Experimento experimentoActual;

    public GestorExperimentos() {
        this.experimentoActual = null;
    }

    public void crearExperimento() {
        this.experimentoActual = new Experimento();
    }

    public void abrirExperimento() throws IOException, ClassNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            this.experimentoActual = ArchivoExperimento.cargarExperimento(selectedFile.getAbsolutePath());
        }
    }

    public void guardar(String nombreArchivo) throws IOException {
        ArchivoExperimento.guardarExperimento(this.experimentoActual, nombreArchivo);
    }

    public void guardarComo(String nuevoNombreArchivo) throws IOException {
        ArchivoExperimento.guardarExperimento(this.experimentoActual, nuevoNombreArchivo);
    }

    public Experimento getExperimentoActual() {
        return this.experimentoActual;
    }
}