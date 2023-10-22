package br.edu.ifba.maratona.borda.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import br.edu.ifba.maratona.borda.actuator.Actuator;
import br.edu.ifba.maratona.models.Runner;
import br.edu.ifba.maratona.nuvem.impl.SortImpl;

public class RunnerRanking implements Actuator<Runner, List<Runner>> {

    // BigO: O(n + NlogN) - Linear Time
    // O tempo de execução é diretamente proporcional ao número de corredores. Porem
    // o metodo ToSort() é O(NlogN)
    @Override
    public List<Runner> act(List<Runner> runners) {
        List<Runner> rankRunners = new ArrayList<>();
        int i = 1;
        for (Runner runner : runners) {
            rankRunners.add(runner);
        }
        RunnerRanking rank = new RunnerRanking();
        for (Runner runner : rank.act(rankRunners)) {
            System.out.println(i + "º Colocado : " + runner);
            i++;
        }
        SortImpl runnerSorter = new SortImpl(runners);
        runnerSorter.toSort();
        return runners;
    }
}
