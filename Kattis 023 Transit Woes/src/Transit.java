import java.util.*;

public class Transit
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); // starting time
        int t = sc.nextInt(); // class time
        int n = sc.nextInt(); // number of transit routes
        int d[] = new int[n + 1]; // time spent walking between stops
        int b[] = new int[n]; // time spent riding each bus
        int c[] = new int[n]; // time interval each bus arrives
        int it = 0; // time iterator
        for (int i = 0; i < n + 1; i++)
        {
            d[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++)
        {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++)
        {
            c[i] = sc.nextInt();
        }
        it += s; // add start time if not 0
        for (int i = 0; i < n; i++)
        {
            it += d[i]; // add time for walking from previous to next stop
            while (it % c[i] != 0) // wait for bus to arrive at stop
            {
                it++;
            }
            it += b[i]; // add time for riding bus
        }
        it += d[d.length - 1]; // add final walk time to class
        if (it <= t) // check if iterator made it before class start time
        {
            System.out.println("yes");
        } else
        {
            System.out.println("no");
        }
    }
}

//0 20 2 2 2 2 5 5 3 5
//0 10 1 3 3 1 8