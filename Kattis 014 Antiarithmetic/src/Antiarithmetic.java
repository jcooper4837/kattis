import java.util.*;

public class Antiarithmetic
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String input[] = new String[6];
        boolean cont = true;
        int a = 0;
        while (cont)
        {
            input[a] = s.nextLine();
            if (input[a].equals("0"))
            {
                cont = false;
                a--;
            }
            a++;
        }
        int x[] = new int[a];
        String[] anti = new String[a];
        for (int i = 0; i < a; i++)
        {
            anti[i] = "yes";
        }
        cont = true;
        a = 0;
        int b;
        while (cont)
        {
            if (input[a].equals("0"))
            {
                cont = false;
            }
            else
            {
                x[a] = Integer.parseInt(input[a].substring(0, input[a].indexOf(':')));
                int summation = 0;
                for (int i = x[a] - 1; i > 1; i--)
                {
                    summation += i;
                }
                int y[] = new int[x[a]];
                String str[] = input[a].split("[^0-9']+");
                int values[] = new int[str.length];
                for (int i = 0; i < values.length; i++)
                {
                    values[i] = Integer.parseInt(str[i]);
                    //System.out.println("values[" + i + "] = " + values[i]);
                }
                int num[] = new int[summation+1];
                for (int i = 0; i < num.length; i++)
                {
                    num[i] = 9999999;
                }
                int c[] = new int[num.length * 2];
                b = 0;
                for (int i = 1; i < values.length; i++)
                {
                    for (int j = i + 1; j < values.length; j++)
                    {
                        //System.out.println(b);
                        num[b] = values[i] - values[j];
                        c[b] = i;
                        c[summation + b] = j;
                        //System.out.println(values[i] + " - " + values[j] + " = " + num[b]);
                        b++;
                    }
                }
                for (int i = 0; i < c.length; i++)
                {
                    //System.out.println("c[" + i + "] = " + c[i]);
                }
                for (int i = 0; i < num.length; i++)
                {
                    //System.out.println("num[" + i + "] = " + num[i]);
                }
                boolean cont2 = true;
                for (int i = 0; i < num.length; i++)
                {
                    if (num[i] == 9999999 || !cont2)
                    {
                        break;
                    }
                    for (int j = 0; j < i; j++)
                    {
                        //System.out.println("near the end: " + i + "     " + num[i] + "     " + j + "     " + num[j]);
                        if (num[i] == num[j])
                        {
                            //System.out.println(i + "     " + num[i] + "     " + j + "     " + num[j]);
                            //System.out.println("match #1!     " + (c[i]) + "     " + c[i + summation]);
                            //System.out.println("match #2!     " + (c[j]) + "     " + c[j + summation]);
                            //System.out.println((c[i] < c[i + summation]) + "   " + (c[j] < c[j + summation]) + "   " + ((c[i + summation] == c[j]) || (c[j + summation] == c[i])));
                            if (c[i] < c[i + summation] && c[j] < c[j + summation] && (c[i + summation] == c[j] || c[j + summation] == c[i]))
                            {
                                //System.out.println("all were true! dope!");
                                anti[a] = "no";
                                cont2 = false;
                                break;
                            }
                        }
                    }
                }
            }
            a++;
        }
        for (int i = 0; i < anti.length; i++)
        {
            System.out.println(anti[i]);
        }
    }
}