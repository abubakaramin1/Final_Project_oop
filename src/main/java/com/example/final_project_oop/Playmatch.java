package com.example.final_project_oop;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Playmatch extends Application {

    Stage window;
    Scene scene, scene1, scene2, scene3;
    Team battingTeam = new Team();
    Team ballingTeam = new Team();

    public static void main(String[] args) throws Exception {

        launch();
    }

    private Team team1 = new Team();
    private Team team2 = new Team();
    private Player batsman1 = new Player();
    private Player batsman2 = new Player();
    private Player bowler = new Player();

    VBox vBox3 = new VBox();
    VBox vBox5 = new VBox();
    VBox vBox1 = new VBox();
    Label label2 = new Label();
    Label l3 = new Label();
    Label l4 = new Label();
    Label l5 = new Label();
    Label l6 = new Label();
    Label l7 = new Label();
    Label bowlerScore = new Label();
    BorderPane borderPane = new BorderPane();


    public Team choosing() {
        boolean win = Math.random() < 0.5;
        if (win)
            return team1;

        return team2;
    }

    public void toss()
    {
        Team team = choosing();
        Label label = new Label();
        label.setText(team.getTeamName() + " won the toss");

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton battingRadioButton = new RadioButton("Batting");
        battingRadioButton.setToggleGroup(toggleGroup);

        RadioButton bowlingRadioButton = new RadioButton("Balling");
        bowlingRadioButton.setToggleGroup(toggleGroup);

        Button button = new Button("PLAY");
        button.setOnAction(e -> {


            if (battingRadioButton.isSelected())
            {
                team.setAction("batting");
            } else if (bowlingRadioButton.isSelected())
            {
                team.setAction("balling");

            }
            if (Objects.equals(team.getTeamName() , team1.getTeamName()))
            {
                if (Objects.equals(team1.getAction() , "batting"))
                {
                    team2.setAction("balling");
                }
                else if (Objects.equals(team1.getAction() , "balling"))
                {
                    team2.setAction("batting");
                }
            }
            if (Objects.equals(team.getTeamName() , team2.getTeamName()))
            {
                if (Objects.equals(team2.getAction() , "batting"))
                {
                    team1.setAction("balling");
                }
                else if (Objects.equals(team2.getAction() , "balling"))
                {
                    team1.setAction("batting");
                }
            }


            if (Objects.equals(team1.getAction(), "batting"))
            {
                battingTeam = team1;
            }

            if (Objects.equals(team2.getAction(), "batting"))
            {
                battingTeam = team2;
            }


            if (Objects.equals(team1.getAction(), "balling"))
            {
                ballingTeam = team1;
            }

            if (Objects.equals(team2.getAction(), "balling"))
            {
                ballingTeam = team2;
            }

            label2.setText(team.getTeamName() + " has choose for " +team.getAction() + " first");
            showLabel();

        });



        battingRadioButton.setOnAction(event -> button.requestFocus());
        battingRadioButton.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.ENTER)
            {
                battingRadioButton.setSelected(true);
                team.setAction("batting");
                 button.requestFocus();
            }
        });
        bowlingRadioButton.setOnAction(event -> button.requestFocus());
        bowlingRadioButton.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.ENTER)
            {
                bowlingRadioButton.setSelected(true);
                team.setAction("balling");
                button.requestFocus();
            }
        });



        VBox vBox = new VBox(label , battingRadioButton,bowlingRadioButton , button);

        Scene scene4 = new Scene(vBox);
        window.setScene(scene4);
    }
    public void showLabel()
    {
        Button button = new Button("START MATCH");
        VBox vBox = new VBox(label2,button);
        button.setOnAction(e -> showBattingTeam());
        Scene scene4 = new Scene(vBox);
        window.setScene(scene4);
    }

    public void showBattingTeam()
    {
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
        b1.setOnAction(e ->
        {
            handle1(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
            showBallingTeam();
        });


        VBox vBox = new VBox();
        vBox.getChildren().addAll(l1, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, b1);
        scene = new Scene(vBox);
        window.setScene(scene);
    }
    public void showBallingTeam()
    {
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


        Button b2 = new Button("Confirm");
        b2.setOnAction(e -> {
            handle2(pa, pb, pc, pd, pe, pf, pg, ph, pi, pj, pk);
            window.setScene(scene2);
        });

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(l2, pa, pb, pc, pd, pe, pf, pg, ph, pi, pj, pk, b2);
        scene1 = new Scene(vBox2);
        window.setScene(scene1);
    }
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Team Management");
        Button bb = new Button("Start Match");
        Scene scene4 = new Scene(bb);
        scene4.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.ENTER)
            {
                bb.fire();
            }
        });
        window.setScene(scene4);
        Scene scene5 = addTeam1();

        bb.setOnAction(e -> window.setScene(scene5));

        Button run1 = new Button("1");
        run1.setOnAction(e -> addOne());
        Button run2 = new Button("2");
        run2.setOnAction(e -> addTwo());
        Button run3 = new Button("3");
        run3.setOnAction(e -> addThree());
        Button run4 = new Button("4");
        run4.setOnAction(e -> addFour());
        Button run5 = new Button("5");
        run5.setOnAction(e -> addFive());
        Button run6 = new Button("6");
        run6.setOnAction(e -> addSix());
        Button run0 = new Button("0");
        run0.setOnAction(e -> addZero());
        Button out = new Button("Out");
        out.setOnAction(e -> {
            out();

        });


        vBox3.getChildren().addAll(l3, l4, l5);

        borderPane.setLeft(vBox3);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(run0, run1, run2, run3, run4, run5, run6, out);

        borderPane.setBottom(hBox);
        borderPane.setCenter(vBox1);
        Button button = new Button("Scorecard");
       borderPane.setRight(button);
       button.setOnAction(e -> showScorecard());


        scene2 = new Scene(borderPane);
