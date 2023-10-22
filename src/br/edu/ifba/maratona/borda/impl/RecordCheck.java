package br.edu.ifba.maratona.borda.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.maratona.borda.actuator.Actuator;
import br.edu.ifba.maratona.models.Distance;

public class RecordCheck implements Actuator<Distance, Boolean> {

    List<Distance> trackRecords = new ArrayList<>();

    public RecordCheck(List<Distance> trackRecords) {
        this.trackRecords = trackRecords;
    }
    //Big O(N²)
    //O Metodo possui um loop for dentro de outro e portanto
    //o tempo de execução depende do tamanho das listas
    @Override
    public Boolean act(List<Distance> distances) {
        boolean isRecord = false;
        for (Distance distance : distances) {
            for (Distance record : trackRecords) {
                if (distance.getNow() > record.getNow()) {
                    if (record.isWorldRecord()) {
                        System.out
                                .println("YES!!! THE WORLD RECORD HAS BEEN BEATEN! Meters/m = " + distance.getNow());
                        record.setNow(distance.getNow());
                        record.setWorldRecord(true);
                    } else {
                        System.out.println("Nice! the local record has been beaten! Meters/m =" + distance.getNow());
                        record.setNow(distance.getNow());
                    }
                    isRecord = true;
                }
            }
        }
        return isRecord;
    }

}
