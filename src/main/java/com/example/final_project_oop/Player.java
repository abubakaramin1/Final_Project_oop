package com.example.final_project_oop;

public class Player {

    private String name;
    private int ballsPlayed;
    private int runsScored;
    private Boolean isOut = false;
    private String howOut;
    private int numOfOvers;
    private int ballsDelivered;
    private int outs;
    private int runsGiven;


    public int getBallsDelivered() {
        return ballsDelivered;
    }

    public void setBallsDelivered(int ballsDelivered) {
        this.ballsDelivered = ballsDelivered;
    }



    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public void setBallsPlayed(int ballsPlayed) {
        this.ballsPlayed = ballsPlayed;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {

        this.runsScored = runsScored;
    }

    public Boolean getOut()
    {
        return isOut;
    }

    public void setOut(Boolean out) {

        isOut = out;
    }

    public String getHowOut() {

        return howOut;
    }

    public void setHowOut(String howOut) {

        this.howOut = howOut;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getNumOfOvers() {

        return numOfOvers;
    }

    public void setNumOfOvers(int numOfOvers) {

        this.numOfOvers = numOfOvers;
    }

    public int getOuts() {
        return outs;
    }

    public void setOuts(int outs) {

        this.outs = outs;
    }

    public int getRunsGiven() {

        return runsGiven;
    }

    public void setRunsGiven(int runsGiven)
    {
        this.runsGiven = runsGiven;
    }

    @Override
    public String toString() {
        return "" + name;
    }
}
