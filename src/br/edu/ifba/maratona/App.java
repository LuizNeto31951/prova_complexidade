package br.edu.ifba.maratona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifba.maratona.impl.Distance;
import br.edu.ifba.maratona.impl.OpImpl;
import br.edu.ifba.maratona.impl.Runner;
import br.edu.ifba.maratona.impl.SensorImpl;
import br.edu.ifba.maratona.op.Op;
import br.edu.ifba.maratona.sensor.Sensor;

public class App {

    private static final int CONTESTANTS = 10;
    private static final int MARATHON_LENGHT = 5000;

    /**
     * complexidade linear, O(N), porque tem um for que depende
     * do total de corredores na maratona.
     */
    public static void main(String[] args) throws Exception {
        Op<Runner, Distance> operations = new OpImpl();
        Sensor<Distance> sensor = new SensorImpl();
        Map<Runner, List<Distance>> distanceRunnedPerRunner = new HashMap<>();

        for (int i = 0; i < CONTESTANTS; i++) {
            String id = (i + 1) + "";
            distanceRunnedPerRunner.put(new Runner(id, "Runner #" + id), sensor.createRun(MARATHON_LENGHT));
        }

        // d.1
        // operations.print(new ArrayList<Runner>(distanceRunnedPerRunner.keySet()));

        // d.2
        // operations.print(distanceRunnedPerRunner);

        // d.3
        Map<Runner, List<Distance>> sortedDistances = operations.sort(distanceRunnedPerRunner);
        operations.print(sortedDistances);

        // d.4
        List<Distance> records = new ArrayList<>();
        records.add(new Distance(400, false));
        records.add(new Distance(435, true));

        boolean newRecord = operations.recordCheck(sortedDistances, records);
        if (newRecord) {
            System.out.println("Congrats!!!");
        } else {
            System.out.println("No records set !");
        }
    }
}
