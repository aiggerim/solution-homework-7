package MediatorPattern.aircraft;

import MediatorPattern.mediator.TowerMediator;

public class CargoPlane extends Aircraft {
    public CargoPlane(String id, int fuel, TowerMediator tower) {
        super(id, fuel, tower);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[CargoPlane " + id + "] received: " + msg);
    }
}

