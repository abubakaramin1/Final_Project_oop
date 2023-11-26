//package com.example.final_project_oop;
//
//import javafx.fxml.FXML;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.geometry.Rectangle2D;
//import javafx.scene.Cursor;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.input.KeyCode;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.stage.Screen;
//import javafx.stage.Stage;
//
//public class HelloController {
//    @FXML
//    private Label welcomeText;
//    public void start(Stage stage) throws Exception {
//
//        StackPane homepage = new StackPane();
//        window = stage;
//        window.setTitle("Team Management");
//        Button bb = new Button("Start Match");
//        bb.setMinSize(100,100);
//
//        BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
//        Background background2 = new Background(backgroundFill);
//        bb.setBackground(background2);
//
//        Rectangle rectangle = new Rectangle(10, 10, 80, 80);
//        rectangle.setArcWidth(80);
//        rectangle.setArcHeight(60);
//        bb.setShape(rectangle);
//        bb.setOnMouseEntered(e -> bb.setCursor(Cursor.HAND));
//        bb.setOnMouseExited(e -> bb.setCursor(Cursor.DEFAULT));
//
//
//        Image backgroundImage = new Image("C:\\Users\\TECHNO-WORLD\\IdeaProjects\\Final_Project_oop\\src\\main\\java\\com\\example\\final_project_oop\\3.jpg");
//        //Calculate the width and height based on the screen size
//        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
//        double screenWidth = primaryScreenBounds.getWidth();
//        double screenHeight = primaryScreenBounds.getHeight();
//
//        BackgroundImage backgroundImage1 = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,false,false,true,true));
//        Background background = new Background(backgroundImage1);
//        Font customFont = Font.font("Arial", FontWeight.BOLD ,30);
//        bb.setFont(customFont);
//        Color customColor = Color.WHITE;
//        bb.setTextFill(customColor);
//        bb.setUnderline(true);
//
//        bb.setBackground(background2);
//        homepage.setBackground(background);
//        homepage.getChildren().addAll(bb);
//        Scene scene4 = new Scene(homepage);
//
//        scene4.setOnKeyPressed(e ->
//        {
//            if (e.getCode() == KeyCode.ENTER)
//            {
//                bb.fire();
//            }
//        });
//
//        window.setScene(scene4);
//
//        Scene scene5 = addTeam1();
//
//        bb.setOnAction(e -> window.setScene(scene5));
//
//        Button run1 = new Button("1");
//        run1.setBackground(background2);
//        run1.setOnAction(e -> addOne());
//        run1.setFont(customFont);
//        run1.setTextFill(customColor);
//        run1.setShape(new Circle(40));
//        run1.setMinSize(90, 90);
//
//        Button run2 = new Button("2");
//        run2.setBackground(background2);
//        run2.setOnAction(e -> addTwo());
//        run2.setFont(customFont);
//        run2.setTextFill(customColor);
//        run2.setShape(new Circle(40));
//        run2.setMinSize(90, 90);
//
//        Button run3 = new Button("3");
//        run3.setBackground(background2);
//        run3.setOnAction(e -> addThree());
//        run3.setFont(customFont);
//        run3.setTextFill(customColor);
//        run3.setShape(new Circle(40));
//        run3.setMinSize(90, 90);
//
//        Button run4 = new Button("4");
//        run4.setBackground(background2);
//        run4.setOnAction(e -> addFour());
//        run4.setFont(customFont);
//        run4.setTextFill(customColor);
//        run4.setShape(new Circle(40));
//        run4.setMinSize(90, 90);
//
//        Button run5 = new Button("5");
//        run5.setBackground(background2);
//        run5.setOnAction(e -> addFive());
//        run5.setFont(customFont);
//        run5.setTextFill(customColor);
//        run5.setShape(new Circle(40));
//        run5.setMinSize(90, 90);
//
//        Button run6 = new Button("6");
//        run6.setBackground(background2);
//        run6.setOnAction(e -> addSix());
//        run6.setFont(customFont);
//        run6.setTextFill(customColor);
//        run6.setShape(new Circle(40));
//        run6.setMinSize(90, 90);
//
//        Button run0 = new Button("0");
//        run0.setBackground(background2);
//        run0.setOnAction(e -> addZero());
//        run0.setFont(customFont);
//        run0.setTextFill(customColor);
//        run0.setShape(new Circle(40));
//        run0.setMinSize(90, 90);
//
//        Button wide = new Button("wide");
//        wide.setBackground(background2);
//        wide.setOnAction( e -> wideBall());
//        wide.setFont(customFont);
//        wide.setTextFill(customColor);
//        wide.setShape(new Circle(40));
//        wide.setMinSize(85, 90);
//
//        Button out = new Button("Out");
//        out.setBackground(background2);
//        out.setFont(customFont);
//        out.setTextFill(customColor);
//        out.setShape(new Circle(40));
//        out.setMinSize(90, 90);
//        out.setOnAction(e -> {
//            out();
//        });
//
//        Font teamFont = Font.font("Arial",FontWeight.BOLD,30);
//        Color teamClr = Color.WHITE;
//
//
//        l3.setTextFill(teamClr);
//        l3.setFont(teamFont);
//        l4.setTextFill(teamClr);
//        l4.setFont(teamFont);
//        l5.setTextFill(teamClr);
//        l5.setFont(teamFont);
//
//
//        vBox3.getChildren().addAll(l3, l4, l5);
//
//        borderPane.setLeft(vBox3);
//
//        HBox hBox = new HBox();
//        hBox.getChildren().addAll(run0, run1, run2, run3, run4, run5, run6,wide, out);
//        hBox.setSpacing(10);
//        hBox.setAlignment(Pos.CENTER);
//
//        HBox hboxVbox = new HBox();
//        hboxVbox.setAlignment(Pos.CENTER);
//        hboxVbox.getChildren().add(vBox1);
//
//        VBox vBoxCenter = new VBox();
//        vBoxCenter.getChildren().addAll( hboxVbox,hBox);
//        vBoxCenter.setAlignment(Pos.CENTER);
//        vBoxCenter.setSpacing(20);
//
//        borderPane.setBackground(background);
//        //borderPane.setBottom(hBox);
//        borderPane.setCenter(vBoxCenter);
//        Button button = new Button("Scorecard");
//        Button button1 = new Button("Total Scorecard");
//        button1.setTextFill(Color.WHITE);
//        button.setPrefSize(120, 60);
//        Font buttonFont = Font.font("Arial", FontWeight.BOLD, 13);
//        Color buttonClr = Color.WHITE;
//        button.setTextFill(buttonClr);
//        button.setFont(buttonFont);
//        button1.setFont(buttonFont);
//        button.setOnMouseEntered(e -> button.setCursor(Cursor.HAND));
//        button.setOnMouseExited(e -> button.setCursor(Cursor.DEFAULT));
//        button.setBackground(background2);
//        button1.setPrefSize(120, 60);
//        Font button1Font = Font.font("Arial", FontWeight.BOLD, 15);
//        Color button1Clr = Color.WHITE;
//        button.setTextFill(button1Clr);
//        button.setFont(button1Font);
//        button1.setOnMouseEntered(e -> button1.setCursor(Cursor.HAND));
//        button1.setOnMouseExited(e -> button1.setCursor(Cursor.DEFAULT));
//        button1.setBackground(background2);
//
//        HBox buttonBox = new HBox(10);
//        buttonBox.getChildren().addAll(button,button1);
//        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
//        buttonBox.setPadding(new Insets(30, 30, 30, 30)); // Adjust padding as needed
//
//        borderPane.setBottom(buttonBox); // Add buttonBox to the bottom of the borderPane
//        button.setOnAction(e -> showScorecard());
//        button1.setOnAction(e -> totalScorecard());
//
//        scene2 = new Scene(borderPane);
//        window.setWidth(screenWidth);
//        window.setHeight(screenHeight);
//
//
//        window.show();
//
//    }
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
//}