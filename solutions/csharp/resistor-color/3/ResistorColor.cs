public static class ResistorColor
{
    public static int ColorCode(string color)
    {
        return Array.IndexOf(Colors(), color);
    }

    public static string[] Colors() => _colors;
    
    public readonly static string[] _colors =
    {
        "black", "brown", "red", "orange", "yellow",         "green", "blue", "violet", "grey", "white"

    };
}