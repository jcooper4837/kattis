
import java.util.*;

public class Bacon
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int in = s.nextInt();
        while (in > 0)
        {
            ArrayList<String> x = new ArrayList<>();
            ArrayList<String> y = new ArrayList<>();
            String[] items = new String[in];
            s.nextLine();
            for (int i = 0; i < in; i++)
            {
                items[i] = s.nextLine();
                String[] food = items[i].split(" ");
                for (int j = 0; j < food.length - 1; j++)
                {
                    if (!x.contains(food[j + 1]))
                    {
                        x.add(food[j + 1]);
                        y.add(food[j + 1] + " " + food[0]);
                    }
                    else
                    {
                        int index = x.indexOf(food[j + 1]);
                        y.set(index, y.get(index) + " " + food[0]);
                    }
                }
            }
            Collections.sort(y);
            for (int i = 0; i < y.size(); i++)
            {
                System.out.println(y.get(i));
            }
            System.out.println("");
            in = s.nextInt();
        }
    }
}