import java.util.Scanner;
import java.time.*; 
//Interface 
interface VehicleInterface
{
    void display();
    void fare(int km);
}
// Base Class 
class Vehicle 
{
double price;
String model;
String licence_plate;
int mileage;
String current_date;
String age;
//Default constructor
Vehicle(){
    price=0.0;
    model="abc";
    licence_plate="#####";
    mileage=0;
}
//Parameterized Constructor
Vehicle(String model,String licence_plate,int mileage,double price,String reg_date)
{
    this.model=model;
    this.licence_plate=licence_plate;
    this.mileage=mileage;
    this.price=price;
    date(reg_date);
}
//Calculating Age of the Vehicle
void date(String reg_date){
    //Handling Wrong Date Format Exception
    try{
    LocalDate l=LocalDate.parse(reg_date);
    Period difference = Period.between(l,java.time.LocalDate.now());
    age= difference.getYears()+" years "+difference.getMonths()+" months "+difference.getDays()+" days";
    }
    catch(Exception e)
    {
        System.out.println("Wrong Date Format!!!");
    }
}
}
class TwoWheeler extends Vehicle implements VehicleInterface{
    String type;
    int capacity;
    double total_fare;
    double fare_rate;
    TwoWheeler()
    {
        fare_rate=10.0;
    }
    TwoWheeler(String model,String licence_plate,int mileage,double price,String reg_date)
    {
        super(model,licence_plate,mileage,price,reg_date);
        type="Two Wheeler";
        capacity=2; 
    }
    public void display()
    {
    System.out.println("Vehicle Details:\n"+"Model: "+model+"\nLicence Plate: "+licence_plate+"\nType: "+type+"\nMileage: "+mileage+"\nCapacity: "+capacity+"\nage:"+age);
    }
    public void fare(int km){
        total_fare=50+km*fare_rate;
        System.out.println("Total Fare(in Rs): "+total_fare);
    }

}
class ThreeWheeler extends Vehicle{
    String type;
    int capacity;
    double total_fare;
    double fare_rate;
    ThreeWheeler()
    {
        fare_rate=15.0;
    }
    ThreeWheeler(String model,String licence_plate,int mileage,double price,String reg_date)
    {
        super(model,licence_plate,mileage,price,reg_date);
        type="Three Wheeler";
        capacity=4;   
     }
     public void display()
    {
        System.out.println("Vehicle Details:\n"+"Model: "+model+"\nLicence Plate: "+licence_plate+"\nType: "+type+"\nMileage: "+mileage+"\nCapacity: "+capacity+"\nage:"+age);
    }
    public void fare(int km){
        total_fare=50+km*fare_rate;
        System.out.println("Total Fare(in Rs): "+total_fare);
    }

}
class FourWheeler extends Vehicle{
    String type;
    int capacity;
    double total_fare;
    double fare_rate;
    FourWheeler()
    {
        fare_rate=20.0;
    }
    FourWheeler(String model,String licence_plate,int mileage,double price,String reg_date)
    {
        super(model,licence_plate,mileage,price,reg_date);
        type="Four Wheeler";
        capacity=5;  
    }
    public void display()
    {
        System.out.println("Vehicle Details:\n"+"Model: "+model+"\nLicence Plate: "+licence_plate+"\nType: "+type+"\nMileage: "+mileage+"\nCapacity: "+capacity+"\nage:"+age);
    }
    public void fare(int km){
        total_fare=50+km*fare_rate;
        System.out.println("Total Fare(in Rs): "+total_fare);
    }
}

public class VehicleTask
{
    public static void main(String args[])
    {
        int choice,ch;
        double price;
        String model;
        String licence_plate;
        int mileage;
        String reg_date;
        int kms;
        Scanner sc=new Scanner(System.in);
        System.out.println("Select a option:\n1.Register a Vehicle\n2.Calculate Fare");
        ch=sc.nextInt();
        if(ch==1)
        {
            System.out.println("Enter the type of vehicle:"+"\n"+"1.Two Wheeler\n"+"2.Three Wheeler\n"+"3.Four Wheeler");
            choice=sc.nextInt();
            System.out.println("Model:");
            model=sc.next();
            System.out.println("Licence Plate:");
            licence_plate=sc.next();
            System.out.println("Mileage:");
            mileage=sc.nextInt();
            System.out.println("Price:");
            price=sc.nextDouble();
            System.out.println("Registeration Date(YYYY-MM-DD):");
            reg_date=sc.next();
            switch(choice)
            {
                case 1:TwoWheeler v1=new TwoWheeler(model, licence_plate, mileage, price,reg_date);v1.display();break;
                case 2:ThreeWheeler v2=new ThreeWheeler(model, licence_plate, mileage, price,reg_date);v2.display();break;
                case 3:FourWheeler v3=new FourWheeler(model, licence_plate, mileage, price,reg_date);v3.display();break;
                default: System.out.println("Wrong Choice"); 
            }
        }
        else if(ch==2)
        {
            System.out.println("Enter the type of vehicle:"+"\n"+"1.Two Wheeler\n"+"2.Three Wheeler\n"+"3.Four Wheeler");
            choice=sc.nextInt();
            System.out.println("Enter kms Travelled:");
            kms=sc.nextInt();
            switch(choice)
            {
                case 1:TwoWheeler v1=new TwoWheeler();v1.fare(kms);break;
                case 2:ThreeWheeler v2=new ThreeWheeler();v2.fare(kms);break;
                case 3:FourWheeler v3=new FourWheeler();v3.fare(kms);break;
                default: System.out.println("Wrong Choice"); 
            }

        }
        else
        {
            System.out.println("Wrong Choice!!!");
        }
    }
}