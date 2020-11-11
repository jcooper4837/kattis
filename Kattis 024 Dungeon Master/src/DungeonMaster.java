import java.util.*;

public class DungeonMaster
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int lvl, row, col, min, size;
        char[][][] dungeon;
        int[][][] paths;
        ArrayList<int[]> nodes = new ArrayList<>();
        int[] temp;
        boolean cont;
        String input;
        while (true)
        {
            lvl = s.nextInt();
            row = s.nextInt();
            col = s.nextInt();
            if (lvl == 0 && row == 0 && col == 0)
            {
                break;
            }//exit condition
            dungeon = new char[lvl][row][col];
            paths = new int[lvl][row][col];
            temp = new int[4];
            cont = true;
            min = -1;
            while (nodes.size() > 0)
            {
                nodes.remove(0);
            }//reset arraylist
            for (int i = 0; i < lvl; i++)
            {
                for (int j = 0; j < row; j++)
                {
                    input = s.next();
                    for (int k = 0; k < col; k++)
                    {
                        dungeon[i][j][k] = input.charAt(k);
                        switch (dungeon[i][j][k])
                        {
                            case '.':
                                paths[i][j][k] = -1;
                                break;
                            case '#':
                                paths[i][j][k] = -3;
                                break;
                            case 'S':
                                temp[1] = i;
                                temp[2] = j;
                                temp[3] = k;
                                paths[i][j][k] = 0;
                                break;
                            case 'E':
                                paths[i][j][k] = -2;
                                break;
                            default:
                                break;
                        }//convert char to int interpretation
                    }//iterate cols
                }//iterate rows
            }//iterate lvls
            nodes.add(temp);
            paths[temp[1]][temp[2]][temp[3]] = 0;
            while (cont)
            {
                size = nodes.size();
                for (int i = 0; i < size; i++)
                {
                    temp = nodes.get(0);
                    //System.out.println(temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[3]);
                    if (searchRoutes(temp[1], temp[2], temp[3], paths, nodes, temp))
                    {
                        cont = false;
                        min = temp[0];
                        break;
                    }//break if exit path is found
                }//search every node for unvisited following node
                //printDungeon(paths);
                if (nodes.isEmpty())
                {
                    cont = false;
                }//break if no path is found
                //System.out.println("\n");
            }
            //min = findRoute(itL, itR, itC, endL, endR, endC, paths, -1, 0);
            //printDungeon(paths);
            if (min > 0)
            {
                System.out.println("Escaped in " + min + " minute(s).");
            }
            else
            {
                System.out.println("Trapped!");
            }
        }//main function loop
    }//main
    public static boolean searchRoutes(int lvl, int r, int c, int[][][] d, ArrayList<int[]> n, int[] arr)
    {
        /*
        algorithm to find shortest path
        similar to dijkstra, checks every node simultaneously
        */
        arr[0]++;
        //printDungeon(d);
        if (lvl+1 < d.length && (d[lvl+1][r][c] == -1 || d[lvl+1][r][c] == -2))
        {
            if (d[lvl+1][r][c] == -2)
            {
                return true;
            }//path found
            d[lvl+1][r][c] = arr[0];
            int[] t = arr.clone();
            t[1]++;
            n.add(t);
        }//check if following level can be visited
        if (lvl-1 >= 0 && (d[lvl-1][r][c] == -1 || d[lvl-1][r][c] == -2))
        {
            if (d[lvl-1][r][c] == -2)
            {
                return true;
            }//path found
            d[lvl-1][r][c] = arr[0];
            int[] t = arr.clone();
            t[1]--;
            n.add(t);
        }//check if previous level can be visited
        if (r+1 < d[0].length && (d[lvl][r+1][c] == -1 || d[lvl][r+1][c] == -2))
        {
            if (d[lvl][r+1][c] == -2)
            {
                return true;
            }//path found
            d[lvl][r+1][c] = arr[0];
            int[] t = arr.clone();
            t[2]++;
            n.add(t);
        }//check if following row can be visited
        if (r-1 >= 0 && (d[lvl][r-1][c] == -1 || d[lvl][r-1][c] == -2))
        {
            if (d[lvl][r-1][c] == -2)
            {
                return true;
            }//path found
            d[lvl][r-1][c] = arr[0];
            int[] t = arr.clone();
            t[2]--;
            n.add(t);
        }//check if previous row can be visited
        if (c+1 < d[0][0].length && (d[lvl][r][c+1] == -1 || d[lvl][r][c+1] == -2))
        {
            if (d[lvl][r][c+1] == -2)
            {
                return true;
            }//path found
            d[lvl][r][c+1] = arr[0];
            int[] t = arr.clone();
            t[3]++;
            n.add(t);
        }//check if following column can be visited
        if (c-1 >= 0 && (d[lvl][r][c-1] == -1 || d[lvl][r][c-1] == -2))
        {
            if (d[lvl][r][c-1] == -2)
            {
                return true;
            }//path found
            d[lvl][r][c-1] = arr[0];
            int[] t = arr.clone();
            t[3]--;
            n.add(t);
        }//check if previous column can be visited
        n.remove(0);
        return false;
    }//searchRoutes
    public static void printDungeon(int[][][] d)
    {
        for (int i = 0; i < d.length; i++)
        {
            for (int j = 0; j < d[0].length; j++)
            {
                for (int k = 0; k < d[0][0].length; k++)
                {
                    if (d[i][j][k] == -1)
                    {
                        System.out.print(".   ");
                    }//unvisited
                    else if (d[i][j][k] == -3)
                    {
                        System.out.print("#   ");
                    }//wall
                    else if (d[i][j][k] == -2)
                    {
                        System.out.println("E   ");
                    }//exit
                    else if (d[i][j][k] >= 0 && d[i][j][k] < 10)
                    {
                        System.out.print(d[i][j][k] + "   ");
                    }//visited 1 digit
                    else if (d[i][j][k] < 0 && d[i][j][k] > -10 || d[i][j][k] >= 10 && d[i][j][k] < 100)
                    {
                        System.out.print(d[i][j][k] + "  ");
                    }//visited 2 digit
                    else
                    {
                        System.out.print(d[i][j][k] + " ");
                    }//visited 3 digit
                }
                System.out.println("");
            }
            System.out.println("---------------------------------------------");
        }
        System.out.println("\n---------------------------------------------\n\n");
    }//print function used in debugging
    public static char[] getOrder(int lvl, int r, int c)
    {
        /*
        find best order of directions to search
        order is based on how far the current lvl/r/c is from exit lvl/r/c
        */
        char[] res = new char[6];
        int dl = Math.abs(lvl), dr = Math.abs(r), dc = Math.abs(c);
        if (dl >= dr && dl >= dc)
        {
            res[0] = 'l';
            if (dr > dc)
            {
                res[1] = 'r';
                res[2] = 'c';
                res[3] = 'c';
                res[4] = 'r';
                res[5] = 'l';
            }
            else
            {
                res[1] = 'c';
                res[2] = 'r';
                res[3] = 'r';
                res[4] = 'c';
                res[5] = 'l';
            }
        }
        else if (dr >= dl && dr >= dc)
        {
            res[0] = 'r';
            if (dl > dc)
            {
                res[1] = 'l';
                res[2] = 'c';
                res[3] = 'c';
                res[4] = 'l';
                res[5] = 'r';
            }
            else
            {
                res[1] = 'c';
                res[2] = 'l';
                res[3] = 'l';
                res[4] = 'c';
                res[5] = 'r';
            }
        }
        else
        {
            res[0] = 'c';
            if (dl > dr)
            {
                res[1] = 'l';
                res[2] = 'r';
                res[3] = 'r';
                res[4] = 'l';
                res[5] = 'c';
            }
            else
            {
                res[1] = 'r';
                res[2] = 'l';
                res[3] = 'l';
                res[4] = 'r';
                res[5] = 'c';
            }
        }
        return res;
    }//getOrder
    public static int findRoute(int lvl, int r, int c, int el, int er, int ec, int[][][] d, int m, int cnt)
    {
        /*
        slower recursive algorithm to find shortest path
        more greedy, tries to 'smartly' determine shortest path first, then tries other applicable solutions
        longest test case had about 3s runtime
        */
        char[] order = getOrder(el-lvl, er-r, ec-c);
        //char[] order = {'c', 'r', 'l', 'c', 'r', 'l'};
        int sign = 1;
        for (int i = 0; i < order.length; i++)
        {
            if (m != -1 && (Math.abs(Math.abs(el-lvl)+Math.abs(er-r)+Math.abs(ec-c))) >= (m-cnt))
            {
                return m;
            }//if path has been found and current node is too far away from exit to result in new shortest path
            if (i >= 3)
            {
                sign = -1;
            }//if all 3 dimensions have been tested, flip direction and try again
            if (d[lvl][r][c] == -1 || d[lvl][r][c] > cnt)
            {
                d[lvl][r][c] = cnt;
                //printDungeon(d);
            }//update distance to current node if unvisited or smaller
            switch (order[i])
            {
                case 'l':
                    if (sign * Integer.signum(el-lvl) > 0)
                    {
                        if (lvl+1 < d.length && (d[lvl+1][r][c] == -1 || d[lvl+1][r][c] == -2 || d[lvl+1][r][c] > 0))
                        {
                            if (d[lvl+1][r][c] > 0 && d[lvl+1][r][c] <= cnt)
                            {
                                break;
                            }//break if node has been visited in shorter time before
                            if (d[lvl+1][r][c] == -2)
                            {
                                if (m > cnt+1 || m == -1)
                                {
                                    m = cnt+1;
                                }//update min if new path is smaller
                                return m;
                            }//if end is found
                            if (d[lvl][r][c] != -2)
                            {
                                //d[lvl][r][c] = cnt;
                            }
                            if (m > cnt+1 || m == -1)
                            {
                                m = findRoute(lvl+1, r, c, el, er, ec, d, m, cnt+1);
                            }//check next node
                            else 
                            {
                                return m;
                            }//return to previous node
                        }//checks if node can be visited
                    }//checks direction that faces exit first
                    //below cases echo this one
                    else
                    {
                        if (lvl-1 >= 0 && (d[lvl-1][r][c] == -1 || d[lvl-1][r][c] == -2 || d[lvl-1][r][c] > 0))
                        {
                            if (d[lvl-1][r][c] > 0 && d[lvl-1][r][c] < cnt)
                            {
                                break;
                            }
                            if (d[lvl-1][r][c] == -2)
                            {
                                if (m > cnt+1 || m == -1)
                                {
                                    m = cnt+1;
                                }
                                return m;
                            }
                            if (m > cnt+1 || m == -1)
                            {
                                m = findRoute(lvl-1, r, c, el, er, ec, d, m, cnt+1);
                            }
                            else 
                            {
                                return m;
                            }
                        }
                    }
                    break;
                case 'r':
                    if (sign * Integer.signum(er-r) > 0)
                    {
                        if (r+1 < d[0].length && (d[lvl][r+1][c] == -1 || d[lvl][r+1][c] == -2 || d[lvl][r+1][c] > 0))
                        {
                            if (d[lvl][r+1][c] > 0 && d[lvl][r+1][c] < cnt)
                            {
                                break;
                            }
                            if (d[lvl][r+1][c] == -2)
                            {
                                if (m > cnt+1 || m == -1)
                                {
                                    m = cnt+1;
                                }
                                return m;
                            }
                            if (m > cnt+1 || m == -1)
                            {
                                m = findRoute(lvl, r+1, c, el, er, ec, d, m, cnt+1);
                            }
                            else 
                            {
                                return m;
                            }
                        }
                    }
                    else
                    {
                        if (r-1 >= 0 && (d[lvl][r-1][c] == -1 || d[lvl][r-1][c] == -2 || d[lvl][r-1][c] > 0))
                        {
                            if (d[lvl][r-1][c] > 0 && d[lvl][r-1][c] < cnt)
                            {
                                break;
                            }
                            if (d[lvl][r-1][c] == -2)
                            {
                                if (m > cnt+1 || m == -1)
                                {
                                    m = cnt+1;
                                }
                                return m;
                            }
                            if (m > cnt+1 || m == -1)
                            {
                                m = findRoute(lvl, r-1, c, el, er, ec, d, m, cnt+1);
                            }
                            else 
                            {
                                return m;
                            }
                        }
                    }
                    break;
                case 'c':
                    if (sign * Integer.signum(ec-c) > 0)
                    {
                        if (c+1 < d[0][0].length && (d[lvl][r][c+1] == -1 || d[lvl][r][c+1] == -2 || d[lvl][r][c+1] > 0))
                        {
                            if (d[lvl][r][c+1] > 0 && d[lvl][r][c+1] < cnt)
                            {
                                break;
                            }
                            if (d[lvl][r][c+1] == -2)
                            {
                                if (m > cnt+1 || m == -1)
                                {
                                    m = cnt+1;
                                }
                                return m;
                            }
                            if (m > cnt+1 || m == -1)
                            {
                                m = findRoute(lvl, r, c+1, el, er, ec, d, m, cnt+1);
                            }
                            else 
                            {
                                return m;
                            }
                        }
                    }
                    else
                    {
                        if (c-1 >= 0 && (d[lvl][r][c-1] == -1 || d[lvl][r][c-1] == -2 || d[lvl][r][c-1] > 0))
                                 //|| (d[lvl][r][c-1] > 0 && d[lvl][r][c-1] < cnt)))
                        {
                            if (d[lvl][r][c-1] > 0 && d[lvl][r][c-1] < cnt)
                            {
                                break;
                            }
                            if (d[lvl][r][c-1] == -2)
                            {
                                if (m > cnt+1 || m == -1)
                                {
                                    m = cnt+1;
                                }
                                return m;
                            }
                            if (m > cnt+1 || m == -1)
                            {
                                m = findRoute(lvl, r, c-1, el, er, ec, d, m, cnt+1);
                            }
                            else 
                            {
                                return m;
                            }
                        }
                    }
                    break;
            }//tests dimensions in calculated order to find the shortest path quickly
            //could probably be broken up into sub function(s)
        }
        if (d[lvl][r][c] == -2)
        {
            if (m > cnt+1 || m == -1)
            {
                m = cnt;
            }//update minimum if new path is smaller
            return m;
        }//if exit has been found
        else
        {
            //d[lvl][r][c] = -1;
        }
        return m;
    }//findRoute
}

/*
3 4 5
S....
.###.
.##..
###.#

#####
#####
##.##
##...

#####
#####
#.###
####E

1 3 3
S##
#E#
###

3 4 5
S....
.###.
..E..
###.#

.####
#####
##.##
##...

.....
####.
#.##.
####.

3 3 3
S..
...
...

...
...
..#

...
..#
.#E

3 3 3
S..
...
...

...
...
...

...
...
..E

5 5 5
S....
.....
.....
.....
.....

.....
.....
.....
.....
.....

.....
.....
.....
.....
.....

.....
.....
.....
.....
.....

.....
.....
.....
.....
....E

5 10 10
S.........
..........
..........
..........
..........
..........
..........
..........
..........
..........

..........
..........
..........
..........
..........
..........
..........
..........
..........
..........

..........
..........
..........
..........
..........
..........
..........
..........
..........
..........

..........
..........
..........
..........
..........
..........
..........
..........
..........
..........

..........
..........
..........
..........
..........
..........
..........
..........
..........
.........E

0 0 0

*/