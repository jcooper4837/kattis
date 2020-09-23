import java.util.*;

public class Moose
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String ls = s.next(), rs = s.next();
        int ln = Integer.parseInt(ls), rn = Integer.parseInt(rs);
        if (ln == 0 && rn == 0)
            System.out.println("Not a moose");
        else if (ln == rn)
            System.out.println("Even " + (ln + rn));
        else
        {
            System.out.print("Odd ");
            if (ln > rn)
                System.out.println(ln * 2);
            else
                System.out.println(rn * 2);
        }
    }
}