package org.example;

public class InterruzioneThread {

    public static void main(String[] args) {

        // Creo e avvio il thread lavoratore
        WorkerThread worker = new WorkerThread();
        Thread t1 = new Thread(worker);
        t1.start();

        // Thread principale aspetta 10 secondi
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Thread principale interrotto.");
        }

        // Interrompe il thread lavoratore
        System.out.println("Invio interruzione al thread lavoratore...");
        t1.interrupt();
    }
}

// Classe che rappresenta il thread lavoratore
class WorkerThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Il thread sta lavorando...");
                Thread.sleep(2000); // Pausa di 2 secondi
            } catch (InterruptedException e) {
                System.out.println("Thread interrotto! Uscita dal ciclo.");
                break; // Uscita dal ciclo infinito
            }
        }

        System.out.println("Il thread ha terminato correttamente.");
    }
}
