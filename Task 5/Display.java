public class Display extends ParkingLot 
{
    Display(){}
    void allocation_chart()
    {
        for(int i=0;i<floors;i++)
        {
            for(int j=0;j<slots;j++)
            {
                System.out.print(parking[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}