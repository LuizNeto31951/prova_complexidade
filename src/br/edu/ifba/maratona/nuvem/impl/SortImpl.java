package br.edu.ifba.maratona.borda.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.maratona.borda.sort.Sort;
import br.edu.ifba.maratona.models.Runner;

/**
 * classe que executa a ordenação dos corredores a das distancias percorridas.
 * 
 * o algoritmo foi adaptado a partir do que se encontra disponibilizado em:
 * https://www.delftstack.com/howto/java/merge-sort-arraylist-java/
 * 
 * A complexidade, como se trata de um algoritimo de MergeSort, é de O(NlogN)
 * pois
 * Ele divide a lista em duas metades, classifica cada metade de forma
 * independente e,
 * em seguida, mescla as duas metades ordenadas em uma única lista ordenada.
 */

public class SortImpl extends Sort<Runner> {

    public SortImpl(List<Runner> runners) {
        super(runners);
    }

    @Override
    public void toSort() {
        toSort(0, totalDistances.size() - 1);
    }

    public void toSort(int start, int end) {
        if (start < end && (end - start) >= 1) {
            int middle = (end + start) / 2;

            toSort(start, middle);
            toSort(middle + 1, end);

            merge(start, middle, end);
        }
    }

    private void merge(int start, int middle, int end) {
        List<Runner> tempRunners = new ArrayList<>(end - start + 1);

        int left = start;
        int right = middle + 1;

        while (left <= middle && right <= end) {
            if (totalDistances.get(left).compareTo(totalDistances.get(right)) <= 0) {
                tempRunners.add(totalDistances.get(left));
                left++;
            } else {
                tempRunners.add(totalDistances.get(right));
                right++;
            }
        }

        while (left <= middle) {
            tempRunners.add(totalDistances.get(left));
            left++;
        }
        while (right <= end) {
            tempRunners.add(totalDistances.get(right));
            right++;
        }

        for (int i = start, j = 0; i <= end; i++, j++) {
            totalDistances.set(i, tempRunners.get(j));
        }
    }
}
