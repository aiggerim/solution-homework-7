# Airport Tower Simulator ✈️

## Part 2 – Mediator Pattern

This project implements an **Airport Control Tower Simulator** using the **Mediator Design Pattern** in Java.

Several aircraft (passenger planes, cargo planes, helicopters) request landing or takeoff permissions, and the `ControlTower` mediates all communication and scheduling, including emergency handling via MAYDAY protocol.

---

## 📦 Project Structure




---

## ✈️ How it works

- **Aircrafts** send runway requests to the **Control Tower**.
- If an aircraft has low fuel, it **automatically triggers MAYDAY**.
- Control Tower:
    - Broadcasts emergency messages to all aircrafts
    - Grants immediate landing to the emergency aircraft
    - Manages landing and takeoff queues (FIFO or by fuel level)
- **RunwayScheduler** strategy can be dynamically changed at runtime (e.g., `FuelPriorityScheduler`).

---

## 🧪 How to Run

1. Open the project in IntelliJ IDEA.
2. Run the `Simulator.java` file.
3. The console will display real-time runway management with planes requesting landings, MAYDAY emergencies, and runway scheduling.

> ✅ Requires Java 17+ or Java 21

---

## 🌐 UML Diagram

(Attach your generated UML diagram here as an image!)

Example:

![UML Diagram](MediatorPattern/MediatorDiagram.png)

---

## ✍️ Reflection: Why Mediator is Better

When designing systems with multiple interacting objects, direct communication between them can quickly become chaotic. Each object would need to know about every other object — leading to tight coupling and tangled dependencies.

**Mediator Pattern** advantages:
- **Centralized control logic** → easier maintenance.
- **Loose coupling** → aircrafts know only the tower, not each other.
- **Extendibility** → adding new aircraft types or coordination rules becomes trivial.

**Disadvantage:**
- Mediator can grow complex and become a "God Object" if not carefully managed.

Overall, Mediator offers scalability, extensibility, and a clean architecture for complex interaction management.

---

## 🚀 Stretch Goal Achieved

- ✅ Added **FuelPriorityScheduler** strategy.
- ✅ Tower dynamically switches runway allocation strategy at runtime.

Example:
```java
tower.setScheduler(new FuelPriorityScheduler());
