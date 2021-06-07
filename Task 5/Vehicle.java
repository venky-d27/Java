public class Vehicle implements Bike,Bus,Car
{
    String licence_plate_no;
    String  vehicle_type;
    int floor_no,slot_no;
    Vehicle(){}
    Vehicle(String licence_plate_no,int type,int floor_no,int slot_no)
    {
        this.licence_plate_no=licence_plate_no;
        this.floor_no=floor_no;
        this.slot_no=slot_no;
        if(type==1)
        {
            this.vehicle_type=Bike.vehicle_type;
        }
        else if(type==2)
        {
            this.vehicle_type=Bus.vehicle_type;
        }
        else
        {
            this.vehicle_type=Car.vehicle_type;
        }
    }
    @Override
    public String toString()
    {
         return "\nLicence Plate No: "+licence_plate_no+"\nVehicle Type"+vehicle_type+"\nFloor No: "+floor_no+"\nSlot No: "+slot_no;
    }


}
