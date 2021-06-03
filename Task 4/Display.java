class Display 
{
    void OccupancyChart()
    {
        System.out.println("Occupancy Chart for Train 1");
        for(int i=0;i<8;i++)
        {
            System.out.println("Seat "+(i+1)+": "+Train.seats1[i]);
        }
        System.out.println("Occupancy Chart for Train 2");
        for(int i=0;i<8;i++)
        {
            System.out.println("Seat "+(i+1)+": "+Train.seats2[i]);
        }
    }
    void display(int pnr)
    {
        for(int i=0;i<Train.train1.size();i++)
        {
            if(Train.train1.get(i).PNR==pnr)
            {
                System.out.println(Train.train1.get(i).toString());
            }
        }
        for(int i=0;i<Train.train2.size();i++)
        {
            if(Train.train2.get(i).PNR==pnr)
            {
                System.out.println(Train.train2.get(i).toString());
            }
        }

    }
}