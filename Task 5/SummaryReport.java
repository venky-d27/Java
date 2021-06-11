public class SummaryReport 
{
    void car_summary()
    {   int c=0;
        double amount_collected=0.0,discount_applied=0.0;
        for(int i=0;i<ParkingLot.parked_vehicles.size();i++)
        {
            if(ParkingLot.parked_vehicles.get(i).vehicle_type=="Car")
            {
                c+=1;
                amount_collected+=ParkingLot.parked_vehicles.get(i).parking_fee;
                discount_applied+=ParkingLot.parked_vehicles.get(i).discount;
            }
        }
        System.out.println("Car Summary\nNo. of Cars Parked: "+c+"\nAmount Collected: "+amount_collected+"\nDicount Applied: "+discount_applied);
    }
    void bus_summary()
    {   int c=0;
        double amount_collected=0.0,discount_applied=0.0;
        for(int i=0;i<ParkingLot.parked_vehicles.size();i++)
        {
            if(ParkingLot.parked_vehicles.get(i).vehicle_type=="Bus")
            {
                c+=1;
                amount_collected+=ParkingLot.parked_vehicles.get(i).parking_fee;
                discount_applied+=ParkingLot.parked_vehicles.get(i).discount;
            }
        }
        System.out.println("Bus Summary\nNo. of Bus Parked: "+c+"\nAmount Collected: "+amount_collected+"\nDicount Applied: "+discount_applied);
    }
    void bike_summary()
    {   int c=0;
        double amount_collected=0.0,discount_applied=0.0;
        for(int i=0;i<ParkingLot.parked_vehicles.size();i++)
        {
            if(ParkingLot.parked_vehicles.get(i).vehicle_type=="Bike")
            {
                c+=1;
                amount_collected+=ParkingLot.parked_vehicles.get(i).parking_fee;
                discount_applied+=ParkingLot.parked_vehicles.get(i).discount;
            }
        }
        System.out.println("Bike Summary\nNo. of Cars Parked: "+c+"\nAmount Collected: "+amount_collected+"\nDicount Applied: "+discount_applied);
    }
    void summary(int type)
    {
        if(type==1)
        {
            bike_summary();
        }
        else if(type==2)
        {
            bus_summary();
        }
        else if(type==3)
        {
            car_summary();
        }
        else
        {
            System.out.println("Wrong Choice!!!");
        }
    }
    
}
