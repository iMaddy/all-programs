package com.maddy.systemdesign.callcenter;

/**
 * Created by gitanjali on 13/02/17.
 */
public class Call
{
    private Caller caller;
    private Rank rank;
    private CallAttendant callAttendant;


    public Call(Caller c)
    {
        caller = c;
        rank = Rank.Respondent;
    }

    public Rank getRank()
    {
        return rank;
    }

    public void increamentRank()
    {
        if(rank == Rank.Respondent)
        {
            rank = Rank.Manager;
        }
        else if(rank == Rank.Manager)
        {
            rank = Rank.Director;
        }
    }

    public int getCallerId()
    {
        return caller.getCallerId();
    }

    public void setCallAttendant(CallAttendant c)
    {
        callAttendant = c;
    }
}
