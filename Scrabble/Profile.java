package Scrabble;

import javax.swing.*;
import java.awt.*;

public class Profile extends JFrame
{
    private JLabel name, contact, joinDate, noWins, noLoss, avg, high, time, opp;
    private  JPanel p;
    /*
    Shows the profile of a member
     */
    public Profile(Member m)
    {
        setVisible(true);
        setSize(800,600);
        setTitle("Member Profile");
        setLayout(null);

        name = new JLabel("Member's name: "+m.getName());
        contact = new JLabel("Member's contact: "+m.getContactDetails());
        joinDate = new JLabel("Date Joined: "+m.getJoinDate());
        noWins = new JLabel("No. of Wins: "+m.getWins());
        noLoss = new JLabel("No. of Losses: "+m.getLosses());
        avg = new JLabel("Average Score: "+m.getAvgScore());
        high = new JLabel("Highest Score: "+m.getHighScore());
        time = new JLabel("High Score Date: "+m.getHSDate());
        opp = new JLabel("High Score opponent: "+m.getHSOpp());

        name.setBounds(400,50,200,25);
        contact.setBounds(400,100,200,25);
        joinDate.setBounds(400,150,200,25);
        noWins.setBounds(400,200,200,25);
        noLoss.setBounds(400,250,200,25);
        avg.setBounds(400,300,200,25);
        high.setBounds(400,350,200,25);
        time.setBounds(400,400,200,25);
        opp.setBounds(400,450,200,25);

        add(name);
        add(contact);
        add(joinDate);
        add(noWins);
        add(noLoss);
        add(avg);
        add(high);
        add(time);
        add(opp);
    }
}
