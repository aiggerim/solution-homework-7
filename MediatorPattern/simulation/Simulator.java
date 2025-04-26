package MediatorPattern.simulation;

import MediatorPattern.aircraft.*;
import MediatorPattern.mediator.*;
import MediatorPattern.scheduler.FuelPriorityScheduler;

import java.util.*;
import java.util.concurrent.*;

public class Simulator {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        tower.setScheduler(new FuelPriorityScheduler());

        Random rand = new Random();
        List<Aircraft> aircraftList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int type = rand.nextInt(3);
            int fuel = rand.nextInt(20) + 1;
            Aircraft aircraft;

            if (type == 0)
                aircraft = new PassengerPlane("PAX-" + i, fuel, tower);
            else if (type == 1)
                aircraft = new CargoPlane("CARGO-" + i, fuel, tower);
            else
                aircraft = new Helicopter("HELI-" + i, fuel, tower);

            tower.register(aircraft);
            aircraftList.add(aircraft);
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            if (!aircraftList.isEmpty()) {
                Aircraft a = aircraftList.remove(0);
                System.out.println("✈️ " + a.getId() + " requesting runway (fuel: " + a.getFuelLevel() + ")");
                a.requestRunway();
            } else {
                tower.releaseRunway();
            }
        }, 0, 2, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            System.out.println("🛑 Simulation finished.");
            scheduler.shutdown();
        }, 30, TimeUnit.SECONDS);
    }
}
