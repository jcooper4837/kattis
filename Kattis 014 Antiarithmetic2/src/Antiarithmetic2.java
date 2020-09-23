import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner;
import java.util.StringTokenizer;

public class Antiarithmetic2
{
    public static int perm;
    public static int vals[] = new int[10000];
    public static int pos[] = new int[1000];
    public static int diff;
    public static void getAnti()
    {
        for (int i = 0; i < perm; i++)
        {
            for (int j = i + 1; j < perm; j++)
            {
                diff = vals[j] + vals[j] - vals[i];
                //System.out.println(vals[j] + "+" + vals[j] + "-" + vals[i] + "=" + diff);
                if (diff < 0 || diff >= perm)
                {
                    continue;
                }
                //System.out.println(pos[diff] + ">" + j);
                if (pos[diff] > j)
                {
                    System.out.println("no");
                    return;
                }
            }
        }
        System.out.println("yes");
    }
    public static void main(String[] args) throws IOException
    {
        long startTime = 0;
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer("");
        int cases = 0;
        vals = new int[10000];
        pos = new int[10000];
        while (true)
        {
            t = new StringTokenizer(s.readLine());
            String input = t.nextToken();
            startTime = System.nanoTime();
            if (input.equals("0"))
            {
                break;
            }
            perm = Integer.parseInt(input.substring(0, input.indexOf(':')));
            for (int i = 0; i < perm; i++)
            {
                vals[i] = Integer.parseInt(t.nextToken());
                pos[vals[i]] = i;
            }
            getAnti();
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime / 1000.000);
    }
}