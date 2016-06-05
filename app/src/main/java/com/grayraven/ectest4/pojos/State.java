package com.grayraven.ectest4.pojos;

import java.util.Comparator;

public class State implements Comparable<State>  {

    private Integer votes;
    private Boolean splitable;
    private String abbr;

    public State() {
    }

    public State(String abbr, Integer votes, Boolean splitable) {
        this.abbr = abbr;
        this.votes = votes;
        this.splitable = splitable;
    }

    public void setAbbr(String abbr) { this.abbr = abbr; }

    public String getAbbr() { return abbr; }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Boolean getSplitable() {
        return splitable;
    }

    public void setSplitable(Boolean splitable) {
        this.splitable = splitable;
    }

    public String toString() {
        return "State: " + abbr + " Votes: " + votes + " Spitable: " + splitable;
    }

    @Override
    public int compareTo(State another) {
        int compareValue = this.abbr.toUpperCase().compareTo(another.getAbbr().toUpperCase());
        return compareValue;
    }

    public static Comparator<State> VoteComparator = new Comparator<State>() {
        @Override
        public int compare(State lhs, State rhs) {
           return lhs.getVotes().compareTo(rhs.getVotes());
        }
    };
}