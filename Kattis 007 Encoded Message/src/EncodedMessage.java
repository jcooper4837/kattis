
import java.util.Scanner;

public class EncodedMessage
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        String[] str = new String[size];
        String[] res = new String[size];
        
        for (int i = 0; i < size; i++)
        {
            str[i] = s.next();
        }
        
        for (int l = 0; l < size; l++)
        {
            char a[][] = new char[(int)Math.sqrt(str[l].length())][(int)Math.sqrt(str[l].length())];
            char b[][] = new char[a.length][a[0].length];
            int k = 0;
        
            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < a.length; j++)
                {
                    a[i][j] = str[l].charAt(k);
                    b[a.length - j - 1][i] = a[i][j];
                    k++;
                }
            }
            
            res[l] = "";
            
            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < a.length; j++)
                {
                    res[l] += b[i][j];
                }
            }
        }
        
        for (int i = 0; i < str.length; i++)
        {
            System.out.println(res[i]);
        }
    }
}