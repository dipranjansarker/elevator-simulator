import java.util.List;
import java.util.ArrayList;

public class Building{
    private List<Elevator> elevators;

    public Building(int numberOfElevators){
        this.elevators = new ArrayList<>();
        for (int i = 0; i<numberOfElevators; i++){
            elevators.add(new Elevator(i,i*4));
        }
    }

    public List<Elevator> getElevators(){
        return elevators;
    }

    public void step(){
        for(Elevator e : elevators){
            e.step();
        }
    }

    public boolean anyWork(){
        for(Elevator e : elevators){
            if(e.hasWork()){
                return true;
            }
        }
        return false; 
    }
}