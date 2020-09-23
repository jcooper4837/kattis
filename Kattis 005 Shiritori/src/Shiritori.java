
import java.util.ArrayList;
import java.util.Scanner;

public class Shiritori 
{

    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        boolean status = true;
        int game = 0;
        int count = 1;
        int test;
        String wordPrev;
        String wordNext;
        ArrayList<String> list = new ArrayList<>();

        //test = Integer.parseInt(args[0]);
        test = s.nextInt();
        
        if (test < 2)
            test = test;
        else if (test > 100000)
            test = 100000;
        //wordNext = args[1];
        wordNext = s.next();
        wordNext = wordNext.replaceAll("[^a-zA-Z\\s]", "");
        wordNext = wordNext.toLowerCase();
        wordNext = wordNext.substring(0, Math.min(wordNext.length(), 120));
        list.add(wordNext);

        for (int i = 1; i < test; i++) 
        {
            wordPrev = wordNext;
            //wordNext = args[i+1];
            wordNext = s.next();
            wordNext = wordNext.replaceAll("[^a-zA-Z\\s]", "");
            wordNext = wordNext.toLowerCase();
            wordNext = wordNext.substring(0, Math.min(wordNext.length(), 120));

            if (wordPrev.charAt(wordPrev.length() - 1) != wordNext.charAt(0)) 
                status = false;

            if (!status || list.contains(wordNext))
                game = count % 2 + 1;

            status = true;
            list.add(wordNext);
            count++;
        }

        if (game == 1)
            System.out.println("Player 1 lost");
        else if (game == 2)
            System.out.println("Player 2 lost");
        else
            System.out.println("Fair Game");
    }
}
