package MediatorPattern.scheduler;

import MediatorPattern.aircraft.Aircraft;

import java.util.*;

public class FuelPriorityScheduler implements RunwayScheduler {
    @Override
    public Aircraft selectNext(Queue<Aircraft> queue) {
        return queue.stream()
                .min(Comparator.comparingInt(Aircraft::getFuelLevel))
                .map(a -> {
                    queue.remove(a);
                    return a;
                })
                .orElse(null);
    }
}
