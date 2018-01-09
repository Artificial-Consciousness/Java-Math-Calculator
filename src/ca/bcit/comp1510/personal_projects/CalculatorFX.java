package ca.bcit.comp1510.personal_projects;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * <p>FX Calculator.</p>
 * <p>A calculator GUI made in JavaFX.</p>
 *
 * @author Andy Loi
 * @version 1.0
 */
public class CalculatorFX extends Application {
    /**
     * State of arithmetic calculation.
     */
    private boolean finished;
    
    /**
     * A MathReader.
     */
    private MathReader math;
    /**
     * An array of strings for the button text.
     */
    private String[] listOfButtons = {"SQRT", "X^2", "X^Y", "PI", "CE", "C", 
            "Del", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", 
            "2", "3", "+", "(-)", "0", ".", "="};
    
    /**
     * The display.
     */
    private Label display;
    
    /**
     * The calculator stage.
     * 
     * @param primaryStage
     *            a Stage
     */
    public void start(Stage primaryStage) {
        // Some constants for meta data.
        final int three = 3;
        final int four = 4;
        final int buttonWidth = 55;
        final int buttonHeight = 45;
        final int fontSize = 21;
        
        finished = false;
        GridPane pane = new GridPane();
        display = new Label();
        display.setFont(new Font("Arial", fontSize));
        pane.add(display, 0, 1, four, 2);
        int row = three;
        int col = 0;
        
        // Generate all the buttons.
        ArrayList<Button> numberPad = new ArrayList<Button>();
        for (int count = 0; count < listOfButtons.length; count++) {
            if (col > three) {
                col = 0;
                row++;
            }
            numberPad.add(new Button(listOfButtons[count]));
            numberPad.get(count).setPrefWidth(buttonWidth);
            numberPad.get(count).setPrefHeight(buttonHeight);
            numberPad.get(count).setOnAction(this::process);
            pane.add(numberPad.get(count), col, row);
            col++;
        }

        // Meta data.
        pane.setAlignment(Pos.CENTER);
        final int appWidth = 250;
        final int appHeight = 350;
        Scene scene = new Scene(pane, appWidth, appHeight, Color.BLACK);
        
        // Setup stage.
        primaryStage.setTitle("FX Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Processes the button press events.
     * 
     * @param event button press
     */
    private void process(ActionEvent event) {
        // Clears display after with any button press after a calculation.
        if (finished) {
            display.setText("");
            finished = false;
        }
        
        // The text from the button that was pressed.
        String temp = ((Button) event.getSource()).getText();
        
        switch (temp) {
        case "=":
            math = new MathReader(display.getText());
            display.setText(math.result());
            finished = true;
            break;
        case "CE":
            display.setText("");
            break;
        case "C":
            display.setText("");
            break;
        case "Del":
            if (display.getText().length() != 0) {
                display.setText(display.getText().substring(0,
                        display.getText().length() - 1));
            }
            break;
        case "SQRT":
            math = new MathReader(display.getText());
            display.setText("" + Math.sqrt(Double.parseDouble(math.result())));
            break;
        case "X^2":
            math = new MathReader(display.getText());
            display.setText("" + Math.pow(Double.parseDouble(
                    math.result()), 2));
            break;
        case "X^Y":
            // Unimplemented ^ sign.
            // display.setText(display.getText() + "^");
            break;
        case "PI":
            display.setText("" + display.getText() + Math.PI);
            break;
        default:
            display.setText("" + display.getText() + temp);
        }
        
    }
    
    /**
     * Launches the JavaFX application.
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
