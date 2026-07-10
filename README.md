# Elevator Simulator

A Java simulation of an elevator system, built to explore object-oriented design,
state machines, and scheduling logic.

This project is a work in progress, developed in stages. Each stage is a complete,
runnable step that builds on the last.

## Current features

- A single elevator modeled as a **state machine** (`IDLE`, `MOVING_UP`, `MOVING_DOWN`, `DOORS_OPEN`)
- A **nearest-stop scheduler**: given several requested floors, the elevator always
  serves the closest one next
- A tick-based **simulation loop** that advances time one step at a time and reports
  the elevator's position and state

## Planned

- Multiple elevators coordinated by a dispatcher
- Pluggable scheduling strategies
- Performance measurement (average passenger wait time)
- Unit tests (JUnit)

## How to run

Compile all source files, then run `Main`:

```bash
javac *.java
java Main
```

## Example output

```
Tick 0: Floor 1 [MOVING_UP]
Tick 1: Floor 2 [DOORS_OPEN]
Tick 2: Floor 3 [MOVING_UP]
Tick 3: Floor 4 [MOVING_UP]
Tick 4: Floor 5 [DOORS_OPEN]
Tick 5: Floor 6 [MOVING_UP]
Tick 6: Floor 7 [MOVING_UP]
Tick 7: Floor 8 [DOORS_OPEN]
```

The elevator starts at floor 0 with requests for floors 5, 2, and 8, and serves them
in nearest-first order: 2, then 5, then 8.

## Project structure

| File | Responsibility |
|------|----------------|
| `Elevator.java` | The elevator: tracks floor and state, decides movement, serves stops |
| `ElevatorState.java` | Enum of the four elevator states |
| `Main.java` | Driver: sets up the scenario, runs the simulation loop, prints output |

## Built with

- Java 25
- No external dependencies
