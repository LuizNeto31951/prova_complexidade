package br.edu.ifba.maratona.borda.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import br.edu.ifba.maratona.borda.sensor.Sensor;
import br.edu.ifba.maratona.models.Distance;

public class SensorImpl implements Sensor<Distance> {

    private static final int AVARAGE_SPEED = 352;
    private static final int MAX_OSCILATION = 50;

    private static final int LIMIT_OF_READINGS = 20;

    private Queue<Distance> lastReadings = new LinkedList<>();

    Distance runnedDistance = new Distance(0, 0, 0);
    int distanceId = 0;
    RecordCheck record = null;

    /**
     * gerador da corrida de cada maratonista,
     * A complexidade é linarO(N²), porque agora executa o metodo act
     * portanto assim, aliviando o processamento da nuvem
     */
    @Override
    public Distance createRun(int marathonLenght, List<Distance> recordCheck) {
        this.record = new RecordCheck(recordCheck);
        int speed = 0;
        Random randomizer = new Random();
        int seconds = randomizer.nextInt(60);
        int oscilation = AVARAGE_SPEED * randomizer.nextInt(MAX_OSCILATION) / 100;
        speed = (randomizer.nextBoolean() ? AVARAGE_SPEED + oscilation : AVARAGE_SPEED - oscilation);
        distanceId++;
        if (runnedDistance.getDistance() + speed < marathonLenght) {
            runnedDistance = new Distance(distanceId, runnedDistance.getDistance() + speed, speed, seconds);
            lastReadings.add(runnedDistance);
        } else {
            runnedDistance = new Distance(distanceId, marathonLenght, speed, seconds);
            lastReadings.add(runnedDistance);
        }

        if (lastReadings.size() > LIMIT_OF_READINGS) {
            lastReadings.remove();
        }
        List<Distance> distancesList = new ArrayList<>();
        distancesList.addAll(lastReadings);

        runnedDistance.setBeatenRecord(new RecordCheck(recordCheck).act(distancesList));

        return runnedDistance;
    }

}