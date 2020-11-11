import java.util.*;

public class Paintball
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        final int size = 1001;
        int op = s.nextInt(), x = 0, y = 0, r = 0;
        int[][] f = new int[size][size], err = new int[size][3];
        int[] resE = new int[2], resB = new int[2];
        double[] ans = new double[4];
        double h1 = 10.00, h2 = 10.00, temp, m1, m2, h1t, h2t;
        for (int i = 0; i < op; i++)
        {
            x = s.nextInt();
            y = s.nextInt();
            r = s.nextInt();
            err[i][0] = x;
            err[i][1] = y;
            err[i][2] = r;
            loadOpps(f, x, y, r);
        }//get all opponents and load them into field array
        for (int i = 0; i < f.length; i++)
        {
            if (canVisit(f, i, f[0].length-1))
            {
                f[i][f[0].length-1] = -3;
            }
        }//make all y values -3 when x is 1000
        //printField(f);
        for (int i = f[0].length - 1; i >= 0; i--)
        {
            if (canVisit(f, 0, i))
            {
                resE = findRoute(f, 0, i, resE);
            }//find route for valid start position
            if (resE[0] != 0)
            {
                resB[1] = i;
                i = -1;
            }//break if path to exit has been found
        }//loop through all possible start positions
        for (int i = 0; i < err.length; i++)
        {
            /*
            loop to calculate more precise begin and end coordinates
            field is represented with ints as floats are only needed for these 2 coordinates
            */
            if (err[i][2] == 0)
            {
                break;
            }//break if no more opponents
            h1t = pythag(err[i][0], resB[1]-err[i][1]) - err[i][2];
            h2t = pythag(f.length-1-err[i][0], resE[1]-err[i][1]) - err[i][2];
            if (Math.abs(h1t) < 1)
            {
                temp = 0.00;
                m1 = Math.abs(pythag(err[i][0], resB[1]-err[i][1]+temp) - err[i][2]);
                temp += 0.01;
                while (true)
                {
                    m2 = m1;
                    m1 = Math.abs(pythag(err[i][0], resB[1]-err[i][1]+temp) - err[i][2]);
                    temp += 0.01;
                    if (m1 > m2)
                    {
                        temp -= 0.02;
                        break;
                    }//break if incremented float is in opponent range
                    if (temp >= 1.00)
                    {
                        break;
                    }//break if float never crosses opponent range
                }//incrememnt float values to find the northernmost value that doesn't cross the opponent's range
                if (h1 > temp)
                {
                    h1 = temp;
                }//update if calculated value is less than previous
                //System.out.println(i + " " + resB[1] + "B " + h1);
            }//check if current opponent's range touches the begin coordinate
            if (Math.abs(h2t) < 1)
            {
                temp = 0.00;
                m1 = Math.abs(pythag(f.length-1-err[i][0], resE[1]-err[i][1]+temp) - err[i][2]);
                temp += 0.01;
                while (true)
                {
                    m2 = m1;
                    m1 = Math.abs(pythag(f.length-1-err[i][0], resE[1]-err[i][1]+temp) - err[i][2]);
                    temp += 0.01;
                    if (m1 > m2)
                    {
                        temp -= 0.02;
                        break;
                    }//break if incremented float is in opponent range
                    if (temp >= 1.00)
                    {
                        break;
                    }//break if float never crosses opponent range
                }//incrememnt float values to find the northernmost value that doesn't cross the opponent's range
                if (h2 > temp)
                {
                    h2 = temp;
                }//update if calculated value is less than previous
                //System.out.println(i + " " + resE[1] + "E " + h2);
            }//check if current opponent's range touches the end coordinate
        }//check all opponents to find which one's range reaches the begin and exit coordinates
        //could probably be broken up into sub function(s)
        if (resE[0] != 0)
        {
            //System.out.println(h1 + " " + h2);
            //dB[resB[1]] += resB[1];
            //dE[resE[1]] += resE[1];
            if (h1 >= 2.00)
            {
                h1 = 0.00;
            }//set h1 to 0 if float was never updated
            if (h2 >= 2.00)
            {
                h2 = 0.00;
            }//set h2 to 0 if float was never updated
            h1 += resB[1];
            h2 += resE[1];
            System.out.print("0.00 ");
            System.out.printf("%.2f", h1);
            System.out.print(" 1000.00 ");
            System.out.printf("%.2f", h2);
            System.out.println("");
        }//check if exit point was found
        else
        {
            System.out.println("IMPOSSIBLE");
        }
    }//main
    public static double pythag(double x, double y)
    {
        return Math.sqrt(x*x+y*y);
    }//returns the hypotenuse of a right triangle
    public static double distance(int x1, int y1, int x2, int y2)
    {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }//same as above except subtraction is done within function instead of parameter
    public static boolean canVisit(int[][] f, int x, int y)
    {
        return (x < f.length && x >= 0 && y < f[0].length && y >= 0 && (f[x][y] == 0 || f[x][y] == -3));
    }//checks if node can be visited
    public static void loadOpps(int[][] f, int x, int y, int r)
    {
        /*
        loads field with all possible opponent ranges accounted for
        represented as ints instead of floats as floats are only needed for final answer
        every node's coordinate represents the most top left area of that node
        any node that has at least 1 hundreth of a coordinate that is out of opponent range is marked uniquely
        ie if an opponent can reach (5.5, 5.5) but not (5.0, 5.0) then the node (5, 5) is marked uniquely
        */
        f[x][y] = -2;
        double h;
        for (int i = 1; i < r; i++)
        {
            if (canVisit(f, x+i, y))
            {
                f[x+i][y] = -2;
            }
            if (canVisit(f, x-i, y))
            {
                f[x-i][y] = -2;
            }
            if (canVisit(f, x, y+i))
            {
                f[x][y+i] = -2;
            }
            if (canVisit(f, x, y-i))
            {
                f[x][y-i] = -2;
            }
        }//loads horizontal and vertical ranges
        if (canVisit(f, x-r, y))
        {
            f[x-r][y] = -3;
        }
        if (canVisit(f, x, y-r))
        {
            f[x][y-r] = -3;
        }
        //loads additional node in negative directions
        for (int i = 0; i < 4; i++)
        {
            //iterates through all 4 quadrants and marks nodes within opponent range
            switch (i)
            {
                case 0:
                    for (int j = 1; j <= r; j++)
                    {
                        for (int k = 1; k <= r; k++)
                        {
                            if (canVisit(f, x+j, y+k))
                            {
                                h = pythag(j+1, k+1);
                                if (Math.floor(h) <= r)
                                {
                                    if (Math.floor(h) != r || (h - .001 < r))
                                    {
                                        f[x+j][y+k] = -2;
                                    }//checks if node is 100% in range
                                    else
                                    {
                                        f[x+j][y+k] = -3;
                                    }//node is partially in range
                                }//checks if node is in range
                                else
                                {
                                    k = r;
                                }
                            }//checks if node can be visited
                            else if (y+k >= f[0].length)
                            {
                                k = r;
                            }//checks if node is out of range
                        }//y
                    }//x
                    break;
                //cases below echo above
                //could probably be broken up into sub function(s)
                case 1:
                    for (int j = 1; j <= r; j++)
                    {
                        for (int k = 1; k <= r; k++)
                        {
                            if (canVisit(f, x-j, y+k))
                            {
                                h = pythag(j, k+1);
                                if (Math.floor(h) <= r)
                                {
                                    if (Math.floor(h) != r || (h - .001 < r))
                                    {
                                        f[x-j][y+k] = -2;
                                    }
                                    else
                                    {
                                        f[x-j][y+k] = -3;
                                    }
                                }
                                else
                                {
                                    k = r;
                                }
                            }
                            else if (y+k >= f[0].length)
                            {
                                k = r;
                            }
                        }
                    }
                    break;
                case 2:
                    for (int j = 1; j <= r; j++)
                    {
                        for (int k = 1; k <= r; k++)
                        {
                            if (canVisit(f, x-j, y-k))
                            {
                                h = pythag(j, k);
                                if (Math.floor(h) <= r)
                                {
                                    if (Math.floor(h) != r || (h - .001 < r))
                                    {
                                        f[x-j][y-k] = -2;
                                    }
                                    else
                                    {
                                        f[x-j][y-k] = -3;
                                    }
                                }
                                else
                                {
                                    k = r;
                                }
                            }
                            else if (y-k < 0)
                            {
                                k = r;
                            }
                        }
                    }
                    break;
                case 3:
                    for (int j = 1; j <= r; j++)
                    {
                        for (int k = 1; k <= r; k++)
                        {
                            if (canVisit(f, x+j, y-k))
                            {
                                h = pythag(j+1, k);
                                if (Math.floor(h) <= r)
                                {
                                    if (Math.floor(h) != r || (h - .001 < r))
                                    {
                                        f[x+j][y-k] = -2;
                                    }
                                    else
                                    {
                                        f[x+j][y-k] = -3;
                                    }
                                }
                                else
                                {
                                    k = r;
                                }
                            }
                            else if (y-k < 0)
                            {
                                k = r;
                            }
                        }
                    }
                    break;
            }
        }
    }//loadOpps
    public static int[] findRoute(int[][] f, int x, int y, int[] res)
    {
        /*
        algorithm to find northernmost route through field
        greedy, prioritizes northeast direction
        passes through nodes marked as partially in range
        */
        ArrayList<Integer> p = new ArrayList<>();
        p.add(0, x);
        p.add(1, y);
        while (!p.isEmpty())
        {
            x = p.get(p.size()-2);
            y = p.get(p.size()-1);
            if (f[x][y] == 0)
            {
                f[x][y] = -1;
            }//check if node is not in range
            else
            {
                f[x][y] = -4;
            }//node is partially in range
            if (x == f.length - 1)
            {
                res[0] = x;
                res[1] = y;
                return res;
            }//checks if end node has been reached
            if (canVisit(f, x, y+1))
            {
                p.add(x);
                p.add(y+1);
            }//check north
            else if (canVisit(f, x+1, y))
            {
                p.add(x+1);
                p.add(y);
            }//check east
            else if (canVisit(f, x, y-1))
            {
                p.add(x);
                p.add(y-1);
            }//check south
            else if (canVisit(f, x-1, y))
            {
                p.add(x-1);
                p.add(y);
            }//check west
            else
            {
                p.remove(p.size()-1);
                p.remove(p.size()-1);
            }//no node can be visited
        }//loop while there are nodes to visit
        return res;
    }//findRoute
    public static void printField(int[][] f)
    {
        for (int i = 0; i < f[0].length; i++)
        {
            for (int j = 0; j < f.length; j++)
            {
                switch (f[j][i])
                {
                    case 0://out of range
                        System.out.print(".");
                        break;
                    case 1://visited out of range
                        System.out.print("o");
                        break;
                    case -2://in range
                        System.out.print("#");
                        break;
                    case -3://partially in range
                        System.out.print("%");
                        break;
                    case -4://visited partially in range
                        System.out.println("@");
                        break;
                    default:
                        break;
                }
            }
            System.out.println("");
        }
        System.out.println("\n---------------------------------------------\n\n");
    }//print function used in debugging
}

/*
3
50 50 49
0 0 99
100 100 20
*/