package MediatorPattern.scheduler;

import MediatorPattern.aircraft.Aircraft;

import java.util.Queue;

public class FifoScheduler implements RunwayScheduler {
    @Override
    public Aircraft selectNext(Queue<Aircraft> queue) {
        return queue.poll(); // стандартная очередь
    }
}
