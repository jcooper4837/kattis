
import java.util.*;

public class Ants
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int cases, max, min, length, num, ant;
        cases = s.nextInt();
        for (int i = 0; i < cases; i++)
        {
            length = s.nextInt();
            num = s.nextInt();
            max = 0;
            min = 0;
            for (int j = 0; j < num; j++)
            {
                ant = s.nextInt();
                if (ant > max)
                    max = ant;
                if (length - ant > max)
                    max = length - ant;
                if (ant > length - ant)
                    ant = length - ant;
                if (ant > min)
                    min = ant;
            }
            System.out.println(min + " " + max);
        }
    }
}

//2 10 3 2 6 7 214 7 11 12 7 13 176 23 191