package br.edu.ifba.maratona.op;

import java.util.List;
import java.util.Map;

/**
 * classe que determina as operações que vão ser realizadas no programa
 * a complexidade e constante O(1), pois não existe nenhum loop nem nada do tipo.
 */

public interface Op<People, Sensor> {

    // d.1
    public void print(List<People> runners);

    // d.2
    public void print(Map<People, List<Sensor>> distances);

    // d.3
    public Map<People, List<Sensor>> sort(Map<People, List<Sensor>> distances);
    
    // d.4
    public boolean recordCheck(Map<People, List<Sensor>> distances, List<Sensor> records);
}
