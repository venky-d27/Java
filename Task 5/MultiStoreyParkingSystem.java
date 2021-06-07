import java.util.*;
public class MultiStoreyParkingSystem
{
    public static void main(String[] args) 
    {
        int vehicle_type;
        String licence_plate_no;
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
            System.out.println("Choose the service you need:\n1.Park the Vehicle\n2.Exit");
            ch=sc.nextInt();
            switch (ch) 
            {
                case 1:
                    System.out.println("Enter Vehicle Type:\n1.Bike\n2.Bus\n3.Car\n");
                    vehicle_type=sc.nextInt();
                    System.out.println("Enter Vehicle's Licence Plate Number: ");
                    licence_plate_no=sc.next(); 
                    ParkingLotAllotment pla=new ParkingLotAllotment(licence_plate_no, vehicle_type);
                    pla.parking_allotment();
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }while(ch!=2);
        

    }
}