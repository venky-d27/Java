public class Vehicle 
{
    String vehicle_plate_no;
    String  vehicle_type;
    int floor_no,slot_no,reservation_status;
    double parking_fee,reserve_fee,discount;
    String in_time,out_time;
    String couponcode;
    int alive;
    Vehicle(){}
    Vehicle(String vehicle_plate_no,int type,int floor_no,int slot_no)
    {
        this.vehicle_plate_no=vehicle_plate_no;
        this.floor_no=floor_no;
        this.slot_no=slot_no;
        this.alive=1;
        if(type==1)
        {
            this.vehicle_type="Bike";
        }
        else if(type==2)
        {
            this.vehicle_type="Bus";
        }
        else
        {
            this.vehicle_type="Car";
        }
    }
    
    @Override
    public String toString()
    {
         return "\nLicence Plate No: "+vehicle_plate_no+"\nVehicle Type: "+vehicle_type+"\nFloor No: "+floor_no+"\nSlot No: "+slot_no+"\nIn-time: "+in_time+"\nOut-time: "+out_time+"\nDiscount Amount: -"+discount+"\nParking fee: "+parking_fee;
    }
}