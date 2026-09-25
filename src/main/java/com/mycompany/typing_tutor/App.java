package com.mycompany.typing_tutor;

import java.util.HashMap;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A Typing Tutor application that allows the user to practice typing
 * using a virtual keyboard.
 *
 * @author Alvee Ahsan Bhuiyan
 */
public class App extends Application {

    private int currentTextNumber = 1;
    private boolean shiftPressed = false;
    private int correctKeyStrokes = 0;
    private int incorrectKeyStrokes = 0;
    private Label statsLabel = new Label("Correct Keys: 0\nIncorrect Keys: 0");
    private StringBuilder typedText = new StringBuilder();
    private Label textToType = new Label("Text to type");

    @Override
    public void start(Stage stage) {
        Label keyPressedLabel = new Label("");
        Label notHandledLabel = new Label("");
        TextField responseField = new TextField();
        GridPane keyboard = new GridPane();

        keyboard.setHgap(15);
        keyboard.setVgap(15);
        keyboard.setAlignment(Pos.CENTER);
        keyboard.setPadding(new Insets(20));
        keyboard.setStyle("-fx-font-size: 18px;");

        Button qButton = new Button("Q");
        Button wButton = new Button("W");
        Button eButton = new Button("E");
        Button rButton = new Button("R");
        Button tButton = new Button("T");
        Button yButton = new Button("Y");
        Button uButton = new Button("U");
        Button iButton = new Button("I");
        Button oButton = new Button("O");
        Button pButton = new Button("P");

        Button aButton = new Button("A");
        Button sButton = new Button("S");
        Button dButton = new Button("D");
        Button fButton = new Button("F");
        Button gButton = new Button("G");
        Button hButton = new Button("H");
        Button jButton = new Button("J");
        Button kButton = new Button("K");
        Button lButton = new Button("L");

        Button shiftButton = new Button("Shift");
        Button zButton = new Button("Z");
        Button xButton = new Button("X");
        Button cButton = new Button("C");
        Button vButton = new Button("V");
        Button bButton = new Button("B");
        Button nButton = new Button("N");
        Button mButton = new Button("M");

        Button spaceButton = new Button("Space");
        Button backspaceButton = new Button("Backspace");
        Button commaButton = new Button(",");
        Button periodButton = new Button(".");

        keyboard.add(qButton, 0, 0);
        keyboard.add(wButton, 1, 0);
        keyboard.add(eButton, 2, 0);
        keyboard.add(rButton, 3, 0);
        keyboard.add(tButton, 4, 0);
        keyboard.add(yButton, 5, 0);
        keyboard.add(uButton, 6, 0);
        keyboard.add(iButton, 7, 0);
        keyboard.add(oButton, 8, 0);
        keyboard.add(pButton, 9, 0);

        keyboard.add(aButton, 0, 1);
        keyboard.add(sButton, 1, 1);
        keyboard.add(dButton, 2, 1);
        keyboard.add(fButton, 3, 1);
        keyboard.add(gButton, 4, 1);
        keyboard.add(hButton, 5, 1);
        keyboard.add(jButton, 6, 1);
        keyboard.add(kButton, 7, 1);
        keyboard.add(lButton, 8, 1);

        keyboard.add(shiftButton, 0, 2);
        keyboard.add(zButton, 1, 2);
        keyboard.add(xButton, 2, 2);
        keyboard.add(cButton, 3, 2);
        keyboard.add(vButton, 4, 2);
        keyboard.add(bButton, 5, 2);
        keyboard.add(nButton, 6, 2);
        keyboard.add(mButton, 7, 2);
        keyboard.add(commaButton, 8, 2);
        keyboard.add(periodButton, 9, 2);

        HashMap<KeyCode, Button> keyMap = new HashMap<>();
        HashMap<Integer, String> sampleTexts = new HashMap<>();

        sampleTexts.put(1, "Try typing this text. Do it as quickly and accurately as you can.");
        sampleTexts.put(2, "Next type another line of input data.");
        sampleTexts.put(3, "The quick brown fox jumps over the lazy dog.");
        sampleTexts.put(4, "Five big quacking zephyrs jolt my wax bed.");
        sampleTexts.put(5, "Sympathizing would fix Quaker objectives.");
        sampleTexts.put(6, "A large fawn jumped quickly over white zinc boxes.");

        textToType.setText(sampleTexts.get(currentTextNumber));

        keyMap.put(KeyCode.Q, qButton);
        keyMap.put(KeyCode.W, wButton);
        keyMap.put(KeyCode.E, eButton);
        keyMap.put(KeyCode.R, rButton);
        keyMap.put(KeyCode.T, tButton);
        keyMap.put(KeyCode.Y, yButton);
        keyMap.put(KeyCode.U, uButton);
        keyMap.put(KeyCode.I, iButton);
        keyMap.put(KeyCode.O, oButton);
        keyMap.put(KeyCode.P, pButton);

        keyMap.put(KeyCode.A, aButton);
        keyMap.put(KeyCode.S, sButton);
        keyMap.put(KeyCode.D, dButton);
        keyMap.put(KeyCode.F, fButton);
        keyMap.put(KeyCode.G, gButton);
        keyMap.put(KeyCode.H, hButton);
        keyMap.put(KeyCode.J, jButton);
        keyMap.put(KeyCode.K, kButton);
        keyMap.put(KeyCode.L, lButton);

        keyMap.put(KeyCode.SHIFT, shiftButton);
        keyMap.put(KeyCode.Z, zButton);
        keyMap.put(KeyCode.X, xButton);
        keyMap.put(KeyCode.C, cButton);
        keyMap.put(KeyCode.V, vButton);
        keyMap.put(KeyCode.B, bButton);
        keyMap.put(KeyCode.N, nButton);
        keyMap.put(KeyCode.M, mButton);

        keyMap.put(KeyCode.SPACE, spaceButton);
        keyMap.put(KeyCode.BACK_SPACE, backspaceButton);
        keyMap.put(KeyCode.COMMA, commaButton);
        keyMap.put(KeyCode.PERIOD, periodButton);

        HBox bottomRow = new HBox(20, spaceButton, backspaceButton);

        bottomRow.setAlignment(Pos.CENTER);
        bottomRow.setPadding(new Insets(10));
        
        Button nextButton = new Button("Go to next input text");
        Label textCounterLabel = new Label("1 of 6");
        Button resetButton = new Button("Reset");

        HBox buttonRow = new HBox(10, nextButton, resetButton);
        buttonRow.setAlignment(Pos.CENTER);

        VBox navigationRow = new VBox(10, buttonRow, textCounterLabel);
        
        navigationRow.setAlignment(Pos.CENTER);
        
        responseField.setStyle("-fx-font-size: 20px;");
        textToType.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
        keyPressedLabel.setStyle("-fx-font-size: 18px;");
        notHandledLabel.setStyle("-fx-text-fill: red; -fx-font-size: 18px;");
        statsLabel.setStyle("-fx-font-size: 18px;");
        textCounterLabel.setStyle("-fx-font-size: 18px;");
        
        spaceButton.setPrefWidth(200);
        spaceButton.setPrefHeight(55);

        backspaceButton.setPrefWidth(200);
        backspaceButton.setPrefHeight(55);

        textToType.setPrefWidth(650);

        responseField.setPrefWidth(650);
        responseField.setPrefHeight(55);

        VBox root = new VBox(
                textToType,
                responseField,
                keyboard,
                bottomRow,
                keyPressedLabel,
                notHandledLabel,
                statsLabel,
                navigationRow);
        
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        
        Scene scene = new Scene(root, 900, 650);

        nextButton.setOnAction(event -> {

            if (currentTextNumber < 6) {
                currentTextNumber++;
            }

            textToType.setText(sampleTexts.get(currentTextNumber));

            typedText.setLength(0);
            responseField.setText("");

            textCounterLabel.setText(currentTextNumber + " of 6");

            correctKeyStrokes = 0;
            incorrectKeyStrokes = 0;
            statsLabel.setText("Correct Keys: 0\nIncorrect Keys: 0");

            keyPressedLabel.setText("");
            notHandledLabel.setText("");

            root.requestFocus();
        });

        resetButton.setOnAction(event -> {

            currentTextNumber = 1;
            textToType.setText(sampleTexts.get(currentTextNumber));

            typedText.setLength(0);
            responseField.setText("");

            textCounterLabel.setText("1 of 6");

            correctKeyStrokes = 0;
            incorrectKeyStrokes = 0;
            statsLabel.setText("Correct Keys: 0\nIncorrect Keys: 0");

            keyPressedLabel.setText("");
            notHandledLabel.setText("");

            shiftPressed = false;

            root.requestFocus();
        });

        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            String keyText = event.getText();
            Button virtualKey = keyMap.get(keyCode);
            keyPressedLabel.setText(keyCode.getName());

            if (keyCode == KeyCode.SHIFT) {
                shiftPressed = true;
            }

            if (virtualKey != null) {
                virtualKey.setStyle("-fx-background-color: lightblue;");
                notHandledLabel.setText("");

                if (keyCode == KeyCode.BACK_SPACE) {

                    if (typedText.length() > 0) {
                        typedText.deleteCharAt(typedText.length() - 1);
                    }

                    responseField.setText(typedText.toString());

                } else if (!keyText.equals("")) {

                    if (shiftPressed) {
                        keyText = keyText.toUpperCase();
                    }

                    checkKeyStrokeCorrectness(keyText);

                    typedText.append(keyText);
                    responseField.setText(typedText.toString());
                }

            } else {
                notHandledLabel.setText("Not handled");
            }
        });

        scene.setOnKeyReleased(event -> {
            KeyCode keyCode = event.getCode();
            Button virtualKey = keyMap.get(keyCode);

            if (virtualKey != null) {
                virtualKey.setStyle("");
            }

            if (keyCode == KeyCode.SHIFT) {
                shiftPressed = false;
            }
        });

        stage.setTitle("Typing Tutor");
        stage.setScene(scene);
        stage.show();

        root.requestFocus();
    }

    /**
     * Checks if the the typed key is correct or incorrect
     * and updates the number of correct and incorrect keystrokes
     * 
     * @param typedKey the key typed by the user
     */
    public void checkKeyStrokeCorrectness(String typedKey) {

        String targetText = textToType.getText();
        int position = typedText.length();

        if (position < targetText.length()
                && targetText.charAt(position) == typedKey.charAt(0)) {

            correctKeyStrokes++;
        } else {
            incorrectKeyStrokes++;
        }

        statsLabel.setText(
                "Correct Keys: " + correctKeyStrokes
                + "\nIncorrect Keys: " + incorrectKeyStrokes
        );
    }

    public static void main(String[] args) {
        launch();
    }

}
