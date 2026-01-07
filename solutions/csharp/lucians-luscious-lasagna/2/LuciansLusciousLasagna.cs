class Lasagna
{
    // TODO: define the 'ExpectedMinutesInOven()' method
    public int ExpectedMinutesInOven()
    {
        return 40;
    }
    // TODO: define the 'RemainingMinutesInOven()' method
    public int RemainingMinutesInOven(int timeInOven)
    {
        return ExpectedMinutesInOven() - timeInOven;
    }
    // TODO: define the 'PreparationTimeInMinutes()' method
    public int PreparationTimeInMinutes(int layers)
    {
        var layerPreparationTake = 2;
        return (layers * layerPreparationTake);
    }
    // TODO: define the 'ElapsedTimeInMinutes()' method

    public int ElapsedTimeInMinutes(int numberOfLayers, int timeInOven)
    {
        
        return PreparationTimeInMinutes(numberOfLayers) + timeInOven;
    }
}
