package MediatorPattern;

import MediatorPattern.TowerMediator;

public abstract class Aircraft {
    protected String id;
    protected int fuelLevel;
    protected TowerMediator tower;

    public Aircraft(String id, int fuelLevel, TowerMediator tower) {
        this.id = id;
        this.fuelLevel = fuelLevel;
        this.tower = tower;
    }

    public String getId() {
        return id;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void send(String msg) {
        tower.broadcast(msg, this);
    }

    public void requestRunway() {
        if (fuelLevel < 10) {
            System.out.println(id + " LOW FUEL! Sending MAYDAY");
            tower.mayday(this);
        } else {
            boolean granted = tower.requestRunway(this);
            if (!granted) {
                System.out.println(id + " waiting for runway...");
            }
        }
    }

    public abstract void receive(String msg);
}
