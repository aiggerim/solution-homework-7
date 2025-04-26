package MediatorPattern.mediator;

import MediatorPattern.aircraft.Aircraft;

public interface TowerMediator {
    void broadcast(String msg, Aircraft sender);
    boolean requestRunway(Aircraft a);
    void mayday(Aircraft a);
}

