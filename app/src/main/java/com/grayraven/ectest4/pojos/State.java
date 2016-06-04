package com.grayraven.ectest4.pojos;

public class State   {

    private String abbrv;
    private Integer votes;
    private Boolean splitable;

    public State() {
    }

    /**
     *
     * @param votes
     * @param splitable
     */
    public State( Integer votes, Boolean splitable) {
        this.abbrv = abbrv;
        this.votes = votes;
        this.splitable = splitable;
    }

    /**
     *
     * @return
     * The votes
     */
    public Integer getVotes() {
        return votes;
    }

    /**
     *
     * @param votes
     * The votes
     */
    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    /**
     *
     * @return
     * The splitable
     */
    public Boolean getSplitable() {
        return splitable;
    }

    /**
     *
     * @param splitable
     * The splitable
     */
    public void setSplitable(Boolean splitable) {
        this.splitable = splitable;
    }

    public String toString() {
        return "Votes: " + votes + " Spitable: " + splitable;
    }

}