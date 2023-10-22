package br.edu.ifba.maratona.models;

/**
 * classe para simular a distancia percorrida tanto no minuto quanto no total de
 * um corredor.
 * a complexidade e constante O(1) pois não possui nenhum loop nem
 * nada que problematize a execução dos metodos.
 */

public class Distance {

    Integer id = 0;
    Integer distance = 0;
    Integer now = 0;
    Integer seconds = 0;
    String finalTime = "";

    boolean beatenRecord = false;

    boolean isWorldRecord = false;

    public Distance(Integer id, Integer distance, Integer now, Integer seconds) {
        this.id = id;
        this.distance = distance;
        this.now = now;
        this.seconds = seconds;
    }

    public Distance(Integer id, Integer distance, Integer now) {
        this.id = id;
        this.distance = distance;
        this.now = now;
    }

    public Distance(Integer distance, Integer now) {
        this.distance = distance;
        this.now = now;
    }

    public Distance(Integer now, boolean isWorldRecord) {
        this.now = now;
        this.isWorldRecord = isWorldRecord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getNow() {
        return now;
    }

    public void setNow(Integer now) {
        this.now = now;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    public String getFinalTime() {
        return finalTime;
    }

    public void setFinalTime() {
        this.finalTime = String.valueOf(id) + ":" + String.format("%02d", seconds);
    }

    public boolean isWorldRecord() {
        return isWorldRecord;
    }

    public void setWorldRecord(boolean isWorldRecord) {
        this.isWorldRecord = isWorldRecord;
    }

    public boolean isBeatenRecord() {
        return beatenRecord;
    }

    public void setBeatenRecord(boolean beatenRecord) {
        this.beatenRecord = beatenRecord;
    }

    @Override
    public String toString() {
        return "Distance runned in minute " + id + ": " + now + "\n Total distance : " + distance;
    }
}
