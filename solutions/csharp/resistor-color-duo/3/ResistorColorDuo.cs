public static class ResistorColorDuo
{
       private static readonly string [] _resistorColor = {
            "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"
        };
    
    public static int Value(string[] colors)
    {

        int first = Array.IndexOf(_resistorColor, colors[0]);
        int second = Array.IndexOf(_resistorColor, colors[1]);

        return int.Parse(String.Concat(first, second));
    }
}
