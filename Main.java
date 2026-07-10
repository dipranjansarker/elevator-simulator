public class Main{
    public static void main(String[] args){
        Elevator elevator= new Elevator(0);
        elevator.addStop(5);
        elevator.addStop(2);
        elevator.addStop(8);

        int tick=0;
        while(elevator.hasWork()){
            elevator.step();
            System.out.println("Tick" + tick + ":" + elevator);
            tick++;
        }

        
    }
}