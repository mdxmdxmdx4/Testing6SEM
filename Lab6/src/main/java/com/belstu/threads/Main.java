package com.belstu.threads;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int totalPlanes = 10;
        int totalTerminals = 5;
        int totalTraps = 3;

        Semaphore terminals = new Semaphore(totalTerminals, true);
        Semaphore traps = new Semaphore(totalTraps, true);

        ExecutorService executor = Executors.newFixedThreadPool(totalPlanes);

        for (int i = 1; i <= totalPlanes; i++) {
            executor.execute(new Plane(i, terminals, traps));
        }

        executor.shutdown();
    }
}