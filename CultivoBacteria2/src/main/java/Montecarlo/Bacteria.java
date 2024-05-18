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
