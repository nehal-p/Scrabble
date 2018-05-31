package Scrabble;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DispWindow implements ActionListener
{
    private Database data;
    private int width;
    private int height;
    private JFrame frame;
    private JPanel pan;

    private JLabel enterName, enterContact, enterSName, enterProfile, mem1, mem2, score1, score2;
    private JTextField name, contact, searchName, profileName, pl1, pl2, sc1, sc2;
    private JButton addNew, modifyName, modifyCon, leaderBoards, profile, addMatch;

    private String newName, newCon, memName, prfName, player1, player2;
    private int p1Score, p2Score;

    public DispWindow(int width, int height)
    {
        data = new Database();
        this.width=width;
        this.height=height;

        frame = new JFrame("Scrabble");
        pan = new JPanel();
        name = new JTextField(20);
        contact = new JTextField(20);
        searchName = new JTextField(20);
        profileName = new JTextField(20);
        pl1 = new JTextField(20);
        pl2 = new JTextField(20);
        sc1 = new JTextField(20);
        sc2 = new JTextField(20);

        enterName = new JLabel("New member's name: ");
        enterContact = new JLabel("New member's contact no.: ");
        enterSName = new JLabel("Member's name: ");
        enterProfile = new JLabel("Member's name: ");
        mem1 = new JLabel("Player 1 name: ");
        mem2 = new JLabel("Player 2 name: ");
        score1 = new JLabel("Player 1 score (int): ");
        score2 = new JLabel("Player 2 score (int): ");

        frame.setVisible(true);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gui();
    }

    public void gui()
    {
        addNew = new JButton("Add new member");
        addNew.addActionListener(this);
        modifyName = new JButton("Edit member's name");
        modifyName.addActionListener(this);
        modifyCon = new JButton("Edit member's contact");
        modifyCon.addActionListener(this);
        leaderBoards = new JButton("Leaderboards");
        leaderBoards.addActionListener(this);
        profile = new JButton("View Profile");
        profile.addActionListener(this);
        addMatch = new JButton("Add Match Details");
        addMatch.addActionListener(this);

        pan.setLayout(null);

        enterName.setBounds(width/8,50,150,25);
        name.setBounds((width/8)+130,50,120,25);

        enterContact.setBounds(width/2,50,160,25);
        contact.setBounds((width/2)+160,50,120,25);

        enterSName.setBounds(width/3,200,150,25);
        searchName.setBounds((width/3)+130,200,120,25);

        enterProfile.setBounds(width/3,350,150,25);
        profileName.setBounds((width/3)+130,350,120,25);

        mem1.setBounds(width/8,600,150,25);
        pl1.setBounds((width/8)+130,600,120,25);

        mem2.setBounds(width/2,600,160,25);
        pl2.setBounds((width/2)+130,600,120,25);

        score1.setBounds(width/8,650,150,25);
        sc1.setBounds((width/8)+130,650,120,25);

        score2.setBounds(width/2,650,160,25);
        sc2.setBounds((width/2)+130,650,120,25);

        addNew.setBounds((width/2)-100,100,200,25);
        modifyName.setBounds(width/4,250,200,25);
        modifyCon.setBounds((width/4)+250,250,200,25);
        profile.setBounds((width/2)-100,400,200,25);
        leaderBoards.setBounds((width/2)-100,500,200,25);
        addMatch.setBounds((width/2)-100,700,200,25);

        pan.add(enterName);
        pan.add(name);
        pan.add(enterContact);
        pan.add(contact);
        pan.add(addNew);

        pan.add(enterSName);
        pan.add(searchName);
        pan.add(modifyName);
        pan.add(modifyCon);

        pan.add(enterProfile);
        pan.add(profileName);
        pan.add(profile);

        pan.add(leaderBoards);

        pan.add(mem1);
        pan.add(pl1);
        pan.add(mem2);
        pan.add(pl2);
        pan.add(score1);
        pan.add(sc1);
        pan.add(score2);
        pan.add(sc2);
        pan.add(addMatch);

        frame.add(pan);
    }

    public void actionPerformed(ActionEvent e)
    {
        /*
        Adds new members
        Makes sure the name of new members does not match with an existing member
         */
        if(e.getSource()==addNew)
        {
            newName = name.getText();
            newCon = contact.getText();
            if(newName.length()==0 || newCon.length()==0)
            {
                new InputError("Please enter all the details", "Error");
            }
            else
            {
                ArrayList <Member> members = data.getData();
                int flag = 0;
                for(int i=0;i<members.size();i++)
                {
                    if(members.get(i).getName().equals(newName))
                    {
                        new InputError("A member with this name already exists", "Error");
                        flag = 1;
                    }
                }
                if(flag == 0)
                {
                    Date d = new Date();
                    Member n = new Member(newName, d, newCon);
                    data.setData(n);
                    new InputError("A member named '"+newName+"' has been added", "Member Added");
                }
            }
        }
        /*
        Modify name and modify contact buttons
        Ensures input
        Ensures member exists
        Modifies the member details in the database
         */
        else if(e.getSource() == modifyName)
        {
            ArrayList <Member> members = data.getData();
            memName = searchName.getText();
            if(memName.length()==0)
            {
                new InputError("Please enter a name", "Error");
            }
            else
            {
                int flag = 0;
                for(int i=0;i<members.size();i++)
                {
                    if(members.get(i).getName().equals(memName))
                    {
                        new ModifyMember(members.get(i),1, data);
                        flag = 1;
                    }
                }
                if(flag == 0)
                    new InputError("No member with this name exists", "Error");
            }
        }
        else if(e.getSource() == modifyCon)
        {
            ArrayList <Member> members = data.getData();
            memName = searchName.getText();
            if(memName.length()==0)
            {
                new InputError("Please enter a name", "Error");
            }
            else
            {
                int flag = 0;
                for(int i=0;i<members.size();i++)
                {
                    if(members.get(i).getName().equals(memName))
                    {
                        new ModifyMember(members.get(i),2, data);
                        flag = 1;
                    }
                }
                if(flag == 0)
                    new InputError("No member with this name exists", "Error");
            }
        }
        /*
        View Profile of a member
        Ensures an input is given
        Ensures a member with the given name exists
         */
        else if(e.getSource() == profile)
        {
            ArrayList <Member> members = data.getData();
            prfName = profileName.getText();
            if(prfName.length()==0)
            {
                new InputError("Please enter a name", "Error");
            }
            else
            {
                int flag = 0;
                for(int i=0;i<members.size();i++)
                {
                    if(members.get(i).getName().equals(prfName))
                    {
                        new Profile(members.get(i));
                        flag = 1;
                    }
                }
                if(flag == 0)
                    new InputError("No member with this name exists", "Error");
            }
        }
        /*
        Adding match details
        Ideally this will be automatically simulated when a game is played but they are manually added here
         */
        else if(e.getSource() == addMatch)
        {
            ArrayList <Member> members = data.getData();
            int flag1=0;
            int flag2=0;
            player1 = pl1.getText();
            player2 = pl2.getText();
            if(sc1.getText().length()==0)
                p1Score=0;
            else
                p1Score = Integer.parseInt(sc1.getText());
            if(sc2.getText().length()==0)
                p2Score=0;
            else
                p2Score = Integer.parseInt(sc2.getText());

            /*
            Ensures all details are added
            Ensures that the members exist in the database
            Updates the match details for both members
             */
            if(player1.length()==0 || player2.length()==0 || p1Score==0 || p2Score==0)
            {
                new InputError("Please enter all details", "Error");
            }
            else
            {
                for(int i=0;i<members.size();i++)
                {
                    if(members.get(i).getName().equals(player1))
                    {
                        flag1=1;
                        for(int j=0;j<members.size();j++)
                        {
                            if(members.get(j).getName().equals(player2))
                            {
                                flag2=1;
                                Matches m = new Matches(members.get(i),members.get(j),p1Score,p2Score,new Date());
                                m.update();
                                new InputError("A match with these details has been added", "Match Added");
                            }
                        }
                        if(flag2==0)
                            new InputError("Player 2 "+player2+" doesn't exist", "Error");
                    }
                }
                if(flag1==0)
                {
                    new InputError("Player 1 "+player1+" doesn't exist", "Error");
                }
            }
        }
        /*
        If leaderboards button is pressed
         */
        else if(e.getSource() == leaderBoards)
        {
            new leaderboard(data);
        }
    }
}
