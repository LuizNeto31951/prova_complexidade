package br.edu.ifba.maratona.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.maratona.sort.Sort;

/**
 * classe que executa a ordenação dos corredores a das distancias percorridas.
 * 
 * o algoritmo foi adaptado a partir do que se encontra disponibilizado em:
 * https://www.delftstack.com/howto/java/merge-sort-arraylist-java/
 * 
 * A complexidade, como se trata de um algoritimo de MergeSort, é de O(NlogN) pois
 * Ele divide a lista em duas metades, classifica cada metade de forma independente e, 
 * em seguida, mescla as duas metades ordenadas em uma única lista ordenada.
 */

public class SortImpl extends Sort<Distance> {

    public SortImpl(List<Distance> totalDistances) {
        super(totalDistances);
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
        List<Distance> tempDistances = new ArrayList<>(end - start + 1);
    
        int left = start;
        int right = middle + 1;
    
        while (left <= middle && right <= end) {
            if (totalDistances.get(left).getNow() <= totalDistances.get(right).getNow()) {
                tempDistances.add(totalDistances.get(left));
                left++;
            } else {
                tempDistances.add(totalDistances.get(right));
                right++;
            }
        }
    
        while (left <= middle) {
            tempDistances.add(totalDistances.get(left));
            left++;
        }
        while (right <= end) {
            tempDistances.add(totalDistances.get(right));
            right++;
        }
    
        for (int i = start, j = 0; i <= end; i++, j++) {
            totalDistances.set(i, tempDistances.get(j));
        }
    }
    

}
