
import java.util.ArrayList;
import java.util.Scanner;

public class Modulo
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int[] a = new int[10];
        
        for (int i = 0; i < 10; i++)
        {
            a[i] = s.nextInt();
            a[i] %= 42;
        }
        
        ArrayList<Integer> b = new ArrayList<>();
        
        for (int i = 0; i < 10; i++)
        {
            if (!b.contains(a[i]))
            {
                b.add(a[i]);
            }
        }
        
        System.out.println(b.size());
    }
}