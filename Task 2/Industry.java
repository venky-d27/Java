import java.util.*;
interface Car
{
    int tyres=4;
    int seats=4;
    int doors=2;
    public void car_raw_materials(int car);
    public int calculate_car(int tyres,int seats,int doors);
}
interface Bus
{
    int tyres=6;
    int seats=10;
    int doors=2;
    public void bus_raw_materials(int bus);
    public int calculate_bus(int tyres,int seats,int doors);
}
interface Bike
{
    int tyres=2;
    int seats=1;
    int doors=0;
    public void bike_raw_materials(int bike);
    public int calculate_bike(int tyres,int seats,int doors);
}
class Vehicle implements Car,Bus,Bike
{
    int tyres,seats,doors;
    int tot_tyres,tot_seats,tot_doors;
    int a,b,c;
    Vehicle()
    {
        System.out.println("Welcome to ABC Industry");
    }

    Vehicle(int tyres, int seats, int doors) 
    {
        this.tyres = tyres;
        this.seats = seats;
        this.doors = doors;
    }
    public void car_raw_materials(int car)
    {
        tot_tyres+=Car.tyres*car;
        tot_seats+=Car.seats*car;
        tot_doors+=Car.doors*car;
    }
    public void bus_raw_materials(int bus)
    {
        tot_tyres+=Bus.tyres*bus;
        tot_seats+=Bus.seats*bus;
        tot_doors+=Bus.doors*bus;
    }
    public void bike_raw_materials(int bike) 
    {
        tot_tyres+=Bike.tyres*bike;
        tot_seats+=Bike.seats*bike;
        tot_doors+=Bike.doors*bike;    
    }
    public void raw_materials(int car,int bus,int bike)
    {
        car_raw_materials(car);
        bus_raw_materials(bus);
        bike_raw_materials(bike);
        System.out.println("Required Parts:\n"+tot_tyres+" tyres "+tot_seats+" seats "+tot_doors+" doors");
    }
    public int calculate_car(int tyres,int seats,int doors)
    {  
        int b=0;
        while((tyres-Car.tyres)>=0 &&(seats-Car.seats) >=0 &&(doors-Car.doors)>=0 )
        {
            b+=1;
            tyres-=Car.tyres;
            seats-=Car.seats;
            doors-=Car.doors;
            
        }
        System.out.println("Cars:" +b);
        System.out.println("Remaining Parts:\nDoors: "+doors+"\nSeats: "+seats+"\nTyres: "+tyres);
        return doors+seats+tyres;
    } 
    public int calculate_bus(int tyres,int seats,int doors)
    {    int a=0;
        while((tyres-Bus.tyres)>=0 && (seats-Bus.seats) >=0 &&(doors-Bus.doors)>=0 )
        {
            a+=1;
            tyres-=Bus.tyres;
            seats-=Bus.seats;
            doors-=Bus.doors;
            
        }
        System.out.println("Buses: "+a);
        System.out.println("Remaining Parts:\nDoors: "+doors+"\nSeats: "+seats+"\nTyres: "+tyres);
        return doors+seats+tyres;
        
    }
    public int calculate_bike(int tyres,int seats,int doors)
    {   
        int c=0;

        while((tyres-Bike.tyres)>=0 &&(seats-Bike.seats) >= 0 )
        {
            c+=1;
            tyres-=Bike.tyres;
            seats-=Bike.seats;
            doors-=Bike.doors;
            
        }
        System.out.println("Bikes: "+c);
        System.out.println("Remaining Parts:\nDoors: "+doors+"\nSeats: "+seats+"\nTyres: "+tyres);
        return doors+seats+tyres;
    }
    public void calculate_Vehicles()
    {
        a=calculate_bus(tyres,seats,doors); 
        b=calculate_car(tyres,seats,doors);
        c=calculate_bike(tyres,seats,doors);
        if(a<b && a<c)
        System.out.println("Bus is the Optimal Choice");
        else if(b<c)
        System.out.println("Car is the Optimal Choice");
        else
        System.out.println("Bike is the Optimal Choice");
        
        
    }
    
}
public class Industry {
    public static void main(String args[])
    {   
        int ch;
        int car,bus,bike;
        int doors,seats,tyres;
        System.out.println("Enter the Service you want:\n1. Constructing Vehicles\n2. Parts Estimates ");
        Scanner sc=new Scanner(System.in);
        ch=sc.nextInt();
        Vehicle v;
        if(ch==1)
        {
            System.out.println("Enter the quantity of parts available:\nDoors: ");
            doors=sc.nextInt();
            System.out.println("Seats: ");
            seats=sc.nextInt();
            System.out.println("Tyres: ");
            tyres=sc.nextInt();
            v=new Vehicle(tyres,seats,doors);
            v.calculate_Vehicles();

        }
        else if(ch==2)
        {
            System.out.println("Enter the no of below vehicles needed in each category:\nCars:");
            car=sc.nextInt();
            System.out.println("Bus:");
            bus=sc.nextInt();
            System.out.println("Bike:");
            bike=sc.nextInt();
            v=new Vehicle();
            v.raw_materials(car, bus, bike);

        }
        
    }
}
