class BirdCount
{
    private int[] birdsPerDay;

    public BirdCount(int[] birdsPerDay)
    {
        this.birdsPerDay = birdsPerDay;
    }

    public static int[] LastWeek()
    {
        int[] lastWeek = new int[] { 0, 2, 5, 3, 7, 8, 4 };
        return lastWeek;
    }

    public int Today()
    {
        var index = this.birdsPerDay.Length;
        return this.birdsPerDay[index -1];
    }

    public void IncrementTodaysCount()
    {
        this.birdsPerDay[birdsPerDay.Length - 1] = Today() + 1;
    }

    public bool HasDayWithoutBirds()
    {
        foreach(var noVisits in this.birdsPerDay)
        {
            if(noVisits == 0)
            {
                return true;
            }
        }

        return false;
    }

    public int CountForFirstDays(int numberOfDays)
    {
        var result = 0;

        for (int i = 0;  i < numberOfDays; i++)
        {
            result += this.birdsPerDay[i]; 
        }
        return result;
    }

    public int BusyDays()
    {
        var numberOfBusyDays = 0;

        foreach (var num in this.birdsPerDay)
        {
            if (num >= 5)
            {
                numberOfBusyDays++;
            }
        }

        return numberOfBusyDays;
    }
}
