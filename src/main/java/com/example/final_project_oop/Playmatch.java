package com.example.final_project_oop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Scanner;

public class Playmatch extends Application {

    Stage window;

    Scene scene,scene1,scene2;
    Team battingTeam;
    Team ballingTeam;

    public static void main(String[] args) throws Exception{
        launch();
    }

    private Team team1 = new Team();
    private Team team2 = new Team();
    private Player batsman1 = new Player();
    private Player batsman2 = new Player();
    private Player bowler = new Player();

    VBox vBox3 = new VBox();
    Label l3 = new Label();
    Label l4 = new Label();
    Label l5 = new Label();


    public Team choosing(){
        boolean win = Math.random() < 0.5;
        if (win)
            return team1;
        return team2;
    }

    public void toss(){
        Team team = choosing();
        Team loser = new Team();
        System.out.println(""+team.getTeamName() +" won the toss!!");
        System.out.println("Type 'batting' to bat first \n Type 'balling' to bowl first");
        Scanner sc = new Scanner(System.in);
        team.setAction(sc.nextLine());
        if (Objects.equals(team,team1))
        {
            loser = team2;
        }
        else if (Objects.equals(team,team2))
        {
            loser = team1;
        }
        if (Objects.equals(team.getAction() , "batting"))
        {
            loser.setAction("balling");
        }
        if (Objects.equals(team.getAction() , "balling"))
        {
            loser.setAction("batting");
        }

        System.out.println(team.getTeamName() + " is "+team.getAction() + "first");
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        team1.addTeam();
        team2.addTeam();
         battingTeam =new Team();
        toss();
        if (Objects.equals(team1.getAction(),"batting")){
            battingTeam = team1;
        }

        if (Objects.equals(team2.getAction(),"batting")){
            battingTeam = team2;
        }
        Label l1 = new Label("Select 2 batsmen:");
        CheckBox p1 = new CheckBox(battingTeam.team.get(0).toString());
        CheckBox p2 = new CheckBox(battingTeam.team.get(1).toString());
        CheckBox p3 = new CheckBox(battingTeam.team.get(2).toString());
        CheckBox p4 = new CheckBox(battingTeam.team.get(3).toString());
        CheckBox p5 = new CheckBox(battingTeam.team.get(4).toString());
        CheckBox p6 = new CheckBox(battingTeam.team.get(5).toString());
        CheckBox p7 = new CheckBox(battingTeam.team.get(6).toString());
        CheckBox p8 = new CheckBox(battingTeam.team.get(7).toString());
        CheckBox p9 = new CheckBox(battingTeam.team.get(8).toString());
        CheckBox p10 = new CheckBox(battingTeam.team.get(9).toString());
        CheckBox p11 = new CheckBox(battingTeam.team.get(10).toString());


        Button b1 = new Button("Confirm");
        b1.setOnAction( e -> {
            handle1(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11);
            window.setScene(scene1);
        });



        VBox vBox = new VBox();
        vBox.getChildren().addAll(l1,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,b1);
        scene = new Scene(vBox);
        ballingTeam = new Team();

        if (Objects.equals(team1.getAction(),"balling")){
            ballingTeam = team1;
        }

        if (Objects.equals(team2.getAction(),"balling")){
            ballingTeam= team2;
        }

        Label l2 = new Label("Select a baller:");

        CheckBox pa = new CheckBox(ballingTeam.team.get(0).toString());
        CheckBox pb = new CheckBox(ballingTeam.team.get(1).toString());
        CheckBox pc = new CheckBox(ballingTeam.team.get(2).toString());
        CheckBox pd = new CheckBox(ballingTeam.team.get(3).toString());
        CheckBox pe = new CheckBox(ballingTeam.team.get(4).toString());
        CheckBox pf = new CheckBox(ballingTeam.team.get(5).toString());
        CheckBox pg = new CheckBox(ballingTeam.team.get(6).toString());
        CheckBox ph = new CheckBox(ballingTeam.team.get(7).toString());
        CheckBox pi = new CheckBox(ballingTeam.team.get(8).toString());
        CheckBox pj = new CheckBox(ballingTeam.team.get(9).toString());
        CheckBox pk = new CheckBox(ballingTeam.team.get(10).toString());
        // CheckBox p12 = new CheckBox(team.team.get(11).toString());

        Button b2 = new Button("Confirm");
        b2.setOnAction( e -> {
            handle2(pa,pb,pc,pd,pe,pf,pg,ph,pi,pj,pk);
            window.setScene(scene2);
        });

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(l2,pa,pb,pc,pd,pe,pf,pg,ph,pi,pj,pk,b2);
        scene1 = new Scene(vBox2);

        Button run1 = new Button("1");
        run1.setOnAction( e -> addOne());
        Button run2 = new Button("2");
        run2.setOnAction( e -> addTwo());
        Button run3 = new Button("3");
        run3.setOnAction( e -> addThree());
        Button run4 = new Button("4");
        run4.setOnAction( e -> addFour());
        Button run5 = new Button("5");
        run5.setOnAction( e -> addFive());
        Button run6 = new Button("6");
        run6.setOnAction( e -> addSix());

        vBox3.getChildren().addAll(l3,l4,l5);
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vBox3);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(run1,run2,run3,run4,run5,run6);

