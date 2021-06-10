public class DepartParkingLot 
{
    String licence_plate_no;
    String out_time;
    DepartParkingLot(){}
    void deallocate_slot(int floor,int slot)
    {
        ParkingLot.parking[floor-1][slot-1]=0;
    }

    void depart_vehicle(String vehicle_plate_no,String out_time,String couponcode)
    {   
        CouponSystem cs=new CouponSystem();
        int f1=0;
        double fee=0.0;
        for(int i=0;i<ParkingLot.parked_vehicles.size();i++)
        {
            if((ParkingLot.parked_vehicles.get(i).vehicle_plate_no.equals(vehicle_plate_no)) && ParkingLot.parked_vehicles.get(i).alive==1)
            {
                FeeCollection f=new FeeCollection();
                ParkingLot.parked_vehicles.get(i).out_time=out_time;
                if(!couponcode.equals("-1"))
                {
                    ParkingLot.parked_vehicles.get(i).discount= cs.applycoupon(couponcode,ParkingLot.parked_vehicles.get(i).in_time, out_time,ParkingLot.parked_vehicles.get(i).vehicle_type);
                }
                fee=f.calculate_fee(ParkingLot.parked_vehicles.get(i).vehicle_type, ParkingLot.parked_vehicles.get(i).in_time, out_time);
                if(fee>-1)
                {
                ParkingLot.parked_vehicles.get(i).parking_fee=ParkingLot.parked_vehicles.get(i).reserve_fee+fee-ParkingLot.parked_vehicles.get(i).discount;
                deallocate_slot(ParkingLot.parked_vehicles.get(i).floor_no,ParkingLot.parked_vehicles.get(i).slot_no);
                ParkingLot.parked_vehicles.get(i).alive=0;
                ParkingLot.parked_vehicles.get(i).reservation_status=0;
                
                System.out.println("Thanks For Coming!!!\n Your Bill\n"+ParkingLot.parked_vehicles.get(i).toString());
                f1=1;
                }
                // System.out.print(ParkingLot.parking[ParkingLot.parked_vehicles.get(i).floor_no][ParkingLot.parked_vehicles.get(i).slot_no]);
            }   
        
            
        }
        if(f1==0 && fee>-1.0)
            {
                System.out.println("No Vehicle With given Plate Number!!!\nKindly Check!!!");
            }
    }
}
