import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
    private TextField displayField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");

        // Create the display field
        displayField = new TextField();
        displayField.setEditable(false);
        displayField.setAlignment(Pos.CENTER);
        displayField.setPrefHeight(50);

        // Create buttons for numbers and operators
        Button[][] buttons = new Button[4][4];
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int index = i * 4 + j;
                buttons[i][j] = new Button(buttonLabels[index]);
                buttons[i][j].setPrefSize(50, 50);
                buttons[i][j].setOnAction(e -> handleButtonClick(buttonLabels[index]));
                gridPane.add(buttons[i][j], j, i);
            }
        }

        // Create the scene and add the layout
        Scene scene = new Scene(gridPane, 250, 250);
        primaryStage.setScene(scene);

        // Set up the stage and show it
        primaryStage.show();
    }

    private void handleButtonClick(String label) {
        // Handle button clicks here (e.g., update the displayField)
    }

    public static void main(String[] args) {
        launch(args);
    }
}
