using System.Text;


public static class Identifier
{
    public static string Clean(string identifier)
    {
                StringBuilder builder = new StringBuilder();
        bool nextUpperCase = false;

        foreach (char c in identifier)
        {
            bool isLowerGreek = c >= '\u03B1' && c <= '\u03C9'; // α - ω

            if (Char.IsWhiteSpace(c)) //replace with_spaces 
            {
                builder.Append('_');
            }
            else if (Char.IsControl(c)) // with_control \0
            {
                builder.Append("CTRL");
            }
            else if (nextUpperCase)
            {
                builder.Append(Char.ToUpper(c));
                nextUpperCase = false;
            }
            else if(c == '-') //kebab_to_camel_case
            {
                nextUpperCase = true;
            }
            else if (!Char.IsLetter(c) || isLowerGreek) //special_characters 
            {
                continue;
            }
            else
            {
                builder.Append(c);
            }
        }

        var newWord = builder.ToString();
        return newWord;
    }
}
