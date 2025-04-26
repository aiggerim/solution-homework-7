package MediatorPattern.scheduler;

import MediatorPattern.aircraft.Aircraft;

import java.util.Queue;

public interface RunwayScheduler {
    Aircraft selectNext(Queue<Aircraft> queue);
}
