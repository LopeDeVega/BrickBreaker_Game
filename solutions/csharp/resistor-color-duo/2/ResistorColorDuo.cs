public static class ResistorColorDuo
{
    public static int Value(string[] colors)
    {
        string[] resistorColor = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        string[] result = new string[2]; 

        for(int i = 0; i < colors.Length; i++)
        {
            if (i < 2)
            {
                result[i] = Array.IndexOf(resistorColor, colors[i]).ToString();
            }
        }

        return int.Parse(String.Concat(result));
    }
}
