
import java.util.*;

public class Ants
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        if (cases > 100)
            cases = 100;
        int[][] output = new int[cases][2];
        int length, num, largest, smallest, cAnt;
        for (int i = 0; i < cases; i++)
        {
            length = s.nextInt();
            num = s.nextInt();
            if (num > 1000000)
                num = 1000000;
            int[] ants = new int[num];
            for (int j = 0; j < num; j++)
            {
                ants[j] = s.nextInt();
            }
            largest = 0;
            smallest = 0;
            for (int j = 0; j < num; j++)
            {
                cAnt = ants[j];
                System.out.println(cAnt + " > " + largest);
                if (cAnt > largest)
                {
                    System.out.println("largest = " + cAnt);
                    largest = cAnt;
                }
                System.out.println(length + " - " + cAnt + " > " + largest);
                if (length - cAnt > largest)
                {
                    System.out.println("largest = " + (length - cAnt));
                    largest = length - cAnt;
                }
                System.out.println(cAnt + " > " + length + " - " + cAnt);
                if (cAnt > length - cAnt)
                {
                    System.out.println("cAnt = " + (length - cAnt));
                    cAnt = length - cAnt;
                }
                System.out.println(cAnt + " > " + smallest);
                if (cAnt > smallest)
                {
                    System.out.println("smallest = " + cAnt);
                    smallest = cAnt;
                }
            }
            System.out.println("");
            output[i][0] = smallest;
            output[i][1] = largest;
        }
        for (int i = 0; i < output.length; i++)
        {
            for (int j = 0; j < output[i].length; j++)
            {
                System.out.print(output[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

//2 10 3 2 6 7 214 7 11 12 7 13 176 23 191