package br.edu.ifba.maratona.nuvem.impl;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifba.maratona.borda.impl.SensorImpl;
import br.edu.ifba.maratona.models.Distance;
import br.edu.ifba.maratona.models.Runner;
import br.edu.ifba.maratona.nuvem.executor.Executor;

public class ExecutorImpl extends Executor {

    int marathonLenght = 0;

    Runner runner = null;
    SensorImpl sensors = null;
    List<Distance> records = new ArrayList<>();

    public ExecutorImpl(Runner runner, SensorImpl sensors, int marathonLenght) {
        super(marathonLenght);
        this.marathonLenght = marathonLenght;
        this.runner = runner;
        this.sensors = sensors;
        records.add(new Distance(400, false));
        records.add(new Distance(435, true));
    }

    // BigO: O(1)
    // Não possui loops nem nada que incremente exponencialmente o tempo de
    // execução.
    @Override
    public int processDistance(int minute) {

        Distance read = sensors.createRun(marathonLenght, records);
        runner.onRead(read);
        runner.getLastDistance().setFinalTime();
        runner.setFinalTime();
        System.out.println("START OF MINUTE : " + minute + " OF RUNNER " + runner.getName() + "\n TOTAL RUNNED : "
                + runner.getLastDistance().getDistance() + " DISTANCE RUNNED THIS MINUTE : "
                + runner.getLastDistance().getNow());
        if (runner.getLastDistance().isBeatenRecord()) {
            System.out.println("CONGRATS : " + runner.getName());
        }

        return runner.getLastDistance().getNow();
    }

}
