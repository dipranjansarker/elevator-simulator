import java.util.List;
import java.util.ArrayList;

public class Elevator{
    private int currentFloor;
    private ElevatorState state;
    private List<Integer> stops;

    public Elevator(int startFloor){
        this.currentFloor= startFloor;
        this.state= ElevatorState.IDLE;
        this.stops= new ArrayList<>();
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public ElevatorState getState(){
        return state;
    }

    public void step(){
        if(stops.isEmpty()){
            state= ElevatorState.IDLE;
            return;
        }

        int target= nearestStop();

        if (currentFloor< target){
            state= ElevatorState.MOVING_UP;
            currentFloor++;
        }
        else if (currentFloor> target){
            state= ElevatorState.MOVING_DOWN;
            currentFloor--;
        }

        if (currentFloor == target){
            state= ElevatorState.DOORS_OPEN;
            stops.remove(Integer.valueOf(target));
        }
    }

    private int nearestStop(){
        int nearest = stops.get(0);
        for(int floor : stops){
            if(Math.abs(currentFloor - floor) < Math.abs(currentFloor - nearest)){
                nearest= floor;
            }
        }

        return nearest;
    }

    public boolean hasWork(){
        return !stops.isEmpty();
    }

    public void addStop(int floor){
        if(!stops.contains(floor)){
            stops.add(floor);
        }
    }

    @Override
    public String toString(){
        return "Floor" + currentFloor + "[" + state + "]";
    }
}