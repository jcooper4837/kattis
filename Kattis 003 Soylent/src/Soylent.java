
import java.util.Scanner;

public class Soylent
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int[] b = new int[t];
        
        for (int i = 0; i < t; i++)
        {
            b[i] = s.nextInt();
        }
        
        for (int i = 0; i < t; i++)
        {
            if (b[i] % 400 == 0)
                System.out.println(b[i] / 400);
            else
                System.out.println(b[i] / 400 + 1);
        }
    }
}