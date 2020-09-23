
import java.util.*;

public class Cannonball
{
    public double v0, theta, x1, h1, h2;
    public Cannonball(double a, double b, double c, double d, double e)
    {
        v0 = a;
        theta = b;
        x1 = c;
        h1 = d;
        h2 = e;
    }
    public void isSafe()
    {
        double time, y;
        time = x1 / (v0 * Math.cos(Math.toRadians(theta)));
        y = v0 * time * Math.sin(Math.toRadians(theta)) - (.5 * 9.81 * time * time);
        if (y > h1 + 1 && y < h2 - 1)
            System.out.println("Safe");
        else
            System.out.println("Not Safe");
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        Cannonball data[] = new Cannonball[cases];
        for (int i = 0; i < cases; i++)
        {
            double h[] = new double[5];
            for (int j = 0; j < 5; j++)
            {
                h[j] = s.nextDouble();
            }
            data[i] = new Cannonball(h[0], h[1], h[2], h[3], h[4]);
        }
        for (int i = 0; i < cases; i++)
        {
            data[i].isSafe();
        }
    }
}