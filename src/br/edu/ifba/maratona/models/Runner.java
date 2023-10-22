package br.edu.ifba.maratona.models;

import java.util.ArrayList;
import java.util.List;

/**
 * classe para simular um corredor da maratona
 * a complexidade e constante O(1) pois não possui nenhum loop nem
 * nada que problematize a execução dos metodos.
 */

public class Runner implements Comparable<Runner> {

    private String id = "";
    private String name = "";
    private String finalTime = "";

    private List<Distance> allDistances = new ArrayList<>();
    private Distance lastDistance = null;

    public Runner(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Distance> getAllDistances() {
        return allDistances;
    }

    public void setAllDistances(List<Distance> allDistances) {
        this.allDistances = allDistances;
    }

    public Distance getLastDistance() {
        return lastDistance;
    }

    public void setLastDistance(Distance lastDistance) {
        this.lastDistance = lastDistance;
    }

    public void onRead(Distance read) {
        this.allDistances.add(read);
        this.lastDistance = read;
    }

    public String getFinalTime() {
        return finalTime;
    }

    public void setFinalTime() {
        int seconds = this.getLastDistance().getSeconds();
        String secondsString = (seconds < 10) ? "0" + seconds : String.valueOf(seconds);
        this.finalTime = String.valueOf(this.getLastDistance().getId()) + ":" + secondsString;
    }

    @Override
    public String toString() {
        return name + "- Tempo final: " + this.finalTime + " Minutos";
    }

    public int compareTo(Runner otherRunner) {
        String thisTime = this.getLastDistance().getFinalTime();
        String otherTime = otherRunner.getLastDistance().getFinalTime();
        return thisTime.compareTo(otherTime);
    }

}
