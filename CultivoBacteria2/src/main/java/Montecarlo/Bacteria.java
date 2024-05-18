package Montecarlo;

public class Bacteria {
    private int comidaIngerida;
    private Celda celdaActual;

    public Bacteria(){
        this.comidaIngerida = comidaIngerida;
    }

    public void mover(){

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

    }

}
