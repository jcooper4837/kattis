import java.util.*;

public class Everywhere
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        int numCities[] = new int[cases];
        int uniqueCities[] = new int[cases];
        for (int i = 0; i < cases; i++)
        {
            numCities[i] = s.nextInt();
            uniqueCities[i] = numCities[i];
            String cityList[] = new String[numCities[i]];
            for (int j = 0; j < numCities[i]; j++)
            {
                cityList[j] = s.next();
                for (int k = 0; k < j; k++)
                {
                    if (cityList[k].equals(cityList[j]))
                    {
                        cityList[k] = "";
                        uniqueCities[i]--;
                    }
                }
            }
        }
        for (int i = 0; i < cases; i++)
        {
            System.out.println(uniqueCities[i]);
        }
    }
}