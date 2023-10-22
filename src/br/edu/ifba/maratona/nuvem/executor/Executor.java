package br.edu.ifba.maratona.nuvem.executor;

public abstract class Executor implements Runnable {

    int marathonLength = 0;
    int nowDistance = 0;

    public Executor(int marathonLength) {
        this.marathonLength = marathonLength;
    }

    /**
     * metodo que rege a execução das threads
     * a complexidade e linear O(N). onde N é baseado no tamanho da maratona,
     * quanto maior a distancia maior o processamento
     */

    public void run() {
        int minute = 0;
        while (nowDistance < marathonLength) {
            minute++;
            nowDistance += processDistance(minute);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract int processDistance(int minute);
}
