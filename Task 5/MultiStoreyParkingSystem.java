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
            System.out.println("Choose the service you need:\n1.Park the Vehicle\n2.Leave the Parking Lot\n3. Reserve Parking Slot\n4. Dereserve the Reserved slot\n5.Show Allocation Chart\n6.Exit");
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
                    ParkingLotAllotment pla=new ParkingLotAllotment();
                    pla.parking_allotment(vehicle_plate_no, vehicle_type,in_time);
                    break;
                case 2:
                    System.out.println("Enter the Vehicle's Plate Number to be departed: ");
                    vehicle_plate_no=sc.next();
                    System.out.println("Enter the Departing Time(HH:MM:SS): ");
                    out_time=sc.next();
                    DepartParkingLot d=new DepartParkingLot();
                    int a=d.depart_vehicle(vehicle_plate_no, out_time);
                    if(a==-1)
                    {
                        System.out.println("No Vehicle With given Plate Number!!!\nKindly Check!!!");
                    }
                    break;
                case 3:
                    System.out.println("Enter Vehicle's Plate Number: ");
                    vehicle_plate_no=sc.next();
                    System.out.println("Enter Vehicle Type:\n1.Bike\n2.Bus\n3.Car\n");
                    vehicle_type=sc.nextInt();
                    ParkingReservation pr = new ParkingReservation();
                    pr.reserve_slot(vehicle_plate_no, vehicle_type);

                    break;
                case 4:
                    System.out.println("Enter Vehicle's Plate Number: ");
                    vehicle_plate_no=sc.next();
                    ParkingReservation prd = new ParkingReservation();
                    prd.dereserve(vehicle_plate_no);
                    break;
                case 5:
                    Display disp=new Display();
                    disp.allocation_chart();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Wrong Choice!!!");
                    break;
            }
        }while(ch!=6);
        

    }
}