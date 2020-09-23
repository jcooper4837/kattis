import java.util.*;

public class Santa
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        if (n > 19)
        {
            n = 19;
        }
        double sum = 0;
        for (int i = 1; i <= n; i++)
        {
            //System.out.println(i + "     " + sum);
            if (i % 2 == 1)
            {
                sum += 1.0 / factorial(i);
            }
            else
            {
                sum -= 1.0 / factorial(i);
            }
        }
        System.out.println(sum);
    }
    public static long factorial(long n)
    {
        if (n < 1)
        {
            return 1;
        }
        else
        {
            return n * factorial(n-1);
        }
    }
}