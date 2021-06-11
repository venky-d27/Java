import java.util.*;
public class MultiStoreyParkingSystem
{
    public static void main(String[] args) 
    {
        int vehicle_type;
        String vehicle_plate_no;
        String in_time,out_time;
        int floors;
        int slots;
        Scanner sc=new Scanner(System.in);
        int ch;
        System.out.println("Enter the Parking Lot Structure:\nFloors: ");
        floors=sc.nextInt();
        System.out.println("Slots: ");
        slots=sc.nextInt();
        ParkingLot p=new ParkingLot(slots, floors);
        do
        {
            System.out.println("Choose the service you need:\n1.Park the Vehicle\n2.Leave the Parking Lot\n3.Reserve Parking Slot\n4.Dereserve the Reserved slot\n5.Show Allocation Chart\n6.Summary Report\n7.Exit");
            ch=sc.nextInt();
            switch (ch) 
            {
                case 1:
                    System.out.println("Enter Vehicle Type:\n1.Bike\n2.Bus\n3.Car\n");
                    vehicle_type=sc.nextInt();
                    System.out.println("Enter Vehicle's Plate Number: ");
                    vehicle_plate_no=sc.next();
                    System.out.println("Enter Parking time(HH:MM:SS): ");
                    in_time=sc.next();
                    p.parking_allotment(vehicle_plate_no, vehicle_type,in_time);
                    break;
                case 2:
                    System.out.println("Enter the Vehicle's Plate Number to be departed: ");
                    vehicle_plate_no=sc.next();
                    System.out.println("Enter the Departing Time(HH:MM:SS): ");
                    out_time=sc.next();
                    System.out.println("Want to apply coupon?\n1.Yes\n2.No");
                    int ch1=sc.nextInt();
                    if(ch1==1)
                    {
                        System.out.println("Enter your Coupon Code: ");
                        String couponcode=sc.next();
                        p.depart_vehicle(vehicle_plate_no, out_time,couponcode);
                    }
                    else
                    {
                        p.depart_vehicle(vehicle_plate_no, out_time,"-1");
                    }
                    break;
                case 3:
                    System.out.println("Enter Vehicle Type:\n1.Bike\n2.Bus\n3.Car\n");
                    vehicle_type=sc.nextInt();    
                    System.out.println("Enter Vehicle's Plate Number: ");
                    vehicle_plate_no=sc.next();
                    p.reserve_slot(vehicle_plate_no, vehicle_type);

                    break;
                case 4:
                    System.out.println("Enter Vehicle's Plate Number: ");
                    vehicle_plate_no=sc.next();
                    p.dereserve(vehicle_plate_no);
                    break;
                case 5:
                    DisplayBoard disp=new DisplayBoard();
                    disp.allocation_chart();
                    break;
                case 6:
                    SummaryReport s=new SummaryReport();
                    System.out.println("Enter Vehicle Type for which Summary needed:\n1.Bike\n2.Bus\n3.Car\n");
                    vehicle_type=sc.nextInt();
                    s.summary(vehicle_type);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Wrong Choice!!!");
                    break;
            }
        }while(ch!=7);
        

    }
}