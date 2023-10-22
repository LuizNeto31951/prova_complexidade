package br.edu.ifba.maratona.borda.sensor;

import java.util.List;

/**
 * classe que determina as funcionalidades do sensor, que atualmente gera
 * leituras
 * a complexidade e constante O(1). pois não existe nenhum loop nem nada do
 * tipo.
 */

public interface Sensor<Distance> {

    public Distance createRun(int marathonLenght, List<Distance> recordCheck);

    public void createRanking();
}
