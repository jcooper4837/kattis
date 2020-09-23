
import java.util.Scanner;

public class Tarifa 
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int X;
        int N;
        int P = 0;
        int temp;
        
        X = s.nextInt();
        N = s.nextInt();
        
        for (int i = 0; i < N; i++)
        {
            temp = s.nextInt();
            P += X - temp;
        }
        
        P += X;
        System.out.println(P);
    }
}
