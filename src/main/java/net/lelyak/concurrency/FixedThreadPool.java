package net.lelyak.concurrency;

//: net.lelyak.concurrency/FixedThreadPool.java

import java.util.concurrent.*;

public class FixedThreadPool {
    public static void main(String[] args) {

        // Constructor argument is number of threads:
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
} 
