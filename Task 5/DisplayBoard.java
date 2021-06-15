public class DisplayBoard extends ParkingLot 
{
    DisplayBoard(){}
    void allocation_chart(ParkingLot p)
    {
        for(int i=0;i<p.floors;i++)
        {
            for(int j=0;j<p.slots;j++)
            {
                System.out.print(p.parking[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
