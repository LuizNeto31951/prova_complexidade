package br.edu.ifba.maratona.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.maratona.op.Op;
import br.edu.ifba.maratona.sort.Sort;

public class OpImpl implements Op<Runner, Distance> {

    @Override
    public void print(List<Runner> runners) {
        for (Runner runner : runners) {
            System.out.println(runner);
        }
    }

    @Override
    public void print(Map<Runner, List<Distance>> distances) {
        for (Runner runner : distances.keySet()) {
            System.out.println("Distance per minute of " + runner.getName());
            for (Distance time : distances.get(runner)) {
                System.out.println(time);
            }
        }
    }

    @Override
    public Map<Runner, List<Distance>> sort(Map<Runner, List<Distance>> distances) {
        Map<Runner, List<Distance>> sortedDistances = new TreeMap<>();

        for (Runner runner : distances.keySet()) {
            System.out.println("Sorting distances" + runner.getName());

            List<Distance> unsortedDistances = distances.get(runner);
            Sort<Distance> sorting = new SortImpl(unsortedDistances);
            sorting.toSort();

            sortedDistances.put(runner, unsortedDistances);
        }

        return sortedDistances;
    }

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
