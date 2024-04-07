package com.belstu.threads;

import java.util.concurrent.Semaphore;

class Plane implements Runnable {
    private final int id;
    private final Semaphore terminals;
    private final Semaphore traps;

    public Plane(int id, Semaphore terminals, Semaphore traps) {
        this.id = id;
        this.terminals = terminals;
        this.traps = traps;
    }

    @Override
    public void run() {
        try {
            System.out.println("Самолет " + id + " готовится к посадке/высадке пассажиров.");

            terminals.acquire();
            System.out.println("Самолет " + id + " начал посадку/высадку пассажиров через терминал.");
            Thread.sleep(2000);
            terminals.release();

            traps.acquire();
            System.out.println("Самолет " + id + " начал посадку/высадку пассажиров через трап.");
            Thread.sleep(2000);
            traps.release();

            System.out.println("Самолет " + id + " завершил посадку/высадку пассажиров.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}