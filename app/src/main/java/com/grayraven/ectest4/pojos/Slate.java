package com.grayraven.ectest4.pojos;

public class Slate
{
    private String party;

    private String candidates;

    public Slate() {}

    public String getParty ()
    {
        return party;
    }

    public void setParty (String party)
    {
        this.party = party;
    }

    public String getCandidates ()
    {
        return candidates;
    }

    public void setCandidates (String candidates)
    {
        this.candidates = candidates;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [party = "+party+", candidates = "+candidates+"]";
    }
}