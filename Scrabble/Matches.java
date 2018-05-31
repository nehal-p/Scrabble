package Scrabble;
import java.util.*;

public class Matches
{
    private Member p1;
    private Member p2;
    private int score1, score2;
    private Date matchDate;
    /*
    Stores the match details
     */
    public Matches(Member p1, Member p2, int score1, int score2, Date matchDate)
    {
        this.p1=p1;
        this.p2=p2;
        this.score1=score1;
        this.score2=score2;
        this.matchDate=matchDate;
    }

    public void update()
    {
        boolean winner;
        if(score1>score2)
            winner = true;
        else winner = false;
        p1.addScore(score1,matchDate,p2,winner);
        p2.addScore(score2,matchDate,p1,!winner);
    }
}
