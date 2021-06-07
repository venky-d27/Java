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
        for(int i=0;i<floors;i++)
        {
            for(int j=0;j<slots;j++)
            {
                parking[i][j]=0;
            }
        }
        car_slots=(int)(0.4*slots);
        bus_slots=(int)(0.4*slots);
        bike_slots=slots-(car_slots+bus_slots);
    }
    static ArrayList<Vehicle> parked_vehicles=new ArrayList<Vehicle>();
}
