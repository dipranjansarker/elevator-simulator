public class Main{
    public static void main(String[] args){
       Building building = new Building(3);
       Scheduler scheduler = new Scheduler(building);

       building.getElevators().get(0).addStop(5);
       building.getElevators().get(1).addStop(2);
       building.getElevators().get(2).addStop(8);

        int tick=0;
        while(tick <5){
            if (tick ==0 ){
                sendRequest(scheduler, 2);
                sendRequest(scheduler, 7);
                sendRequest(scheduler, 5);
            }
            if(tick ==2){
                sendRequest(scheduler, 9);
            }

            building.step();
            System.out.println("--- Tick " + tick + " ---");
            for (Elevator e : building.getElevators()){
                System.out.println("  " + e);
            }
            tick++;
        }   
    }

    private static void sendRequest(Scheduler scheduler, int floor){
        Elevator chosen = scheduler.handleRequest(floor);
        System.out.println("Request at floor " + floor + " -> assigned to Elevator " + chosen.getId());
    }
}