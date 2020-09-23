
import java.util.*;

public class DASort
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int p, k, n;
        p = s.nextInt();
        long startTime = System.nanoTime();
        int o[][] = new int[p][2];
        for (int i = 0; i < p; i++)
        {
            k = s.nextInt();
            n = s.nextInt();
            int a[] = new int[n];
            for (int j = 0; j < n; j++)
            {
                a[j] = s.nextInt();
            }
            o[i][0] = k;
            int low = 1000000001, pos = 0, prev = 0, inv = n + 1;
            boolean check = false, cont = true;
            while (cont) 
            {
                for (int j = 0; j < a.length; j++)
                {
                    if (a[j] < low)
                    {
                        low = a[j];
                        pos = j;
                    }
                }
                if (prev > pos || inv <= 1)
                {
                    cont = false;
                    for (int h = prev + 1; h < a.length; h++)
                    {
                        if (a[h] == low)
                        {
                            inv--;
                        }
                    }
                }
                System.out.println(inv);
                low = 1000000001;
                a[pos] = 1000000001;
                prev = pos;
                inv--;
            }
            o[i][1] = inv;
        }
        for (int i = 0; i < p; i++)
        {
            System.out.println(o[i][0] + " " + o[i][1]);
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime / 1000000000.000);
    }
}

//3 1 3 1 3 2 2 6 1 5 2 4 3 6 3 23 67890 56312 999999999 12345 23456 38927 45632 100345 98765 23456 87654 43278 23456 117654 321899 25432 54326 217435 26845 31782 33456 41234 56213
