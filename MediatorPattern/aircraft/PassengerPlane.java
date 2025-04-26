package MediatorPattern.aircraft;

import MediatorPattern.mediator.TowerMediator;

public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id, int fuel, TowerMediator tower) {
        super(id, fuel, tower);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[PassengerPlane " + id + "] received: " + msg);
    }
}
