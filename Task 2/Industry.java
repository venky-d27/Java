import java.util.*;
interface Car
{
    int tyres=4;
    int seats=4;
    int doors=2;
    public void car_raw_materials(int car);
    public int calculate_car();
}
interface Bus
{
    int tyres=6;
    int seats=10;
    int doors=2;
    public void bus_raw_materials(int bus);
    public int calculate_bus();
}
interface Bike
{
    int tyres=2;
    int seats=1;
    int doors=0;
    public void bike_raw_materials(int bike);
    public int calculate_bike();
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
    public int calculate_car()
    {  
        int b=0;
        while((tyres-Car.tyres)>=0 &&(seats-Car.seats) >=0 &&(doors-Car.doors)>=0 )
        {
            b+=1;
            this.tyres-=Car.tyres;
            this.seats-=Car.seats;
            this.doors-=Car.doors;
            
        }
        return b;
    } 
    public int calculate_bus()
    {    int a=0;
        while((tyres-Bus.tyres)>=0 && (seats-Bus.seats) >=0 &&(doors-Bus.doors)>=0 )
        {
            a+=1;
            this.tyres-=Bus.tyres;
            this.seats-=Bus.seats;
            this.doors-=Bus.doors;
            
        }
        return a;
        
    }
    public int calculate_bike()
    {   
        int c=0;

        while((tyres-Bike.tyres)>=0 &&(seats-Bike.seats) >= 0 )
        {
            c+=1;
            this.tyres-=Bike.tyres;
            this.seats-=Bike.seats;
            this.doors-=Bike.doors;
            
        }
        
        return c;
    }
    public void calculate_Vehicles()
    {
        a=calculate_bus();
        b=calculate_car();
        c=calculate_bike();
        System.out.println("Buses: "+a+"\nCars: "+b+"\nBikes: "+c);
        System.out.println("Remaining Parts:\nDoors: "+doors+"\nSeats: "+seats+"\nTyres: "+tyres);
        
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
