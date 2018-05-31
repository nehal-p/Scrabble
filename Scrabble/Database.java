package Scrabble;

import java.util.ArrayList;

public class Database
{
    /*
    Stores all the members
     */
    private ArrayList <Member> members;

    public Database()
    {
        members = new ArrayList<>();
    }

    public ArrayList<Member> getData()
    {
        return members;
    }

    public void setData(Member m)
    {
        members.add(m);
    }
    /*
    Updates database with the given changes
     */
    public void update(Member m, String s, int n)
    {
        for(int i=0; i<members.size(); i++)
        {
            if(members.get(i).getName() == m.getName())
            {
                if(n==1)
                    members.get(i).setName(s);
                else if(n==2)
                    members.get(i).setContactDetails(s);
            }
        }
    }
}
