package Scrabble;

import java.util.*;

public class Member
{
    private String name;
    private Date joinDate;
    private String contactDetails;

    private int highScore=0;
    private Date highScoreDate;
    private Member highScoreOpp;

    private float avgScore=0;
    private int win=0;
    private int loss=0;
    private int flag=0;
    /*
    Stores details of all matches of this member
     */
    private ArrayList<Integer> score = new ArrayList<>();
    private ArrayList<Date> matchDates = new ArrayList<>();
    private ArrayList<Member> opponent = new ArrayList<>();

    public Member(String name, Date joinDate, String contactDetails)
    {
        this.name = name;
        this.joinDate = joinDate;
        this.contactDetails = contactDetails;
    }
    /*
    Calculates avg score
     */
    public void calcAvgScore()
    {
        int sum=0;
        for(int i=0; i<score.size(); i++)
            sum+=score.get(i);
        avgScore = sum/score.size();

    }
    /*
    Calculates high score
     */
    public void calcHighScore()
    {
        int temp = score.get(0);
        int index = 0;
        for(int i=0; i<score.size(); i++)
        {
            if(temp<score.get(i))
            {
                temp=score.get(i);
                index=i;
            }
        }
        highScore = temp;
        highScoreDate = matchDates.get(index);
        highScoreOpp = opponent.get(index);
    }
    /*
    Adds all match details for a member
    Recalculates avg score and high score
    flag ensures that the return value for getHighScore method never gives error
     */
    public void addScore(int s, Date d, Member m, boolean b)
    {
        flag = 1;
        score.add(s);
        matchDates.add(d);
        opponent.add(m);
        if(b)
            win++;
        else
            loss++;
        calcAvgScore();
        calcHighScore();
    }

    public String getName()
    {
        return name;
    }

    public String getContactDetails()
    {
        return contactDetails;
    }

    public Date getJoinDate()
    {
        return joinDate;
    }

    public int getHighScore()
    {
        return highScore;
    }

    public float getAvgScore()
    {
        return avgScore;
    }

    public int getWins()
    {
        return win;
    }

    public int getLosses()
    {
        return loss;
    }

    public String getHSOpp()
    {
        /*
        If no match has been played yet, return blank name
         */
        if(flag==0)
            highScoreOpp = new Member("",new Date(),"");
        return highScoreOpp.getName();
    }

    public Date getHSDate()
    {
        return highScoreDate;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setContactDetails(String s)
    {
        contactDetails = s;
    }
}
