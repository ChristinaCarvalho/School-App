import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application{

    @SuppressWarnings("static-access")
    @Override 
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        
        //Places text at top
        StackPane textPane = new StackPane();
        borderPane.setTop(textPane);
        Text text = new Text("School App");
        text.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 20));
        textPane.setAlignment(text, Pos.CENTER);
        textPane.setMargin(text, new Insets(100, 0, 0, 0)); 
        textPane.getChildren().add(text);

        //Pane where apps appear
        GridPane appsPane = new GridPane();
        borderPane.setCenter(appsPane); 
        appsPane.setAlignment(Pos.CENTER);
        appsPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        appsPane.setHgap(100);
        appsPane.setVgap(50);        
        RowConstraints row0 = new RowConstraints();
        row0.setPrefHeight(20); // Row 0 height
        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(100); // Row 1 height
        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(20); // Row 2 height
        appsPane.getRowConstraints().addAll(row0, row1, row2);

        //Calender
        Image calenderImage = new Image("file:src/Images/calculator.png", 100, 100, false, false);
        ImageView calenderImageView = new ImageView(calenderImage);
        appsPane.add(calenderImageView, 0, 0);
        GridPane.setHalignment(calenderImageView, HPos.CENTER);

        Button calenderBtn = new Button("Calender");
        appsPane.add(calenderBtn, 1, 1);
        GridPane.setHalignment(calenderBtn, HPos.CENTER);
        GridPane.setValignment(calenderBtn, VPos.TOP);

        //Calculator
        Image calculatorImage = new Image("file:src/Images/calendar.png", 90, 90, false, false);
        ImageView calculatorImageView = new ImageView(calculatorImage);
        appsPane.add(calculatorImageView, 1, 0);
        GridPane.setHalignment(calculatorImageView, HPos.CENTER);

        Button calculatorBtn = new Button("Calculator");
        appsPane.add(calculatorBtn, 0, 1);
        GridPane.setHalignment(calculatorBtn, HPos.CENTER);
        GridPane.setValignment(calculatorBtn, VPos.TOP);       

        //Notes
        Image notesImage = new Image("file:src/Images/writing.png", 90, 90, false, false);
        ImageView notesImageView = new ImageView(notesImage);
        appsPane.add(notesImageView, 0, 2);
        GridPane.setHalignment(notesImageView, HPos.CENTER);

        Button notesBtn = new Button("Notes");
        appsPane.add(notesBtn, 0, 3);
        GridPane.setHalignment(notesBtn, HPos.CENTER);
        GridPane.setValignment(notesBtn, VPos.TOP);        
        
        //FlashCards
        Image flashcardsImage = new Image("file:src/Images/icons8-flashcards-96.png", 100, 100, false, false);
        ImageView flashcardsImageView = new ImageView(flashcardsImage);
        appsPane.add(flashcardsImageView, 1, 2);
        GridPane.setHalignment(flashcardsImageView, HPos.CENTER);

        Button flashcardsBtn = new Button("Flashcards");
        appsPane.add(flashcardsBtn, 1, 3);
        GridPane.setHalignment(flashcardsBtn, HPos.CENTER);
        GridPane.setValignment(flashcardsBtn, VPos.TOP);
        
        //Defaults to home screen
        Scene homeScreen = new Scene(borderPane, 450, 600);        
        mainDisplay(primaryStage, homeScreen);

        //Switches to the different apps
        Notes notes = new Notes();
        notesBtn.setOnAction(e -> notes.display(primaryStage, homeScreen));

        FlashCards flashCards = new FlashCards();
        flashcardsBtn.setOnAction(e -> flashCards.display(primaryStage, homeScreen));        
        
        Calculator calculator = new Calculator();
        calculatorBtn.setOnAction(e -> {
            try {
                calculator.start(primaryStage, homeScreen);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });        
        Calender calender = new Calender();
        calenderBtn.setOnAction(e -> {
            try {
                calender.start(primaryStage, homeScreen);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
    }

    //Allows for the apps to switch back to the home screen
    public static void mainDisplay(Stage primaryStage, Scene homeScreen){
        primaryStage.setTitle("SchoolApp");
        primaryStage.setScene(homeScreen);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch();
    }
}
