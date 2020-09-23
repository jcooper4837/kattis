import java.util.*;

public class Duplicates
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String words[] = input.split(" ");
        boolean yes = true;
        for (int i = 0; i < words.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (words[i].equals(words[j]))
                    yes = false;
            }
        }
        if (yes)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}