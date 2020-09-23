import java.util.*;

public class Display
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        ArrayList<String> times = new ArrayList<>();
        int i = 0;
        while (true)
        {
            times.add(s.next());
            if (times.get(i).equals("end"))
                break;
            i++;
        }
        char[] digits = new char[5];
        for (i = 0; i < times.size() - 1; i++)
        {
            digits = times.get(i).toCharArray();
            for (int j = 0; j < 7; j++)
            {
                for (int k = 0; k < digits.length; k++)
                {
                    if (k == 2)
                    {
                        if (j == 2 || j == 4)
                            System.out.print("o");
                        else
                            System.out.print(" ");
                    }
                    switch (j)
                    {
                        case 0:
                            switch (digits[k])
                            {
                                case '0':
                                case '2':
                                case '3':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9': System.out.print("+---+"); break;
                                case '1': System.out.print("    +"); break;
                                case '4': System.out.print("+   +"); break;
                            }
                            break;
                        case 1:
                        case 2:
                            switch (digits[k])
                            {
                                case '0':
                                case '4':
                                case '8':
                                case '9': System.out.print("|   |"); break;
                                case '1':
                                case '2':
                                case '3':
                                case '7': System.out.print("    |"); break;
                                case '5':
                                case '6': System.out.print("|    "); break;
                            }
                            break;
                        case 3:
                            switch (digits[k])
                            {
                                case '0': System.out.print("+   +"); break;
                                case '1':
                                case '7': System.out.print("    +"); break;
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '8':
                                case '9': System.out.print("+---+"); break;
                            }
                            break;
                        case 4:
                        case 5:
                            switch (digits[k])
                            {
                                case '0':
                                case '6':
                                case '8': System.out.print("|   |"); break;
                                case '1':
                                case '3':
                                case '4':
                                case '5':
                                case '7':
                                case '9': System.out.print("    |"); break;
                                case '2': System.out.print("|    "); break;
                            }
                            break;
                        case 6:
                            switch (digits[k])
                            {
                                case '0':
                                case '2':
                                case '3':
                                case '5':
                                case '6':
                                case '8':
                                case '9': System.out.print("+---+"); break;
                                case '1':
                                case '4':
                                case '7': System.out.print("    +"); break;
                            }
                            break;
                    }
                    if (k != 4)
                        System.out.print("  ");
                }
                System.out.println("");
            }
            System.out.println("\n");
        }
        System.out.println("end");
    }
}