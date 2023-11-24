package com.example.final_project_oop;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Playmatch extends Application {

    Stage window;
    Scene scene, scene1, scene2, scene3;
    Team battingTeam = new Team();
    Team ballingTeam = new Team();
    List<Player> battingSide;

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

        Font labelFont = Font.font("Arial",FontWeight.BOLD,40);
        Color clr = Color.WHITE;


        Team team = choosing();
        Label label = new Label();
        label.setText(team.getTeamName() + " won the toss");

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton battingRadioButton = new RadioButton("Batting");
        battingRadioButton.setFont(labelFont);
        battingRadioButton.setTextFill(clr);
        battingRadioButton.setPadding(new Insets(40));
        battingRadioButton.setToggleGroup(toggleGroup);

        RadioButton bowlingRadioButton = new RadioButton("Balling");
        bowlingRadioButton.setTextFill(clr);
        bowlingRadioButton.setFont(labelFont);
        bowlingRadioButton.setToggleGroup(toggleGroup);
        bowlingRadioButton.setPadding(new Insets(40));

        Button button = new Button("PLAY");
        button.setPrefSize(120,60);
        Font buttonFont = Font.font("Arial",FontWeight.BOLD,15);
        Color buttonClr = Color.WHITE;
        button.setTextFill(buttonClr);
        button.setFont(buttonFont);
        button.setOnMouseEntered(e -> button.setCursor(Cursor.HAND));
        button.setOnMouseExited(e -> button.setCursor(Cursor.DEFAULT));
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
        Background background2 = new Background(backgroundFill);
        button.setBackground(background2);
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
                battingSide = new ArrayList<>(battingTeam.team);
            }

            else if (Objects.equals(team2.getAction(), "batting"))
            {
                battingTeam = team2;
                battingSide = new ArrayList<>(battingTeam.team);
            }


            if (Objects.equals(team1.getAction(), "balling"))
            {
                ballingTeam = team1;
            }

            if (Objects.equals(team2.getAction(), "balling"))
            {
                ballingTeam = team2;
            }

            label2.setText(team.getTeamName() + " has chosen for " +team.getAction() + " first");
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


        label.setTextFill(clr);
        label.setFont(labelFont);
        VBox vBox = new VBox(label , battingRadioButton,bowlingRadioButton , button);
        Image backgroundImage = new Image("C:\\Users\\TECHNO-WORLD\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
        //Calculate the width and height based on the screen size
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        double screenHeight = primaryScreenBounds.getHeight();

        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
        Background background = new Background(backgroundImage1);
        vBox.setBackground(background);
        vBox.setAlignment(Pos.CENTER);
        Scene scene4 = new Scene(vBox);
        window.setScene(scene4);
    }
    public void showLabel()
    {
        Font labelFont = Font.font("Arial",FontWeight.BOLD,40);
        Color clr = Color.WHITE;

        Button button = new Button("START MATCH");
        button.setPrefSize(150,60);
        button.setPadding(new Insets(10));
        Font buttonFont = Font.font("Arial",FontWeight.BOLD,15);
        Color buttonClr = Color.WHITE;
        button.setTextFill(buttonClr);
        button.setFont(buttonFont);
        button.setOnMouseEntered(e -> button.setCursor(Cursor.HAND));
        button.setOnMouseExited(e -> button.setCursor(Cursor.DEFAULT));
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
        Background background2 = new Background(backgroundFill);
        button.setBackground(background2);

        VBox vBox = new VBox();
        Image backgroundImage = new Image("C:\\Users\\TECHNO-WORLD\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
        //Calculate the width and height based on the screen size
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        double screenHeight = primaryScreenBounds.getHeight();

        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
        Background background = new Background(backgroundImage1);
        vBox.setBackground(background);
        vBox.setAlignment(Pos.CENTER);

        label2.setTextFill(clr);
        label2.setFont(labelFont);
        label2.setPadding(new Insets(10));

        vBox.getChildren().addAll(label2,button);
        button.setOnAction(e -> showBattingTeam());
        Scene scene4 = new Scene(vBox);
        window.setScene(scene4);
    }

    public void showBattingTeam()
    {
        Font labelFont = Font.font("Arial",FontWeight.BOLD,20);
        Color clr = Color.WHITE;
        Label l1 = new Label("Select 2 batsmen:");
        Font font = Font.font("Arial",FontWeight.BOLD,40);

        l1.setTextFill(clr);
        l1.setFont(font);

        l1.setPadding(new Insets(10));
        CheckBox p1 = new CheckBox(battingTeam.team.get(0).toString());
        p1.setPadding(new Insets(10));
        p1.setFont(labelFont);
        p1.setTextFill(clr);
        CheckBox p2 = new CheckBox(battingTeam.team.get(1).toString());
        p2.setPadding(new Insets(10));
        p2.setFont(labelFont);
        p2.setTextFill(clr);
        CheckBox p3 = new CheckBox(battingTeam.team.get(2).toString());
        p3.setPadding(new Insets(10));
        p3.setFont(labelFont);
        p3.setTextFill(clr);
        CheckBox p4 = new CheckBox(battingTeam.team.get(3).toString());
        p4.setPadding(new Insets(10));
        p4.setFont(labelFont);
        p4.setTextFill(clr);
        CheckBox p5 = new CheckBox(battingTeam.team.get(4).toString());
        p5.setPadding(new Insets(10));
        p5.setFont(labelFont);
        p5.setTextFill(clr);
        CheckBox p6 = new CheckBox(battingTeam.team.get(5).toString());
        p6.setPadding(new Insets(10));
        p6.setFont(labelFont);
        p6.setTextFill(clr);
        CheckBox p7 = new CheckBox(battingTeam.team.get(6).toString());
        p7.setPadding(new Insets(10));
        p7.setFont(labelFont);
        p7.setTextFill(clr);
        CheckBox p8 = new CheckBox(battingTeam.team.get(7).toString());
        p8.setPadding(new Insets(10));
        p8.setFont(labelFont);
        p8.setTextFill(clr);
        CheckBox p9 = new CheckBox(battingTeam.team.get(8).toString());
        p9.setPadding(new Insets(10));
        p9.setFont(labelFont);
        p9.setTextFill(clr);
        CheckBox p10 = new CheckBox(battingTeam.team.get(9).toString());
        p10.setPadding(new Insets(10));
        p10.setFont(labelFont);
        p10.setTextFill(clr);
        CheckBox p11 = new CheckBox(battingTeam.team.get(10).toString());
        p11.setPadding(new Insets(10));
        p11.setFont(labelFont);
        p11.setTextFill(clr);


        Button b1 = new Button("Confirm");


        b1.setPrefSize(150,60);
        b1.setPadding(new Insets(10));
        Font buttonFont = Font.font("Arial",FontWeight.BOLD,15);
        Color buttonClr = Color.WHITE;
        b1.setTextFill(buttonClr);
        b1.setFont(buttonFont);
        b1.setOnMouseEntered(e -> b1.setCursor(Cursor.HAND));
        b1.setOnMouseExited(e -> b1.setCursor(Cursor.DEFAULT));
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
        Background background2 = new Background(backgroundFill);
        b1.setBackground(background2);
        b1.setOnAction(e ->
        {
            handle1(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
            showBallingTeam();
        });


        VBox vBox = new VBox();
        Image backgroundImage = new Image("C:\\Users\\TECHNO-WORLD\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
        //Calculate the width and height based on the screen size
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        double screenHeight = primaryScreenBounds.getHeight();

        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
        Background background = new Background(backgroundImage1);
        vBox.setBackground(background);
        vBox.getChildren().addAll(l1, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, b1);
        vBox.setAlignment(Pos.CENTER);
        scene = new Scene(vBox);
        window.setScene(scene);
    }
    public void showBallingTeam()
    {
        Label l2 = new Label("Select a bowler:");
        Font labelFont = Font.font("Arial",FontWeight.BOLD,20);
        Color clr = Color.WHITE;

        Font font = Font.font("Arial",FontWeight.BOLD,40);

        l2.setTextFill(clr);
        l2.setFont(font);

        l2.setPadding(new Insets(10));


        CheckBox pa = new CheckBox(ballingTeam.team.get(0).toString());
        pa.setPadding(new Insets(10));
        pa.setFont(labelFont);
        pa.setTextFill(clr);
        CheckBox pb = new CheckBox(ballingTeam.team.get(1).toString());
        pb.setPadding(new Insets(10));
        pb.setFont(labelFont);
        pb.setTextFill(clr);
        CheckBox pc = new CheckBox(ballingTeam.team.get(2).toString());
        pc.setPadding(new Insets(10));
        pc.setFont(labelFont);
        pc.setTextFill(clr);
        CheckBox pd = new CheckBox(ballingTeam.team.get(3).toString());
        pd.setPadding(new Insets(10));
        pd.setFont(labelFont);
        pd.setTextFill(clr);
        CheckBox pe = new CheckBox(ballingTeam.team.get(4).toString());
        pe.setPadding(new Insets(10));
        pe.setFont(labelFont);
        pe.setTextFill(clr);
        CheckBox pf = new CheckBox(ballingTeam.team.get(5).toString());
        pf.setPadding(new Insets(10));
        pf.setFont(labelFont);
        pf.setTextFill(clr);
        CheckBox pg = new CheckBox(ballingTeam.team.get(6).toString());
        pg.setPadding(new Insets(10));
        pg.setFont(labelFont);
        pg.setTextFill(clr);
        CheckBox ph = new CheckBox(ballingTeam.team.get(7).toString());
        ph.setPadding(new Insets(10));
        ph.setFont(labelFont);
        ph.setTextFill(clr);
        CheckBox pi = new CheckBox(ballingTeam.team.get(8).toString());
        pi.setPadding(new Insets(10));
        pi.setFont(labelFont);
        pi.setTextFill(clr);
        CheckBox pj = new CheckBox(ballingTeam.team.get(9).toString());
        pj.setPadding(new Insets(10));
        pj.setFont(labelFont);
        pj.setTextFill(clr);
        CheckBox pk = new CheckBox(ballingTeam.team.get(10).toString());
        pk.setPadding(new Insets(10));
        pk.setFont(labelFont);
        pk.setTextFill(clr);


        Button b2 = new Button("Confirm");
        b2.setPrefSize(150,60);
        b2.setPadding(new Insets(10));
        Font buttonFont = Font.font("Arial",FontWeight.BOLD,15);
        Color buttonClr = Color.WHITE;
        b2.setTextFill(buttonClr);
        b2.setFont(buttonFont);
        b2.setOnMouseEntered(e -> b2.setCursor(Cursor.HAND));
        b2.setOnMouseExited(e -> b2.setCursor(Cursor.DEFAULT));
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
        Background background2 = new Background(backgroundFill);
        b2.setBackground(background2);
        b2.setOnAction(e -> {
            handle2(pa, pb, pc, pd, pe, pf, pg, ph, pi, pj, pk);
            window.setScene(scene2);
        });

        VBox vBox2 = new VBox();
        Image backgroundImage = new Image("C:\\Users\\TECHNO-WORLD\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
        //Calculate the width and height based on the screen size
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        double screenHeight = primaryScreenBounds.getHeight();

        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
        Background background = new Background(backgroundImage1);
        vBox2.setBackground(background);
        vBox2.getChildren().addAll(l2, pa, pb, pc, pd, pe, pf, pg, ph, pi, pj, pk, b2);
        vBox2.setAlignment(Pos.CENTER);
        scene1 = new Scene(vBox2);
        window.setScene(scene1);
    }
    @Override
    public void start(Stage stage) throws Exception {
        StackPane homepage = new StackPane();
        window = stage;
        window.setTitle("Team Management");
        Button bb = new Button("Start Match");
        bb.setMinSize(100,100);

        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
        Background background2 = new Background(backgroundFill);
        bb.setBackground(background2);

        Rectangle rectangle = new Rectangle(10, 10, 80, 80);
        rectangle.setArcWidth(80);
        rectangle.setArcHeight(60);
        bb.setShape(rectangle);
        bb.setOnMouseEntered(e -> bb.setCursor(Cursor.HAND));
        bb.setOnMouseExited(e -> bb.setCursor(Cursor.DEFAULT));


        Image backgroundImage = new Image("C:\\Users\\TECHNO-WORLD\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
         //Calculate the width and height based on the screen size
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        double screenHeight = primaryScreenBounds.getHeight();

        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
        Background background = new Background(backgroundImage1);
        Font customFont = Font.font("Arial", FontWeight.BOLD ,30);
        bb.setFont(customFont);
        Color customColor = Color.WHITE;
        bb.setTextFill(customColor);
        bb.setUnderline(true);

        bb.setBackground(background2);
        homepage.setBackground(background);
        homepage.getChildren().addAll(bb);
        Scene scene4 = new Scene(homepage);

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
        Button wide = new Button("wide");
        wide.setOnAction( e -> wideBall());
        Button out = new Button("Out");
        out.setOnAction(e -> {
            out();
        });


        vBox3.getChildren().addAll(l3, l4, l5);

        borderPane.setLeft(vBox3);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(run0, run1, run2, run3, run4, run5, run6,wide, out);

        borderPane.setBottom(hBox);
        borderPane.setCenter(vBox1);
        Button button = new Button("Scorecard");
       borderPane.setRight(button);
       button.setOnAction(e -> showScorecard());


        scene2 = new Scene(borderPane);
        window.setWidth(screenWidth);
        window.setHeight(screenHeight);


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

    private void wideBall(){
        batsman1.setRunsScored(batsman1.getRunsScored() + 1);
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

        battingSide.remove(batsman1);
        battingSide.remove(batsman2);

        List<CheckBox> checkBoxes = new ArrayList<>();

        for (int i = 0; i < battingSide.size(); i++)
        {
                checkBoxes.add(new CheckBox(battingSide.get(i).toString()));
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

                        batsman1 = battingSide.get(i);

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
        teamNameInput.setMaxWidth(180);
        teamNameInput.setPrefHeight(40);

        Button bbb = new Button("Toss");
        HBox buttonBox = new HBox(bbb);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setPadding(new Insets(30,30,30,30));
        bbb.setPrefSize(120,60);
        Font buttonFont = Font.font("Arial",FontWeight.BOLD,15);
        Color buttonClr = Color.WHITE;
        bbb.setTextFill(buttonClr);
        bbb.setFont(buttonFont);
        bbb.setOnMouseEntered(e -> bbb.setCursor(Cursor.HAND));
        bbb.setOnMouseExited(e -> bbb.setCursor(Cursor.DEFAULT));
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
        Background background2 = new Background(backgroundFill);
        bbb.setBackground(background2);

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
            players.get(i).setMaxWidth(180);
            players.get(i).setPrefHeight(60);
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

        Label teamLabel = new Label("Team 2:");
        Font teamFont = Font.font("Arial",FontWeight.BOLD,20);
        teamLabel.setFont(teamFont);
        Color teamClr = Color.WHITE;
        teamLabel.setTextFill(teamClr);


        Label PlayersLabel = new Label("Players:");
        PlayersLabel.setFont(teamFont);
        PlayersLabel.setTextFill(teamClr);

        Image backgroundImage = new Image("C:\\Users\\TECHNO-WORLD\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
        //Calculate the width and height based on the screen size
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        double screenHeight = primaryScreenBounds.getHeight();

        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
        Background background = new Background(backgroundImage1);

        VBox vBox = new VBox();
        vBox.setBackground(background);
        vBox.getChildren().addAll(teamLabel,teamNameInput,PlayersLabel);
        vBox.getChildren().addAll(players);
        vBox.getChildren().add(buttonBox);
        vBox.setSpacing(15);
        vBox.setPadding(new Insets(50));
        vBox.setAlignment(Pos.CENTER);
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
        teamNameInput.setMaxWidth(180);
        teamNameInput.setPrefHeight(40);
        Button bbb = new Button("Add Team");
        HBox buttonBox = new HBox(bbb);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setPadding(new Insets(30,30,30,30));
        bbb.setPrefSize(120,60);
        Font buttonFont = Font.font("Arial",FontWeight.BOLD,15);
        Color buttonClr = Color.WHITE;
        bbb.setTextFill(buttonClr);
        bbb.setFont(buttonFont);
        bbb.setOnMouseEntered(e -> bbb.setCursor(Cursor.HAND));
        bbb.setOnMouseExited(e -> bbb.setCursor(Cursor.DEFAULT));
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
        Background background2 = new Background(backgroundFill);
        bbb.setBackground(background2);

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
            players.get(i).setMaxWidth(180);
            players.get(i).setPrefHeight(60);
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
        

        Label teamLabel = new Label("Team 1:");
        Font teamFont = Font.font("Arial",FontWeight.BOLD,20);
        teamLabel.setFont(teamFont);
        Color teamClr = Color.WHITE;
        teamLabel.setTextFill(teamClr);


        Label PlayersLabel = new Label("Players:");
        PlayersLabel.setFont(teamFont);
        PlayersLabel.setTextFill(teamClr);


        Image backgroundImage = new Image("C:\\Users\\TECHNO-WORLD\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
        //Calculate the width and height based on the screen size
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        double screenHeight = primaryScreenBounds.getHeight();

        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
        Background background = new Background(backgroundImage1);

        VBox vBox = new VBox();
        vBox.setBackground(background);
        vBox.getChildren().addAll(teamLabel,teamNameInput,PlayersLabel);
        vBox.getChildren().addAll(players);
        vBox.getChildren().add(buttonBox);
        vBox.setSpacing(15);
        vBox.setPadding(new Insets(50));
        vBox.setAlignment(Pos.CENTER);

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













