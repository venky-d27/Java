import java.util.*;
public class ParkingLot 
{
    static int[][] parking;
    static int car_slots,bus_slots,bike_slots,slots,floors;
    ParkingLot(){}
    ParkingLot(int slots,int floors)
    {
        this.slots=slots;
        this.floors=floors;
        parking=new int[floors][slots];
        car_slots=(int)(Car.slots_required*slots);
        bus_slots=(int)(Bus.slots_required*slots);
        bike_slots=slots-(car_slots+bus_slots);
    }
    static ArrayList<Vehicle> parked_vehicles=new ArrayList<Vehicle>();
}
