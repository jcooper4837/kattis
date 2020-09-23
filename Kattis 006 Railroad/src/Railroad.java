
import java.util.Scanner;

public class Railroad
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        int possible = x * 2 + y;
        
        if (possible % 2 == 0)
            System.out.println("possible");
        else
            System.out.println("impossible");
    }
}