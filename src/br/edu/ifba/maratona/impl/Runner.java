package br.edu.ifba.maratona.impl;


/**
 * classe para simular um corredor da maratona
 * a complexidade e constante O(1) pois não possui nenhum loop nem
 * nada que problematize a execução dos metodos.
 */

public class Runner implements Comparable<Runner> {

    private String id;
    private String name;

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

    @Override
    public String toString() {
        return "nome do corredor: " + name + ", id: " + id;
    }

    public int compareTo(Runner otherRunner) {
        int thisId = Integer.parseInt(this.getId());
        int otherId = Integer.parseInt(otherRunner.getId());
        return Integer.compare(thisId, otherId);
    }

}
