package Montecarlo;

import java.util.ArrayList;
import java.util.List;

public class Celda {
    private int comida;
    private List<Bacteria> bacterias;

    public Celda(){
        this.comida = comida;
        this.bacterias = new ArrayList<Bacteria>();
    }

    public int getComida() {
        return comida;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    public List<Bacteria> getBacterias() {
        return bacterias;
    }

    public void setBacterias(List<Bacteria> bacterias) {
        this.bacterias = bacterias;
    }
}
