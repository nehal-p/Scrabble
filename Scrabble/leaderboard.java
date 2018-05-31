package Scrabble;

import javax.swing.*;
import java.util.*;

public class leaderboard extends JFrame
{
    private JLabel leader;
    private JLabel err;
    private JLabel[] players;
    private ArrayList<Member> m;
    private Float [] high;
    private String[] names;
    private int flag = 0;

    public leaderboard(Database d)
    {
        m = d.getData();

        setVisible(true);
        setSize(500,500);
        setTitle("Leaderboards");
        setLayout(null);
        leader = new JLabel("LeaderBoard");

        findHigh();

        leader.setBounds(200,50,100,25);
        add(leader);
        /*
        * Flag ensures that labels are printed only if players that have played >10 games exist
        */
        if(flag==0)
            for(int i=players.length-1; i>=0; i--)
            {
                players[i].setBounds(150,50+((players.length-i)*25),200,25);
                add(players[i]);
            }
    }

    public void findHigh()
    {
        ArrayList<Member> tempMem = new ArrayList<>();
        /*
        Ensuring a total of 10 games to be included in the leaderboard
        Adding those members to tempMem array
         */
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getWins() + m.get(i).getLosses() >= 10)
                tempMem.add(m.get(i));
        }
        /*
        High stores all avg scores
        names stores the names of members with respect to the scores
         */
        high = new Float[tempMem.size()];
        names = new String[tempMem.size()];

        if(tempMem.size() == 0)
            flag = 1;

        players = new JLabel[tempMem.size()];
        /*
        Adding the respective values to each array for scores and names
         */
        for (int i = 0; i < tempMem.size(); i++)
        {
            players[i] = new JLabel();
            high[i] = tempMem.get(i).getAvgScore();
            names[i] = tempMem.get(i).getName();
        }
        /*
        Bubble Sort only if there are multiple members with >=10 games
         */
        if(high.length>1)
        {
            int n = high.length;
            int k;
            for (int z = n; z >= 0; z--)
            {
                for (int i = 0; i < n - 1; i++)
                {
                    k = i + 1;
                    if (high[i] > high[k])
                    {
                        float temp;
                        temp = high[i];
                        high[i] = high[k];
                        high[k] = temp;

                        String t;
                        t = names[i];
                        names[i] = names[k];
                        names[k] = t;
                    }
                }
            }
        }
        /*
        Checking if there are 0 players with >=10 games
         */
        else if(high.length == 0)
        {
            err = new JLabel("No player has played 10 games yet");
            err.setBounds(150,100,200,25);
            add(err);
        }
        /*
        Setting labels for the members on leaderboard
         */
        for(int i= high.length-1; i>=Math.max(high.length-11,0); i--)
        {
            players[i].setText("Avg Score: "+high[i]+" Player Name: "+names[i]);
        }
    }
}
