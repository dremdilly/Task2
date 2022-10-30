package example;

import java.util.LinkedList;
import java.util.Queue;

public class MultithreadQueue<T> {
    private final Queue<T> queue;

    public MultithreadQueue() {
        queue = new LinkedList<>();
    }

    public synchronized void add(T e) {
        queue.add(e);
        notify();
    }

    public synchronized T pop() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.poll();
    }

    public synchronized int size() {
        return queue.size();
    }
}
