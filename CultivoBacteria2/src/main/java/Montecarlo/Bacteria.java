package Montecarlo;

import java.util.Random;

public class Bacteria {
    private int comidaIngerida;
    private Celda celdaActual;

    public Bacteria(){
        this.comidaIngerida = comidaIngerida;
    }

    public int getComidaIngerida() {
        return comidaIngerida;
    }

    public void setComidaIngerida(int comidaIngerida) {
        this.comidaIngerida = comidaIngerida;
    }

    public Celda getCeldaActual() {
        return celdaActual;
    }

    public void setCeldaActual(Celda celdaActual) {
        this.celdaActual = celdaActual;
    }

    public int generarNumeroAleatorio() {
        Random rand = new Random();
        return rand.nextInt(101);
    }

    public void mover(){
        int numeroAleatorio = generarNumeroAleatorio();
        int direccion = -1;

        if (celdaActual.getComida() >= 100) {
            if (numeroAleatorio >= 60 && numeroAleatorio < 100) {
                direccion = (numeroAleatorio - 60) / 5;
            }
        } else if (celdaActual.getComida() > 9) {
            if (numeroAleatorio >= 20 && numeroAleatorio < 100) {
                direccion = (numeroAleatorio - 20) / 10;
            }
        } else {
            if (numeroAleatorio >= 60 && numeroAleatorio < 100) {
                direccion = (numeroAleatorio - 60) / 5;
            }
        }

        if (direccion != -1) {
            celdaActual.moverBacteria(this, direccion);
        }
    }
    public void comer(){
        int comidaDisponible = celdaActual.getComida();
        if (comidaDisponible >= 100) {
            celdaActual.setComida(comidaDisponible - 20);
            this.comidaIngerida += 20;
        } else if (comidaDisponible > 9) {
            celdaActual.setComida(comidaDisponible - 10);
            this.comidaIngerida += 10;
        }
    }
    public void reproducir(){
        if (comidaIngerida >= 150) {
            for (int i = 0; i < 3; i++) {
                celdaActual.getBacterias().add(new Bacteria());
            }
        } else if (comidaIngerida >= 100) {
            for (int i = 0; i < 2; i++) {
                celdaActual.getBacterias().add(new Bacteria());
            }
        } else if (comidaIngerida >= 50) {
            celdaActual.getBacterias().add(new Bacteria());
        }
    }

}
