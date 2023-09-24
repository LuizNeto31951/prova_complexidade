package br.edu.ifba.maratona.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.maratona.op.Op;
import br.edu.ifba.maratona.sort.Sort;

public class OpImpl implements Op<Runner, Distance> {


    /**
     * imprime uma lista dos corredores da maratona
     * 
     * a complexidade deste metodo e linear O(N), porque o total de passos de execução
     * cresce de acordo a quantidade de corredores
     */

    @Override
    public void print(List<Runner> runners) {
        for (Runner runner : runners) {
            System.out.println(runner);
        }
    }

    /**
     * imprime uma lista dos corredores da maratona e a distancia percorrida por minuto bem como a total,
     * 
     * a complexidade deste metodo e quadratica O(N²), porque existe um loop for dentro de outro loop for
     * consequentemente aumentando quadraticamente o tempo de execução do codigo com base na quantidade de dados.
     */

    @Override
    public void print(Map<Runner, List<Distance>> distances) {
        for (Runner runner : distances.keySet()) {
            System.out.println("Distance per minute of " + runner.getName());
            for (Distance time : distances.get(runner)) {
                System.out.println(time);
            }
        }
    }

    /**
     * realiza a ordenacao das distancias percorridas para cada corredor
     * 
     * a complexidade deste metodo é O(N²LOGN), porque existe um loop que 
     * ealiza uma chamada ao algoritmo de ordenacao cuja complexidade é
     * O(NLogN)
     */

    @Override
    public Map<Runner, List<Distance>> sort(Map<Runner, List<Distance>> distances) {
        Map<Runner, List<Distance>> sortedDistances = new TreeMap<>();

        for (Runner runner : distances.keySet()) {
            System.out.println("Sorting distances for ruuner : " + runner.getName());

            List<Distance> unsortedDistances = distances.get(runner);
            Sort<Distance> sorting = new SortImpl(unsortedDistances);
            sorting.toSort();

            sortedDistances.put(runner, unsortedDistances);
        }

        return sortedDistances;
    }

    /**
     * esta metodo verifica se algum recorde local ou mundial foi batido na corrida.
     * 
     * a complexidade é cubica O(N³), porque existem 3 loops for dentros um do outro
     * 
     * dependendo do tamanho da maratona e da quantidade de corredores o algoritimo pode
     * ocasionar uma situação de brute force, pois teriam muitas leituras a serem monitoradas
     * com uma quantidade de dados muito grande para executar a verificação.
     **/

    @Override
    public boolean recordCheck(Map<Runner, List<Distance>> distances, List<Distance> records) {
        boolean isRecord = false;
        for (Runner runner : distances.keySet()) {
            System.out.println("Checking for record in runner: " + runner.getName());
            List<Distance> metrics = distances.get(runner);
            for (Distance metric : metrics) {
                for (Distance record : records) {
                    if (metric.getNow() > record.getNow()) {
                        if (record.isWorldRecord) {
                            System.out.println("YES!!! THE WORLD RECORD HAS BEEN BEATEN! Meters/m = " + metric.getNow());
                            record.setNow(metric.getNow());
                        } else {
                            System.out.println("Nice! the local record has been beaten! Meters/m =" + metric.getNow());
                            record.setNow(metric.getNow());
                            isRecord = true;
                        }
                    }
                }
            }
        }
        return isRecord;
    }

}
