import java.util.*;

public class Avion
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String blimps[] = new String[5];
        boolean b = false;
        for (int i = 0; i < 5; i++)
        {
            blimps[i] = s.next();
        }
        for (int i = 0; i < 5; i++)
        {
            if (blimps[i].contains("FBI"))
            {
                System.out.print((i + 1) + " ");
                b = true;
            }
        }
        if (!b)
        {
            System.out.println("HE GOT AWAY!");
        }
    }
}