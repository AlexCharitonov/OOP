package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Параллельное решение задачи.
 */
public class ThreadCheck {
    private static int countOfThreads = 1;
    private static final Object lock = new Object();

    /**
     * Сеттер для количества рабочих потоков.
     */
    public static void setCountOfThreads(int newCountOfThreads) {
        if (countOfThreads >= 1) {
            countOfThreads = newCountOfThreads;
        }
    }

    /**
     * Реализация потока, проверяющие вхождение составного числа в части массива.
     */
    private static class Threads extends Thread {
        private int[] array;
        private boolean res = false;
        private boolean done = false;

        /**
         * Constructs a Threads instance with the specified array.
         *
         * @param array the array of integers to check
         */
        Threads(int[] array) {
            this.array = array;
        }

        /**
         * Checks if the thread has completed execution.
         *
         * @return true if execution is complete, false otherwise
         */
        public boolean isDone() {
            return done;
        }

        /**
         * Gets the result of the check.
         *
         * @return true if a non-prime number was found, false otherwise
         */
        public boolean getResult() {
            return res;
        }

        /**
         * My {@code run} realisation.
         */
        @Override
        public void run() {
            for (int i = 0; i < array.length; i++) {
                if (array[i] < 2) {
                    done = true;
                    res = true;
                    synchronized (lock) {
                        lock.notify();
                    }
                    return;
                }
                for (int j = 2; j * j < array[i]; j++) {
                    if (array[i] % j == 0) {
                        break;
                    }
                }
            }
            done = true;
            synchronized (lock) {
                lock.notify();
            }
        }
    }

    /**
     * решение задачи.
     */
    public boolean findNotPrime(int [] numbers) {
        Threads[] threads = new Threads[countOfThreads];
        ArrayList<Integer> helper = new ArrayList<>();
        int end = 0;
        int step = numbers.length / countOfThreads;
        int rest = numbers.length % countOfThreads;
        if (rest != 0){
            step++;
        }
        for (int i = 0; i < countOfThreads; i++) {
            int start = end;
            end += step;
            if (end > numbers.length) {
                end = numbers.length;
            }
            int[] newArray = Arrays.copyOfRange(numbers, start, end);
            threads[i] = new Threads(newArray);
            helper.add(i);
            threads[i].start();
        }

        while (!helper.isEmpty()) {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                }
            }
            for (int i = 0; i < countOfThreads; i++) {
                if (threads[i] != null) {
                    if (threads[i].isDone()) {
                        if (threads[i].getResult()) {
                            for (int j = 0; j < countOfThreads; j++) {
                                if (threads[j] != null) {
                                    threads[j].interrupt();
                                }
                            }
                            return true;
                        } else {
                            threads[i] = null;
                            helper.remove(helper.size() - 1);
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void killThreads(Collection<Threads> threads) {
        for (Threads thread : threads) {
            thread.interrupt();
        }
    }
}