        borderPane.setCenter(hBox);

        scene2 = new Scene(borderPane);
        window.setScene(scene);
        window.show();

    }

    private void handle1(CheckBox p1,CheckBox p2,CheckBox p3,CheckBox p4,CheckBox p5,CheckBox p6,CheckBox p7,CheckBox p8,CheckBox p9,CheckBox p10,CheckBox p11){
        if (p1.isSelected()){
            if (batsman1.getName() == null){
                batsman1 = battingTeam.team.get(0);
            }
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(0);
        }
        if (p2.isSelected()){
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(1);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(1);
        }
        if (p3.isSelected()){
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(2);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(2);
        }
        if (p4.isSelected()){
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(3);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(3);
        }
        if (p5.isSelected()){
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(4);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(4);
        }
        if (p6.isSelected()){
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(5);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(5);
        }if (p7.isSelected()){
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(6);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(6);
        }
        if (p8.isSelected()){
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(7);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(7);
        }
        if (p9.isSelected()){
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(8);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(8);
        }
        if (p10.isSelected()){
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(9);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(9);
        }
        if (p11.isSelected()){
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(10);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(10);
        }


        l3.setText(batsman1.getName());
        l4.setText(batsman2.getName());


    }

    private void handle2(CheckBox pa,CheckBox pb,CheckBox pc,CheckBox pd,CheckBox pe,CheckBox pf,CheckBox pg,CheckBox ph,CheckBox pi,CheckBox pj,CheckBox pk){
        if (pa.isSelected()){
            if (bowler.getName() == null)
            {
                bowler = ballingTeam.team.get(0);
            }
        }
        if (pb.isSelected()){
            if (bowler.getName() == null)
            {
                bowler = ballingTeam.team.get(1);
            }
        }
        if (pc.isSelected()){
            if (bowler.getName() == null)
            {
                bowler = ballingTeam.team.get(2);
            }
        }
        if (pd.isSelected()){
            if (bowler.getName() == null)
            {
                bowler = ballingTeam.team.get(3);
            }
        }
        if (pe.isSelected()){
            if (bowler.getName() == null)
            {
                bowler = ballingTeam.team.get(4);
            }
        }
        if (pf.isSelected()){
            if (bowler.getName() == null)
            {
                bowler = ballingTeam.team.get(5);
            }
        }
        if (pg.isSelected()){
            if (bowler.getName() == null)
            {
                bowler = ballingTeam.team.get(6);
            }
        }
        if (ph.isSelected()){
            if (bowler.getName() == null)
            {
                bowler = ballingTeam.team.get(7);
            }
        }
        if (pi.isSelected()){
            if (bowler.getName() == null)
            {
                bowler = ballingTeam.team.get(8);
            }
        }
        if (pj.isSelected()){
            if (bowler.getName() == null)
            {
                bowler = ballingTeam.team.get(9);
            }
        }
        if (pk.isSelected()){
            if (bowler.getName() == null)
            {
                bowler = ballingTeam.team.get(10);
            }
        }



        l5.setText(bowler.getName());
    }

    private void addOne(){
        batsman1.setRunsScored(batsman1.getRunsScored() + 1);
        Player temp = new Player();
        temp = batsman1;
        batsman1 = batsman2;
        batsman2 = temp;
    }

    private void addTwo(){
        batsman1.setRunsScored(bowler.getRunsScored() + 2);
    }

    private void addThree(){
        batsman1.setRunsScored(bowler.getRunsScored() + 3);
        Player temp = new Player();
        temp = batsman1;
        batsman1 = batsman2;
        batsman2 = temp;
    }

    private void addFour(){
        batsman1.setRunsScored(batsman1.getRunsScored()+ 4);
    }

    private void addFive(){
        batsman1.setRunsScored(bowler.getRunsScored() + 5);
        Player temp = new Player();
        temp = batsman1;
        batsman1 = batsman2;
        batsman2 = temp;
    }

    private void addSix(){
        batsman1.setRunsScored(batsman1.getRunsScored()+ 6);
    }
}
