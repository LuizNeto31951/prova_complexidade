package br.edu.ifba.maratona.sensor;

import java.util.List;

public interface Sensor<Distance> {
    
    public List<Distance> createRun(int marathonLenght);

}
