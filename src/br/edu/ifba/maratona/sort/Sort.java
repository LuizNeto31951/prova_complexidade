package br.edu.ifba.maratona.sort;

import java.util.List;

public abstract class Sort<Sensor> {
    
    protected List<Sensor> totalDistances = null;

    public List<Sensor> getTotalDistances() {
        return totalDistances;
    }

    public Sort(List<Sensor> totalDistances){
        this.totalDistances = totalDistances;
    }
    
    public abstract void toSort();

}
