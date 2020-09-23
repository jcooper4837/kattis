import java.util.*;

public class Reverse
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String b = Integer.toBinaryString(n);
        String rev = "";
        for (int i = b.length() - 1; i >= 0; i--)
        {
            rev += b.charAt(i);
        }
        n = Integer.parseInt(rev, 2);
        System.out.println(n);
    }
}