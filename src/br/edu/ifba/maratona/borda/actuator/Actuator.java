package br.edu.ifba.maratona.borda.actuator;

import java.util.List;

/**
 * classe que determina as funcionalidades do Actuator
 * a complexidade e constante O(1).
 */

public interface Actuator<Readings, Result> {

    Result act(List<Readings> readings);

}
