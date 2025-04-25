package MediatorPattern.aircraft;

import MediatorPattern.mediator.TowerMediator;

public class Helicopter extends Aircraft {
    public Helicopter(String id, int fuel, TowerMediator tower) {
        super(id, fuel, tower);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[Helicopter " + id + "] received: " + msg);
    }
}

