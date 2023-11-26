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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import static java.lang.Integer.parseInt;

public class Playmatch extends Application {

    Stage window;
    Scene scene, scene1, scene2, scene3;
    Team battingTeam = new Team();
    Team ballingTeam = new Team();
    List<Player> battingSide;
    int maxOvers;
    int totalOvers;


    public static void main(String[] args) throws Exception {

        launch();
    }

    private Team team1 = new Team();
    private Team team2 = new Team();
    private Player batsman1 = new Player();
    private Player batsman2 = new Player();
    private Player bowler = new Player();
    int innings = 1;

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
        Image backgroundImage = new Image("C:\\Users\\Administrator\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
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
        TextField textField = new TextField();
        textField.setPromptText("Enter Maximum overs");
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
        Image backgroundImage = new Image("C:\\Users\\Administrator\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
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

        vBox.getChildren().addAll(label2, textField, button);
        button.setOnAction(e ->
        {
            maxOvers = parseInt(textField.getText());
            showBattingTeam();
        });
        textField.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.ENTER) {
                button.requestFocus();
            }
        });
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

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50));
        gridPane.setAlignment(Pos.CENTER);

        CheckBox p1 = new CheckBox(battingTeam.team.get(0).toString());
        p1.setPadding(new Insets(10));
        p1.setContentDisplay(ContentDisplay.TOP);
        p1.setAlignment(Pos.CENTER);
        p1.setTextFill(clr);
        p1.setFont(labelFont);
        p1.setTextFill(clr);

        CheckBox p2 = new CheckBox(battingTeam.team.get(1).toString());
        p2.setPadding(new Insets(10));
        p2.setContentDisplay(ContentDisplay.TOP);
        p2.setAlignment(Pos.CENTER);
        p2.setFont(labelFont);
        p2.setTextFill(clr);

        CheckBox p3 = new CheckBox(battingTeam.team.get(2).toString());
        p3.setPadding(new Insets(10));
        p3.setContentDisplay(ContentDisplay.TOP);
        p3.setAlignment(Pos.CENTER);
        p3.setFont(labelFont);
        p3.setTextFill(clr);

        CheckBox p4 = new CheckBox(battingTeam.team.get(3).toString());
        p4.setPadding(new Insets(10));
        p4.setContentDisplay(ContentDisplay.TOP);
        p4.setAlignment(Pos.CENTER);
        p4.setFont(labelFont);
        p4.setTextFill(clr);

        CheckBox p5 = new CheckBox(battingTeam.team.get(4).toString());
        p5.setPadding(new Insets(10));
        p5.setContentDisplay(ContentDisplay.TOP);
        p5.setAlignment(Pos.CENTER);
        p5.setFont(labelFont);
        p5.setTextFill(clr);

        CheckBox p6 = new CheckBox(battingTeam.team.get(5).toString());
        p6.setPadding(new Insets(10));
        p6.setContentDisplay(ContentDisplay.TOP);
        p6.setAlignment(Pos.CENTER);
        p6.setFont(labelFont);
        p6.setTextFill(clr);

        CheckBox p7 = new CheckBox(battingTeam.team.get(6).toString());
        p7.setPadding(new Insets(10));
        p7.setContentDisplay(ContentDisplay.TOP);
        p7.setAlignment(Pos.CENTER);
        p7.setFont(labelFont);
        p7.setTextFill(clr);

        CheckBox p8 = new CheckBox(battingTeam.team.get(7).toString());
        p8.setPadding(new Insets(10));
        p8.setContentDisplay(ContentDisplay.TOP);
        p8.setAlignment(Pos.CENTER);
        p8.setFont(labelFont);
        p8.setTextFill(clr);

        CheckBox p9 = new CheckBox(battingTeam.team.get(8).toString());
        p9.setPadding(new Insets(10));
        p9.setContentDisplay(ContentDisplay.TOP);
        p9.setAlignment(Pos.CENTER);
        p9.setFont(labelFont);
        p9.setTextFill(clr);

        CheckBox p10 = new CheckBox(battingTeam.team.get(9).toString());
        p10.setPadding(new Insets(10));
        p10.setContentDisplay(ContentDisplay.TOP);
        p10.setAlignment(Pos.CENTER);
        p10.setFont(labelFont);
        p10.setTextFill(clr);

        CheckBox p11 = new CheckBox(battingTeam.team.get(10).toString());
        p11.setPadding(new Insets(10));
        p11.setContentDisplay(ContentDisplay.TOP);
        p11.setAlignment(Pos.CENTER);
        p11.setFont(labelFont);
        p11.setTextFill(clr);

        gridPane.add(p1, 0, 0);
        gridPane.add(p2, 0, 1);
        gridPane.add(p3, 0, 2);
        gridPane.add(p4, 0, 3);
        gridPane.add(p5, 0, 4);
        gridPane.add(p6, 0, 5);
        gridPane.add(p7, 0, 6);
        gridPane.add(p8, 0, 7);
        gridPane.add(p9, 0, 8);
        gridPane.add(p10, 0, 9);
        gridPane.add(p11, 0, 10);

        Button b1 = new Button("Confirm");


        b1.setPrefSize(150,60);
        b1.setPadding(new Insets(10));
        Font buttonFont = Font.font("Arial",FontWeight.BOLD,20);
        b1.setUnderline(true);
        Color buttonClr = Color.WHITE;
        b1.setTextFill(buttonClr);
        b1.setFont(buttonFont);
        b1.setOnMouseEntered(e -> b1.setCursor(Cursor.HAND));
        b1.setOnMouseExited(e -> b1.setCursor(Cursor.DEFAULT));
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
        Background background2 = new Background(backgroundFill);
        b1.setBackground(background2);
        b1.setAlignment(Pos.BOTTOM_CENTER);
        b1.setOnAction(e ->
        {
            handle1(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
            showBallingTeam();
        });


        VBox vBox = new VBox();
        Image backgroundImage = new Image("C:\\Users\\Administrator\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");


        //Calculate the width and height based on the screen size
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        double screenHeight = primaryScreenBounds.getHeight();

        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
        Background background = new Background(backgroundImage1);
        vBox.setBackground(background);
        vBox.getChildren().addAll(l1,gridPane, b1);
        vBox.setAlignment(Pos.TOP_CENTER);
        //  VBox.setMargin(b1, new Insets(-40, 0, 0, 0));
        b1.setTranslateY(-20);

        VBox.setMargin(b1, new Insets(0, 0, 20, 0));
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

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50));
        gridPane.setAlignment(Pos.CENTER);


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

        gridPane.add(pa, 0, 0);
        gridPane.add(pb, 0, 1);
        gridPane.add(pc, 0, 2);
        gridPane.add(pd, 0, 3);
        gridPane.add(pe, 0, 4);
        gridPane.add(pf, 0, 5);
        gridPane.add(pg, 0, 6);
        gridPane.add(ph, 0, 7);
        gridPane.add(pi, 0, 8);
        gridPane.add(pj, 0, 9);
        gridPane.add(pk, 0, 10);

        Button b2 = new Button("Confirm");
        b2.setPrefSize(150,60);
        b2.setPadding(new Insets(10));
        Font buttonFont = Font.font("Arial",FontWeight.BOLD,20);
        b2.setUnderline(true);
        Color buttonClr = Color.WHITE;
        b2.setTextFill(buttonClr);
        b2.setFont(buttonFont);
        b2.setOnMouseEntered(e -> b2.setCursor(Cursor.HAND));
        b2.setOnMouseExited(e -> b2.setCursor(Cursor.DEFAULT));
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
        Background background2 = new Background(backgroundFill);
        b2.setBackground(background2);
        b2.setAlignment(Pos.BOTTOM_CENTER);

        b2.setOnAction(e -> {
            handle2(pa, pb, pc, pd, pe, pf, pg, ph, pi, pj, pk);
            window.setScene(scene2);
        });

        VBox vBox2 = new VBox();
        Image backgroundImage = new Image("C:\\Users\\Administrator\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
        //Calculate the width and height based on the screen size
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        double screenHeight = primaryScreenBounds.getHeight();

        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
        Background background = new Background(backgroundImage1);
        vBox2.setBackground(background);
        vBox2.getChildren().addAll(l2,gridPane, b2);
        vBox2.setAlignment(Pos.CENTER);
        // VBox.setMargin(b2, new Insets(-40, 0, 0, 0));
        b2.setTranslateY(-20);

        VBox.setMargin(b2, new Insets(0, 0, 20, 0));
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


        Image backgroundImage = new Image("C:\\Users\\Administrator\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
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
        run1.setBackground(background2);
        run1.setOnAction(e -> addOne());
        run1.setFont(customFont);
        run1.setTextFill(customColor);
        run1.setShape(new Circle(40));
        run1.setMinSize(90, 90);

        Button run2 = new Button("2");
        run2.setBackground(background2);
        run2.setOnAction(e -> addTwo());
        run2.setFont(customFont);
        run2.setTextFill(customColor);
        run2.setShape(new Circle(40));
        run2.setMinSize(90, 90);

        Button run3 = new Button("3");
        run3.setBackground(background2);
        run3.setOnAction(e -> addThree());
        run3.setFont(customFont);
        run3.setTextFill(customColor);
        run3.setShape(new Circle(40));
        run3.setMinSize(90, 90);

        Button run4 = new Button("4");
        run4.setBackground(background2);
        run4.setOnAction(e -> addFour());
        run4.setFont(customFont);
        run4.setTextFill(customColor);
        run4.setShape(new Circle(40));
        run4.setMinSize(90, 90);

        Button run5 = new Button("5");
        run5.setBackground(background2);
        run5.setOnAction(e -> addFive());
        run5.setFont(customFont);
        run5.setTextFill(customColor);
        run5.setShape(new Circle(40));
        run5.setMinSize(90, 90);

        Button run6 = new Button("6");
        run6.setBackground(background2);
        run6.setOnAction(e -> addSix());
        run6.setFont(customFont);
        run6.setTextFill(customColor);
        run6.setShape(new Circle(40));
        run6.setMinSize(90, 90);

        Button run0 = new Button("0");
        run0.setBackground(background2);
        run0.setOnAction(e -> addZero());
        run0.setFont(customFont);
        run0.setTextFill(customColor);
        run0.setShape(new Circle(40));
        run0.setMinSize(90, 90);

        Button wide = new Button("wide");
        wide.setBackground(background2);
        wide.setOnAction( e -> wideBall());
        wide.setFont(customFont);
        wide.setTextFill(customColor);
        wide.setShape(new Circle(40));
        wide.setMinSize(85, 90);

        Button out = new Button("Out");
        out.setBackground(background2);
        out.setFont(customFont);
        out.setTextFill(customColor);
        out.setShape(new Circle(40));
        out.setMinSize(90, 90);
        out.setOnAction(e -> {
            out();
        });

        Font teamFont = Font.font("Arial",FontWeight.BOLD,30);
        Color teamClr = Color.WHITE;


        l3.setTextFill(teamClr);
        l3.setFont(teamFont);
        l4.setTextFill(teamClr);
        l4.setFont(teamFont);
        l5.setTextFill(teamClr);
        l5.setFont(teamFont);


        vBox3.getChildren().addAll(l3, l4, l5);

        borderPane.setLeft(vBox3);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(run0, run1, run2, run3, run4, run5, run6,wide, out);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        HBox hboxVbox = new HBox();
        hboxVbox.setAlignment(Pos.CENTER);
        hboxVbox.getChildren().add(vBox1);

        VBox vBoxCenter = new VBox();
        vBoxCenter.getChildren().addAll( hboxVbox,hBox);
        vBoxCenter.setAlignment(Pos.CENTER);
        vBoxCenter.setSpacing(20);

        borderPane.setBackground(background);
        //borderPane.setBottom(hBox);
        borderPane.setCenter(vBoxCenter);
        Button button = new Button("Scorecard");
        Button button1 = new Button("Total Scorecard");
        button.setPrefSize(120, 60);
        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 15);
        Color buttonClr = Color.WHITE;
        button.setTextFill(buttonClr);
        button.setFont(buttonFont);
        button.setOnMouseEntered(e -> button.setCursor(Cursor.HAND));
        button.setOnMouseExited(e -> button.setCursor(Cursor.DEFAULT));
        button.setBackground(background2);
        button1.setPrefSize(120, 60);
        Font button1Font = Font.font("Arial", FontWeight.BOLD, 15);
        Color button1Clr = Color.WHITE;
        button.setTextFill(button1Clr);
        button.setFont(button1Font);
        button1.setOnMouseEntered(e -> button1.setCursor(Cursor.HAND));
        button1.setOnMouseExited(e -> button1.setCursor(Cursor.DEFAULT));
        button1.setBackground(background2);

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(button,button1);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.setPadding(new Insets(30, 30, 30, 30)); // Adjust padding as needed

        borderPane.setBottom(buttonBox); // Add buttonBox to the bottom of the borderPane
        button.setOnAction(e -> showScorecard());
        button1.setOnAction(e -> totalScorecard());
        scene2 = new Scene(borderPane);
        window.setWidth(screenWidth);
        window.setHeight(screenHeight);


        window.show();

    }

    private void handle1(CheckBox p1, CheckBox p2, CheckBox p3, CheckBox p4, CheckBox p5, CheckBox p6, CheckBox p7, CheckBox p8, CheckBox p9, CheckBox p10, CheckBox p11) {
        if (p1.isSelected())
        {
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

    private void addOne() {
        batsman1.setRunsScored(batsman1.getRunsScored() + 1);
        battingTeam.totalScore = battingTeam.totalScore + 1;
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
        nextInnings();
        updateBatsmanScores();
    }

    private void addTwo() {
        batsman1.setRunsScored(batsman1.getRunsScored() + 2);
        battingTeam.totalScore = battingTeam.totalScore + 2;
        batsman1.setBallsPlayed(batsman1.getBallsPlayed() + 1);
        if (bowler.getBallsDelivered() < 6) {
            bowler.setBallsDelivered(bowler.getBallsDelivered() + 1);
            bowler.setRunsGiven(bowler.getRunsGiven() + 2);
        }
        checkBalls();
        nextInnings();
        updateBatsmanScores();
    }

    private void addThree() {
        batsman1.setRunsScored(batsman1.getRunsScored() + 3);
        battingTeam.totalScore = battingTeam.totalScore + 3;

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
        nextInnings();
        updateBatsmanScores();
    }

    private void addFour() {
        batsman1.setRunsScored(batsman1.getRunsScored() + 4);
        battingTeam.totalScore = battingTeam.totalScore + 4;

        batsman1.setBallsPlayed(batsman1.getBallsPlayed() + 1);
        if (bowler.getBallsDelivered() < 6) {
            bowler.setBallsDelivered(bowler.getBallsDelivered() + 1);
            bowler.setRunsGiven(bowler.getRunsGiven() + 4);
        }
        checkBalls();
        nextInnings();
        updateBatsmanScores();
    }

    private void addFive() {
        batsman1.setRunsScored(batsman1.getRunsScored() + 5);
        battingTeam.totalScore = battingTeam.totalScore + 5;

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
        nextInnings();
        updateBatsmanScores();
    }

    private void addSix() {
        batsman1.setRunsScored(batsman1.getRunsScored() + 6);
        battingTeam.totalScore = battingTeam.totalScore + 6;

        batsman1.setBallsPlayed(batsman1.getBallsPlayed() + 1);
        if (bowler.getBallsDelivered() < 6) {
            bowler.setBallsDelivered(bowler.getBallsDelivered() + 1);
            bowler.setRunsGiven(bowler.getRunsGiven() + 6);
        }
        checkBalls();
        nextInnings();
        updateBatsmanScores();
    }

    private void addZero() {
        batsman1.setBallsPlayed(batsman1.getBallsPlayed() + 1);
        if (bowler.getBallsDelivered() < 6) {
            bowler.setBallsDelivered(bowler.getBallsDelivered() + 1);
        }
        checkBalls();
        nextInnings();
        updateBatsmanScores();
    }

    private void wideBall() {
        battingTeam.totalScore = battingTeam.totalScore + 1;

        updateBatsmanScores();

    }

    private void checkBalls()
    {
        Label l8 = new Label("Select a new Bowler:");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50));
        gridPane.setAlignment(Pos.CENTER);

        Font labelFont = Font.font("Arial",FontWeight.BOLD,20);
        Font font = Font.font("Arial",FontWeight.BOLD,40);
        Color clr = Color.WHITE;
        l8.setTextFill(clr);
        l8.setFont(font);

        if (bowler.getBallsDelivered() == 6) {

            bowler.setNumOfOvers(bowler.getNumOfOvers() + 1 );
            totalOvers = totalOvers + 1;
            Player temp = new Player();
            temp = batsman1;
            batsman1 = batsman2;
            batsman2 = temp;

            CheckBox b1 = new CheckBox(ballingTeam.team.get(0).toString());
            b1.setPadding(new Insets(10));
            b1.setFont(labelFont);
            b1.setTextFill(clr);

            CheckBox b2 = new CheckBox(ballingTeam.team.get(1).toString());
            b2.setPadding(new Insets(10));
            b2.setFont(labelFont);
            b2.setTextFill(clr);

            CheckBox b3 = new CheckBox(ballingTeam.team.get(2).toString());
            b3.setPadding(new Insets(10));
            b3.setFont(labelFont);
            b3.setTextFill(clr);

            CheckBox b4 = new CheckBox(ballingTeam.team.get(3).toString());
            b4.setPadding(new Insets(10));
            b4.setFont(labelFont);
            b4.setTextFill(clr);

            CheckBox b5 = new CheckBox(ballingTeam.team.get(4).toString());
            b5.setPadding(new Insets(10));
            b5.setFont(labelFont);
            b5.setTextFill(clr);

            CheckBox b6 = new CheckBox(ballingTeam.team.get(5).toString());
            b6.setPadding(new Insets(10));
            b6.setFont(labelFont);
            b6.setTextFill(clr);

            CheckBox b7 = new CheckBox(ballingTeam.team.get(6).toString());
            b7.setPadding(new Insets(10));
            b7.setFont(labelFont);
            b7.setTextFill(clr);

            CheckBox b8 = new CheckBox(ballingTeam.team.get(7).toString());
            b8.setPadding(new Insets(10));
            b8.setFont(labelFont);
            b8.setTextFill(clr);

            CheckBox b9 = new CheckBox(ballingTeam.team.get(8).toString());
            b9.setPadding(new Insets(10));
            b9.setFont(labelFont);
            b9.setTextFill(clr);

            CheckBox b10 = new CheckBox(ballingTeam.team.get(9).toString());
            b10.setPadding(new Insets(10));
            b10.setFont(labelFont);
            b10.setTextFill(clr);

            CheckBox b11 = new CheckBox(ballingTeam.team.get(10).toString());
            b11.setPadding(new Insets(10));
            b11.setFont(labelFont);
            b11.setTextFill(clr);


            gridPane.add(b1, 0, 0);
            gridPane.add(b2, 0, 1);
            gridPane.add(b3, 0, 2);
            gridPane.add(b4, 0, 3);
            gridPane.add(b5, 0, 4);
            gridPane.add(b6, 0, 5);
            gridPane.add(b7, 0, 6);
            gridPane.add(b8, 0, 7);
            gridPane.add(b9, 0, 8);
            gridPane.add(b10, 0, 9);
            gridPane.add(b11, 0, 10);

            Button b = new Button("Confirm");
            b.setPrefSize(150,60);
            b.setPadding(new Insets(10));
            Font buttonFont = Font.font("Arial",FontWeight.BOLD,20);
            b.setUnderline(true);
            Color buttonClr = Color.WHITE;
            b.setTextFill(buttonClr);
            b.setFont(buttonFont);
            b.setOnMouseEntered(e -> b.setCursor(Cursor.HAND));
            b.setOnMouseExited(e -> b.setCursor(Cursor.DEFAULT));
            BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
            Background background2 = new Background(backgroundFill);
            b.setBackground(background2);
            b.setAlignment(Pos.BOTTOM_CENTER);
            b.setOnAction(e -> {
                handle2(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11);
                window.setScene(scene2);
                bowler.setBallsDelivered(0);
                updateBatsmanScores();
            });

            VBox vBox = new VBox();

            Image backgroundImage = new Image("C:\\Users\\Administrator\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
            //Calculate the width and height based on the screen size
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            double screenWidth = primaryScreenBounds.getWidth();
            double screenHeight = primaryScreenBounds.getHeight();

            BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
            Background background = new Background(backgroundImage1);
            vBox.setBackground(background);
            vBox.getChildren().addAll(l8,gridPane, b);
            vBox.setAlignment(Pos.CENTER);
            b.setTranslateY(-20);
            VBox.setMargin(b,new Insets(0,0,20,0));
            Scene scene3 = new Scene(vBox);
            window.setScene(scene3);
        }
    }


    private void updateBatsmanScores()
    {
        Font teamFont = Font.font("Arial",FontWeight.BOLD,30);
        Color teamClr = Color.WHITE;

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        Label l1 = new Label("Batsman");
        gridPane.add(l1, 0, 0);
        l1.setFont(teamFont);
        l1.setTextFill(teamClr);

        Label l2 = new Label("Runs");
        l2.setTextFill(teamClr);
        l2.setFont(teamFont);
        gridPane.add(l2, 1, 0);

        Label l3 = new Label("Balls");
        l3.setFont(teamFont);
        l3.setTextFill(teamClr);
        gridPane.add(l3, 2, 0);

        Label l4 = new Label(batsman1.getName());
        l4.setTextFill(teamClr);
        l4.setFont(teamFont);
        gridPane.add(l4, 0, 1);

        Label l5 = new Label(String.valueOf(batsman1.getRunsScored()));
        l5.setFont(teamFont);
        l5.setTextFill(teamClr);
        gridPane.add(l5, 1, 1);

        Label l6 = new Label(String.valueOf(batsman1.getBallsPlayed()));
        l6.setTextFill(teamClr);
        l6.setFont(teamFont);
        gridPane.add(l6, 2, 1);

        Label l7 = new Label(batsman2.getName());
        l7.setFont(teamFont);
        l7.setTextFill(teamClr);
        gridPane.add(l7, 0, 2);

        Label l8 = new Label(String.valueOf(batsman2.getRunsScored()));
        l8.setTextFill(teamClr);
        l8.setFont(teamFont);
        gridPane.add(l8, 1, 2);

        Label l9 = new Label(String.valueOf(batsman2.getBallsPlayed()));
        l9.setFont(teamFont);
        l9.setTextFill(teamClr);
        gridPane.add(l9, 2, 2);

        Label l10 =new Label("Bowler");
        l10.setTextFill(teamClr);
        l10.setFont(teamFont);
        gridPane.add(l10, 0, 4);

        Label l11 = new Label("Deliveries");
        l11.setFont(teamFont);
        l11.setTextFill(teamClr);
        gridPane.add(l11, 1, 4);

        Label l12 = new Label("Runs/Wickets");
        l12.setTextFill(teamClr);
        l12.setFont(teamFont);
        gridPane.add(l12, 2, 4);

        Label l13 = new Label("Overs");
        l13.setFont(teamFont);
        l13.setTextFill(teamClr);
        gridPane.add(l13 , 3 ,4);

        Label l14 = new Label(bowler.getName());
        l14.setTextFill(teamClr);
        l14.setFont(teamFont);
        gridPane.add(l14, 0, 5);

        Label l15 = new Label(String.valueOf(bowler.getBallsDelivered()));
        l15.setFont(teamFont);
        l15.setTextFill(teamClr);
        gridPane.add(l15, 1, 5);

        Label l16 = new Label(String.format("%d/%d", bowler.getRunsGiven(), bowler.getOuts()));
        l16.setTextFill(teamClr);
        l16.setFont(teamFont);
        gridPane.add(l16, 2, 5);

        Label l17 = new Label(String.valueOf(bowler.getNumOfOvers()));
        l17.setFont(teamFont);
        l17.setTextFill(teamClr);
        gridPane.add(l17 , 3 , 5);

        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().clear();
        vBox1.getChildren().add(gridPane);
    }

    private void out() {
        Label l1 = new Label("Select a new Batsman:");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50));
        gridPane.setAlignment(Pos.CENTER);

        Font labelFont = Font.font("Arial",FontWeight.BOLD,20);
        Font font = Font.font("Arial",FontWeight.BOLD,40);
        Color clr = Color.WHITE;
        l1.setTextFill(clr);
        l1.setFont(font);

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
               // checkBoxes.add(new CheckBox(battingSide.get(i).toString()));
            CheckBox checkBox = new CheckBox(battingSide.get(i).toString());
            checkBox.setFont(labelFont);
            checkBox.setTextFill(clr);
            checkBox.setPadding(new Insets(10));
            checkBoxes.add(checkBox);
            gridPane.add(checkBox, 0, i);
        }

        VBox vBox = new VBox();
        Image backgroundImage = new Image("C:\\Users\\Administrator\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
        //Calculate the width and height based on the screen size
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        double screenHeight = primaryScreenBounds.getHeight();

        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
        Background background = new Background(backgroundImage1);
        vBox.setBackground(background);
        vBox.getChildren().addAll(l1,gridPane);
        vBox.setAlignment(Pos.CENTER);


        Button confirmButton = new Button("Confirm");
        confirmButton.setPrefSize(150,60);
        confirmButton.setPadding(new Insets(10));
        Font buttonFont = Font.font("Arial",FontWeight.BOLD,20);
        confirmButton.setUnderline(true);
        Color buttonClr = Color.WHITE;
        confirmButton.setTextFill(buttonClr);
        confirmButton.setFont(buttonFont);
        confirmButton.setOnMouseEntered(e -> confirmButton.setCursor(Cursor.HAND));
        confirmButton.setOnMouseExited(e -> confirmButton.setCursor(Cursor.DEFAULT));
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
        Background background2 = new Background(backgroundFill);
        confirmButton.setBackground(background2);
        confirmButton.setAlignment(Pos.BOTTOM_CENTER);

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
        confirmButton.setTranslateY(-20);
        confirmButton.setTextAlignment(TextAlignment.CENTER);
        vBox.getChildren().add(confirmButton);
        VBox.setMargin(confirmButton,new Insets(0,0,20,0));
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

        Image backgroundImage = new Image("C:\\Users\\Administrator\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
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

        Font buttonFont = Font.font("Arial",FontWeight.BOLD,15);
        Color buttonClr = Color.WHITE;
        bbb.setPrefSize(120,60);
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


        Image backgroundImage = new Image("C:\\Users\\Administrator\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
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

        Label label = new Label();
        if (innings ==1)
        {
            label.setText("Innings 1");
        }
        else if (innings == 2)
        {
            label.setText("Innings 2");
        }
        Image backgroundImage = new Image("C:\\Users\\Administrator\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
        //Calculate the width and height based on the screen size
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        double screenHeight = primaryScreenBounds.getHeight();
        VBox team1Score = new VBox();
        VBox team2Score = new VBox();
        BorderPane scorecardPane = new BorderPane();
        if (Objects.equals(team1, battingTeam))
        {
            team1Score = createScorecardVBox(team1.getTeamName(), team1);
            team2Score = createScorecardVBoxBalling(team2.getTeamName(), team2);
        }
        else if (Objects.equals(team2 , battingTeam))
        {
            team1Score = createScorecardVBox(team2.getTeamName(), team2);
            team2Score = createScorecardVBoxBalling(team1.getTeamName(), team1);
        }

        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
        Background background = new Background(backgroundImage1);
        scorecardPane.setBackground(background);
//        Label l1 = new Label(team1.getTeamName());
//        Label l2 = new Label(team2.getTeamName());



        HBox scorecardBox = new HBox(team1Score, team2Score);
        scorecardBox.setSpacing(30);
        scorecardBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(label,scorecardBox);
        Button button = new Button("Ball By Ball");
        button.setPrefSize(120, 60);
        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 15);
        Color buttonClr = Color.WHITE;
        button.setTextFill(buttonClr);
        button.setFont(buttonFont);
        button.setOnMouseEntered(e -> button.setCursor(Cursor.HAND));
        button.setOnMouseExited(e -> button.setCursor(Cursor.DEFAULT));
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
        Background background2 = new Background(backgroundFill);
        button.setBackground(background2);

        HBox buttonBox = new HBox(button);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.setPadding(new Insets(30, 30, 30, 30)); // Adjust padding as needed

        borderPane.setBottom(buttonBox); // Add buttonBox to the bottom of the borderPane

        button.setOnAction( e -> window.setScene(scene2));

        scorecardPane.setCenter(vBox);
        scorecardPane.setBottom(buttonBox);
        Scene scorecardScene = new Scene(scorecardPane, 600, 400);
        window.setScene(scorecardScene);
    }
    private VBox createScorecardVBox(String teamName, Team team) {
        VBox vBox = new VBox();
        vBox.setSpacing(10);


        Font teamFont = Font.font("Arial",FontWeight.BOLD,30);
        Color teamClr = Color.WHITE;

        Label teamLabel = new Label(teamName);
        teamLabel.setFont(teamFont);
        teamLabel.setTextFill(teamClr);

       // teamLabel.setFont(new Font("Arial", 18));
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);

        Label l1 = new Label("Player");
        Label l2 = new Label("Runs");
        Label l3 = new Label("Balls");


        l1.setFont(teamFont);
        l1.setTextFill(teamClr);
        l2.setFont(teamFont);
        l2.setTextFill(teamClr);
        l3.setFont(teamFont);
        l3.setTextFill(teamClr);

        // Add column headers
        gridPane.add(l1, 0, 0);
        gridPane.add(l2, 1, 0);
        gridPane.add(l3, 2, 0);

        // Add player details
        for (int i = 0; i < team.team.size(); i++) {
            Player player = team.team.get(i);
            Label l4 = new Label(player.getName());
            Label l5 = new Label(String.valueOf(player.getRunsScored()));
            Label l6 = new Label(String.valueOf(player.getBallsPlayed()));
            l4.setTextFill(teamClr);
            l4.setFont(teamFont);
            l5.setTextFill(teamClr);
            l5.setFont(teamFont);
            l6.setTextFill(teamClr);
            l6.setFont(teamFont);
            gridPane.add(l4, 0, i + 1);
            gridPane.add(l5, 1, i + 1);
            gridPane.add(l6, 2, i + 1);
        }

        vBox.getChildren().addAll(teamLabel, gridPane);
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    private VBox createScorecardVBoxBalling(String teamName, Team team)
    {
        VBox vBox = new VBox();
        vBox.setSpacing(10);


        Font teamFont = Font.font("Arial",FontWeight.BOLD,30);
        Color teamClr = Color.WHITE;

        Label teamLabel = new Label(teamName);
        teamLabel.setFont(teamFont);
        teamLabel.setTextFill(teamClr);

        // teamLabel.setFont(new Font("Arial", 18));
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);

        Label l1 = new Label("Player");
        Label l2 = new Label("Runs Given");
        Label l3 = new Label("Overs");

        l1.setFont(teamFont);
        l1.setTextFill(teamClr);
        l2.setFont(teamFont);
        l2.setTextFill(teamClr);
        l3.setFont(teamFont);
        l3.setTextFill(teamClr);

        // Add column headers
        gridPane.add(l1, 0, 0);
        gridPane.add(l2, 1, 0);
        gridPane.add(l3, 2, 0);

        // Add player details
        for (int i = 0; i < team.team.size(); i++) {
            Player player = team.team.get(i);
            Label l4 = new Label(player.getName());
            Label l5 = new Label(String.valueOf(player.getRunsGiven()));
            Label l6 = new Label(String.valueOf(player.getNumOfOvers()));
            l4.setTextFill(teamClr);
            l4.setFont(teamFont);
            l5.setTextFill(teamClr);
            l5.setFont(teamFont);
            l6.setTextFill(teamClr);
            l6.setFont(teamFont);
            gridPane.add(l4, 0, i + 1);
            gridPane.add(l5, 1, i + 1);
            gridPane.add(l6, 2, i + 1);
        }

        vBox.getChildren().addAll(teamLabel, gridPane);
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }
    public void totalScorecard()
    {
        if (innings == 1)
        {
            Label label = new Label("Innings 1");
            label.setAlignment(Pos.TOP_CENTER);
            VBox vboxBatting = createScorecardVBox(battingTeam.getTeamName(), battingTeam);
            VBox vboxBalling = createScorecardVBoxBalling(ballingTeam.getTeamName(), ballingTeam);
            HBox hBox = new HBox(vboxBatting,vboxBalling);
            VBox vBox = new VBox(label,hBox);
            Label label1 = new Label("Innings 2");
            label1.setAlignment(Pos.TOP_CENTER);
            VBox vBox2Batting = createScorecardVBox(ballingTeam.getTeamName(),ballingTeam);
            VBox vbox2Balling = createScorecardVBoxBalling(battingTeam.getTeamName(),battingTeam);
            HBox hBox1 = new HBox(vBox2Batting,vbox2Balling);
            VBox vBox1 = new VBox(label1 , hBox1);
            Button button = new Button("Ball By Ball");
            button.setOnAction( e -> window.setScene(scene2));
            VBox vBoxMain = new VBox(vBox , vBox1 ,button);
            Scene scene4 = new Scene(vBoxMain);
            window.setScene(scene4);
        }
        else if (innings == 2)
        {
            Label label = new Label("Innings 1");
            label.setAlignment(Pos.TOP_CENTER);
            VBox vboxBatting = createScorecardVBox(ballingTeam.getTeamName(), ballingTeam);
            VBox vboxBalling = createScorecardVBoxBalling(battingTeam.getTeamName(), battingTeam);
            HBox hBox = new HBox(vboxBatting,vboxBalling);
            VBox vBox = new VBox(label,hBox);
            Label label1 = new Label("Innings 2");
            label1.setAlignment(Pos.TOP_CENTER);
            VBox vBox2Batting = createScorecardVBox(battingTeam.getTeamName(),battingTeam);
            VBox vbox2Balling = createScorecardVBoxBalling(ballingTeam.getTeamName(),ballingTeam);
            HBox hBox1 = new HBox(vBox2Batting,vbox2Balling);
            VBox vBox1 = new VBox(label1 , hBox1);
            Button button = new Button("Ball By Ball");
            button.setOnAction( e -> window.setScene(scene2));
            if (innings == 2 && totalOvers == maxOvers)
            {
                button.setVisible(false);
            }
            VBox vBoxMain = new VBox(vBox , vBox1 , button);
            Scene scene4 = new Scene(vBoxMain);
            window.setScene(scene4);
        }
    }

    private void nextInnings() {
        if (totalOvers == maxOvers)
        {
            if (innings == 2)
            {
                Label label = new Label("Match has been completed ");
                Button button = new Button("Innings Scorecard");
                Button button1 = new Button("Total Scorecard");
                button.setOnAction(e ->
                {
                    showScorecard();
                });
                button1.setOnAction(e -> totalScorecard());
                VBox vBox = new VBox(label, button , button1);
                Scene scene4 = new Scene(vBox);
                window.setScene(scene4);
            } else if (innings < 2) {
                innings = innings + 1;
                Label label = new Label("First Innings has been completed.");
                Button button = new Button("Next Innings");
                VBox vBox = new VBox(label, button);
                Scene scene4 = new Scene(vBox);
                window.setScene(scene4);
                button.setOnAction(e ->
                {
                    Team temp = new Team();
                    temp = battingTeam;
                    battingTeam = ballingTeam;
                    ballingTeam = temp;
                    battingSide = new ArrayList<>(battingTeam.team);
                    totalOvers = 0;
                    batsman1 = new Player();
                    batsman2 = new Player();

                    showBattingTeam();
                });
            }

        }
    }





}













