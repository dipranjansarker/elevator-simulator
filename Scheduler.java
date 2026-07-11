import java.util.List;

public class Scheduler{
    private Building building;
    
    public Scheduler(Building building){
        this.building = building;
    }

    public Elevator handleRequest(int requestFloor){
        Elevator chosen = chooseElevator(requestFloor);
        chosen.addStop(requestFloor);
        return chosen;
    }

    private Elevator chooseElevator(int requestFloor){
        List<Elevator> elevators = building.getElevators();
        Elevator best = elevators.get(0);
        for (Elevator e : elevators){
            int distance = Math.abs(e.getCurrentFloor() - requestFloor);
            int bestDistance = Math.abs(best.getCurrentFloor() - requestFloor);
            if(distance < bestDistance){
                best = e;
            }
        }
        return best;       
    }
}