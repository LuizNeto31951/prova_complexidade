package br.edu.ifba.maratona.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ifba.maratona.sensor.Sensor;

public class SensorImpl implements Sensor<Distance> {

    private static final int AVARAGE_SPEED = 352;
    private static final int MAX_OSCILATION = 25;

    /**
     * gerador da corrida de cada maratonista,
     * A complexidade é linarO(N),porque tem um loop do/while
     * que continua até o maratonista terminar a corrida.
     */

    @Override
    public List<Distance> createRun(int marathonLenght) {
        List<Distance> distanceChart = new ArrayList<>();
        Distance total = new Distance(0, 0, 0);
        int speed = 0;
        int distanceId = 0;

        Random randomizer = new Random();
        do {
            int oscilation = AVARAGE_SPEED * randomizer.nextInt(MAX_OSCILATION) / 100;
            speed = (randomizer.nextBoolean() ? AVARAGE_SPEED + oscilation : AVARAGE_SPEED - oscilation);
            distanceId++;
            if (total.getDistance() + speed < marathonLenght) {
                total = new Distance(distanceId, total.getDistance() + speed, speed);
            } else {
                total = new Distance(distanceId, marathonLenght, speed);
            }
            distanceChart.add(total);
        } while (total.getDistance() < marathonLenght);
        return distanceChart;
    }

}