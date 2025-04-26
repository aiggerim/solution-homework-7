package MediatorPattern.mediator;

import MediatorPattern.aircraft.Aircraft;

import java.util.*;

public class ControlTower implements TowerMediator {
    private final List<Aircraft> allAircraft = new ArrayList<>();
    private final Queue<Aircraft> landingQueue = new LinkedList<>();
    private final Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private Aircraft runwayInUse = null;

    public void register(Aircraft aircraft) {
        allAircraft.add(aircraft);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        for (Aircraft a : allAircraft) {
            if (!a.equals(sender)) {
                a.receive(sender.getId() + ": " + msg);
            }
        }
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (runwayInUse == null) {
            runwayInUse = a;
            System.out.println("✅ Runway granted to " + a.getId());
            return true;
        } else {
            landingQueue.add(a);
            System.out.println("🕓 " + a.getId() + " added to landing queue");
            return false;
        }
    }

    @Override
    public void mayday(Aircraft a) {
        System.out.println("🚨 MAYDAY from " + a.getId());

        if (runwayInUse != null && !runwayInUse.equals(a)) {
            landingQueue.add(runwayInUse);
            System.out.println("⚠️ Forcing " + runwayInUse.getId() + " to yield runway");
        }

        broadcast("Emergency declared by " + a.getId(), a);
        runwayInUse = a;
        System.out.println("✅ EMERGENCY LANDING GRANTED to " + a.getId());
    }

    public void releaseRunway() {
        if (runwayInUse != null) {
            System.out.println("🛬 " + runwayInUse.getId() + " has cleared the runway");
            runwayInUse = null;
        }

        if (!landingQueue.isEmpty()) {
            Aircraft next = landingQueue.poll();
            System.out.println("🛫 Granting runway to next: " + next.getId());
            runwayInUse = next;
        }
    }
}

