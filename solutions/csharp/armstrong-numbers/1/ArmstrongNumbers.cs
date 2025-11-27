public static class ArmstrongNumbers
{
    public static bool IsArmstrongNumber(int number)
    {
        var pow = number.ToString().Length;
        double result = 0;

        foreach (char _char in number.ToString())
        {
            var digit = int.Parse(_char.ToString());

            result += Math.Pow(digit, pow);
        }

        return result == number;
    }
}