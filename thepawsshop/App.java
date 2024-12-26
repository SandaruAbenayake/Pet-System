package com.thepawsshop.thepawsshop;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Login loginView = new Login();
        loginView.setVisible(true);
    }

    public static void main(String[] args) {
        launch();
    }

}