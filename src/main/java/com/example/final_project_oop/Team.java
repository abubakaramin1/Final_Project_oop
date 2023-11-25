package com.example.final_project_oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team {
    List<Player>  team = new ArrayList<>();



   private String teamName;
   private String action;
    int totalScore;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Team(){
       int counter =0;
       while (counter!=11)
       {
           team.add(new Player());
           counter++;
       }


   }

   public void addTeam(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter team name:");
       setTeamName(sc.nextLine());
       int counter = 0;
       while (counter != 11){
           System.out.println("Enter the name of the Player:");
           team.get(counter).setName(sc.nextLine());
           counter++;
       }

   }



}
