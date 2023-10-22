package br.edu.ifba.maratona.borda.sort;

import java.util.List;

/**
 * classe que determina as funcionalidades do Sort, que ordena as leituras
 * a complexidade e constante O(1).
 */

public abstract class Sort<Sensor> {

    protected List<Sensor> totalDistances = null;

    public List<Sensor> getTotalDistances() {
        return totalDistances;
    }

    public Sort(List<Sensor> totalDistances) {
        this.totalDistances = totalDistances;
    }

    public abstract void toSort();

}