public class ParkingLotAllotment extends ParkingLot
{
    String licence_plate_no;
    int type;
    ParkingLotAllotment(String licence_plate_no,int type)
    {
        this.licence_plate_no=licence_plate_no;
        this.type=type;
    }
    int[] allot_slot(String licence_plate_no,int type)
    {   int a[]=new int[]{-1,-1};
        if(type==1)
        {   
            for(int i=0;i<floors;i++)
            {
                for(int j=(bus_slots+car_slots);j<slots;j++)
                {   
                    if(parking[i][j]==0)
                    {
                        parking[i][j]=1;
                        a[0]=i;
                        a[1]=j;
                        break;
                    }
                }
            }
        }
        else if(type==2)
        {
            for(int i=0;i<floors;i++)
            {
                for(int j=car_slots;j<(bus_slots+car_slots);j++)
                {
                    if(parking[i][j]==0)
                    {
                        parking[i][j]=1;
                        a[0]=i;
                        a[1]=j;
                        break;
                    }
                }
            }
        }
        else
        {
            for(int i=0;i<floors;i++)
            {
                for(int j=0;j<car_slots;j++)
                {
                    if(parking[i][j]==0)
                    {
                        parking[i][j]=1;
                        a[0]=i;
                        a[1]=j;
                        break;
                    }
                }
            } 
        }
        return a;
    }
    void parking_allotment()
    {
        int a[]=allot_slot(licence_plate_no, type);
        Vehicle v;
        if(a[0]==-1 || a[1]==-1)
        {
            System.out.println("Sorry no parking slots Available!!!");
        }
        else
        {
            v=new Vehicle(licence_plate_no,type,a[0],a[1]);
            parked_vehicles.add(v);
            System.out.println(parked_vehicles.get(parked_vehicles.size()-1).toString());
        }
    }
}
