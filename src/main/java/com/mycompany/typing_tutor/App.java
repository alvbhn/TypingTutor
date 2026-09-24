package com.mycompany.typing_tutor;

import java.util.HashMap;
import javafx.application.Application;
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
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        Label textToType = new Label("Text to type");
        Label keyPressedLabel = new Label("");
        Label notHandledLabel = new Label("");
        TextField responseField = new TextField();
                
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
        
        GridPane keyboard = new GridPane();

        keyboard.setHgap(10);
        keyboard.setVgap(10);
        
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
        
        notHandledLabel.setStyle("-fx-text-fill: red;");


        HBox bottomRow = new HBox(10, spaceButton, backspaceButton);

        VBox root = new VBox(textToType, responseField, keyboard, bottomRow, keyPressedLabel, notHandledLabel);

        Scene scene = new Scene(root, 700, 500);
        
        scene.setOnKeyPressed(event -> {
            KeyCode keyCode = event.getCode();
            String keyText = event.getText();
            Button virtualKey = keyMap.get(keyCode);
            keyPressedLabel.setText(keyCode.getName());
            
            if (virtualKey != null) {
                virtualKey.setStyle("-fx-background-color: lightblue;");
                notHandledLabel.setText("");
                
                if (!keyText.equals("")) {
                    responseField.setText(responseField.getText() + keyText);
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
        });
            
        stage.setTitle("Typing Tutor");
        stage.setScene(scene);
        stage.show();
        
        root.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }

}