//        window.setScene(scene);
        window.show();

    }

    private void handle1(CheckBox p1, CheckBox p2, CheckBox p3, CheckBox p4, CheckBox p5, CheckBox p6, CheckBox p7, CheckBox p8, CheckBox p9, CheckBox p10, CheckBox p11) {
        if (p1.isSelected()) {
            if (batsman1.getName() == null) {
                batsman1 = battingTeam.team.get(0);
            } else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(0);
        }
        if (p2.isSelected()) {
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(1);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(1);
        }
        if (p3.isSelected()) {
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(2);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(2);
        }
        if (p4.isSelected()) {
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(3);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(3);
        }
        if (p5.isSelected()) {
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(4);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(4);
        }
        if (p6.isSelected()) {
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(5);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(5);
        }
        if (p7.isSelected()) {
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(6);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(6);
        }
        if (p8.isSelected()) {
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(7);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(7);
        }
        if (p9.isSelected()) {
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(8);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(8);
        }
        if (p10.isSelected()) {
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(9);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(9);
        }
        if (p11.isSelected()) {
            if (batsman1.getName() == null)
                batsman1 = battingTeam.team.get(10);
            else if (batsman2.getName() == null)
                batsman2 = battingTeam.team.get(10);
        }


    }

    private void handle2(CheckBox pa, CheckBox pb, CheckBox pc, CheckBox pd, CheckBox pe, CheckBox pf, CheckBox pg, CheckBox ph, CheckBox pi, CheckBox pj, CheckBox pk) {
        if (pa.isSelected()) {

            bowler = ballingTeam.team.get(0);


        }
        if (pb.isSelected()) {

            bowler = ballingTeam.team.get(1);

        }
        if (pc.isSelected()) {


            bowler = ballingTeam.team.get(2);


        }
        if (pd.isSelected()) {


            bowler = ballingTeam.team.get(3);


        }
        if (pe.isSelected()) {

            bowler = ballingTeam.team.get(4);


        }
        if (pf.isSelected()) {

            bowler = ballingTeam.team.get(5);

        }
        if (pg.isSelected()) {

            bowler = ballingTeam.team.get(6);


        }
        if (ph.isSelected()) {
            bowler = ballingTeam.team.get(7);


        }
        if (pi.isSelected()) {

            bowler = ballingTeam.team.get(8);


        }
        if (pj.isSelected()) {

            bowler = ballingTeam.team.get(9);


        }
        if (pk.isSelected()) {

            bowler = ballingTeam.team.get(10);

        }
        updateBatsmanScores();


    }

    private void addOne()
    {
        batsman1.setRunsScored(batsman1.getRunsScored() + 1);
        batsman1.setBallsPlayed(batsman1.getBallsPlayed() + 1);
        Player temp = new Player();
        temp = batsman1;
        batsman1 = batsman2;
        batsman2 = temp;
        if (bowler.getBallsDelivered() < 6) {
            bowler.setBallsDelivered(bowler.getBallsDelivered() + 1);
            bowler.setRunsGiven(bowler.getRunsGiven() + 1);
        }
        checkBalls();
        updateBatsmanScores();
    }

    private void addTwo()
    {
        batsman1.setRunsScored(batsman1.getRunsScored() + 2);
        batsman1.setBallsPlayed(batsman1.getBallsPlayed() + 1);
        if (bowler.getBallsDelivered() < 6) {
            bowler.setBallsDelivered(bowler.getBallsDelivered() + 1);
            bowler.setRunsGiven(bowler.getRunsGiven() + 2);
        }
        checkBalls();
        updateBatsmanScores();
    }

    private void addThree()
    {
        batsman1.setRunsScored(batsman1.getRunsScored() + 3);
        batsman1.setBallsPlayed(batsman1.getBallsPlayed() + 1);
        Player temp = new Player();
        temp = batsman1;
        batsman1 = batsman2;
        batsman2 = temp;
        if (bowler.getBallsDelivered() < 6) {
            bowler.setBallsDelivered(bowler.getBallsDelivered() + 1);
            bowler.setRunsGiven(bowler.getRunsGiven() + 3);
        }
        checkBalls();
        updateBatsmanScores();
    }

    private void addFour()
    {
        batsman1.setRunsScored(batsman1.getRunsScored() + 4);
        batsman1.setBallsPlayed(batsman1.getBallsPlayed() + 1);
        if (bowler.getBallsDelivered() < 6) {
            bowler.setBallsDelivered(bowler.getBallsDelivered() + 1);
            bowler.setRunsGiven(bowler.getRunsGiven() + 4);
        }
        checkBalls();
        updateBatsmanScores();
    }

    private void addFive()
    {
        batsman1.setRunsScored(batsman1.getRunsScored() + 5);
        batsman1.setBallsPlayed(batsman1.getBallsPlayed() + 1);
        Player temp = new Player();
        temp = batsman1;
        batsman1 = batsman2;
        batsman2 = temp;
        if (bowler.getBallsDelivered() < 6) {
            bowler.setBallsDelivered(bowler.getBallsDelivered() + 1);
            bowler.setRunsGiven(bowler.getRunsGiven() + 5);
        }
        checkBalls();

        updateBatsmanScores();
    }

    private void addSix()
    {
        batsman1.setRunsScored(batsman1.getRunsScored() + 6);
        batsman1.setBallsPlayed(batsman1.getBallsPlayed() + 1);
        if (bowler.getBallsDelivered() < 6) {
            bowler.setBallsDelivered(bowler.getBallsDelivered() + 1);
            bowler.setRunsGiven(bowler.getRunsGiven() + 6);
        }
        checkBalls();

        updateBatsmanScores();
    }

    private void addZero()
    {
        batsman1.setBallsPlayed(batsman1.getBallsPlayed() + 1);
        if (bowler.getBallsDelivered() < 6)
        {
            bowler.setBallsDelivered(bowler.getBallsDelivered() + 1);
        }
        checkBalls();

        updateBatsmanScores();
    }

    private void checkBalls()
    {
        if (bowler.getBallsDelivered() == 6) {

            bowler.setNumOfOvers(bowler.getNumOfOvers() + 1 );
            Player temp = new Player();
            temp = batsman1;
            batsman1 = batsman2;
            batsman2 = temp;
            Label l8 = new Label("Select a new bowler:");
            CheckBox b1 = new CheckBox(ballingTeam.team.get(0).toString());
            CheckBox b2 = new CheckBox(ballingTeam.team.get(1).toString());
            CheckBox b3 = new CheckBox(ballingTeam.team.get(2).toString());
            CheckBox b4 = new CheckBox(ballingTeam.team.get(3).toString());
            CheckBox b5 = new CheckBox(ballingTeam.team.get(4).toString());
            CheckBox b6 = new CheckBox(ballingTeam.team.get(5).toString());
            CheckBox b7 = new CheckBox(ballingTeam.team.get(6).toString());
            CheckBox b8 = new CheckBox(ballingTeam.team.get(7).toString());
            CheckBox b9 = new CheckBox(ballingTeam.team.get(8).toString());
            CheckBox b10 = new CheckBox(ballingTeam.team.get(9).toString());
            CheckBox b11 = new CheckBox(ballingTeam.team.get(10).toString());


            Button b = new Button("Confirm");
            b.setOnAction(e -> {
                handle2(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11);
                window.setScene(scene2);
                bowler.setBallsDelivered(0);
                updateBatsmanScores();
            });

            VBox vBox = new VBox();
            vBox.getChildren().addAll(l8, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b);
            Scene scene3 = new Scene(vBox);
            window.setScene(scene3);
        }
    }


    private void updateBatsmanScores() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        gridPane.add(new Label("Batsman"), 0, 0);
        gridPane.add(new Label("Runs"), 1, 0);
        gridPane.add(new Label("Balls"), 2, 0);

        gridPane.add(new Label(batsman1.getName()), 0, 1);
        gridPane.add(new Label(String.valueOf (batsman1.getRunsScored())), 1, 1);
        gridPane.add(new Label(String.valueOf(batsman1.getBallsPlayed())), 2, 1);

        gridPane.add(new Label(batsman2.getName()), 0, 2);
        gridPane.add(new Label(String.valueOf(batsman2.getRunsScored())), 1, 2);
        gridPane.add(new Label(String.valueOf(batsman2.getBallsPlayed())), 2, 2);


        gridPane.add(new Label("Bowler"), 0, 4);
        gridPane.add(new Label("Deliveries"), 1, 4);
        gridPane.add(new Label("Runs/Wkts"), 2, 4);
        gridPane.add(new Label("Overs") , 3 ,4);

        gridPane.add(new Label(bowler.getName()), 0, 5);
        gridPane.add(new Label(String.valueOf(bowler.getBallsDelivered())), 1, 5);
        gridPane.add(new Label(String.format("%d/%d", bowler.getRunsGiven(), bowler.getOuts())), 2, 5);
        gridPane.add(new Label(String.valueOf(bowler.getNumOfOvers())) , 3 , 5);

        vBox1.getChildren().clear();
        vBox1.getChildren().add(gridPane);
    }

    private void out() {

        batsman1.setBallsPlayed(batsman1.getBallsPlayed() + 1);
        bowler.setOuts(bowler.getOuts() + 1);

        if (bowler.getBallsDelivered() < 6)
        {
            bowler.setBallsDelivered(bowler.getBallsDelivered() + 1);
        }


        batsman1.setOut(true);
        battingTeam.battingSide.remove(batsman1);
        battingTeam.battingSide.remove(batsman2);

        List<CheckBox> checkBoxes = new ArrayList<>();

        for (int i = 0; i < battingTeam.battingSide.size(); i++)
        {
                checkBoxes.add(new CheckBox(battingTeam.battingSide.get(i).toString()));
        }

        VBox vBox = new VBox();
        vBox.getChildren().addAll(checkBoxes);

        Button confirmButton = new Button("Confirm");

        confirmButton.setOnAction(e ->
        {


            for (int i = 0; i < checkBoxes.size(); i++)
            {
                if (checkBoxes.get(i).isSelected())
                {

                        batsman1 = battingTeam.battingSide.get(i);

                      vBox.getChildren().clear();

                      updateBatsmanScores();

                      if (bowler.getBallsDelivered() == 6)
                      {
                      checkBalls();
                      }
                      else
                      {
                          window.setScene(scene2);
                      }


                }
            }


        });

        vBox.getChildren().add(confirmButton);
        Scene newBatsmanScene = new Scene(vBox);
        window.setScene(newBatsmanScene);


    }

    private void addTeam2()
    {

        TextField teamNameInput = new TextField();
        teamNameInput.setPromptText("Enter team name");
        Button bbb = new Button("Toss");

        List<TextField> players = new ArrayList<>();
        teamNameInput.setOnKeyPressed(e ->
        {

            if (e.getCode() == KeyCode.ENTER)
            {
                if (!players.isEmpty()) {
                    players.get(0).requestFocus();
                }
            }
        });
        for (int i = 0 ; i < team2.team.size() ; i++)
        {
            players.add(new TextField());
            players.get(i).setPromptText("Enter Player Name");
            final int currentIndex = i;

            players.get(i).setOnKeyPressed(e ->
            {
                if (e.getCode() == KeyCode.ENTER) {

                    if (currentIndex < players.size() - 1) {

                        players.get(currentIndex + 1).requestFocus();

                    } else {
                        bbb.requestFocus();
                    }
                }

            });

        }


        VBox vBox = new VBox();
        vBox.getChildren().add(teamNameInput);
        vBox.getChildren().addAll(players);
        vBox.getChildren().add(bbb);
        Scene scene4 = new Scene(vBox);
        bbb.setOnAction(e ->
        {
            String teamName = teamNameInput.getText();
            team2.setTeamName(teamName);
            for (int i = 0 ; i < team2.team.size() ; i++)
            {
                String playerName = players.get(i).getText();
                team2.team.get(i).setName(playerName);
            }
           toss();
        });
       window.setScene(scene4);



    }





    private Scene addTeam1() {
        TextField teamNameInput = new TextField();
        teamNameInput.setPromptText("Enter team name");
        Button bbb = new Button("Add Team");

        List<TextField> players = new ArrayList<>();
        teamNameInput.setOnKeyPressed(e ->
        {

            if (e.getCode() == KeyCode.ENTER)
            {
                if (!players.isEmpty()) {
                    players.get(0).requestFocus();
                }
            }
        });

        for (int i = 0; i < team1.team.size(); i++) {
            players.add(new TextField());
            players.get(i).setPromptText("Enter Player Name");
            final int currentIndex = i;

            players.get(i).setOnKeyPressed(e ->
            {
                if (e.getCode() == KeyCode.ENTER) {

                    if (currentIndex < players.size() - 1) {
                        players.get(currentIndex + 1).requestFocus();
                    } else {
                        bbb.requestFocus();
                    }
                }

            });
        }
        


        VBox vBox = new VBox();
        vBox.getChildren().add(teamNameInput);
        vBox.getChildren().addAll(players);
        vBox.getChildren().add(bbb);
        bbb.setOnAction(e ->
        {
            String teamName = teamNameInput.getText();
            team1.setTeamName(teamName);
            for (int i = 0; i < team1.team.size(); i++) {
                String playerName = players.get(i).getText().trim();
                team1.team.get(i).setName(playerName);
            }
            addTeam2();
        });
        return new Scene(vBox);
    }


        public void showScorecard()
    {
        BorderPane scorecardPane = new BorderPane();
        VBox team1Score = createScorecardVBox(team1.getTeamName(), team1);
        VBox team2Score = createScorecardVBox(team2.getTeamName(), team2);

        HBox scorecardBox = new HBox(team1Score, team2Score);
        scorecardBox.setSpacing(30);
        Button button = new Button("Ball By Ball");
        button.setOnAction( e -> window.setScene(scene2));
        scorecardPane.setCenter(scorecardBox);
        scorecardPane.setBottom(button);
        Scene scorecardScene = new Scene(scorecardPane, 600, 400);
        window.setScene(scorecardScene);
    }
    private VBox createScorecardVBox(String teamName, Team team) {
        VBox vBox = new VBox();
        vBox.setSpacing(10);

        Label teamLabel = new Label(teamName);
        teamLabel.setFont(new Font("Arial", 18));
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);

        // Add column headers
        gridPane.add(new Label("Player"), 0, 0);
        gridPane.add(new Label("Runs"), 1, 0);
        gridPane.add(new Label("Balls"), 2, 0);

        // Add player details
        for (int i = 0; i < team.team.size(); i++) {
            Player player = team.team.get(i);
            gridPane.add(new Label(player.getName()), 0, i + 1);
            gridPane.add(new Label(String.valueOf(player.getRunsScored())), 1, i + 1);
            gridPane.add(new Label(String.valueOf(player.getBallsPlayed())), 2, i + 1);
        }

        vBox.getChildren().addAll(teamLabel, gridPane);
        return vBox;
    }








    }






