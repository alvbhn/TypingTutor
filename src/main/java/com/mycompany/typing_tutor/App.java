package com.mycompany.typing_tutor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        Label textToType = new Label("Text to type");
        
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

        HBox firstRow = new HBox(10, qButton, wButton, eButton, rButton, tButton,
                yButton, uButton, iButton, oButton, pButton);
        
        

        VBox root = new VBox(textToType, responseField, firstRow);

        Scene scene = new Scene(root, 700, 500);

        stage.setTitle("Typing Tutor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}