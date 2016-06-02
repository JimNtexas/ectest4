package com.grayraven.ectest4.pojos;

import java.util.List;

public class Election
{
    private String Year;

    private List State;

    private List Slate;

    private String Remark;

    private String ToWin;

    public Election() {};

    public String getYear ()
    {
        return Year;
    }

    public void setYear (String Year)
    {
        this.Year = Year;
    }

    public List getState ()
    {
        return this.State;
    }

    public void setState (List State)
    {
        this.State = State;
    }

    public List getSlate ()
    {
        return this.Slate;
    }

    public void setSlate (List Slate)
    {
        this.Slate = Slate;
    }

    public String getRemark ()
    {
        return Remark;
    }

    public void setRemark (String Remark)
    {
        this.Remark = Remark;
    }

    public String getToWin ()
    {
        return ToWin;
    }

    public void setToWin (String ToWin)
    {
        this.ToWin = ToWin;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Year = "+Year+", State = "+State+", Slate = "+Slate+", Remark = "+Remark+", ToWin = "+ToWin+"]";
    }
}