package com.nhnacademy.yunhwa.Exercise3_8;

import javafx.application.Application;
import javafx.stage.Stage;

public class Exercise3_8 extends Application {

    public static void main(String[] args) {
        SimpleGraphicsStarter.main(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SimpleGraphicsStarter simpleGraphicsStarter = new SimpleGraphicsStarter();
        simpleGraphicsStarter.start(new Stage());
    }
}
