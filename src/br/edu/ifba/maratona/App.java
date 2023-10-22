package br.edu.ifba.maratona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.javafaker.Faker;

import java.util.Map.Entry;

import br.edu.ifba.maratona.borda.impl.RunnerRanking;
import br.edu.ifba.maratona.borda.impl.SensorImpl;
import br.edu.ifba.maratona.models.Runner;
import br.edu.ifba.maratona.nuvem.impl.ExecutorImpl;

public class App {

    private static final int CONTESTANTS = 10;
    private static final int MARATHON_LENGHT = 10000;

    private static List<Thread> executors = new ArrayList<>();
    private static Map<Runner, SensorImpl> runners = new HashMap<>();

    // BigO: O(n) - Linear Time
    // O tempo de execução é diretamente proporcional ao número de entradas.
    public static void initiallize(Map<Runner, SensorImpl> runners) {

        for (Entry<Runner, SensorImpl> item : runners.entrySet()) {
            Runner runner = item.getKey();
            SensorImpl sensors = item.getValue();

            Thread executor = new Thread(new ExecutorImpl(runner, sensors, MARATHON_LENGHT));
            executors.add(executor);
            executor.start();

        }
    }

    // BigO: O(n) - Linear Time
    // O tempo de execução é diretamente proporcional ao número de executores.
    public static void Wait() throws InterruptedException {
        for (Thread executor : executors) {
            executor.join();
        }
    }

    // BigO: O(n) - Linear Time
    // O tempo de execução é diretamente proporcional ao número de corredores.
    public static Map<Runner, SensorImpl> createRunners() {
        Faker faker = new Faker(Locale.forLanguageTag("pt-BR"));
        for (int i = 0; i < CONTESTANTS; i++) {
            Runner runner = new Runner(faker.code().ean13(), faker.name().fullName());
            runners.put(runner, new SensorImpl());
        }
        return runners;
    }

    // BigO: O(n + NlogN) - Linear Time
    // O tempo de execução é diretamente proporcional ao número de corredores. Porem
    // o metodo rank.act é NlogN.
    public static void createRanking() {
        List<Runner> rankRunners = new ArrayList<>();
        int i = 1;

        for (Entry<Runner, SensorImpl> item : runners.entrySet()) {
            Runner runner = item.getKey();
            rankRunners.add(runner);
        }
        RunnerRanking rank = new RunnerRanking();
        for (Runner runner : rank.act(rankRunners)) {
            System.out.println(i + "º Colocado : " + runner);
            i++;
        }
    }

    // BigO: O(n) - Linear Time
    // O tempo de execução é diretamente proporcional ao número de corredores.
    public static void main(String[] args) throws Exception {
        Map<Runner, SensorImpl> runners = createRunners();

        System.out.println("INITIALIZING");
        initiallize(runners);
        Wait();
        System.out.println("EVERYONE COMPLETED THE MARATHON");
        createRanking();

    }
}
